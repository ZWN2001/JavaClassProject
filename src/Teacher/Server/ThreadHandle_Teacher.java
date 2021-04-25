package Teacher.Server;


import Teacher.Server.Action.SubmitQuestion_S.SubmitQuestion_Choice_S;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.Socket;

public class ThreadHandle_Teacher extends Thread {
    Socket socket;

    ThreadHandle_Teacher(Socket s) {
        socket = s;
        System.out.println("客户端连接：" + s.getInetAddress() + ":" + s.getPort());
    }

    @Override
    public void run() {
        try {
            DataInputStream dataInputStream = new DataInputStream(socket.getInputStream());
            String str = dataInputStream.readUTF();

            System.out.println("收到客户端指令：" + str);//客户端发送一条指令，服务端接收后由action包中类响应然后关闭连接。一线程只处理一任务。因此这里只分析第一条语句，只处理一道命令。后续的收发数据由action包中的相应类完成
            switch (str) {
                case "CLOSE SERVER":
                    ServerMain.closeServer();
                    break;
                case "SUBMIT_QUESTION_CHOICE":
                    new SubmitQuestion_Choice_S(socket);
                    break;
                default:
                    System.out.println("未知的教师端命令，socket直接关闭");
                    break;
            }
          //  socket.close();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
