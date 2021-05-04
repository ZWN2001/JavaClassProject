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

public class GetClass {
    //1为存在班级，0为未加入任何班级，-1是不应该发生的错误
    public GetClass(Socket socket) throws IOException, SQLException {
        BufferedReader obr = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        DataOutputStream dos = new DataOutputStream(new BufferedOutputStream(socket.getOutputStream()));
        PrintWriter opw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(socket.getOutputStream())), true);
        Student student = JSON.parseObject(obr.readLine(), Student.class);
        DbConnection database = Server.getDatabase();
        String account = student.getAccount();
        ResultSet resultSet = database.query("SELECT * FROM exam.index WHERE `student` =" + account);
        if (resultSet.next()) {
            dos.writeUTF("1");
            dos.flush();
            ResultSet newResultSet = database.query1("SELECT * FROM exam.index WHERE `student` =" + account);
            while (newResultSet.next()) {
                String teacherAcc = newResultSet.getString("teacher");
                ResultSet teacherSet = database.query2("SELECT * FROM exam.teacher WHERE `account` =" + teacherAcc);
                if (teacherSet.next()) {
                    Teacher teacher = new Teacher(teacherSet.getString("account"), teacherSet.getString("name"));
                    opw.println(JSON.toJSONString(teacher));
                }
                else {
                    dos.writeUTF("-1");
                    dos.flush();
                }
            }
            Teacher teacher = new Teacher("","");
            opw.println(JSON.toJSONString(teacher));
        } else {
            dos.writeUTF("0");
            dos.flush();
        }
    }
}
