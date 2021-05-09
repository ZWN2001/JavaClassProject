package Teacher.Util.Component.MyPanel.QuestionCardUtils.QCard_Titles;

import Teacher.Util.AdapterAndHelper.GBC;
import Teacher.Util.AdapterAndHelper.MultiAnswerUtil;
import Teacher.Util.Component.MyButton.BackgroundButton;
import Teacher.Util.MyFont;
import javax.swing.*;
import java.awt.*;

public class QuestionCard_CheckTitle extends JPanel {
    int qid;
    int mark;
    int difficulty;
    String answer;
    public BackgroundButton change;
    public QuestionCard_CheckTitle(int qid,int mark,int difficulty,String answer){
        setLayout(new GridBagLayout());
        this.qid=qid;
        this.mark=mark;
        this.difficulty=difficulty;
        this.answer=answer;

        JLabel qid_Label=new JLabel("第"+qid+"题");
        qid_Label.setFont(MyFont.Font_16);
        JLabel mark_Label=new JLabel("分值："+mark);
        mark_Label.setFont(MyFont.Font_16);
        JLabel difficulty_Label=new JLabel("  难度系数: "+difficulty);
        difficulty_Label.setFont(MyFont.Font_16);
        JLabel answer_Label=new JLabel("  答案: "+answer);
        answer_Label.setFont(MyFont.Font_16);
         change=new BackgroundButton("修改");
        change.setUnFocusedColor(Color.WHITE);
        change.setBackground(Color.WHITE);

        add(qid_Label,new GBC(0,0).setInsets(0,0,0,80));
        add(mark_Label,new GBC(1,0).setInsets(0,0,0,20));
        add(answer_Label,new GBC(2,0).setInsets(0,0,0,20));
        add(difficulty_Label,new GBC(3,0).setInsets(0,0,0,300));
        add(change,new GBC(4,0).setInsets(0,0,0,20));
        setBackground(Color.WHITE);
    }

}
