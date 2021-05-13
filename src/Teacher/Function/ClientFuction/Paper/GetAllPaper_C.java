package Teacher.Function.ClientFuction.Paper;

import Teacher.Bean.Paper;
import com.alibaba.fastjson.JSON;

import java.io.*;
import java.net.Socket;

import static Teacher.Server.Server.Address;
import static Teacher.Server.Server.PORT;

public class GetAllPaper_C {
    String COMMAND="GET_PAPERS";
    private Socket socket;
    private DataInputStream dis;//输入
    private DataOutputStream dos;//输出
    private BufferedReader in;
    private PrintWriter out;

    private Paper[] papers;
    public GetAllPaper_C(String teacherID)throws IOException {
        this.socket = new Socket(Address, PORT);
        dis = new DataInputStream(new BufferedInputStream(socket.getInputStream()));
        dos = new DataOutputStream(new DataOutputStream(socket.getOutputStream()));
        in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        out = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()), true);
        dos.writeUTF(COMMAND);
        dos.flush();
        out.println(teacherID);

        papers = JSON.parseObject(in.readLine(), Paper[].class);
        this.socket.close();
    }

    public Paper[] getPapers() {
        return papers;
    }
}
