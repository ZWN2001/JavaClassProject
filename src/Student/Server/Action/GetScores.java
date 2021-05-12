package Student.Server.Action;

import Student.Bean.Scores;
import Student.Bean.Student;
import Teacher.Bean.Paper;
import Teacher.Server.DataBase.DB;
import com.alibaba.fastjson.JSON;

import java.io.*;
import java.net.Socket;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class GetScores {
    DB database = DB.instance;
    public GetScores(Socket socket) throws IOException, SQLException {
        BufferedReader obr = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        DataOutputStream dos = new DataOutputStream(new BufferedOutputStream(socket.getOutputStream()));
        PrintWriter opw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(socket.getOutputStream())), true);
        Student student = JSON.parseObject(obr.readLine(), Student.class);
       // DbConnection database = Server.getDatabase();
        String account = student.getAccount();
        String resultCode = "0";
        ArrayList<Scores> scoresList = new ArrayList<>();
        ResultSet resultSet = database.query("SELECT * FROM exam.score WHERE `student` = " + account);
        while (resultSet.next()) {
            System.out.println("有信息");
            String paperID = resultSet.getString("paperid");
            ResultSet paperSet = database.query("SELECT * FROM papers.paper WHERE `id` = " + paperID);
            if (paperSet.next()) {
                resultCode = "1";
                System.out.println("返回值为1");
                Paper paper = new Paper(paperSet.getString("title"), paperSet.getInt("ownerID"), paperSet.getString("owner"), paperSet.getString("time"), paperSet.getInt("difficulty"));
                scoresList.add(new Scores(student.getAccount(), paper, resultSet.getInt("objectivescore"), resultSet.getInt("subjectivescore")));
            }
        }
        dos.writeUTF(resultCode);
        dos.flush();
        if (resultCode.equals("1")) {
            for (Scores scores : scoresList){
                opw.println(JSON.toJSONString(scores));
            }
            opw.println(JSON.toJSONString(new Scores("",new Paper("",0,0,"",0,"",0,""),0,0)));
        }
    }
}
