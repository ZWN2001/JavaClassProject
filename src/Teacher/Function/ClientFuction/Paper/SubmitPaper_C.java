package Teacher.Function.ClientFuction.Paper;

import Teacher.Bean.Paper;
import com.alibaba.fastjson.JSON;

import java.io.*;
import java.net.Socket;

import static Teacher.Server.Server.Address;
import static Teacher.Server.Server.PORT;

public class SubmitPaper_C {
    final DataOutputStream dos;
    final int  resultCode;
    private final String COMMAND="SUBMIT_PAPER";
    public SubmitPaper_C(Paper paper) throws IOException {
        Socket socket = new Socket(Address, PORT);
        dos = new DataOutputStream(new BufferedOutputStream(socket.getOutputStream()));
        DataInputStream dis = new DataInputStream(new BufferedInputStream(socket.getInputStream()));
        //输出
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(socket.getOutputStream())), true);
        //请求类型
        dos.writeUTF(COMMAND);
        dos.flush();

        String json = JSON.toJSONString(paper);
        out.println(json);
        resultCode = Integer.parseInt(dis.readUTF());
        socket.close();
    }

    public int getResultCode() {
        return resultCode;
    }
}
