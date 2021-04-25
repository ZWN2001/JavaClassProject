package Teacher.Util.Component.MyPanel.QuestionCards.Card_Normal;

import Teacher.Util.Component.MyPanel.QuestionCardUtils.QCard_AnswerAreas.QCard_AnswerArea_Judge;
import Teacher.Util.Component.MyPanel.QuestionCardUtils.QCard_Titles.QuestionCard_ExamTitle;
import Teacher.Util.Component.MyPanel.QuestionCardUtils.QuestionCard_Stem;
import Teacher.Util.Layout.VFlowLayout;

import javax.swing.*;

public class QCard_Judge_Normal extends JPanel {
    QuestionCard_ExamTitle examTitle=new QuestionCard_ExamTitle();
    QuestionCard_Stem stemArea=new QuestionCard_Stem();
    QCard_AnswerArea_Judge answerArea=new QCard_AnswerArea_Judge();

    String stem=" ... ";

    public QCard_Judge_Normal(){
        setLayout(new VFlowLayout());
        stemArea.setStemText(stem);
        add(examTitle);
        add(stemArea);
        add(answerArea);

    }
}
