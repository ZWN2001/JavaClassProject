package Teacher.Util.Component.MyPanel.QuestionCads.Card_Check;

import Teacher.Util.Adapter.GBC;
import Teacher.Util.Component.MyPanel.QuestionCardUtils.QCard_AnswerAreas.QCard_AnswerArea_Choice;
import Teacher.Util.Component.MyPanel.QuestionCardUtils.QCard_Titles.QuestionCard_CheckTitle;
import Teacher.Util.Component.MyPanel.QuestionCardUtils.QuestionCard_Stem;
import Teacher.Util.Layout.VFlowLayout;

import javax.swing.*;
import java.awt.*;

public class QCard_Choice_Check extends JPanel {
    QuestionCard_CheckTitle checkTitle=new QuestionCard_CheckTitle();
    QuestionCard_Stem stemArea=new QuestionCard_Stem();
    QCard_AnswerArea_Choice answerArea=new QCard_AnswerArea_Choice();
    String stem=" ... ";

    public QCard_Choice_Check(){
        setLayout(new VFlowLayout(true,true));
        stemArea.setStemText(stem);
        add(checkTitle,new GBC(0,0).setFill(GridBagConstraints.HORIZONTAL).setWeightx(1).setInsets(25,0,0,0));
        add(stemArea,new GBC(0,1).setFill(GridBagConstraints.BOTH).setWeightx(1));
        add(answerArea,new GBC(0,2).setFill(GridBagConstraints.HORIZONTAL).setWeightx(1));
    }
}
