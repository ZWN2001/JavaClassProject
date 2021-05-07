package Student.Server.Action;

import Student.Bean.Student;
import Student.Server.DbConnection;
import Student.Server.Server;
import Teacher.Bean.Paper;
import Teacher.Bean.Teacher;
import com.alibaba.fastjson.JSON;

import java.io.*;
import java.net.Socket;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

public class GetExam {
    //-1为未加入任何班级，0为已加入班级但没有任何待完成试卷，1为读取成功
    public GetExam(Socket socket) throws IOException, SQLException {
        BufferedReader obr = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        DataOutputStream dos = new DataOutputStream(new BufferedOutputStream(socket.getOutputStream()));
        PrintWriter opw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(socket.getOutputStream())), true);
        Student student = JSON.parseObject(obr.readLine(), Student.class);
        DbConnection database = Server.getDatabase();
        String account = student.getAccount();
        Vector<Teacher> teachers = new Vector<>();
        Vector<Paper> papers = new Vector<>();
        ResultSet resultSet = database.query("SELECT * FROM exam.index WHERE `student` =" + account);
        if (resultSet.next()) {
            ResultSet newResultSet = database.query1("SELECT * FROM exam.index WHERE `student` =" + account);
            while (newResultSet.next()) {
                String teacherAcc = newResultSet.getString("teacher");
                ResultSet teacherSet = database.query2("SELECT * FROM exam.teacher WHERE `account` =" + teacherAcc);
                if (teacherSet.next()) {
                    Teacher teacher = new Teacher(teacherSet.getString("account"), teacherSet.getString("name"));
                    teachers.add(teacher);
                }
            } //填充teachers
            for (Teacher teacher : teachers) {
                Statement statement = database.getConnection().createStatement();
                ResultSet examSet = statement.executeQuery("SELECT * FROM exam.paper WHERE `owner` = " + teacher.getAccount());
                while (examSet.next()) {
                    papers.add(new Paper(resultSet.getInt("id"), resultSet.getString("title"), resultSet.getInt("difficulty"),resultSet.getInt("mark"), resultSet.getString("time"), resultSet.getInt("examTime"), resultSet.getString("owner"), resultSet.getInt("ownerID"), resultSet.getString("questions")));
                }
                if (papers.size() == 0) {
                    dos.writeUTF("0");
                    dos.flush();
                } else {
                    dos.writeUTF("1");
                    dos.flush();
                    opw.println(JSON.toJSONString(papers));
                }
            }
        } else {
            dos.writeUTF("-1");
            dos.flush();
        }
    }
}
