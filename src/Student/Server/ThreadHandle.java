package Student.Server;

import Basic.Command;
import Student.Server.Action.*;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.net.Socket;

public class ThreadHandle extends Thread {
    Socket socket;

    public ThreadHandle(Socket socket) {
        this.socket = socket;
        System.out.println("客户端连接：" + socket.getInetAddress() + ":" + socket.getPort());
    }

    @Override
    public void run() {
        super.run();
        try{
            DataInputStream dataInputStream = new DataInputStream(socket.getInputStream());
            System.out.println("准备读入数据");
            String str = dataInputStream.readUTF();
            System.out.println("收到客户端指令：" + str);//客户端发送一条指令，服务端接收后由action包中类响应然后关闭连接。一线程只处理一任务。因此这里只分析第一条语句，只处理一道命令。后续的收发数据由action包中的相应类完成

            switch (str){
                case Command.CLOSER_SERVER:
                    Server.closeServer();
                    break;
                case Command.S_LOGIN:
                    new Login(socket);
                    break;
                case Command.S_REGISTER:
                    new Register(socket);
                    break;
                default:
                    System.out.println("未知命令，socket关闭");
                    break;
            }
            socket.close();
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            try {
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
