package Teacher.Server.Action.ChangeQuestion;

import Teacher.Bean.Question.Question_Subjective;
import Teacher.Server.DataBase.DB;
import com.alibaba.fastjson.JSON;

import java.io.*;
import java.net.Socket;

public class ChangeQuestion_Subjective_S {

    Socket socket;
    DataInputStream dis;//输入
    DataOutputStream dos;//输出
    BufferedReader in;
    DB database = DB.instance;

    Question_Subjective question_subjective;
    int id;
    String stem;
    int mark;
    String answer;
    int difficulty;
    public ChangeQuestion_Subjective_S(Socket socket) throws Exception{
        this.socket=socket;
        dis = new DataInputStream(new BufferedInputStream(socket.getInputStream())); //
        dos = new DataOutputStream(new BufferedOutputStream(socket.getOutputStream()));
        in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        question_subjective= JSON.parseObject(in.readLine(),Question_Subjective.class);
        id=question_subjective.getId();
        stem=question_subjective.getStem();
        mark=question_subjective.getMark();
        difficulty=question_subjective.getDifficulty();
        answer=question_subjective.getAnswer();
        try {
            dos.writeUTF("1");
            dos.flush();
            database.update("UPDATE questions.subjective SET stem= " + stem +  ",mark=" + mark+ ",difficulty=" + difficulty+ ",answer=" + answer+ "WHERE id="+id);

        }catch (Exception e){
            dos.writeUTF("-1");
            dos.flush();
            System.out.println("修改主观题失败");
            e.printStackTrace();
        }
    }
}
