package Teacher.Function.ClientFuction.SubmitQuestion;

import Teacher.Bean.Question.Question;
import com.alibaba.fastjson.JSON;

import java.io.*;
import java.net.Socket;

import static Teacher.Server.Server.Address;
import static Teacher.Server.Server.PORT;

public class SubmitQuestion_C {
     final DataOutputStream dos;
     final int  resultCode;
    public SubmitQuestion_C(Question question,String command) throws Exception{
        Socket socket = new Socket(Address, PORT);
        dos = new DataOutputStream(new BufferedOutputStream(socket.getOutputStream()));
        DataInputStream dis = new DataInputStream(new BufferedInputStream(socket.getInputStream()));
        //输出
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(socket.getOutputStream())), true);
        //请求类型
        dos.writeUTF(command);
        dos.flush();

        String json = JSON.toJSONString(question);//使用JSON序列化对象传输过去
        out.println(json);
        resultCode = Integer.parseInt(dis.readUTF());
        socket.close();
    }
    public  int getResultCode() {
        return resultCode;
    }
}
