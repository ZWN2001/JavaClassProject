package Teacher.Util.Component.MyPanel.QuestionCards.Card_Normal;

import Teacher.Util.Component.MyPanel.QuestionCardUtils.QCard_AnswerAreas.QCard_AnswerArea_Choice;
import Teacher.Util.Component.MyPanel.QuestionCardUtils.QCard_AnswerAreas.QCard_AnswerArea_MultiChoice;
import Teacher.Util.Component.MyPanel.QuestionCardUtils.QCard_Titles.QuestionCard_ExamTitle;
import Teacher.Util.Component.MyPanel.QuestionCardUtils.QuestionCard_Stem;
import Teacher.Util.Layout.VFlowLayout;

import javax.swing.*;

public class QCard_MultiChoice_Normal extends JPanel {
    QuestionCard_ExamTitle examTitle;
    QuestionCard_Stem stemArea;
    QCard_AnswerArea_MultiChoice answerArea;

    int id;
    int qid;
    String stem;
    String optionA;
    String optionB;
    String optionC;
    String optionD;
    int mark;

    public QCard_MultiChoice_Normal(int id,int qid,String stem,String optionA,String optionB,String optionC,String optionD,int mark){
        this.id=id;
        this.qid=qid;
        this.stem=stem;
        this.optionA=optionA;
        this.optionB=optionB;
        this.optionC=optionC;
        this.optionD=optionD;
        this.mark=mark;
        setLayout(new VFlowLayout());
        examTitle=new QuestionCard_ExamTitle(qid, mark);
        stemArea=new QuestionCard_Stem(stem);
        answerArea=new QCard_AnswerArea_MultiChoice(optionA, optionB, optionC, optionD);
        add(examTitle);
        add(stemArea);
        add(answerArea);

    }
}
