package Student.Server.Action;

import Student.Bean.Student;
import Student.Server.DbConnection;
import Student.Server.Server;
import Teacher.Bean.Teacher;
import com.alibaba.fastjson.JSON;

import java.io.*;
import java.net.Socket;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TRegister {
    public TRegister(Socket socket)  throws IOException, SQLException {
        DataOutputStream dos = new DataOutputStream(new BufferedOutputStream(socket.getOutputStream()));
        BufferedReader obr = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        Teacher teacher = JSON.parseObject(obr.readLine(), Teacher.class);
        String name = teacher.getName();
        String account = teacher.getAccount();
        String password = teacher.getPassword();
        DbConnection database = Server.getDatabase();
        ResultSet resultSet = database.query("SELECT * FROM exam.teacher WHERE `account` =" + account);
        if (!resultSet.next()&&!name.equals("defaultHeadImage")) {
            dos.writeUTF("1");
            dos.flush();
            database.update("INSERT INTO exam.teacher VALUES ('" + name + "','" + account + "','" + password + "','" + Server.PATH + "/defaultHeadImage.png ')");
        } else {
            dos.writeUTF("0");
            dos.flush();
        }
    }
}
