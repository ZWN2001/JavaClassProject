package Student.Panel.QuestionPanel;

import Student.Function.MyCheckBox;
import Teacher.Bean.Question.Question_MultiChoice;
import Teacher.Util.AdapterAndHelper.GBC;

import java.awt.*;

public class MultiChoicePanel extends QuestionPanel{
    public MultiChoicePanel(Question_MultiChoice question, int num) {
        super(question, num);
        MyCheckBox cbA = new MyCheckBox("A. "+question.getOptionA());
        MyCheckBox cbB = new MyCheckBox("B. "+question.getOptionB());
        MyCheckBox cbC = new MyCheckBox("C. "+question.getOptionC());
        MyCheckBox cbD = new MyCheckBox("D. "+question.getOptionD());

        cbA.setFont(font);
        cbB.setFont(font);
        cbC.setFont(font);
        cbD.setFont(font);

        cbA.setBackground(this.getBackground());
        cbB.setBackground(this.getBackground());
        cbC.setBackground(this.getBackground());
        cbD.setBackground(this.getBackground());

        add(cbA,new GBC(0,2,10,1).setAnchor(GridBagConstraints.WEST));
        add(cbB,new GBC(0,3,10,1).setAnchor(GridBagConstraints.WEST));
        add(cbC,new GBC(0,4,10,1).setAnchor(GridBagConstraints.WEST));
        add(cbD,new GBC(0,5,10,1).setAnchor(GridBagConstraints.WEST));
    }
}
