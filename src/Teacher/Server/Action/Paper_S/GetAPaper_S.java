package Teacher.Server.Action.Paper_S;

import Teacher.Bean.Paper;
import Teacher.Server.DataBase.DB;
import com.alibaba.fastjson.JSON;

import java.io.*;
import java.net.Socket;
import java.sql.ResultSet;
import java.sql.SQLException;

public class GetAPaper_S {
    Socket socket;
    DB database = DB.instance;
    PrintWriter out;
    BufferedReader in;
    ResultSet resultSet;

    Paper paper;
    int id;
    public GetAPaper_S(Socket s) throws IOException, SQLException {
        socket = s;
        in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(socket.getOutputStream())), true);
        id=Integer.parseInt(in.readLine());

        resultSet = database.query("SELECT * FROM papers.paper WHERE id ="+id);
        paper.setId(resultSet.getInt("id"));
        paper.setTitle(resultSet.getString("title"));
        paper.setMark(resultSet.getInt("mark"));
        paper.setOwnerID(resultSet.getInt("ownerID"));
        paper.setOwner(resultSet.getString("owner"));
        paper.setTime(resultSet.getString("time"));
        paper.setExamTime(resultSet.getInt("examTime"));
        paper.setQuestions(resultSet.getString("questions"));
        out.println(JSON.toJSONString(paper));
    }
}
