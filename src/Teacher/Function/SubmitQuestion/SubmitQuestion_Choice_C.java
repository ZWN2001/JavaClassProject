package Teacher.Function.SubmitQuestion;

import Teacher.Bean.Question.Question_Choice;
import com.alibaba.fastjson.JSON;

import java.io.*;
import java.net.Socket;

import static Teacher.Server.ServerMain.Address;
import static Teacher.Server.ServerMain.PORT;

public class SubmitQuestion_Choice_C {
     final DataOutputStream dos;
     final int  resultCode;
    private final String COMMAND = "SUBMIT_QUESTION_CHOICE";
    public SubmitQuestion_Choice_C(Question_Choice question_choice) throws Exception{
        Socket socket = new Socket(Address, PORT);
        dos = new DataOutputStream(new BufferedOutputStream(socket.getOutputStream()));
        DataInputStream dis = new DataInputStream(new BufferedInputStream(socket.getInputStream()));
        //输出
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(socket.getOutputStream())), true);
        //请求类型
        dos.writeUTF(COMMAND);
        dos.flush();

        String json = JSON.toJSONString(question_choice);//使用JSON序列化对象传输过去
        out.println(json);
        resultCode = dis.read();
        socket.close();
    }
    public  int getResultCode() {
        return resultCode;
    }
}
