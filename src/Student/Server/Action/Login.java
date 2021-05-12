package Student.Server.Action;

import Student.Bean.Student;
import Teacher.Server.DataBase.DB;
import com.alibaba.fastjson.JSON;

import java.io.*;
import java.net.Socket;
import java.sql.ResultSet;

public class Login {
    DataOutputStream dos;
    DB database = DB.instance;
    public Login(Socket socket) throws Exception{
        //返回值：0为账号不存在，-1为密码错误，1为登录成功
            BufferedReader obr = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            dos = new DataOutputStream(new BufferedOutputStream(socket.getOutputStream()));
            Student student = JSON.parseObject(obr.readLine(), Student.class);

            String account = student.getAccount();
            String password = student.getPassword();
          //  DbConnection database = Server.getDatabase();
            ResultSet resultSet = database.query("SELECT * FROM exam.student WHERE `account` =" + account);
            if (resultSet.next()) {
                if (resultSet.getString("password").equals(password)) {
                    dos.writeUTF("1");
                    dos.flush();
                    dos.writeUTF(resultSet.getString("name"));
                    dos.flush();

                    sendFile(resultSet.getString("image"));
                } else {
                    dos.writeUTF("-1");
                    dos.flush();
                }
            } else {
                dos.writeUTF("0");
                dos.flush();
            }
    }

    private void sendFile(String path) throws Exception {//传图方法，直接用就行
        FileInputStream fis;
        File file = new File(path);
        if (file.exists()) {
            fis = new FileInputStream(file);
            // 文件名
            dos.writeUTF(file.getName());
            dos.flush();
            // 开始传输文件
            byte[] bytes = new byte[1024];
            int length;
            while ((length = fis.read(bytes, 0, bytes.length)) != -1) {
                dos.write(bytes, 0, length);
                dos.flush();
            }
        } else System.out.println("文件不存在");
    }
}
