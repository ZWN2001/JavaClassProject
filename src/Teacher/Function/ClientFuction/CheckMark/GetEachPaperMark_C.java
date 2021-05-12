package Teacher.Function.ClientFuction.CheckMark;

import Teacher.Bean.Paper;
import Teacher.Test.PaperMark;
import com.alibaba.fastjson.JSON;

import java.io.*;
import java.net.Socket;

import static Teacher.Server.ServerMain.Address;
import static Teacher.Server.ServerMain.PORT;

public class GetEachPaperMark_C {
    String COMMAND="GET_EACH_MARK";
    private Socket socket;
    private DataInputStream dis;//输入
    private DataOutputStream dos;//输出
    private BufferedReader in;
    private PrintWriter out;

    private PaperMark[] paperMarks;
    public GetEachPaperMark_C(int paperID)throws IOException {
        this.socket = new Socket(Address, PORT);
        dis = new DataInputStream(new BufferedInputStream(socket.getInputStream()));
        dos = new DataOutputStream(new DataOutputStream(socket.getOutputStream()));
        in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        out = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()), true);
        dos.writeUTF(COMMAND);
        dos.flush();

        paperMarks = JSON.parseObject(in.readLine(), PaperMark[].class);
        this.socket.close();
    }

    public PaperMark[] getMarks() {
        return paperMarks;
    }
}
