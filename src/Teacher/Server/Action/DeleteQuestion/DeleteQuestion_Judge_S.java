package Teacher.Server.Action.DeleteQuestion;

import Teacher.Bean.Question.Question_Judge;
import Teacher.Server.DataBase.DB;
import com.alibaba.fastjson.JSON;

import java.io.*;
import java.net.Socket;

public class DeleteQuestion_Judge_S {
    Socket socket;
    DataInputStream dis;//输入
    DataOutputStream dos;//输出
    BufferedReader in;
    DB database = DB.instance;

    Question_Judge question_judge;
    int id;
    String stem;
    int mark;
    String answer;
    int difficulty;

    public DeleteQuestion_Judge_S(Socket socket) throws Exception {
        this.socket=socket;
        dis = new DataInputStream(new BufferedInputStream(socket.getInputStream())); //
        dos = new DataOutputStream(new BufferedOutputStream(socket.getOutputStream()));
        in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        question_judge= JSON.parseObject(in.readLine(),Question_Judge.class);
        id=question_judge.getId();
        stem=question_judge.getStem();
        mark=question_judge.getMark();
        difficulty=question_judge.getDifficulty();
        answer=question_judge.getAnswer();
        try {
            database.update("DELETE FROM questions.judge WHERE id="+id);
            dos.writeUTF("1");
            dos.flush();
        }catch (Exception e){
            dos.writeUTF("-1");
            dos.flush();
            System.out.println("删除判断题失败");
            e.printStackTrace();
        }
    }
}
