package Teacher.Function.ClientFuction;

import Teacher.Bean.Question.Question_Choice;
import Teacher.Bean.Question.Question_Judge;
import Teacher.Bean.Question.Question_MultiChoice;
import Teacher.Bean.Question.Question_Subjective;
import com.alibaba.fastjson.JSON;

import java.io.*;
import java.net.Socket;

import static Teacher.Server.Server.Address;
import static Teacher.Server.Server.PORT;

public class GetPreviewQuestions_C {
    Question_Choice[] choices;
    Question_MultiChoice[] multiChoices;
    Question_Judge[] judges;
    Question_Subjective[] subjective;
    String command="GET_QUESTION_PREVIEW";
    private DataInputStream dis;//输入
    private DataOutputStream dos;//输出
    private BufferedReader in;
    private PrintWriter out;
    public GetPreviewQuestions_C(String questionString) throws IOException{
        Socket socket = new Socket(Address, PORT);
        dis = new DataInputStream(new BufferedInputStream(socket.getInputStream()));
        dos = new DataOutputStream(new DataOutputStream(socket.getOutputStream()));
        in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        out = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()), true);
        dos.writeUTF(command);
        dos.flush();

        out.println(questionString);
        choices= JSON.parseObject(in.readLine(),Question_Choice[].class);
        multiChoices=JSON.parseObject(in.readLine(),Question_MultiChoice[].class);
        judges=JSON.parseObject(in.readLine(),Question_Judge[].class);
        subjective=JSON.parseObject(in.readLine(),Question_Subjective[].class);
        socket.close();
    }

    public Question_Choice[] getChoices() {
        return choices;
    }
    public Question_MultiChoice[] getMultiChoices() {
        return multiChoices;
    }
    public Question_Judge[] getJudges() {
        return judges;
    }
    public Question_Subjective[] getSubjective() {
        return subjective;
    }
}
