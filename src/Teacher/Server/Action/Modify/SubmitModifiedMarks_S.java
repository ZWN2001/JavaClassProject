package Teacher.Server.Action.Modify;

import Teacher.Bean.Paper;
import Teacher.Server.DataBase.DB;
import com.alibaba.fastjson.JSON;

import java.io.*;
import java.net.Socket;

public class SubmitModifiedMarks_S {
    Socket socket;
    DataInputStream dis;//输入
    DataOutputStream dos;//输出
    BufferedReader in;
    DB database = DB.instance;
    private String[] studentID;
    private int[] subjectiveScore;
    private int paperID,i;

    public SubmitModifiedMarks_S(Socket socket) throws Exception{
        this.socket = socket;
        dis = new DataInputStream(new BufferedInputStream(socket.getInputStream())); //
        dos = new DataOutputStream(new BufferedOutputStream(socket.getOutputStream()));
        in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        paperID = Integer.parseInt(in.readLine());
        studentID=JSON.parseObject(in.readLine(),String[].class);
        subjectiveScore=JSON.parseObject(in.readLine(),int[].class);
        try {
         for (i=0;i<subjectiveScore.length;i++){
             database.update("UPDATE exam.score SET subjectivescore = "+subjectiveScore[i]+" WHERE paperid= "+paperID+" AND student = "+studentID[i]);
         }
            dos.writeUTF("1");
            dos.flush();
        }catch (Exception e){
            dos.writeUTF("-1");
            dos.flush();
            System.out.println("添加成绩失败");
            e.printStackTrace();
        }
    }
}
