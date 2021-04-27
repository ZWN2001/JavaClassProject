package Student.Server.Action;

import Student.Bean.Student;
import Student.Server.DbConnection;
import Student.Server.Server;
import com.alibaba.fastjson.JSON;

import java.io.*;
import java.net.Socket;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Register {
    Socket socket;
    DataOutputStream dos;
    BufferedReader obr;
    Student student;
    public Register(Socket s) throws IOException, SQLException {
        this.socket=s;
        System.out.println("开始尝试注册");
        dos = new DataOutputStream(new BufferedOutputStream(socket.getOutputStream()));
        System.out.println("输出流建立完毕");
        obr = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        System.out.println("输入流建立完毕");
        student = JSON.parseObject(obr.readLine(),Student.class);
        System.out.println("学生对象读取完毕");
        String name = student.getName();
        String account = student.getAccount();
        String password = student.getPassword();
        System.out.println(name + account + password);
        DbConnection database = Server.getDatabase();
        ResultSet resultSet = database.query("SELECT * FROM exam.student WHERE `account` =" + account);
        if (!resultSet.next()) {
            dos.writeUTF("1");
            dos.flush();
            database.update("INSERT INTO exam.student VALUES ('" + name + "','" + account + "','" + password + "','" + Server.PATH + "/defaultHeadImage.png ')");
            System.out.println("账号写入数据库");
        } else {
            dos.writeUTF("0");
            dos.flush();
        }
    }
}
