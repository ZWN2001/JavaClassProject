package Teacher.View.MyQuestions;

import Teacher.Util.Component.MyPanel.QuestionCads.QuestionCardPanel;
import Teacher.Util.Layout.VFlowLayout;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class CheckMyQuestionBank extends JScrollPane {
    Font titleFont=new Font("宋体",Font.PLAIN,26);
    public CheckMyQuestionBank(){
        JPanel panel=new JPanel(new VFlowLayout());
        JLabel title=new JLabel("我的题库");
        title.setHorizontalAlignment(0);
        title.setFont(titleFont);

        Border border = title.getBorder();
        Border margin = new EmptyBorder(10,10,8,10);
        title.setBorder(new CompoundBorder(border, margin));

        panel.add(title,VFlowLayout.TOP);
        for (int i=0;i<20;i++){
            QuestionCardPanel panel1=new QuestionCardPanel();
        panel.add(panel1);
        }
        getViewport().add(panel);
    }

}
