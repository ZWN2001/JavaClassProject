package Teacher.Server.Action.GetQuestionBank_S;

import Teacher.Server.DataBase.DB;
import com.alibaba.fastjson.JSON;

import java.io.*;
import java.net.Socket;
import java.sql.ResultSet;
import java.sql.SQLException;

public class GetQuestionBank_MultiChoice_S {
    Socket socket;

    DB database = DB.instance;
    PrintWriter out;
    BufferedReader in;

    ResultSet resultSet;

    public GetQuestionBank_MultiChoice_S(Socket s) throws IOException, SQLException {
        socket = s;
        in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(socket.getOutputStream())), true);
        resultSet = database.query("SELECT id,stem,optA,optB,optC,optD,mark,difficulty,answer FROM questions.multiChoice ORDER BY id");
        int n = resultSet.getRow();

        int[] idList = new int[n];
        String[] stemList = new String[n];
        String[] optionA_List = new String[n];
        String[] optionB_List = new String[n];
        String[] optionC_List = new String[n];
        String[] optionD_List = new String[n];
        int[] markList = new int[n];
        int[] difficultyList = new int[n];
        String[] answerList = new String[n];

        resultSet.beforeFirst();
        if (n>0) {
            for (int i = 0; i < n; i++) {
                idList[i] = resultSet.getInt("id");
                stemList[i]=resultSet.getString("stem");
                optionA_List[i]=resultSet.getString("optA");
                optionB_List[i]=resultSet.getString("optB");
                optionC_List[i]=resultSet.getString("optC");
                optionD_List[i]=resultSet.getString("optD");
                markList[i]=resultSet.getInt("mark");
                difficultyList[i]=resultSet.getInt("difficulty");
                answerList[i]=resultSet.getString("answer");
            }
        }
        out.println(JSON.toJSONString(idList));
        out.println(JSON.toJSONString(stemList));
        out.println(JSON.toJSONString(optionA_List));
        out.println(JSON.toJSONString(optionB_List));
        out.println(JSON.toJSONString(optionC_List));
        out.println(JSON.toJSONString(optionD_List));
        out.println(JSON.toJSONString(markList));
        out.println(JSON.toJSONString(difficultyList));
        out.println(JSON.toJSONString(answerList));

        System.out.println("id:"+JSON.toJSONString(idList));
        System.out.println("stemList:"+JSON.toJSONString(stemList));
        System.out.println("optionA_List:"+JSON.toJSONString(optionA_List));
        System.out.println("optionB_List:"+JSON.toJSONString(optionB_List));
        System.out.println("optionC_List:"+JSON.toJSONString(optionC_List));
        System.out.println("optionD_List:"+JSON.toJSONString(optionD_List));
        System.out.println("markList:"+JSON.toJSONString(markList));
        System.out.println("difficultyList:"+JSON.toJSONString(difficultyList));
        System.out.println("answerList:"+JSON.toJSONString(answerList));
    }
}
