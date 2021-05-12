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
    Paper [] papers;
    int i;
    public GetAllPaper_S(Socket socket) throws IOException, SQLException {
        this.socket = socket;
        in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(socket.getOutputStream())), true);
        resultSet = database.query("SELECT * FROM papers.paper ORDER BY id");
        resultSet.last();

        int n=resultSet.getRow();
         papers=new Paper[n];

        resultSet.beforeFirst();
        for (int i = 0; resultSet.next(); i++) {
            papers[i]=new Paper(resultSet.getInt("id"),resultSet.getString("title"),resultSet.getInt("mark"),
                    resultSet.getDouble("difficulty"),resultSet.getString("time") ,resultSet.getInt("examTime"),
                    resultSet.getString("owner"),resultSet.getInt("ownerID"), resultSet.getString("questions"));

        }
        out.println(JSON.toJSONString(papers));
        System.out.println(JSON.toJSONString(papers));
    }
}
