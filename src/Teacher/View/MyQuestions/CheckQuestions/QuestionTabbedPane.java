package Teacher.View.MyQuestions.CheckQuestions;

import Teacher.View.MyQuestions.CheckMyQuestionBank;

import javax.swing.*;
import java.awt.*;

public class QuestionTabbedPane extends JPanel {
    public QuestionTabbedPane(){
        setLayout(new BorderLayout());
        JTabbedPane pane=new JTabbedPane();
        pane.addTab("单选题",new CheckMyQuestionBank());
        pane.addTab("多选题",new JPanel());
        pane.addTab("判断题",new JPanel());
        pane.addTab("主观题",new JPanel());
        add(pane);

    }
}
