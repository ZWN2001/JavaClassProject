package Teacher.Server.Action.Paper_S;

import Teacher.Server.DataBase.DB;
import com.alibaba.fastjson.JSON;

import java.io.*;
import java.net.Socket;
import java.sql.ResultSet;
import java.sql.SQLException;
/**
 * @ClassName:
 * @parms: QuestionType共计四种：choice multiChoice judge subjective
 *   GetQuestionIDList中的参数n是指题目类型的顺序，单选为0，多选为1，判断为2，主观为3
 * @author 赵炜宁
 * @date
 *
 */

public class GetAutoPaper_S {
    Socket socket;
    DB database = DB.instance;
    PrintWriter out;
    BufferedReader in;
    ResultSet resultSet;
    String questionString;
    int[] demands;
    int i;
    int[] choiceID,multiChoiceID,judgeID,subjectiveID;
    public GetAutoPaper_S(Socket s)throws IOException, SQLException {
        socket = s;
        in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(socket.getOutputStream())), true);
        demands= JSON.parseObject(in.readLine(),int[].class);
        if (demands[0]!=0||demands[1]!=0||demands[2]!=0||demands[3]!=0||demands[4]!=0){
             choiceID=new int[demands[0]+demands[1]+demands[2]+demands[3]+demands[4]];
            getQuestionID("choice",choiceID,0);
        }
        if (demands[5]!=0||demands[6]!=0||demands[7]!=0||demands[8]!=0||demands[9]!=0){
            multiChoiceID=new int[demands[5]+demands[6]+demands[7]+demands[8]+demands[9]];
            getQuestionID("multiChoice",multiChoiceID,1);
        }
        if (demands[10]!=0||demands[11]!=0||demands[12]!=0||demands[13]!=0||demands[14]!=0){
            judgeID=new int[demands[10]+demands[11]+demands[12]+demands[13]+demands[14]];
            getQuestionID("judge",judgeID,2);
        }
        if (demands[15]!=0||demands[16]!=0||demands[17]!=0||demands[18]!=0||demands[19]!=0){
            subjectiveID=new int[demands[15]+demands[16]+demands[17]+demands[18]+demands[19]];
            getQuestionID("subjective",subjectiveID,3);
        }
        String[] questions=new String[4];
        questions[0]=JSON.toJSONString(choiceID);
        questions[1]=JSON.toJSONString(multiChoiceID);
        questions[2]=JSON.toJSONString(judgeID);
        questions[3]=JSON.toJSONString(subjectiveID);
        questionString=JSON.toJSONString(questions);
        out.println(questionString);
    }
    private void getQuestionID(String questionType,int[] QuestionIDList,int n) throws SQLException {
        if (demands[5*n]>0){
            resultSet = database.query("SELECT id FROM questions."+questionType+" WHERE difficulty = 1");
            for (i=0;i<demands[5*n]&&resultSet.next();i++){
                QuestionIDList[i]=resultSet.getInt("id");
                System.out.println(QuestionIDList[i]);
            }
        }
        if (demands[5*n+1]>0){
            resultSet = database.query("SELECT id FROM questions."+questionType+" WHERE difficulty = 2");
            for (i=demands[5*n];i<demands[5*n]+demands[5*n+1]&&resultSet.next();i++){
                QuestionIDList[i]=resultSet.getInt("id");
                System.out.println(QuestionIDList[i]);
            }
        }
        if (demands[5*n+2]>0){
            resultSet = database.query("SELECT id FROM questions."+questionType+" WHERE difficulty = 3");
            for (i=demands[5*n]+demands[5*n+1];i<demands[5*n]+demands[5*n+1]+demands[5*n+2]&&resultSet.next();i++){
                QuestionIDList[i]=resultSet.getInt("id");
                System.out.println(QuestionIDList[i]);
            }
        }
        if (demands[5*n+3]>0){
            resultSet = database.query("SELECT id FROM questions."+questionType+" WHERE difficulty = 4");
            for (i=demands[5*n]+demands[5*n+1]+demands[5*n+2];i<demands[5*n]+demands[5*n+1]+demands[4*n+2]+demands[4*n+3]&&resultSet.next();i++){
                QuestionIDList[i]=resultSet.getInt("id");
                System.out.println(QuestionIDList[i]);
            }
        }
        if (demands[5*n+4]>0){
            resultSet = database.query("SELECT id FROM questions."+questionType+" WHERE difficulty = 3");
            for (i=demands[5*n]+demands[5*n+1]+demands[5*n+2]+demands[5*n+3];i<demands[5*n]+demands[5*n+1]+demands[5*n+2]+demands[5*n+3]+demands[5*n+4]&&resultSet.next();i++){
                QuestionIDList[i]=resultSet.getInt("id");
                System.out.println(QuestionIDList[i]);
            }
        }
    }
}
