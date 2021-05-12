package Student.Server.Action;

import Teacher.Bean.Teacher;
import Teacher.Server.DataBase.DB;
import com.alibaba.fastjson.JSON;

import java.io.*;
import java.net.Socket;
import java.sql.ResultSet;

public class Login_T {
    DataOutputStream dos;
    DB database = DB.instance;
    public Login_T(Socket socket) throws Exception{
        //返回值：0为账号不存在，-1为密码错误，1为登录成功
        BufferedReader obr = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        dos = new DataOutputStream(new BufferedOutputStream(socket.getOutputStream()));
        Teacher teacher = JSON.parseObject(obr.readLine(), Teacher.class);

        String account = teacher.getAccount();
        String password = teacher.getPassword();
        ResultSet resultSet = database.query("SELECT * FROM exam.teacher WHERE account="+account);
        if (resultSet.next()) {
            if (resultSet.getString("password").equals(password)) {
                dos.writeUTF("1");
                dos.flush();
                dos.writeUTF(resultSet.getString("name"));
                dos.flush();
            } else {
                dos.writeUTF("-1");
                dos.flush();
            }
        } else {
            dos.writeUTF("0");
            dos.flush();
        }
    }
}
