package Teacher.Server.Action;

import Teacher.Server.DataBase.DB;
import com.alibaba.fastjson.JSON;

import java.io.*;
import java.net.Socket;
import java.sql.ResultSet;
import java.sql.SQLException;

public class GetQuestionBankSituation_S {
    Socket socket;
    DB database = DB.instance;
    PrintWriter out;
    BufferedReader in;
    ResultSet resultSet;
    QuestionSituation situation_Choice= new QuestionSituation();
    QuestionSituation situation_MultiChoice= new QuestionSituation();
    QuestionSituation situation_Judge= new QuestionSituation();
    QuestionSituation situation_Subjective= new QuestionSituation();
    public GetQuestionBankSituation_S(Socket s)throws IOException, SQLException {
        socket = s;
        in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(socket.getOutputStream())), true);

        getSituation("SELECT difficulty FROM questions.choice",situation_Choice);
        getSituation("SELECT difficulty FROM questions.multiChoice",situation_MultiChoice);
        getSituation("SELECT difficulty FROM questions.judge",situation_Judge);
        getSituation("SELECT difficulty FROM questions.subjective",situation_Subjective);

        out.println(JSON.toJSONString(situation_Choice.getAll()));
        out.println(JSON.toJSONString(situation_MultiChoice.getAll()));
        out.println(JSON.toJSONString(situation_Judge.getAll()));
        out.println(JSON.toJSONString(situation_Subjective.getAll()));
        out.println(JSON.toJSONString(situation_Choice.getEach()));
        out.println(JSON.toJSONString(situation_MultiChoice.getEach()));
        out.println(JSON.toJSONString(situation_Judge.getEach()));
        out.println(JSON.toJSONString(situation_Subjective.getEach()));
    }

    private static class QuestionSituation{
         int all=0;
         int []each={0,0,0,0,0};

        public int getAll() {
            return all;
        }
        public void setAll(int all) {
            this.all = all;
        }
        public int[] getEach() {
            return each;
        }
        public void add1(){
            each[0]++;
        }
        public void add2(){
            each[1]++;
        }
        public void add3(){
            each[2]++;
        }
        public void add4(){
            each[3]++;
        }
        public void add5(){
            each[4]++;
        }
    }

    public void getSituation(String sqlCommand,QuestionSituation situation)throws SQLException {
        resultSet = database.query(sqlCommand);
        resultSet.last();
        int n=resultSet.getRow();
        situation.setAll(n);
        resultSet.beforeFirst();
        if (n>0) {
            for (int i = 0; resultSet.next(); i++) {
                int difficulty=resultSet.getInt("difficulty");
                switch (difficulty){
                    case 1:situation.add1();break;
                    case 2:situation.add2();break;
                    case 3:situation.add3();break;
                    case 4:situation.add4();break;
                    case 5:situation.add5();break;
                    default:break;
                }
            }
        }

    }
}
