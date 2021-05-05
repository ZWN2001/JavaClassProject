package Teacher.Function.ClientFuction.Paper;

import Teacher.Bean.Paper;
import com.alibaba.fastjson.JSON;

import java.io.*;
import java.net.Socket;

import static Teacher.Server.ServerMain.Address;
import static Teacher.Server.ServerMain.PORT;

public class GetAPaper_C {
    String COMMAND="GET_A_PAPER";
    private Socket socket;
    private DataInputStream dis;//输入
    private DataOutputStream dos;//输出
    private BufferedReader in;
    private PrintWriter out;
    private Paper paper;

    public GetAPaper_C(int id) throws IOException {
        this.socket = new Socket(Address, PORT);
        dis = new DataInputStream(new BufferedInputStream(socket.getInputStream()));
        dos = new DataOutputStream(new DataOutputStream(socket.getOutputStream()));
        in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        out = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()), true);
        dos.writeUTF(COMMAND);
        dos.flush();

        out.println(id);
        paper = JSON.parseObject(in.readLine(), Paper.class);
        this.socket.close();
    }

    public Paper getPaper() {
        return paper;
    }
}
