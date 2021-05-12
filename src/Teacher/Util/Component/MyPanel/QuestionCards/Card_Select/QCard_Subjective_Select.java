package Teacher.Util.Component.MyPanel.QuestionCards.Card_Select;

import Teacher.Util.AdapterAndHelper.GBC;
import Teacher.Util.Component.MyPanel.QuestionCardUtils.QCard_AnswerAreas.QCard_AnswerArea_Subjective;
import Teacher.Util.Component.MyPanel.QuestionCardUtils.QCard_Titles.QuestionCard_ExamTitle;
import Teacher.Util.Component.MyPanel.QuestionCardUtils.QuestionCard_Stem;
import Teacher.Util.Component.MyPanel.QuestionCards.Card_Check.QCard_Subjective_Check;
import Teacher.Util.Layout.VFlowLayout;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;

public class QCard_Subjective_Select extends JPanel {
    public JCheckBox isSelected=new JCheckBox("选入试卷");
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
        Border border=getBorder();
        Border margin = new EmptyBorder(4,10,8,10);//边距设置
        setBorder(new CompoundBorder(border, margin));//加到组件上

        add(isSelected);
     qCard_subjective_check=new QCard_Subjective_Check(id, qid, stem, mark, difficulty, answer);
        qCard_subjective_check.removeBtn();
        qCard_subjective_check.checkTitle.add(isSelected,new GBC(5,0));
     add(qCard_subjective_check);

    }
    public boolean isSelected(){
        return isSelected.isSelected();
    }
    public int getId(){
        return qCard_subjective_check.getId();
    }
    public int getQid() {
        return qid;
    }
    public int getDifficulty() {
        return difficulty;
    }
}
