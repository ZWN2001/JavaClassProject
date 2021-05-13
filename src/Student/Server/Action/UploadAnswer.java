package Student.Server.Action;

import Student.Bean.Student;
import Teacher.Bean.Paper;
import Teacher.Server.DataBase.DB;
import com.alibaba.fastjson.JSON;

import java.io.*;
import java.net.Socket;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class UploadAnswer {
    DB database = DB.instance;
    public UploadAnswer(Socket socket) throws IOException, SQLException {
        DataOutputStream dos = new DataOutputStream(new BufferedOutputStream(socket.getOutputStream()));
        BufferedReader obr = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        Student student = JSON.parseObject(obr.readLine(), Student.class);
        Paper paper = JSON.parseObject(obr.readLine(), Paper.class);
        String answer = obr.readLine();
        //DbConnection database = Server.getDatabase();
        database.update("INSERT INTO exam.answer VALUES ('" + student.getAccount() + "','" + paper.getId() + "','" + answer + "')");
        String[] answers = JSON.parseObject(answer, String[].class);
        String[] questions = JSON.parseObject(paper.getQuestions(), String[].class);
        int objectiveScores = 0;
       // DbConnection database = Server.getDatabase();
        //database.update("INSERT INTO exam.answer VALUES ('" + student.getAccount() + "','" + paper.getId() + "','"+ answer + "')");
//        String[] answers = JSON.parseObject(answer,String[].class);
//        String[] questions = JSON.parseObject(paper.getQuestions(),String[].class);
//        int objectiveScores=0;

        String[] choiceAnswers = JSON.parseObject(answers[0], String[].class);
        String[] multiAnswers = JSON.parseObject(answers[1], String[].class);
        String[] judgeAnswers = JSON.parseObject(answers[2], String[].class);
        String[] choices = JSON.parseObject(questions[0], String[].class);
        String[] multiChoices = JSON.parseObject(questions[1], String[].class);
        String[] judges = JSON.parseObject(questions[2], String[].class);
        String[] subjectives = JSON.parseObject(questions[3], String[].class);

        objectiveScores += singleTypeScores(database, choices, choiceAnswers, "choice") + singleTypeScores(database, multiChoices, multiAnswers, "multichoice") +
                singleTypeScores(database, judges, judgeAnswers, "judge");

        if (subjectives!=null&&subjectives.length > 0)
            database.update("INSERT INTO exam.score VALUES ('" + student.getAccount() + "','" + paper.getId() + "','" + objectiveScores + "'," + " -1 ,0)");
        else database.update("INSERT INTO exam.score VALUES ('" + student.getAccount() + "','" + paper.getId() + "','" + objectiveScores + "'," + " 0 ,0 )");
        dos.writeUTF(objectiveScores + "");
        dos.flush();
    }

    private int singleTypeScores(DB database,String[] questions,String[] answers,String type) throws SQLException {
        int score=0;
        System.out.println(type);
        for (int i = 0; i < questions.length; i++) {
            Statement statement = database.getConnection().createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM questions." + type + " WHERE `id` =" + questions[i]);
            if (resultSet.next()) {
                String answer = resultSet.getString("answer");
                if (answer.equals(answers[i]))
                    score += resultSet.getInt("mark");
            }
        }
        return score;
    }
}
