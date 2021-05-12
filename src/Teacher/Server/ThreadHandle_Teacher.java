package Teacher.Server;


import Teacher.Function.ClientFuction.CheckMark.CheckAvailMarks_C;
import Teacher.Server.Action.ChangeQuestion.ChangeQuestion_Choice_S;
import Teacher.Server.Action.ChangeQuestion.ChangeQuestion_Judge_S;
import Teacher.Server.Action.ChangeQuestion.ChangeQuestion_MultiChoice_S;
import Teacher.Server.Action.ChangeQuestion.ChangeQuestion_Subjective_S;
import Teacher.Server.Action.CheckMark.CheckAvailMarks_S;
import Teacher.Server.Action.CheckMark.GetEachPaperMark_S;
import Teacher.Server.Action.DeleteQuestion.DeleteQuestion_Choice_S;
import Teacher.Server.Action.DeleteQuestion.DeleteQuestion_Judge_S;
import Teacher.Server.Action.DeleteQuestion.DeleteQuestion_MultiChoice_S;
import Teacher.Server.Action.DeleteQuestion.DeleteQuestion_Subjective_S;
import Teacher.Server.Action.GetPreviewQuestions_S;
import Teacher.Server.Action.GetQuestionBankSituation_S;
import Teacher.Server.Action.GetQuestionBank_S.GetQuestionBank_Choice_S;
import Teacher.Server.Action.GetQuestionBank_S.GetQuestionBank_Judge_S;
import Teacher.Server.Action.GetQuestionBank_S.GetQuestionBank_MultiChoice_S;
import Teacher.Server.Action.GetQuestionBank_S.GetQuestionBank_Subjective_S;
import Teacher.Server.Action.Modify.GetAvailableModifyPaperID_S;
import Teacher.Server.Action.Modify.GetModifyQuestion_S;
import Teacher.Server.Action.Modify.SubmitModifiedMarks_S;
import Teacher.Server.Action.MyStudent.GetMyStudent_S;
import Teacher.Server.Action.Paper_S.GetAPaper_S;
import Teacher.Server.Action.Paper_S.GetAllPaper_S;
import Teacher.Server.Action.Paper_S.GetAutoPaper_S;
import Teacher.Server.Action.Paper_S.SubmitPaper_S;
import Teacher.Server.Action.SubmitQuestion_S.SubmitQuestion_Choice_S;
import Teacher.Server.Action.SubmitQuestion_S.SubmitQuestion_Judge_S;
import Teacher.Server.Action.SubmitQuestion_S.SubmitQuestion_MultiChoice_S;
import Teacher.Server.Action.SubmitQuestion_S.SubmitQuestion_Subjective_S;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.Socket;

public class ThreadHandle_Teacher extends Thread {
    Socket socket;

    ThreadHandle_Teacher(Socket s) {
        socket = s;
        System.out.println("客户端连接：" + s.getInetAddress() + ":" + s.getPort());
    }

    @Override
    public void run() {
        try {
            DataInputStream dataInputStream = new DataInputStream(socket.getInputStream());
            String str = dataInputStream.readUTF();

            System.out.println("收到客户端指令：" + str);//客户端发送一条指令，服务端接收后由action包中类响应然后关闭连接。一线程只处理一任务。因此这里只分析第一条语句，只处理一道命令。后续的收发数据由action包中的相应类完成
            switch (str) {
                case "CLOSE SERVER":
                    ServerMain.closeServer();
                    break;
                case "SUBMIT_QUESTION_CHOICE":
                    new SubmitQuestion_Choice_S(socket);
                    break;
                case "SUBMIT_QUESTION_JUDGE":
                    new SubmitQuestion_Judge_S(socket);
                    break;
                case "SUBMIT_QUESTION_MULTICHOICE":
                    new SubmitQuestion_MultiChoice_S(socket);
                    break;
                case "SUBMIT_QUESTION_SUBJECTIVE":
                    new SubmitQuestion_Subjective_S(socket);
                    break;
                case "GET_QUESTION_CHOICE":
                    new GetQuestionBank_Choice_S(socket);
                    break;
                case "GET_QUESTION_JUDGE":
                    new GetQuestionBank_Judge_S(socket);
                    break;
                case "GET_QUESTION_MULTICHOICE":
                    new GetQuestionBank_MultiChoice_S(socket);
                    break;
                case "GET_QUESTION_SUBJECTIVE":
                    new GetQuestionBank_Subjective_S(socket);
                    break;
                case "GET_QUESTION_BANK_SITUATION":
                    new GetQuestionBankSituation_S(socket);
                    break;
                case "GET_QUESTION_PREVIEW":
                    new GetPreviewQuestions_S(socket);
                    break;
                case "SUBMIT_PAPER":
                    new SubmitPaper_S(socket);
                    break;
                case "GET_PAPERS":
                    new GetAllPaper_S(socket);
                    break;
                case "GET_A_PAPER":
                    new GetAPaper_S(socket);
                    break;
                case "GET_AUTO_PAPER":
                    new GetAutoPaper_S(socket);
                    break;
                case"CHANGE_QUESTION_CHOICE":
                    new ChangeQuestion_Choice_S(socket);
                    break;
                case"CHANGE_QUESTION_MULTICHOICE":
                    new ChangeQuestion_MultiChoice_S(socket);
                    break;
                case"CHANGE_QUESTION_JUDGE":
                    new ChangeQuestion_Judge_S(socket);
                    break;
                case"CHANGE_QUESTION_SUBJECTIVE":
                    new ChangeQuestion_Subjective_S(socket);
                    break;
                case"DELETE_QUESTION_CHOICE":
                    new DeleteQuestion_Choice_S(socket);
                    break;
                case"DELETE_QUESTION_MULTICHOICE":
                    new DeleteQuestion_MultiChoice_S(socket);
                    break;
                case"DELETE_QUESTION_JUDGE":
                    new DeleteQuestion_Judge_S(socket);
                    break;
                case"DELETE_QUESTION_SUBJECTIVE":
                    new DeleteQuestion_Subjective_S(socket);
                    break;
                case "GET_MODIFY_PAPER":
                    new GetAvailableModifyPaperID_S(socket);
                    break;
                case "GET_MODIFY_QUESTIONS":
                    new GetModifyQuestion_S(socket);
                    break;
                case "SUBMIT_MARKS":
                    new SubmitModifiedMarks_S(socket);
                    break;
                case "GET_STUDENT_NAME":
                    new GetMyStudent_S(socket);
                    break;
                case "GET_ALL_MARK":
                    new CheckAvailMarks_S(socket);
                    break;
                case "GET_EACH_MARK":
                    new GetEachPaperMark_S(socket);
                    break;
                default:
                    System.out.println("未知的教师端命令，socket直接关闭");
                    break;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
