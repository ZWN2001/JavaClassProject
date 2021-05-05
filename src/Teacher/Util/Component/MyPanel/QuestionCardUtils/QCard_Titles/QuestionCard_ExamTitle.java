package Teacher.Util.Component.MyPanel.QuestionCardUtils.QCard_Titles;

import Teacher.Util.AdapterAndHelper.GBC;
import Teacher.Util.MyFont;

import javax.swing.*;
import java.awt.*;

public class QuestionCard_ExamTitle extends JPanel {
    int qid;
    int mark;
    public  QuestionCard_ExamTitle( int qid,int mark){
        this.qid=qid;
        this.mark=mark;
        setLayout(new GridBagLayout());
        JLabel qidLabel=new JLabel("第"+qid+"题");
        qidLabel.setFont(MyFont.Font_16);
        JLabel markLabel=new JLabel("分值:"+mark);
        markLabel.setFont(MyFont.Font_16);

        add(qidLabel,new GBC(0,0).setInsets(3,20,3,20).setAnchor(GridBagConstraints.WEST));
        add(markLabel,new GBC(1,0).setInsets(3,0,3,20).setFill(GridBagConstraints.HORIZONTAL).setWeightx(1));

        setBackground(Color.WHITE);
    }
}
