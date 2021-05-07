package Student.Panel.QuestionPanel;

import Teacher.Bean.Question.Question_Judge;
import Teacher.Util.AdapterAndHelper.GBC;

import javax.swing.*;

public class JudgePanel extends QuestionPanel{
    private final JRadioButton yes,no;
    public JudgePanel(Question_Judge question,int num){
        super(question,num);
        yes= new JRadioButton("T");
        no = new JRadioButton("F");
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

    @Override
    public String getAnswer() {
        if (yes.isSelected())
            return "T";
        else if (no.isSelected())
            return "F";
        else return "";
    }
}
