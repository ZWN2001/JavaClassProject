package Teacher.Util.Component.MyPanel.QuestionCardUtils.QCard_AnswerAreas;

import Teacher.Util.Layout.VFlowLayout;

import javax.swing.*;

public class QCard_AnswerArea_MultiChoice extends JPanel {
    String optionA;
    String optionB;
    String optionC;
    String optionD;
public QCard_AnswerArea_MultiChoice(String optionA,String optionB,String optionC,String optionD){
    this.optionA=optionA;
    this.optionB=optionB;
    this.optionC=optionC;
    this.optionD=optionD;
        setLayout(new VFlowLayout());
    JCheckBox optA = new JCheckBox("A: "+optionA);
    JCheckBox optB = new JCheckBox("B: "+optionB);
    JCheckBox optC = new JCheckBox("C: "+optionC);
    JCheckBox optD = new JCheckBox("D: "+optionD);
        add(optA);
        add(optB);
        add(optC);
        add(optD);
    }
    public void setOptionA(String optionA) {
        this.optionA = optionA;
    }

    public void setOptionB(String optionB) {
        this.optionB = optionB;
    }

    public void setOptionC(String optionC) {
        this.optionC = optionC;
    }

    public void setOptionD(String optionD) {
        this.optionD = optionD;
    }
}
