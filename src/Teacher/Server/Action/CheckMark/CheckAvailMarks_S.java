package Teacher.Server.Action.CheckMark;

import Teacher.Bean.Paper;
import Teacher.Server.DataBase.DB;
import com.alibaba.fastjson.JSON;

import java.io.*;
import java.net.Socket;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CheckAvailMarks_S {
    Socket socket;
    DB database = DB.instance;
    PrintWriter out;
    BufferedReader in;
    ResultSet resultSet,resultSet1;
    Paper[] papers;
    String[] paperID;
    int i;
    public CheckAvailMarks_S(Socket socket) throws IOException, SQLException {
        this.socket = socket;
        in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(socket.getOutputStream())), true);
        resultSet = database.query("SELECT DISTINCT paperid FROM exam.score ");
        resultSet.last();
        int n=resultSet.getRow();
         paperID=new String[n];
         for (i=0;resultSet.next();i++){
             paperID[i]=resultSet.getString("paperid");
         }

         papers=new Paper[n];
        if (n>0){
            for (i=0;i<n;i++){
                resultSet1 = database.query("SELECT * FROM papers.paper WHERE id= "+paperID[i]);
                resultSet1.beforeFirst();
                while (resultSet1.next()){
                    papers[i]=new Paper(resultSet1.getInt("id"),resultSet1.getString("title"),resultSet1.getInt("mark"),
                            resultSet1.getDouble("difficulty"),resultSet1.getString("time") ,resultSet1.getInt("examTime"),
                            resultSet1.getString("owner"),resultSet1.getInt("ownerID"), resultSet1.getString("questions"));
                }
            }
        }

        out.println(JSON.toJSONString(papers));
        System.out.println(JSON.toJSONString(papers));
    }
}
