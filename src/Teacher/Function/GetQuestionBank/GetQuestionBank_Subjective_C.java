package Teacher.Function.GetQuestionBank;

import com.alibaba.fastjson.JSON;

import java.io.*;
import java.net.Socket;

import static Teacher.Server.ServerMain.Address;
import static Teacher.Server.ServerMain.PORT;

public class GetQuestionBank_Subjective_C {
    String command="GET_QUESTION_SUBJECTIVE";
    private Socket socket;
    private DataInputStream dis;//输入
    private DataOutputStream dos;//输出
    private BufferedReader in;
    private PrintWriter out;
    private int[] idList ;
    private String[] stemList;
    private int[] markList;
    private int[]difficultyList;
    private String[] answerList;

    public GetQuestionBank_Subjective_C() throws IOException {
        this.socket = new Socket(Address, PORT);
        dis = new DataInputStream(new BufferedInputStream(socket.getInputStream()));
        dos = new DataOutputStream(new DataOutputStream(socket.getOutputStream()));
        in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        out = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()), true);
        dos.writeUTF(command);
        dos.flush();
            /*
            注意：上面能不改就不改，因为Command只能用writeUTF发送；下面的对象传输只能用out.println()来传输JSON序列化的对象
             */
        idList = JSON.parseObject(in.readLine(), int[].class);
        stemList=JSON.parseObject(in.readLine(), String[].class);
        markList=JSON.parseObject(in.readLine(), int[].class);
        difficultyList=JSON.parseObject(in.readLine(), int[].class);
        answerList=JSON.parseObject(in.readLine(), String[].class);

        this.socket.close();
    }

    public int[] getIdList() {
        return idList;
    }
    public String[] getStemList() {
        return stemList;
    }
    public int[] getMarkList() {
        return markList;
    }
    public int[] getDifficulty() {
        return difficultyList;
    }
    public String[] getAnswerList() {
        return answerList;
    }
}
