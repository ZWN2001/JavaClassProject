package Student.Server.Action;

import Student.Bean.Student;
import Student.Server.DbConnection;
import Student.Server.Server;
import com.alibaba.fastjson.JSON;

import java.io.*;
import java.net.Socket;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SetClass {
    //返回值：1为加入成功，0为已经加入，-1为不存在该班级
    public SetClass(Socket socket) throws IOException, SQLException {
        DataInputStream dis = new DataInputStream(socket.getInputStream());
        DataOutputStream dos = new DataOutputStream(new BufferedOutputStream(socket.getOutputStream()));
        BufferedReader obr = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        String classNum = dis.readUTF();
        Student student = JSON.parseObject(obr.readLine(), Student.class);
        DbConnection database = Server.getDatabase();
        ResultSet resultSet = database.query("SELECT * FROM exam.teacher WHERE `account` = '" + classNum + "'");
        if (resultSet.next()) {
            resultSet = database.query("SELECT * FROM exam.index WHERE `student` = '" + student.getAccount() + "' AND `teacher` = " + classNum);
            if (resultSet.next()) {
                dos.writeUTF("0");
            } else {
                database.update("INSERT INTO exam.index VALUES ('" + student.getAccount() + "','" + classNum + "')");
                dos.writeUTF("1");
            }
        }
        else {
            dos.writeUTF("-1");
        }
        dos.flush();
    }
}
