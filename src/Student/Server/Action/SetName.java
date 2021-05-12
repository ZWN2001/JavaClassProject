package Student.Server.Action;

import Student.Bean.Student;
import Teacher.Server.DataBase.DB;
import com.alibaba.fastjson.JSON;

import java.io.*;
import java.net.Socket;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SetName {
     DataInputStream dis;
    DataOutputStream dos;
    DB database = DB.instance;
    public SetName(Socket socket) throws IOException, SQLException {
        dis = new DataInputStream(socket.getInputStream());
        dos = new DataOutputStream(new BufferedOutputStream(socket.getOutputStream()));
        BufferedReader obr = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        String newName = dis.readUTF();
        Student student = JSON.parseObject(obr.readLine(), Student.class);
        //DbConnection database = Server.getDatabase();
        ResultSet resultSet = database.query("SELECT * FROM exam.student WHERE `account` = " + student.getAccount());
        if (resultSet.next()) {
            database.update("UPDATE exam.student SET `name` = '" + newName + "' WHERE `account` = " + student.getAccount());
            dos.writeUTF("1");
        } else {
            dos.writeUTF("0");
        }
        dos.flush();
    }
}
