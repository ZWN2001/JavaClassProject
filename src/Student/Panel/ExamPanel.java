package Student.Panel;


import Basic.Command;
import Student.Bean.Student;
import Student.Frame.MainFrame;
import Teacher.Bean.Paper;
import Teacher.Util.AdapterAndHelper.GBC;
import Teacher.Util.Layout.VFlowLayout;
import com.alibaba.fastjson.JSON;

import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Vector;

import static Basic.Login.HOST;
import static Basic.Login.PORT;

public class ExamPanel extends JPanel {
    private final MainFrame mainFrame;
    private final Student student;

    public ExamPanel(MainFrame mainFrame) {
        this.mainFrame = mainFrame;
        student = mainFrame.getStudent();
        setBackground(Color.WHITE);
        setLayout(new VFlowLayout());
        setVisible(false);
    }

    public void refresh(){
        removeAll();
        loadExPanel();
    }

    public void loadExPanel() {
        try {
            NetGetExam netGetExam = new NetGetExam(student);
            switch (netGetExam.getResultCode()) {
                case "1":
                    for (Paper paper : netGetExam.getPapers()) {
                        add(new ExExPanel(mainFrame, paper));
                    }
                    break;
                case "0":
                    add(new JLabel(new ImageIcon("src/Teacher/Util/Images/nullResult.png")));
                    JLabel nullResultLabel = new JLabel("当前没有任何试卷待完成，请等待老师发布考试",JLabel.CENTER);
                    nullResultLabel.setFont(new Font("微软雅黑",Font.BOLD,50));
                    add(nullResultLabel);
                    break;
                case "-1":
                    add(new JLabel(new ImageIcon("src/Teacher/Util/Images/nullResult.png")));
                    JLabel nullClassLabel = new JLabel("当前还未加入任何班级，请先在账号设置-编辑资料中加入班级",JLabel.CENTER);
                    nullClassLabel.setFont(new Font("微软雅黑",Font.BOLD,40));
                    add(nullClassLabel);
                    break;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static class NetGetExam {
        private final String resultCode;
        private final ArrayList<Paper> papers = new ArrayList<>();

        public NetGetExam(Student student) throws IOException {
            Socket socket = new Socket(HOST, PORT);
            DataOutputStream dos = new DataOutputStream(new BufferedOutputStream(socket.getOutputStream()));
            DataInputStream dis = new DataInputStream(new BufferedInputStream(socket.getInputStream()));
            PrintWriter opw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(socket.getOutputStream())), true);
            BufferedReader obr = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            dos.writeUTF(Command.S_GET_EXAM);
            dos.flush();
            opw.println(JSON.toJSONString(student));
            resultCode = dis.readUTF();
            if (resultCode.equals("1")) {
                while (true) {
                    Paper paper = JSON.parseObject(obr.readLine(),Paper.class);
                    if (paper.getTitle().equals(""))
                        break;
                    papers.add(paper);
                }
            }
        }

        public ArrayList<Paper> getPapers() {
            return papers;
        }

        public String getResultCode() {
            return resultCode;
        }
    }
}

