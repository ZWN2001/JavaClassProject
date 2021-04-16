package Teacher.Util.Component.MyPanel.QuestionCardUtils.QCard_AnswerAreas;

import Teacher.Util.Layout.VFlowLayout;

import javax.swing.*;

public class QCard_AnswerArea_Choice extends JPanel {
    private String optionA="A";
    private String optionB="B";
    private String optionC="C";
    private String optionD="D";
    public QCard_AnswerArea_Choice(){
        setLayout(new VFlowLayout());
        ButtonGroup optionsGroup=new ButtonGroup();
        JRadioButton optA=new JRadioButton("A:"+optionA);
        JRadioButton optB=new JRadioButton("B:"+optionB);
        JRadioButton optC=new JRadioButton("C:"+optionC);
        JRadioButton optD=new JRadioButton("D:"+optionD);
        optionsGroup.add(optA);
        optionsGroup.add(optB);
        optionsGroup.add(optC);
        optionsGroup.add(optD);
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
