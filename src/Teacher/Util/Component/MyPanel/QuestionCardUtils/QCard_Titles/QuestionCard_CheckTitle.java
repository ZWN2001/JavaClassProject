package Teacher.Util.Component.MyPanel.QuestionCardUtils.QCard_Titles;

import Teacher.Util.Adapter.GBC;
import Teacher.Util.Component.MyButton.BackgroundButton;
import Teacher.Util.Component.myFont;
import javax.swing.*;
import java.awt.*;

public class QuestionCard_CheckTitle extends JPanel {
    public QuestionCard_CheckTitle(){
        setLayout(new GridBagLayout());

        JLabel qid=new JLabel("第i题");
        qid.setFont(myFont.titleFont);
        JLabel mark=new JLabel("分值：");
        mark.setFont(myFont.titleFont);
        JLabel difficulty=new JLabel("难度系数:");
        difficulty.setFont(myFont.titleFont);
        JLabel answer=new JLabel("答案:");
        answer.setFont(myFont.titleFont);
        BackgroundButton change=new BackgroundButton("修改");
        change.setUnFocusedColor(Color.WHITE);
        change.setBackground(Color.WHITE);
        BackgroundButton delete= new BackgroundButton("删除");
        delete.setUnFocusedColor(Color.WHITE);
        delete.setBackground(Color.WHITE);

        add(qid,new GBC(0,0).setInsets(0,0,0,80));
        add(mark,new GBC(1,0).setInsets(0,0,0,20));
        add(answer,new GBC(2,0).setInsets(0,0,0,20));
        add(difficulty,new GBC(3,0).setInsets(0,0,0,300));
        add(change,new GBC(4,0).setInsets(0,0,0,20));
        add(delete,new GBC(5,0));
        setBackground(Color.WHITE);
    }
}
