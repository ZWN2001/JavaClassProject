package Teacher.Function.ClientFuction.Modify;

import com.alibaba.fastjson.JSON;

import java.io.*;
import java.net.Socket;

import static Teacher.Server.ServerMain.Address;
import static Teacher.Server.ServerMain.PORT;

public class SubmitModifiedMarks_C {
    final DataOutputStream dos;
    final int  resultCode;
    private final String COMMAND="SUBMIT_MARKS";
    public SubmitModifiedMarks_C(int paperID,String[] studentID,int[] subjectiveScore) throws Exception{
        Socket socket = new Socket(Address, PORT);
        dos = new DataOutputStream(new BufferedOutputStream(socket.getOutputStream()));
        DataInputStream dis = new DataInputStream(new BufferedInputStream(socket.getInputStream()));
        //输出
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(socket.getOutputStream())), true);
        //请求类型
        dos.writeUTF(COMMAND);
        dos.flush();

        out.println(paperID);
        out.println(JSON.toJSONString(studentID));
        out.println(JSON.toJSONString(subjectiveScore));

        resultCode = Integer.parseInt(dis.readUTF());
        socket.close();
    }
    public  int getResultCode() {
        return resultCode;
    }

}
