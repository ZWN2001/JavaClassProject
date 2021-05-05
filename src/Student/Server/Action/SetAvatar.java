package Student.Server.Action;

import Student.Bean.Student;
import Student.Server.DbConnection;
import Student.Server.Server;
import com.alibaba.fastjson.JSON;

import java.io.*;
import java.net.Socket;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SetAvatar {
    DataInputStream dis;
    DataOutputStream dos;
    String path;
    Student student;
    String suffix;

    public SetAvatar(Socket socket) throws IOException, SQLException {
        dis = new DataInputStream(new BufferedInputStream(socket.getInputStream()));
        dos = new DataOutputStream(new BufferedOutputStream(socket.getOutputStream()));
        BufferedReader obr = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        student = JSON.parseObject(obr.readLine(), Student.class);
        System.out.println(student.getName());
        DbConnection database = Server.getDatabase();
        ResultSet resultSet = database.query("SELECT * FROM exam.student WHERE `account` = " + student.getAccount());
        if (resultSet.next()) {
            dos.writeUTF("1");
            dos.flush();
            getFile(Server.PATH);
            database.update("UPDATE exam.student SET `image` = '" + Server.PATH + "/" + student.getAccount() + suffix + "' WHERE `account` = " + student.getAccount());
        } else {
            dos.writeUTF("0");
            dos.flush();
        }
    }

    public void getFile(String path) throws IOException {//接收文件的方法，直接用即可,参数为存放路径
        FileOutputStream fos;
        // 文件名
        suffix = dis.readUTF();
        File directory = new File(path);
        if (!directory.exists()) {
            directory.mkdir();
        }
        File file = new File(directory.getAbsolutePath() + File.separatorChar + student.getAccount() + suffix);
        this.path = file.getAbsolutePath().replace('\\', '/');
        System.out.println(this.path);
        fos = new FileOutputStream(file);
        // 开始接收文件
        byte[] bytes = new byte[1024];
        int length;
        while ((length = dis.read(bytes, 0, bytes.length)) != -1) {
            fos.write(bytes, 0, length);
            fos.flush();
        }
    }
}
