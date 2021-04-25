package Teacher.View.MyQuestions.CheckQuestions;

import Teacher.Util.Component.MyPanel.QuestionCards.Card_Check.QCard_Judge_Check;
import Teacher.Util.Layout.VFlowLayout;

import javax.swing.*;

public class CheckQuestionPanel_Judge extends JScrollPane {
    public CheckQuestionPanel_Judge(){
        JPanel panel=new JPanel(new VFlowLayout());

        for (int i=0;i<20;i++){
            QCard_Judge_Check panel1=new QCard_Judge_Check("..44...");
            panel.add(panel1);
        }
        getViewport().add(panel);

    }
}
