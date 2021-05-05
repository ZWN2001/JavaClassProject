package Teacher.Server.Action.Paper_S;

import Teacher.Bean.Paper;
import Teacher.Server.DataBase.DB;
import com.alibaba.fastjson.JSON;

import java.io.*;
import java.net.Socket;
import java.sql.ResultSet;
import java.sql.SQLException;

public class GetAllPaper_S {
    Socket socket;
    DB database = DB.instance;
    PrintWriter out;
    BufferedReader in;
    ResultSet resultSet;

    public GetAllPaper_S(Socket socket) throws IOException, SQLException {
        this.socket = socket;
        in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(socket.getOutputStream())), true);
        resultSet = database.query("SELECT * FROM papers.paper ORDER BY id");
        resultSet.last();

        Paper [] papers=new Paper[resultSet.getRow()];

        resultSet.beforeFirst();
        for (int i = 0; resultSet.next(); i++) {
            papers[i].setId(resultSet.getInt("id"));
            papers[i].setTitle(resultSet.getString("title"));
            papers[i].setMark(resultSet.getInt("mark"));
            papers[i].setOwnerID(resultSet.getInt("ownerID"));
            papers[i].setOwner(resultSet.getString("owner"));
            papers[i].setTime(resultSet.getString("time"));
            papers[i].setExamTime(resultSet.getInt("examTime"));
            papers[i].setQuestions(resultSet.getString("questions"));
        }
        out.println(JSON.toJSONString(papers));
    }
}
