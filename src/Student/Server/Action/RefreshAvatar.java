package Student.Server.Action;

import Student.Bean.Student;
import Student.Server.DbConnection;
import Student.Server.Server;
import com.alibaba.fastjson.JSON;

import java.io.*;
import java.net.Socket;
import java.sql.ResultSet;

public class RefreshAvatar{
    DataOutputStream dos;
    public RefreshAvatar(Socket socket) throws Exception {
        BufferedReader obr = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        dos = new DataOutputStream(new BufferedOutputStream(socket.getOutputStream()));
        Student student = JSON.parseObject(obr.readLine(),Student.class);
        String account = student.getAccount();
        DbConnection database = Server.getDatabase();
        ResultSet resultSet = database.query("SELECT * FROM exam.student WHERE `account` =" + account);
        if (resultSet.next()) {
            String path = resultSet.getString("image");
            sendFile(path);
        }
    }

    private void sendFile(String path) throws Exception {//传图方法，直接用就行
        FileInputStream fis;
        File file = new File(path);
        if (file.exists()) {
            fis = new FileInputStream(file);
            dos.writeUTF(file.getName());
            dos.flush();
            byte[] bytes = new byte[1024];
            int length;
            while ((length = fis.read(bytes, 0, bytes.length)) != -1) {
                dos.write(bytes, 0, length);
                dos.flush();
            }
        } else System.out.println("文件不存在");
    }
}
