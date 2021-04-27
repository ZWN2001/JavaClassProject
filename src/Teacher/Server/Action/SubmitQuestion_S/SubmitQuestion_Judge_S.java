package Teacher.Server.Action.SubmitQuestion_S;

import Teacher.Bean.Question.Question_Judge;
import Teacher.Server.DataBase.DB;
import com.alibaba.fastjson.JSON;

import java.io.*;
import java.net.Socket;

public class SubmitQuestion_Judge_S {

    Socket socket;
    DataInputStream dis;//输入
    DataOutputStream dos;//输出
    BufferedReader in;
    DB database = DB.instance;

    Question_Judge question_judge;
    private static int id=0;
    String stem;
    int mark;
    String answer;
    int difficulty;
    public SubmitQuestion_Judge_S(Socket socket) throws Exception{
        this.socket=socket;
        dis = new DataInputStream(new BufferedInputStream(socket.getInputStream())); //
        dos = new DataOutputStream(new BufferedOutputStream(socket.getOutputStream()));
        in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        question_judge= JSON.parseObject(in.readLine(),Question_Judge.class);
        stem=question_judge.getStem();
        mark=question_judge.getMark();
        difficulty=question_judge.getDifficulty();
        answer=question_judge.getAnswer();
        try {
            dos.writeUTF("1");
            dos.flush();
            database.update("INSERT INTO questions.judge VALUES ('" + id + "','" + stem +  "','" + mark+ "','" + difficulty+ "','" + answer+ "')");
            id++;
            // socket.close();
        }catch (Exception e){
            dos.writeUTF("-1");
            dos.flush();
            System.out.println("添加判断题失败");
            e.printStackTrace();
        }
    }
}
