package Teacher.Util.Component.MyPanel.QuestionCads.Card_Select;

import Teacher.Util.Component.MyPanel.QuestionCardUtils.QCard_AnswerAreas.QCard_AnswerArea_Subjective;
import Teacher.Util.Component.MyPanel.QuestionCardUtils.QCard_Titles.QuestionCard_ExamTitle;
import Teacher.Util.Component.MyPanel.QuestionCardUtils.QuestionCard_Stem;
import Teacher.Util.Layout.VFlowLayout;

import javax.swing.*;

public class QCard_Subjective_Select extends JPanel {
    JCheckBox isSelected=new JCheckBox("选入试卷");
    QuestionCard_ExamTitle examTitle=new QuestionCard_ExamTitle();
    QuestionCard_Stem stemArea=new QuestionCard_Stem();
    QCard_AnswerArea_Subjective answerArea=new QCard_AnswerArea_Subjective();

    String stem=" ... ";

    public QCard_Subjective_Select(){
        setLayout(new VFlowLayout());
        add(isSelected);
        stemArea.setStemText(stem);
        add(examTitle);
        add(stemArea);
        add(answerArea);

    }
}
