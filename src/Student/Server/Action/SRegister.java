package Student.Server.Action;

import Student.Bean.Student;
import Student.Server.DbConnection;
import Student.Server.Server;
import com.alibaba.fastjson.JSON;

import java.io.*;
import java.net.Socket;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SRegister {
    public SRegister(Socket socket) throws IOException, SQLException {
        DataOutputStream dos = new DataOutputStream(new BufferedOutputStream(socket.getOutputStream()));
        BufferedReader obr = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        Student student = JSON.parseObject(obr.readLine(),Student.class);
        String name = student.getName();
        String account = student.getAccount();
        String password = student.getPassword();
        DbConnection database = Server.getDatabase();
        ResultSet resultSet = database.query("SELECT * FROM exam.student WHERE `account` =" + account);
        if (!resultSet.next()&&!account.equals("defaultHeadImage")) {
            dos.writeUTF("1");
            dos.flush();
            database.update("INSERT INTO exam.student VALUES ('" + name + "','" + account + "','" + password + "','" + Server.PATH + "/defaultHeadImage.png ')");
        } else {
            dos.writeUTF("0");
            dos.flush();
        }
    }
}
