package Student.Panel;

import Student.Bean.Scores;
import Student.Bean.Student;
import Teacher.Bean.Paper;

import javax.swing.*;
import java.awt.*;

public class QueryPanel extends JPanel {
    Image queryImage;

    public QueryPanel(Scores scores) {
        Dimension size = new Dimension(1000, 270);
        setPreferredSize(size);
        setLayout(null);
        ImageIcon queryIcon = new ImageIcon("src/Student/Resource/QueryPanel.png");
        queryImage = queryIcon.getImage();

        Paper paper = scores.getPaper();


        JLabel examID = new JLabel(paper.getTitle());
        JLabel examTime = new JLabel("考试发布时间:"+paper.getTime());
        JLabel examOwner = new JLabel("试题创建人:"+paper.getOwner());
        JLabel examScores1 = new JLabel("客观题得分:"+scores.getObjectiveScore());
        JLabel examScores2 = new JLabel(scores.getSubjectiveScore()==-1?"主观题待批阅":"主观题得分："+scores.getSubjectiveScore());
        JLabel examSumScores = new JLabel("总得分:"+scores.getScore());
        Font queryFont = new Font("微软雅黑", Font.BOLD, 30);
        examID.setFont(queryFont);
        examTime.setFont(queryFont);
        examOwner.setFont(queryFont);
        examScores1.setFont(queryFont);
        examScores2.setFont(queryFont);
        examSumScores.setFont(queryFont);
        examID.setBounds(40, 20, 1000, 100);
        examTime.setBounds(600, 20, 1000, 100);
        examOwner.setBounds(80, 120, 600, 100);
        examScores1.setBounds(900, 60, 300, 100);
        examScores2.setBounds(900,100,300,100);
        examSumScores.setBounds(900,160,300,100);
        add(examID);
        add(examTime);
        add(examOwner);
        add(examScores1);
        add(examScores2);
        add(examSumScores);
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(queryImage, 0, 0, this.getWidth(), this.getHeight(), this);
    }
}
