package Student.Server.Action;

import Student.Bean.Student;
import Student.Server.DbConnection;
import Student.Server.Server;
import Teacher.Bean.Paper;
import com.alibaba.fastjson.JSON;

import java.io.*;
import java.net.Socket;
import java.sql.SQLException;

public class UploadAnswer {
    public UploadAnswer(Socket socket) throws IOException, SQLException {
        DataOutputStream dos = new DataOutputStream(new BufferedOutputStream(socket.getOutputStream()));
        BufferedReader obr = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        Student student = JSON.parseObject(obr.readLine(), Student.class);
        Paper paper =JSON.parseObject(obr.readLine(),Paper.class);
        String answer = obr.readLine();
        DbConnection database = Server.getDatabase();
        database.update("INSERT INTO exam.answer VALUES ('" + student.getAccount() + "','" + paper.getId() + "','"+ answer + "')");
        dos.writeUTF("1");
    }
}
