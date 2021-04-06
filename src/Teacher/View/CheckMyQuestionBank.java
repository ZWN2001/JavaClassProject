package Teacher.View;

import Teacher.Util.Component.MyPanel.QuestionCardPanel;
import Teacher.Util.Layout.VFlowLayout;

import javax.swing.*;

public class CheckMyQuestionBank extends JScrollPane {
    public CheckMyQuestionBank(){
        JPanel panel=new JPanel(new VFlowLayout());
        panel.add(new JLabel("aaaa"));
        for (int i=0;i<20;i++){
            QuestionCardPanel panel1=new QuestionCardPanel();
        panel.add(panel1);
        }
        getViewport().add(panel);
    }
}
