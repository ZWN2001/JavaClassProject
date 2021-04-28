package Teacher.Server.Action.GetQuestionBank_S;

import Teacher.Server.DataBase.DB;
import com.alibaba.fastjson.JSON;

import java.io.*;
import java.net.Socket;
import java.sql.ResultSet;
import java.sql.SQLException;

public class GetQuestionBank_Subjective_S {
    Socket socket;

    DB database = DB.instance;
    PrintWriter out;
    BufferedReader in;

    ResultSet resultSet;

    public GetQuestionBank_Subjective_S(Socket s) throws IOException, SQLException {
        socket = s;
        in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(socket.getOutputStream())), true);
        resultSet = database.query("SELECT id,stem,mark,difficulty,answer FROM questions.subjective ORDER BY id");
        resultSet.last();
        int n = resultSet.getRow();

        int[] idList = new int[n];
        String[] stemList = new String[n];
        int[] markList = new int[n];
        int[] difficultyList = new int[n];
        String[] answerList = new String[n];

        resultSet.beforeFirst();
        if (n>0) {
            for (int i = 0; resultSet.next(); i++) {
                idList[i] = resultSet.getInt("id");
                stemList[i]=resultSet.getString("stem");
                markList[i]=resultSet.getInt("mark");
                difficultyList[i]=resultSet.getInt("difficulty");
                answerList[i]=resultSet.getString("answer");
            }
        }
        out.println(JSON.toJSONString(idList));
        out.println(JSON.toJSONString(stemList));
        out.println(JSON.toJSONString(markList));
        out.println(JSON.toJSONString(difficultyList));
        out.println(JSON.toJSONString(answerList));

        System.out.println("id:"+JSON.toJSONString(idList));
        System.out.println("stemList:"+JSON.toJSONString(stemList));
        System.out.println("markList:"+JSON.toJSONString(markList));
        System.out.println("difficultyList:"+JSON.toJSONString(difficultyList));
        System.out.println("answerList:"+JSON.toJSONString(answerList));
    }
}
