package Teacher.View.MyQuestions.CheckQuestions;

import Teacher.Util.Component.MyPanel.QuestionCards.Card_Check.QCard_Subjective_Check;
import Teacher.Util.Layout.VFlowLayout;

import javax.swing.*;

public class CheckQuestionPanel_Subjective extends JScrollPane {
    public CheckQuestionPanel_Subjective(){
        JPanel panel=new JPanel(new VFlowLayout());

        for (int i=0;i<20;i++){
            QCard_Subjective_Check panel1=new QCard_Subjective_Check("..22...","00000");
            panel.add(panel1);
        }
        getViewport().add(panel);

    }
}
