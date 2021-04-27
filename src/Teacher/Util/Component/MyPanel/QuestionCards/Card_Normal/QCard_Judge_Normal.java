package Teacher.Util.Component.MyPanel.QuestionCards.Card_Normal;

import Teacher.Util.Component.MyPanel.QuestionCardUtils.QCard_AnswerAreas.QCard_AnswerArea_Judge;
import Teacher.Util.Component.MyPanel.QuestionCardUtils.QCard_Titles.QuestionCard_ExamTitle;
import Teacher.Util.Component.MyPanel.QuestionCardUtils.QuestionCard_Stem;
import Teacher.Util.Layout.VFlowLayout;

import javax.swing.*;

public class QCard_Judge_Normal extends JPanel {
    QuestionCard_ExamTitle examTitle;
    QuestionCard_Stem stemArea;
    QCard_AnswerArea_Judge answerArea;

    int id;
    int qid;
    String stem;
    int mark;

    public QCard_Judge_Normal(int id,int qid,String stem,int mark){
        this.id=id;
        this.qid=qid;
        this.stem=stem;
        this.mark=mark;
        setLayout(new VFlowLayout());
        examTitle=new QuestionCard_ExamTitle(qid, mark);
        stemArea=new QuestionCard_Stem(stem);
        answerArea=new QCard_AnswerArea_Judge();
        add(examTitle);
        add(stemArea);
        add(answerArea);

    }
}
