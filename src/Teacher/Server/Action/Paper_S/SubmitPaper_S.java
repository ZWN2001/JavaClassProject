package Teacher.Server.Action.Paper_S;

import Teacher.Bean.Paper;
import Teacher.Server.DataBase.DB;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;

public class SubmitPaper_S {

    Socket socket;
    DataInputStream dis;//输入
    DataOutputStream dos;//输出
    BufferedReader in;
    DB database = DB.instance;
    Paper paper;

}
