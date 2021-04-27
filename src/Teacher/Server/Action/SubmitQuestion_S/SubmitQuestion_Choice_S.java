package Teacher.Server.Action.SubmitQuestion_S;

import Teacher.Bean.Question.Question_Choice;
import Teacher.Server.DataBase.DB;
import com.alibaba.fastjson.JSON;
import java.io.*;
import java.net.Socket;
import java.sql.ResultSet;

/**
 * @Description: 向数据库添加选择题
 * @author 赵炜宁
 * @date 2021.4.23
 *
 */
public class SubmitQuestion_Choice_S {

    Socket socket;
    DataInputStream dis;//输入
    DataOutputStream dos;//输出
    BufferedReader in;
    DB database = DB.instance;

    Question_Choice question_choice;
    private static int id=0;
    String stem;
    int mark;
    String optionA;
    String optionB;
    String optionC;
    String optionD;
    String answer;
    int difficulty;
    public SubmitQuestion_Choice_S(Socket socket) throws Exception{
        this.socket=socket;
        dis = new DataInputStream(new BufferedInputStream(socket.getInputStream())); //
        dos = new DataOutputStream(new BufferedOutputStream(socket.getOutputStream()));
        in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        question_choice=JSON.parseObject(in.readLine(),Question_Choice.class);
        stem=question_choice.getStem();
        optionA=question_choice.getOptionA();
        optionB=question_choice.getOptionB();
        optionC=question_choice.getOptionC();
        optionD=question_choice.getOptionD();
        mark=question_choice.getMark();
        difficulty=question_choice.getDifficulty();
        answer=question_choice.getAnswer();
        try {
            dos.writeUTF("1");
            dos.flush();
            database.update("INSERT INTO questions.choice VALUES ('" + id + "','" + stem + "','" + optionA + "','" +
                    optionB+ "','" + optionC+ "','" + optionD + "','" + mark+ "','" + difficulty+ "','" + answer+ "')");
        id++;

       // socket.close();
        }catch (Exception e){
            dos.writeUTF("-1");
            dos.flush();
            System.out.println("添加选择题失败");
            e.printStackTrace();
        }
    }
}
