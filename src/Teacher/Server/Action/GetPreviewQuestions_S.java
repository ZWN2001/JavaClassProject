package Teacher.Server.Action;

import Student.Server.DbConnection;
import Student.Server.Server;
import Teacher.Bean.Question.Question_Choice;
import Teacher.Bean.Question.Question_Judge;
import Teacher.Bean.Question.Question_MultiChoice;
import Teacher.Bean.Question.Question_Subjective;
import Teacher.Server.DataBase.DB;
import com.alibaba.fastjson.JSON;

import java.io.*;
import java.net.Socket;
import java.sql.ResultSet;
import java.sql.SQLException;

public class GetPreviewQuestions_S {
    Socket socket;
    //DB database = DB.instance;
    DbConnection database = Server.getDatabase();
    PrintWriter out;
    BufferedReader in;
    ResultSet resultSet;
    String[] questionString;
    int[] choiceIDList,multiChoiceIDList,judgeIDList,subjectiveIDList;
    int i;
    Question_Choice[] choices;
    Question_MultiChoice[] multiChoices;
    Question_Judge[] judges;
    Question_Subjective[] subjectives;
    public GetPreviewQuestions_S(Socket s)throws IOException, SQLException {
        socket = s;
        in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(socket.getOutputStream())), true);

        questionString= JSON.parseObject(in.readLine(), String[].class);
        choiceIDList=JSON.parseObject(questionString[0],int[].class);
        multiChoiceIDList=JSON.parseObject(questionString[1],int[].class);
        judgeIDList=JSON.parseObject(questionString[2],int[].class);
        subjectiveIDList=JSON.parseObject(questionString[3],int[].class);

        if (choiceIDList!=null){
            choices=new Question_Choice[choiceIDList.length];
            int id=0;
            String stem="";
            int mark=0;
            String optionA="null";
            String optionB="null";
            String optionC="null";
            String optionD="null";
            String answer="A";
            int difficulty=0;
            for (i=0;i<choiceIDList.length;i++){
                ResultSet resultSet=database.query("SELECT * FROM questions.choice WHERE id="+choiceIDList[i]);
                resultSet.beforeFirst();
               if(resultSet.next()){
                    id = resultSet.getInt("id");
                    stem = resultSet.getString("stem");
                    mark = resultSet.getInt("mark");
                    difficulty = resultSet.getInt("difficulty");
                    optionA = resultSet.getString("optA");
                    optionB = resultSet.getString("optB");
                    optionC = resultSet.getString("optC");
                    optionD = resultSet.getString("optD");
                    answer = resultSet.getString("answer");
                    Question_Choice question_choice = new Question_Choice(id, stem, mark, difficulty, optionA, optionB, optionC, optionD, answer);
                    choices[i] = question_choice;
                    System.out.println(question_choice);
                }
            }
        }
        if (multiChoiceIDList!=null){
            multiChoices=new Question_MultiChoice[multiChoiceIDList.length];
            int id=0;
            String stem="";
            int mark=0;
            String optionA="null";
            String optionB="null";
            String optionC="null";
            String optionD="null";
            String answer="A";
            int difficulty=0;
            for (i=0;i<multiChoices.length;i++){
                resultSet=database.query("SELECT * FROM questions.multiChoice WHERE id="+multiChoiceIDList[i]);
                resultSet.beforeFirst();
                if(resultSet.next()) {
                    id = resultSet.getInt("id");
                    stem = resultSet.getString("stem");
                    mark = resultSet.getInt("mark");
                    difficulty = resultSet.getInt("difficulty");
                    optionA = resultSet.getString("optA");
                    optionB = resultSet.getString("optB");
                    optionC = resultSet.getString("optC");
                    optionD = resultSet.getString("optD");
                    answer = resultSet.getString("answer");
                    Question_MultiChoice question_multiChoice = new Question_MultiChoice(id, stem, mark, difficulty, optionA, optionB, optionC, optionD, answer);
                    multiChoices[i] = question_multiChoice;
                }
            }
        }
        if (judgeIDList!=null){
            judges=new Question_Judge[judgeIDList.length];
            int id=0;
            String stem="null";
            int mark = 0;
            String answer;
            int difficulty=0;
            for (i=0;i<judgeIDList.length;i++){
                resultSet=database.query("SELECT * FROM questions.judge WHERE id="+judgeIDList[i]);
                resultSet.beforeFirst();
                if(resultSet.next()) {
                    id = resultSet.getInt("id");
                    stem = resultSet.getString("stem");
                    mark = resultSet.getInt("mark");
                    difficulty = resultSet.getInt("difficulty");
                    answer = resultSet.getString("answer");
                    Question_Judge question_judge = new Question_Judge(id, stem, mark, difficulty, answer);
                    judges[i] = question_judge;
                }
            }
        }
        if (subjectiveIDList!=null){
            subjectives=new Question_Subjective[subjectiveIDList.length];
            int id=0;
            String stem="null";
            int mark = 0;
            String answer;
            int difficulty=0;
            for (i=0;i<subjectiveIDList.length;i++){
                resultSet=database.query("SELECT * FROM questions.subjective WHERE id="+subjectiveIDList[i]);
                resultSet.beforeFirst();
                if(resultSet.next()) {
                    id = resultSet.getInt("id");
                    stem = resultSet.getString("stem");
                    mark = resultSet.getInt("mark");
                    difficulty = resultSet.getInt("difficulty");
                    answer = resultSet.getString("answer");
                    Question_Subjective question_subjective = new Question_Subjective(id, stem, mark, difficulty, answer);
                    subjectives[i] = question_subjective;
                }
            }
        }

        out.println(JSON.toJSONString(choices));
        out.println(JSON.toJSONString(multiChoices));
        out.println(JSON.toJSONString(judges));
        out.println(JSON.toJSONString(subjectives));
    }
}
