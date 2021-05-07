package Student.Panel.QuestionPanel;

import Student.Function.MyRadioButton;
import Teacher.Bean.Question.Question_Choice;
import Teacher.Util.AdapterAndHelper.GBC;

import javax.swing.*;
import java.awt.*;

public class ChoicePanel extends QuestionPanel{
    private final MyRadioButton rbA,rbB,rbC,rbD;
    public ChoicePanel(Question_Choice question,int num){
        super(question,num);

        rbA = new MyRadioButton("A. "+question.getOptionA());
        rbB = new MyRadioButton("B. "+question.getOptionB());
        rbC = new MyRadioButton("C. "+question.getOptionC());
        rbD = new MyRadioButton("D. "+question.getOptionD());
        ButtonGroup group = new ButtonGroup();

        rbA.setFont(font);
        rbB.setFont(font);
        rbC.setFont(font);
        rbD.setFont(font);
        rbA.setBackground(this.getBackground());
        rbB.setBackground(this.getBackground());
        rbC.setBackground(this.getBackground());
        rbD.setBackground(this.getBackground());
        group.add(rbA.getButton());
        group.add(rbB.getButton());
        group.add(rbC.getButton());
        group.add(rbD.getButton());

        add(rbA,new GBC(0,2,10,1).setAnchor(GridBagConstraints.WEST));
        add(rbB,new GBC(0,3,10,1).setAnchor(GridBagConstraints.WEST));
        add(rbC,new GBC(0,4,10,1).setAnchor(GridBagConstraints.WEST));
        add(rbD,new GBC(0,5,10,1).setAnchor(GridBagConstraints.WEST));
    }

    @Override
    public String getAnswer() {
        if (rbA.getButton().isSelected())
            return "A";
        else if(rbB.getButton().isSelected())
            return "B";
        else if (rbC.getButton().isSelected())
            return "C";
        else if (rbD.getButton().isSelected())
            return "D";
        else return "";
    }
}
