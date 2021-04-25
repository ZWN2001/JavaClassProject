package Teacher.View.MyQuestions.CheckQuestions;

import Teacher.Util.Component.MyPanel.QuestionCards.Card_Check.QCard_MultiChoice_Check;
import Teacher.Util.Layout.VFlowLayout;

import javax.swing.*;

public class CheckQuestionPanel_MultiChoice extends JScrollPane {
    public CheckQuestionPanel_MultiChoice(){
        JPanel panel=new JPanel(new VFlowLayout());

        for (int i=0;i<20;i++){
            QCard_MultiChoice_Check panel1=new QCard_MultiChoice_Check("..33...");
            panel.add(panel1);
        }
        getViewport().add(panel);
    }
}
