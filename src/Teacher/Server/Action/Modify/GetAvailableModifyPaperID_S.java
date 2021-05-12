package Teacher.Server.Action.Modify;

import Teacher.Bean.Paper;
import Teacher.Server.DataBase.DB;
import com.alibaba.fastjson.JSON;

import java.io.*;
import java.net.Socket;
import java.sql.ResultSet;
import java.sql.SQLException;

public class GetAvailableModifyPaperID_S {
    Socket socket;
    DB database = DB.instance;
    PrintWriter out;
    BufferedReader in;
    ResultSet resultSet;
    int[] ID;
    int i;
    public GetAvailableModifyPaperID_S(Socket socket) throws IOException, SQLException {
        this.socket = socket;
        in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(socket.getOutputStream())), true);
        resultSet = database.query("SELECT DISTINCT paperid FROM exam.answer ");
        resultSet.last();

        int n=resultSet.getRow();
        ID=new int[n];

        resultSet.beforeFirst();
        for ( i = 0; resultSet.next(); i++) {
            ID[i]=resultSet.getInt("paper");
        }
        out.println(JSON.toJSONString(ID));
    }
}
