package Student.Server;

import java.io.File;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.sql.SQLException;

public class Server {
    public static int PORT = 8080;
    public static final String PATH = "D:\\ExamAvatar";
    static ServerSocket serverSocket;
    static Socket socket;
    private static DbConnection database;

    public static DbConnection getDatabase() {
        return database;
    }

    public static void main(String[] args) throws IOException, SQLException {
        File directory = new File(PATH);
        if (!directory.exists()) directory.mkdir();
        serverSocket = new ServerSocket(PORT);
        database = new DbConnection();
        while (true) {
            try {
                socket = serverSocket.accept();
            } catch (SocketException e) {
                break;
            }
            new ThreadHandle(socket).start();
        }
    }

    public static void closeServer() throws IOException, SQLException {//安全关闭服务器的方法
        serverSocket.close();
        database.close();
        System.exit(0);
    }
}
