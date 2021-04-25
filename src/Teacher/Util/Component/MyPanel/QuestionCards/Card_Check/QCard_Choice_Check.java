package Teacher.Util.Component.MyPanel.QuestionCards.Card_Check;

import Teacher.Util.Component.MyPanel.QuestionCardUtils.QCard_AnswerAreas.QCard_AnswerArea_Choice;
import Teacher.Util.Component.MyPanel.QuestionCardUtils.QCard_Titles.QuestionCard_CheckTitle;
import Teacher.Util.Component.MyPanel.QuestionCardUtils.QuestionCard_Stem;
import Teacher.Util.Layout.VFlowLayout;

import javax.swing.*;

public class QCard_Choice_Check extends JPanel {
    QuestionCard_CheckTitle checkTitle=new QuestionCard_CheckTitle();
    QuestionCard_Stem stemArea=new QuestionCard_Stem();
    QCard_AnswerArea_Choice answerArea=new QCard_AnswerArea_Choice();
    String stem="  ";

    public QCard_Choice_Check(String stem){
        this.stem=stem;
        setLayout(new VFlowLayout(true,true));
        stemArea.setStemText(stem);
        updateUI();
        add(checkTitle);
        add(stemArea);
        add(answerArea);
    }

}
