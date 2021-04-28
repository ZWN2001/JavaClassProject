package Student.Server.Action;

import Student.Bean.Student;
import Student.Server.DbConnection;
import Student.Server.Server;
import com.alibaba.fastjson.JSON;

import java.io.*;
import java.net.Socket;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SetPassword {
    //返回值：1为修改成功，0为密码错误，-1为新密码与旧密码相同
    public SetPassword(Socket socket) throws IOException, SQLException {
        DataInputStream dis = new DataInputStream(socket.getInputStream());
        DataOutputStream dos = new DataOutputStream(new BufferedOutputStream(socket.getOutputStream()));
        BufferedReader obr = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        String pPassword = dis.readUTF();
        String newPassword = dis.readUTF();
        System.out.println("读取新密码成功" + pPassword + " " + newPassword);
        Student student = JSON.parseObject(obr.readLine(), Student.class);
        String account = student.getAccount();
        System.out.println("读取学生对象成功" + account);
        DbConnection database = Server.getDatabase();
        ResultSet resultSet = database.query("SELECT * FROM exam.student WHERE `account` = " + account);
        if (resultSet.next()) {
            if (resultSet.getString("password").equals(pPassword)) {
                if (!pPassword.equals(newPassword)) {
                    dos.writeUTF("1");
                    dos.flush();
                    database.update("UPDATE exam.student SET `password` = " + newPassword + " WHERE `account` = " + account);
                } else {
                    dos.writeUTF("-1");
                    dos.flush();
                }
            } else {
                dos.writeUTF("0");
                dos.flush();
            }
            System.out.println("已发送返回值");
        }
    }
}
