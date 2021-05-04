package Teacher.Function.ClientFuction;

import com.alibaba.fastjson.JSON;

import java.io.*;
import java.net.Socket;

import static Teacher.Server.ServerMain.Address;
import static Teacher.Server.ServerMain.PORT;

public class GetPreviewQuestions_C {
    int [] choices,multiChoices,judges,subjective;
    String command="GET_QUESTION_PREVIEW";
    private DataInputStream dis;//输入
    private DataOutputStream dos;//输出
    private BufferedReader in;
    private PrintWriter out;
    public GetPreviewQuestions_C(String questionString) throws IOException{
        Socket socket = new Socket(Address, PORT);
        dis = new DataInputStream(new BufferedInputStream(socket.getInputStream()));
        dos = new DataOutputStream(new DataOutputStream(socket.getOutputStream()));
        in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        out = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()), true);
        dos.writeUTF(command);
        dos.flush();

        out.println(questionString);
        choices= JSON.parseObject(in.readLine(),int[].class);
        multiChoices=JSON.parseObject(in.readLine(),int[].class);
        judges=JSON.parseObject(in.readLine(),int[].class);
        subjective=JSON.parseObject(in.readLine(),int[].class);
        socket.close();
    }
}
