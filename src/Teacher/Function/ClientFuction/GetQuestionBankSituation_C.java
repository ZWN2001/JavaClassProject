package Teacher.Function.ClientFuction;

import com.alibaba.fastjson.JSON;

import java.io.*;
import java.net.Socket;

import static Teacher.Server.Server.Address;
import static Teacher.Server.Server.PORT;

public class GetQuestionBankSituation_C {
    String command="GET_QUESTION_BANK_SITUATION";
    private final int  questionNum_all_Choice;
    private final int  questionNum_all_MultiChoice;
    private final int  questionNum_all_Judge;
    private final int  questionNum_all_Subjective;
    private final int[] questionNum_each_Choice;
    private final int[] questionNum_each_MultiChoice;
    private final int[] questionNum_each_Judge;
    private final int[] questionNum_each_Subjective;

    private DataInputStream dis;//输入
    private DataOutputStream dos;//输出
    private BufferedReader in;
    private PrintWriter out;
    public GetQuestionBankSituation_C()throws IOException{
        Socket socket = new Socket(Address, PORT);
        dis = new DataInputStream(new BufferedInputStream(socket.getInputStream()));
        dos = new DataOutputStream(new DataOutputStream(socket.getOutputStream()));
        in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        out = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()), true);
        dos.writeUTF(command);
        dos.flush();
            /*
            注意：上面能不改就不改，因为Command只能用writeUTF发送；下面的对象传输只能用out.println()来传输JSON序列化的对象
             */
        questionNum_all_Choice=JSON.parseObject(in.readLine(),int.class);
        questionNum_all_MultiChoice=JSON.parseObject(in.readLine(),int.class);
        questionNum_all_Judge=JSON.parseObject(in.readLine(),int.class);
        questionNum_all_Subjective=JSON.parseObject(in.readLine(),int.class);
        questionNum_each_Choice=JSON.parseObject(in.readLine(),int[].class);
        questionNum_each_MultiChoice=JSON.parseObject(in.readLine(),int[].class);
        questionNum_each_Judge=JSON.parseObject(in.readLine(),int[].class);
        questionNum_each_Subjective=JSON.parseObject(in.readLine(),int[].class);

        socket.close();
    }

    public int getQuestionNum_all_Choice() {
        return questionNum_all_Choice;
    }
    public int getQuestionNum_all_MultiChoice() {
        return questionNum_all_MultiChoice;
    }
    public int getQuestionNum_all_Judge() {
        return questionNum_all_Judge;
    }
    public int getQuestionNum_all_Subjective() {
        return questionNum_all_Subjective;
    }
    public int[] getQuestionNum_each_Choice() {
        return questionNum_each_Choice;
    }
    public int[] getQuestionNum_each_MultiChoice() {
        return questionNum_each_MultiChoice;
    }
    public int[] getQuestionNum_each_Judge() {
        return questionNum_each_Judge;
    }
    public int[] getQuestionNum_each_Subjective() {
        return questionNum_each_Subjective;
    }
}
