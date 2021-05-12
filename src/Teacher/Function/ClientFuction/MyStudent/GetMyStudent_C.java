package Teacher.Function.ClientFuction.MyStudent;

import com.alibaba.fastjson.JSON;

import java.io.*;
import java.net.Socket;

import static Teacher.Server.Server.Address;
import static Teacher.Server.Server.PORT;

public class GetMyStudent_C {
    String COMMAND="GET_STUDENT_NAME";
    private Socket socket;
    private DataInputStream dis;//输入
    private DataOutputStream dos;//输出
    private BufferedReader in;
    private PrintWriter out;

    private String[] studentName;
    public GetMyStudent_C(String teacherID)throws IOException {
        this.socket = new Socket(Address, PORT);
        dis = new DataInputStream(new BufferedInputStream(socket.getInputStream()));
        dos = new DataOutputStream(new DataOutputStream(socket.getOutputStream()));
        in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        out = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()), true);
        dos.writeUTF(COMMAND);
        dos.flush();

        out.println(teacherID);
        studentName = JSON.parseObject(in.readLine(), String[].class);
        this.socket.close();
    }

    public String[] getStudentName() {
        return studentName;
    }
}
