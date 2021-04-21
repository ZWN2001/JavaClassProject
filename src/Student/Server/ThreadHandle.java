package Student.Server;

import Student.Server.Action.Register;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
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
            DataInputStream dataInputStream = new DataInputStream(new BufferedInputStream(socket.getInputStream()));
            System.out.println("准备读入数据");
            String str = dataInputStream.readUTF();
            switch (str){
                case "CLOSE SERVER":
                    System.out.println("关闭服务器");
                    Server.closeServer();
                    break;
                case "REGISTER":
                    System.out.println("注册");
                    new Register(socket);
                    break;
                default:
                    System.out.println("未知命令，socket关闭");
                    break;
            }
            socket.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
