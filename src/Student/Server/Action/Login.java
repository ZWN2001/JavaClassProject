package Student.Server.Action;

import Student.Bean.Student;
import Student.Server.DbConnection;
import Student.Server.Server;
import com.alibaba.fastjson.JSON;

import java.io.*;
import java.net.Socket;
import java.sql.ResultSet;

public class Login {
    Socket socket;
    public Login(Socket s) throws Exception{
        this.socket=s;
        //返回值：0为账号不存在，-1为密码错误，1为登录成功
            System.out.println("开始尝试登录");
            //ObjectInputStream ois = new ObjectInputStream(new BufferedInputStream(socket.getInputStream()));
            BufferedReader obr = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            System.out.println("输入流建立完毕");
            DataOutputStream dos = new DataOutputStream(new BufferedOutputStream(socket.getOutputStream()));
            System.out.println("输出流建立完毕");
            Student student = JSON.parseObject(obr.readLine(), Student.class);//json->Student
            System.out.println("学生对象读取完毕");

            String account = student.getAccount();
            String password = student.getPassword();
            DbConnection database = Server.getDatabase();
            ResultSet resultSet = database.query("SELECT * FROM exam.student WHERE `account` =" + account);
            if (resultSet.next()) {
                if (resultSet.getString("password").equals(password)) {
                    dos.writeUTF("1");
                } else {
                    dos.writeUTF("-1");
                }
            } else {
                dos.writeUTF("0");
            }
            dos.flush();
    }
}
