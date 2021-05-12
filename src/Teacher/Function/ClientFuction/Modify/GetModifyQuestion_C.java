package Teacher.Function.ClientFuction.Modify;

import com.alibaba.fastjson.JSON;

import java.io.*;
import java.net.Socket;

import static Teacher.Server.Server.Address;
import static Teacher.Server.Server.PORT;

public class GetModifyQuestion_C {
    String COMMAND="GET_MODIFY_QUESTIONS";
    private Socket socket;
    private DataInputStream dis;//输入
    private DataOutputStream dos;//输出
    private BufferedReader in;
    private PrintWriter out;
    private String[] studentID;
    private String[] answers;
    public GetModifyQuestion_C(int id)throws IOException {
        this.socket = new Socket(Address, PORT);
        dis = new DataInputStream(new BufferedInputStream(socket.getInputStream()));
        dos = new DataOutputStream(new DataOutputStream(socket.getOutputStream()));
        in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        out = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()), true);
        dos.writeUTF(COMMAND);
        dos.flush();

        out.println(id);
        studentID=JSON.parseObject(in.readLine(), String[].class);
        answers = JSON.parseObject(in.readLine(), String[].class);
        this.socket.close();
    }

    public String[] getStudentID() {
        return studentID;
    }
    public String[] getModifyAnswers() {
        return answers;
    }
}
