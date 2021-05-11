package Student.Server;

import Student.Server.Action.*;
import Teacher.Server.Action.GetPreviewQuestions_S;

import static Basic.Command.*;

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
            String str = dataInputStream.readUTF();
            System.out.println("收到客户端指令：" + str);//客户端发送一条指令，服务端接收后由action包中类响应然后关闭连接。一线程只处理一任务。因此这里只分析第一条语句，只处理一道命令。后续的收发数据由action包中的相应类完成

            switch (str){
                case CLOSER_SERVER:
                    Server.closeServer();
                    break;
                case GET_QUESTION_PREVIEW:
                    new GetPreviewQuestions_S(socket);
                    break;
                case S_GET_CLASS:
                    new GetClass(socket);
                    break;
                case S_GET_EXAM:
                    new GetExam(socket);
                    break;
                case S_GET_SCORES:
                    new GetScores(socket);
                    break;
                case S_LOGIN:
                    new Login(socket);
                    break;
                case S_QUIT_CLASS:
                    new QuitClass(socket);
                    break;
                case S_REFRESH_AVATAR:
                    new RefreshAvatar(socket);
                    break;
                case S_REGISTER:
                    new Register(socket);
                    break;
                case S_SET_AVATAR:
                    new SetAvatar(socket);
                    break;
                case S_SET_CLASS:
                    new SetClass(socket);
                    break;
                case S_SET_NAME:
                    new SetName(socket);
                    break;
                case S_SET_PASSWORD:
                    new SetPassword(socket);
                    break;
                case UPLOAD_ANSWER:
                    new UploadAnswer(socket);
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
