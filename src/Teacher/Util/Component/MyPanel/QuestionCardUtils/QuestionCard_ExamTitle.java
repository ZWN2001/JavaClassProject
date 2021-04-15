package Teacher.Util.Component.MyPanel.QuestionCardUtils;

import Teacher.Util.Adapter.GBC;
import Teacher.Util.Component.MyButton.BackgroundButton;
import Teacher.Util.Component.myFont;

import javax.swing.*;
import java.awt.*;

public class QuestionCard_ExamTitle extends JPanel {
    int qid=0;
    int mark=0;
    int difficulty=0;
    public  QuestionCard_ExamTitle( int qid, int mark, int difficulty){
        setLayout(new GridBagLayout());
        JLabel qidLabel=new JLabel("题号：");
        qidLabel.setFont(myFont.titleFont);
        JLabel markLabel=new JLabel("分值：");
        markLabel.setFont(myFont.titleFont);
        JLabel difficultyLabel=new JLabel("难度系数:");
        difficultyLabel.setFont(myFont.titleFont);

        add(qidLabel,new GBC(0,0).setInsets(0,0,0,20));
        add(markLabel,new GBC(1,0).setInsets(0,0,0,20));
        add(difficultyLabel,new GBC(2,0).setInsets(0,0,0,300));

        setBackground(Color.WHITE);
    }
}
