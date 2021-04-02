package Teacher.View;

import Teacher.Bean.Question.Question;
import Teacher.Bean.Question.Question_choice;
import Teacher.Test.QuestionBank;
import Teacher.Util.Component.MyPanel.QuestionCardPanel;
import Teacher.Util.Layout.VFlowLayout;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class CheckMyQuestionBank extends JScrollPane {
    public CheckMyQuestionBank(){
//        JPanel panel=new JPanel();
//        for (int i=0;i<20;i++){
            QuestionCardPanel panel1=new QuestionCardPanel();
            add(panel1);
//        panel.add(panel1, BorderLayout.CENTER);
////        }
//        add(panel);
    }
}
