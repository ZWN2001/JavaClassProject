package Teacher.Server.Action.CheckMark;

import Teacher.Server.DataBase.DB;
import Teacher.Test.PaperMark;
import com.alibaba.fastjson.JSON;

import java.io.*;
import java.net.Socket;
import java.sql.ResultSet;
import java.sql.SQLException;

public class GetEachPaperMark_S {
    Socket socket;
    DB database = DB.instance;
    PrintWriter out;
    BufferedReader in;
    ResultSet resultSet,resultSet1;
    private PaperMark[] paperMarks;
    String paperID;
    int i;
    public GetEachPaperMark_S(Socket socket) throws IOException, SQLException {
        this.socket = socket;
        in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(socket.getOutputStream())), true);

        paperID=in.readLine();
        resultSet = database.query("SELECT * FROM exam.score WHERE paperid= "+paperID+" ORDER BY sumScore");
        resultSet.last();
        int n=resultSet.getRow();
        paperMarks=new PaperMark[n];
        resultSet.beforeFirst();
        if (n>0){
            for (i=0;resultSet.next();i++){
                String studentName="";
                resultSet1=database.query("SELECT name FROM exam.student WHERE account = "+resultSet.getString("student"));
                while (resultSet1.next()){
                     studentName=resultSet1.getString("name");
                }
                int objScore=Integer.parseInt(resultSet.getString("objectivescore"));
                int subScore=Integer.parseInt(resultSet.getString("subjectivescore"));
                paperMarks[i]=new PaperMark(studentName,objScore,subScore,objScore+subScore);
            }
        }

        out.println(JSON.toJSONString(paperMarks));
        System.out.println(JSON.toJSONString(paperMarks));
    }
}
