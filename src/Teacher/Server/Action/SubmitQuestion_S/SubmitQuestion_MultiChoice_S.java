package Teacher.Server.Action.SubmitQuestion_S;

import Teacher.Bean.Question.Question_MultiChoice;
import Teacher.Server.DataBase.DB;
import com.alibaba.fastjson.JSON;

import java.io.*;
import java.net.Socket;

public class SubmitQuestion_MultiChoice_S {

    Socket socket;
    DataInputStream dis;//输入
    DataOutputStream dos;//输出
    BufferedReader in;
    DB database = DB.instance;

    Question_MultiChoice question_multiChoice;
    private static int id=0;
    String stem;
    int mark;
    String optionA;
    String optionB;
    String optionC;
    String optionD;
    String answer;
    int difficulty;
    public SubmitQuestion_MultiChoice_S(Socket socket) throws Exception{
        this.socket=socket;
        dis = new DataInputStream(new BufferedInputStream(socket.getInputStream())); //
        dos = new DataOutputStream(new BufferedOutputStream(socket.getOutputStream()));
        in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        question_multiChoice= JSON.parseObject(in.readLine(),Question_MultiChoice.class);
        stem=question_multiChoice.getStem();
        optionA=question_multiChoice.getOptionA();
        optionB=question_multiChoice.getOptionB();
        optionC=question_multiChoice.getOptionC();
        optionD=question_multiChoice.getOptionD();
        mark=question_multiChoice.getMark();
        difficulty=question_multiChoice.getDifficulty();
        answer=question_multiChoice.getAnswer();
        try {
            dos.writeUTF("1");
            dos.flush();
            database.update("INSERT INTO questions.multiChoice VALUES ('" + id + "','" + stem + "','" + optionA + "','" +
                    optionB+ "','" + optionC+ "','" + optionD + "','" + mark+ "','" + difficulty+ "','" + answer+ "')");
            id++;
            // socket.close();
        }catch (Exception e){
            dos.writeUTF("-1");
            dos.flush();
            System.out.println("添加多选题失败");
            e.printStackTrace();
        }
    }
}
