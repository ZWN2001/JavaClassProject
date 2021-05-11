package Student.Panel;

import Basic.Command;
import Student.Bean.Scores;
import Student.Bean.Student;
import Teacher.Util.Layout.VFlowLayout;
import com.alibaba.fastjson.JSON;

import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.net.Socket;
import java.util.ArrayList;

import static Basic.Login.HOST;
import static Basic.Login.PORT;


public class GradePanel extends JPanel {
    private final Student student;
    private ArrayList<Scores> scoresList = new ArrayList<>();

    public GradePanel(Student student) {
        this.student = student;
        setBackground(Color.WHITE);
        setLayout(new VFlowLayout());
        setVisible(false);
    }

    public void refresh() {
        removeAll();
        loadQueryPanel();
    }

    public void loadQueryPanel() {
        try {
            NetGetScores netGetScores = new NetGetScores(student);
            scoresList = netGetScores.getScores();
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (scoresList.size() != 0) {
            for (Scores scores : scoresList)
                add(new QueryPanel(scores));
        } else {
            add(new JLabel(new ImageIcon("src/Teacher/Util/Images/nullResult.png")));
            JLabel nullResultLabel = new JLabel("当前没有成绩记录",JLabel.CENTER);
            nullResultLabel.setFont(new Font("微软雅黑",Font.BOLD,50));
            add(nullResultLabel);
        }
    }

    private static class NetGetScores {
        private final ArrayList<Scores> scoresList = new ArrayList<>();
        private final String resultCode;

        public NetGetScores(Student student) throws IOException {
            Socket socket = new Socket(HOST, PORT);
            DataOutputStream dos = new DataOutputStream(new BufferedOutputStream(socket.getOutputStream()));
            DataInputStream dis = new DataInputStream(new BufferedInputStream(socket.getInputStream()));
            PrintWriter opw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(socket.getOutputStream())), true);
            BufferedReader obr = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            dos.writeUTF(Command.S_GET_SCORES);
            dos.flush();
            opw.println(JSON.toJSONString(student));
            resultCode = dis.readUTF();
            if (resultCode.equals("1")) {
                while (true) {
                    Scores scores = JSON.parseObject(obr.readLine(), Scores.class);
                    if (scores.getPaper().getTitle().equals(""))
                        break;
                    scoresList.add(scores);
                }
            }
        }


        public String getResultCode() {
            return resultCode;
        }

        public ArrayList<Scores> getScores() {
            return scoresList;
        }
    }
}
