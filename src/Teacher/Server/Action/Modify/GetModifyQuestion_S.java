package Teacher.Server.Action.Modify;

import Teacher.Server.DataBase.DB;
import com.alibaba.fastjson.JSON;

import java.io.*;
import java.net.Socket;
import java.sql.ResultSet;
import java.sql.SQLException;

public class GetModifyQuestion_S {
    Socket socket;
    DB database = DB.instance;
    PrintWriter out;
    BufferedReader in;
    ResultSet resultSet;
    int i;
    private int paperID;
    private String[] studentName;
    private String[] answers;
    public GetModifyQuestion_S(Socket socket) throws IOException, SQLException {
        this.socket = socket;
        in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(socket.getOutputStream())), true);
        paperID=Integer.parseInt(in.readLine());
        resultSet = database.query("SELECT student,answer FROM exam.answer WHERE paper = "+paperID);
        resultSet.last();

        int n=resultSet.getRow();
        studentName=new String[n];
        answers=new String[n];

        resultSet.beforeFirst();
        for ( i = 0; resultSet.next(); i++) {
            studentName[i]=resultSet.getString("student");
            answers[i]=resultSet.getString("paper");
        }
        out.println(JSON.toJSONString(studentName));
        out.println(JSON.toJSONString(answers));
    }
}
