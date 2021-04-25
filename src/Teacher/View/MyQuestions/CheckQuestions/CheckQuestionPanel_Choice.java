package Teacher.View.MyQuestions.CheckQuestions;

import Teacher.Util.Component.MyPanel.QuestionCards.Card_Check.QCard_Choice_Check;
import Teacher.Util.Layout.VFlowLayout;

import javax.swing.*;

public class CheckQuestionPanel_Choice extends JScrollPane {
    public CheckQuestionPanel_Choice(){
            JPanel panel=new JPanel(new VFlowLayout());

            for (int i=0;i<20;i++){
                QCard_Choice_Check panel1=new QCard_Choice_Check(".....");
                panel.add(panel1);
            }
            getViewport().add(panel);

    }
}
