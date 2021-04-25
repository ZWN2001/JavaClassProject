package Teacher.Util.Component.MyPanel.QuestionCardUtils.QCard_AnswerAreas;

import Teacher.Util.Layout.VFlowLayout;

import javax.swing.*;

public class QCard_AnswerArea_MultiChoice extends JPanel {
    private String optionA="A";
    private String optionB="B";
    private String optionC="C";
    private String optionD="D";
public QCard_AnswerArea_MultiChoice(){
        setLayout(new VFlowLayout());
    JCheckBox optA = new JCheckBox("A");
    JCheckBox optB = new JCheckBox("B");
    JCheckBox optC = new JCheckBox("C");
    JCheckBox optD = new JCheckBox("D");
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
