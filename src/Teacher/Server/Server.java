package Teacher.Server;

import Teacher.Server.DataBase.DB;

import java.io.File;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.sql.SQLException;

public class Server {
    public static final String Address = "localhost";
    public static int PORT = 8080;//端口号
    public static final String PATH = "D:/ExamAvatar/server";//服务器保存图片地址
    static ServerSocket serverSocket;
    static Socket socket;
    public static DB database;
    public static void main(String[] args) throws IOException, SQLException {
        File directory = new File(PATH);
        if (!directory.exists()) {
            directory.mkdir();
        }
        serverSocket = new ServerSocket(PORT);
        System.out.println("服务端启动，端口:" + PORT);

        database = new DB();//初始化数据库
        while (true) {
            try {
                socket = serverSocket.accept();
            } catch (SocketException e) {
                System.out.println("收到服务器关闭指令！服务器已关闭");
                break;
            }
            new ThreadHandle(socket).start();//将socket交给多线程，进一步处理客户端的指令
        }
    }

    public static void closeServer() throws IOException, SQLException {//安全关闭服务器的方法
        serverSocket.close();
        database.close();
        System.exit(0);
    }
}
