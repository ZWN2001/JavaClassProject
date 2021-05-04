package Teacher.Server.Action;

import Teacher.Server.DataBase.DB;
import com.alibaba.fastjson.JSON;

import java.io.*;
import java.net.Socket;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class GetPreviewQuestions_S {
    Socket socket;
    DB database = DB.instance;
    PrintWriter out;
    BufferedReader in;
    ResultSet resultSet;
    String[] questionString;
    int[] choiceIDList,multiChoiceIDList,judgeIDList,subjectiveIDList;
    public GetPreviewQuestions_S(Socket s)throws IOException, SQLException {
        socket = s;
        in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(socket.getOutputStream())), true);

        questionString= JSON.parseObject(in.readLine(), String[].class);
        choiceIDList=JSON.parseObject(questionString[0],int[].class);
        multiChoiceIDList=JSON.parseObject(questionString[1],int[].class);
        judgeIDList=JSON.parseObject(questionString[2],int[].class);
        subjectiveIDList=JSON.parseObject(questionString[3],int[].class);

        String[] choices=new String[choiceIDList.length];
        String[]multiChoices=new String[multiChoiceIDList.length];
        String[]judges=new String[judgeIDList.length];
        String[]subjectives=new String[subjectiveIDList.length];
        if (choiceIDList.length>0){

        }

    }
}
