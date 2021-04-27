package Teacher.Util.Component.MyPanel.QuestionCards.Card_Select;

import Teacher.Util.Component.MyPanel.QuestionCardUtils.QCard_AnswerAreas.QCard_AnswerArea_Subjective;
import Teacher.Util.Component.MyPanel.QuestionCardUtils.QCard_Titles.QuestionCard_ExamTitle;
import Teacher.Util.Component.MyPanel.QuestionCardUtils.QuestionCard_Stem;
import Teacher.Util.Component.MyPanel.QuestionCards.Card_Check.QCard_Subjective_Check;
import Teacher.Util.Layout.VFlowLayout;

import javax.swing.*;

public class QCard_Subjective_Select extends JPanel {
    JCheckBox isSelected=new JCheckBox("选入试卷");
   QCard_Subjective_Check qCard_subjective_check;
    int id;
    int qid;
    String stem;
    int mark;
    int difficulty;
    String answer;

    public QCard_Subjective_Select(int id,int qid,String stem,int mark,int difficulty,String answer){
        this.id=id;
        this.qid=qid;
        this.stem=stem;
        this.mark=mark;
        this.difficulty=difficulty;
        this.answer=answer;
        setLayout(new VFlowLayout());
        add(isSelected);
     qCard_subjective_check=new QCard_Subjective_Check(id, qid, stem, mark, difficulty, answer);
     add(qCard_subjective_check);

    }
    public boolean isSelected(){
        return isSelected.isSelected();
    }
    public int getId(){
        return qCard_subjective_check.getId();
    }
}
