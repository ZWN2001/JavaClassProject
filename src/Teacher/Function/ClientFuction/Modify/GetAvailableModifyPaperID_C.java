package Teacher.Function.ClientFuction.Modify;

import com.alibaba.fastjson.JSON;

import java.io.*;
import java.net.Socket;

import static Teacher.Server.ServerMain.Address;
import static Teacher.Server.ServerMain.PORT;

public class GetAvailableModifyPaperID_C {
    String COMMAND="GET_MODIFY_PAPER";
    private Socket socket;
    private DataInputStream dis;//输入
    private DataOutputStream dos;//输出
    private BufferedReader in;
    private PrintWriter out;

    private int[] ID;
    public GetAvailableModifyPaperID_C()throws IOException {
        this.socket = new Socket(Address, PORT);
        dis = new DataInputStream(new BufferedInputStream(socket.getInputStream()));
        dos = new DataOutputStream(new DataOutputStream(socket.getOutputStream()));
        in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        out = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()), true);
        dos.writeUTF(COMMAND);
        dos.flush();

        ID = JSON.parseObject(in.readLine(), int[].class);
        this.socket.close();
    }

    public int[] getModifyID() {
        return ID;
    }
}
