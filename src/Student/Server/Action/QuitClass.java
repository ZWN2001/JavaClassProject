package Student.Server.Action;

import Student.Bean.Student;
import Student.Server.DbConnection;
import Student.Server.Server;
import Teacher.Bean.Teacher;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;

import java.io.*;
import java.net.Socket;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

public class QuitClass {
    DataOutputStream dos;
    public QuitClass(Socket socket) throws IOException, SQLException {
        dos = new DataOutputStream(new BufferedOutputStream(socket.getOutputStream()));
        BufferedReader obr = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        DbConnection database = Server.getDatabase();
        Student student = JSON.parseObject(obr.readLine(), Student.class);
        Vector<Teacher> teacherVector = JSON.parseObject(obr.readLine(), new TypeReference<>() {});
        for (Teacher teacher : teacherVector) {
            Statement statement = database.getConnection().createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM exam.index WHERE `student` = '" + student.getAccount() + "' AND `teacher` = '" + teacher.getAccount() + "'");
            if (resultSet.next())
                statement.executeUpdate("DELETE FROM exam.index WHERE `student` = '"+student.getAccount()+"' AND `teacher` = '"+teacher.getAccount()+"'");
        }
        dos.writeUTF("1");
        dos.flush();
    }
}
