package Teacher.Util.Component.MyPanel.QuestionCards.Card_Select;

import Teacher.Util.AdapterAndHelper.GBC;
import Teacher.Util.Component.MyPanel.QuestionCardUtils.QCard_AnswerAreas.QCard_AnswerArea_Judge;
import Teacher.Util.Component.MyPanel.QuestionCardUtils.QCard_Titles.QuestionCard_ExamTitle;
import Teacher.Util.Component.MyPanel.QuestionCardUtils.QuestionCard_Stem;
import Teacher.Util.Component.MyPanel.QuestionCards.Card_Check.QCard_Judge_Check;
import Teacher.Util.Layout.VFlowLayout;

import javax.swing.*;

public class QCard_Judge_Select extends JPanel {
    public JCheckBox isSelected=new JCheckBox("选入试卷");
    QCard_Judge_Check qCard_judge_check;
    int id;
    int qid;
    String stem;
    int mark;
    int difficulty;
    String answer;

    public QCard_Judge_Select(int id,int qid,String stem,int mark,int difficulty,String answer){
        this.id=id;
        this.qid=qid;
        this.stem=stem;
        this.mark=mark;
        this.difficulty=difficulty;
        this.answer=answer;
        setLayout(new VFlowLayout());

        qCard_judge_check=new QCard_Judge_Check(id, qid, stem, mark, difficulty, answer);
        qCard_judge_check.removeBtn();
        qCard_judge_check.checkTitle.add(isSelected,new GBC(5,0));
        add(qCard_judge_check);
    }
    public boolean isSelected(){
        return isSelected.isSelected();
    }
    public int getId(){
        return qCard_judge_check.getId();
    }
    public int getQid(){
        return qid;
    }
    public int getDifficulty() {
        return difficulty;
    }
}
