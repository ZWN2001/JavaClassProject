package Student.Panel.QuestionPanel;

import Teacher.Bean.Question.Question_Judge;
import Teacher.Util.AdapterAndHelper.GBC;

import javax.swing.*;

public class JudgePanel extends QuestionPanel{
    public JudgePanel(Question_Judge question,int num){
        super(question,num);
        JRadioButton yes= new JRadioButton("T");
        JRadioButton no = new JRadioButton("F");
        yes.setBackground(this.getBackground());
        no.setBackground(this.getBackground());
        yes.setFocusPainted(false);
        no.setFocusPainted(false);
        yes.setFont(font);
        no.setFont(font);
        ButtonGroup group = new ButtonGroup();
        group.add(yes);
        group.add(no);
        add(yes,new GBC(0,2,1,1));
        add(no,new GBC(0,3,1,1));
    }
}
