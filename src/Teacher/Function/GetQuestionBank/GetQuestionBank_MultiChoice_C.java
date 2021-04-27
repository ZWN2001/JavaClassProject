package Teacher.Function.GetQuestionBank;

import com.alibaba.fastjson.JSON;

import java.io.*;
import java.net.Socket;

import static Teacher.Server.ServerMain.Address;
import static Teacher.Server.ServerMain.PORT;

public class GetQuestionBank_MultiChoice_C {
    String command="GET_QUESTION_MULTICHOICE";
    private Socket socket;
    private DataInputStream dis;//输入
    private DataOutputStream dos;//输出
    private BufferedReader in;
    private PrintWriter out;
    //    private String Path;
//    private String json;
    private int[] idList ;
    private String[] stemList;
    private String[] optionA_List;
    private String[] optionB_List;
    private String[] optionC_List;
    private String[] optionD_List;
    private int[] markList;
    private int[]difficultyList;
    private String[] answerList;

    public GetQuestionBank_MultiChoice_C() throws IOException {
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
//        json = JSON.toJSONString(itemListFilter);//使用JSON序列化对象传输过去
//        out.println(json);

        idList = JSON.parseObject(in.readLine(), int[].class);
        stemList=JSON.parseObject(in.readLine(), String[].class);
        optionA_List=JSON.parseObject(in.readLine(), String[].class);
        optionB_List=JSON.parseObject(in.readLine(), String[].class);
        optionC_List=JSON.parseObject(in.readLine(), String[].class);
        optionD_List=JSON.parseObject(in.readLine(), String[].class);
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
    public String[] getOptionA_List() {
        return optionA_List;
    }
    public String[] getOptionB_List() {
        return optionB_List;
    }
    public String[] getOptionC_List() {
        return optionC_List;
    }
    public String[] getOptionD_List() {
        return optionD_List;
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
