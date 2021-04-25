package Teacher.Util.Component.MyPanel.QuestionCards.Card_Check;

import Teacher.Util.Component.MyPanel.QuestionCardUtils.QCard_AnswerAreas.QCard_AnswerArea_Subjective;
import Teacher.Util.Component.MyPanel.QuestionCardUtils.QCard_Titles.QuestionCard_CheckTitle;
import Teacher.Util.Component.MyPanel.QuestionCardUtils.QuestionCard_Stem;
import Teacher.Util.Layout.VFlowLayout;

import javax.swing.*;

public class QCard_Subjective_Check extends JPanel {
    QuestionCard_CheckTitle checkTitle=new QuestionCard_CheckTitle();
    QuestionCard_Stem stemArea=new QuestionCard_Stem();
    String answerText="";

    String stem=" ... ";

    public QCard_Subjective_Check(String stem,String answerText){
        this.stem=stem;
        this.answerText=answerText;
        setLayout(new VFlowLayout(true,true));
        QCard_AnswerArea_Subjective answerArea=new QCard_AnswerArea_Subjective(answerText);
        stemArea.setStemText(stem);
        add(checkTitle);
        add(stemArea);
        add(answerArea);

    }
}
