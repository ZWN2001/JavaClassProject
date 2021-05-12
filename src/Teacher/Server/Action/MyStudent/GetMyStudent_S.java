package Teacher.Server.Action.MyStudent;

import Teacher.Server.DataBase.DB;
import com.alibaba.fastjson.JSON;

import java.io.*;
import java.net.Socket;
import java.sql.ResultSet;
import java.sql.SQLException;

public class GetMyStudent_S {
    Socket socket;
    DB database = DB.instance;
    PrintWriter out;
    BufferedReader in;
    ResultSet resultSet,resultSet1;

    String teacherID;
    String[] studentID;
    String[] studentName;
    int i;
    public GetMyStudent_S(Socket socket) throws IOException, SQLException {
        this.socket = socket;
        in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(socket.getOutputStream())), true);
        teacherID=in.readLine();
        resultSet = database.query("SELECT DISTINCT student FROM exam.index WHERE teacher = "+teacherID);
        resultSet.last();

        int n=resultSet.getRow();
        studentID=new String[n];

        resultSet.beforeFirst();
        for ( i = 0; resultSet.next(); i++) {
            studentID[i]=resultSet.getString("student");
        }

        studentName=new String[n];
        if (n>0){
            for (i=0;i<n;i++){
                resultSet1 = database.query("SELECT name FROM exam.student WHERE account = "+studentID[i]);
                resultSet1.beforeFirst();
                while (resultSet1.next()){
                    studentName[i]=resultSet1.getString("name");
                }
            }
        }
        out.println(JSON.toJSONString(studentName));
    }
}
