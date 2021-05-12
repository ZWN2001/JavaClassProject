package Teacher.Function.ClientFuction.Paper;

import java.io.*;
import java.net.Socket;

import static Teacher.Server.Server.Address;
import static Teacher.Server.Server.PORT;

public class GetAutoPaper_C {
    String COMMAND="GET_AUTO_PAPER";
    private Socket socket;
    private DataInputStream dis;//输入
    private DataOutputStream dos;//输出
    private BufferedReader in;
    private PrintWriter out;
    private  String questionString;

    public GetAutoPaper_C(String demand)throws IOException {
        this.socket = new Socket(Address, PORT);
        dis = new DataInputStream(new BufferedInputStream(socket.getInputStream()));
        dos = new DataOutputStream(new DataOutputStream(socket.getOutputStream()));
        in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        out = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()), true);
        dos.writeUTF(COMMAND);
        dos.flush();

        out.println(demand);
        questionString =in.readLine();
        this.socket.close();
    }

    public String getQuestionString() {
        return questionString;
    }
}
