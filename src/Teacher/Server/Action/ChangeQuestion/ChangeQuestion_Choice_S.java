package Teacher.Server.Action.ChangeQuestion;

import Teacher.Bean.Question.Question_Choice;
import Teacher.Server.DataBase.DB;
import com.alibaba.fastjson.JSON;

import java.io.*;
import java.net.Socket;

public class ChangeQuestion_Choice_S {
    Socket socket;
    DataInputStream dis;//输入
    DataOutputStream dos;//输出
    BufferedReader in;
    DB database = DB.instance;

    Question_Choice question_choice;
    int id;
    String stem;
    int mark;
    String optionA;
    String optionB;
    String optionC;
    String optionD;
    String answer;
    int difficulty;

    public ChangeQuestion_Choice_S(Socket socket) throws Exception {
            this.socket = socket;
            dis = new DataInputStream(new BufferedInputStream(socket.getInputStream())); //
            dos = new DataOutputStream(new BufferedOutputStream(socket.getOutputStream()));
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            question_choice = JSON.parseObject(in.readLine(), Question_Choice.class);
            id=question_choice.getId();
            stem = question_choice.getStem();
            optionA = question_choice.getOptionA();
            optionB = question_choice.getOptionB();
            optionC = question_choice.getOptionC();
            optionD = question_choice.getOptionD();
            mark = question_choice.getMark();
            difficulty = question_choice.getDifficulty();
            answer = question_choice.getAnswer();
            try {
                database.update("UPDATE questions.choice SET stem='" + stem + "',optA='" + optionA + "',optB='" +
                        optionB + "',optC='" + optionC + "',optD='" + optionD + "',mark='" + mark +
                        "',difficulty='" + difficulty + "',answer='" + answer + "' WHERE id="+id);
                dos.writeUTF("1");
                dos.flush();
            } catch (Exception e) {
                dos.writeUTF("-1");
                dos.flush();
                System.out.println("修改选择题失败");
                e.printStackTrace();
            }
        }
}
