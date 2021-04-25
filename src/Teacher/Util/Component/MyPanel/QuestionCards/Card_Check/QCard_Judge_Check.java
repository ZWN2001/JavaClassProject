package Teacher.Util.Component.MyPanel.QuestionCards.Card_Check;

import Teacher.Util.Component.MyPanel.QuestionCardUtils.QCard_AnswerAreas.QCard_AnswerArea_Judge;
import Teacher.Util.Component.MyPanel.QuestionCardUtils.QCard_Titles.QuestionCard_CheckTitle;
import Teacher.Util.Component.MyPanel.QuestionCardUtils.QuestionCard_Stem;
import Teacher.Util.Layout.VFlowLayout;

import javax.swing.*;

public class QCard_Judge_Check extends JPanel {
    QuestionCard_CheckTitle checkTitle=new QuestionCard_CheckTitle();
    QuestionCard_Stem stemArea=new QuestionCard_Stem();
    QCard_AnswerArea_Judge answerArea=new QCard_AnswerArea_Judge();

    String stem=" ... ";

    public QCard_Judge_Check(String stem){
        this.stem=stem;
        setLayout(new VFlowLayout());
        stemArea.setStemText(stem);
        add(checkTitle);
        add(stemArea);
        add(answerArea);

    }
}
