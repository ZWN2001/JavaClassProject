package Teacher.Server.Action.Paper;

import Teacher.Bean.Paper;
import Teacher.Server.DataBase.DB;
import com.alibaba.fastjson.JSON;

import java.io.*;
import java.net.Socket;

public class SubmitPaper_S {

    Socket socket;
    DataInputStream dis;//输入
    DataOutputStream dos;//输出
    BufferedReader in;
    DB database = DB.instance;
    Paper paper;

    public SubmitPaper_S(Socket socket) throws Exception{
        this.socket = socket;
        dis = new DataInputStream(new BufferedInputStream(socket.getInputStream())); //
        dos = new DataOutputStream(new BufferedOutputStream(socket.getOutputStream()));
        in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        paper = JSON.parseObject(in.readLine(),Paper.class);
        try {
            dos.writeUTF("1");
            dos.flush();
            database.update("INSERT INTO papers.paper VALUES ('" + 0 + "','" + paper.getTitle() + "','" + paper.getMark() + "','" + paper.getDifficulty() + "','"+
                    paper.getOwnerID()+ "','" + paper.getOwner()+ "','" + paper.getTime() + "','" + paper.getExamTime()+ "','" + paper.getQuestions()+ "')");

        }catch (Exception e){
            dos.writeUTF("-1");
            dos.flush();
            System.out.println("添加试卷失败");
            e.printStackTrace();
        }
    }
}
