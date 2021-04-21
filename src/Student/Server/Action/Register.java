package Student.Server.Action;

import Student.Bean.Student;
import Student.Server.DbConnection;
import Student.Server.Server;

import java.io.*;
import java.net.Socket;
import java.sql.ResultSet;

public class Register {
    public Register(Socket socket){
        try {
            System.out.println("开始尝试注册");
            DataOutputStream dos = new DataOutputStream(new BufferedOutputStream(socket.getOutputStream()));
            System.out.println("输出流建立完毕");
            ObjectInputStream ois = new ObjectInputStream(new BufferedInputStream(socket.getInputStream()));
            System.out.println("输入流建立完毕");
            Student student = (Student) ois.readObject();
            System.out.println("学生对象读取完毕");
            String name = student.getName();
            String account = student.getAccount();
            String password = student.getPassword();
            System.out.println(name+account+password);
            DbConnection database = Server.getDatabase();
            ResultSet resultSet = database.query("SELECT * FROM exam.student WHERE `account` =" + account);
            if (!resultSet.next()){
                dos.writeUTF("1");
                dos.flush();
                database.update("INSERT INTO exam.student VALUES ('" + name + "','" + account + "','" + password + "','" + Server.PATH + " \\defaultHeadImage.png ')");
                System.out.println("账号写入数据库");
            }else{
                dos.writeUTF("0");
                dos.flush();
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}
