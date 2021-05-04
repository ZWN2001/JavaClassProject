package Teacher.Util.Component.MyPanel.QuestionCards.Card_Select;

import Teacher.Util.AdapterAndHelper.GBC;
import Teacher.Util.Component.MyPanel.QuestionCardUtils.QCard_AnswerAreas.QCard_AnswerArea_MultiChoice;
import Teacher.Util.Component.MyPanel.QuestionCardUtils.QCard_Titles.QuestionCard_ExamTitle;
import Teacher.Util.Component.MyPanel.QuestionCardUtils.QuestionCard_Stem;
import Teacher.Util.Component.MyPanel.QuestionCards.Card_Check.QCard_MultiChoice_Check;
import Teacher.Util.Layout.VFlowLayout;

import javax.swing.*;

public class QCard_MultiChoice_Select extends JPanel {
    public JCheckBox isSelected=new JCheckBox("选入试卷");
    QCard_MultiChoice_Check qCard_multiChoice_check;
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

    public QCard_MultiChoice_Select(int id,int qid,String stem,String optionA,String optionB,String optionC,String optionD,int mark,int difficulty,String answer){
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
        qCard_multiChoice_check=new QCard_MultiChoice_Check(id, qid, stem, optionA, optionB, optionC, optionD, mark, difficulty, answer);
        qCard_multiChoice_check.removeBtn();
        qCard_multiChoice_check.checkTitle.add(isSelected,new GBC(5,0));
        add(qCard_multiChoice_check);

    }
    public boolean isSelected(){
        return isSelected.isSelected();
    }
    public int getId(){
        return qCard_multiChoice_check.getId();
    }
    public int getQid() {
        return qid;
    }
    public int getDifficulty() {
        return difficulty;
    }
}
