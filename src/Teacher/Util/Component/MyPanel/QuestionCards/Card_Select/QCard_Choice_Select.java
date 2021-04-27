package Teacher.Util.Component.MyPanel.QuestionCards.Card_Select;

import Teacher.Util.Component.MyPanel.QuestionCards.Card_Check.QCard_Choice_Check;
import Teacher.Util.Layout.VFlowLayout;

import javax.swing.*;

public class QCard_Choice_Select extends JPanel {
    JCheckBox isSelected=new JCheckBox("选入试卷");
   QCard_Choice_Check qCard_choice_check;
    int id;
    int qid;
    String stem;
    String optionA;
    String optionB;
    String optionC;
    String optionD;
    int mark;
    int difficulty;
    String answer;
    public QCard_Choice_Select(int id,int qid,String stem,String optionA,String optionB,String optionC,String optionD,int mark,int difficulty,String answer){
        this.id=id;
        this.qid=qid;
        this.stem=stem;
        this.optionA=optionA;
        this.optionB=optionB;
        this.optionC=optionC;
        this.optionD=optionD;
        this.mark=mark;
        this.difficulty=difficulty;
        this.answer=answer;
        setLayout(new VFlowLayout());
        add(isSelected);
    qCard_choice_check=new QCard_Choice_Check(id, qid, stem, optionA, optionB, optionC, optionD, mark, difficulty, answer);
    add(qCard_choice_check);
    }
    public boolean isSelected(){
        return isSelected.isSelected();
    }
    public int getId(){
        return qCard_choice_check.getId();
    }
}
