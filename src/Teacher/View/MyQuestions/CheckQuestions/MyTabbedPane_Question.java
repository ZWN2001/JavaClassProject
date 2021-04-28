package Teacher.View.MyQuestions.CheckQuestions;

import javax.swing.*;
import java.awt.*;

public class MyTabbedPane_Question extends JPanel {
    public MyTabbedPane_Question(){
        setLayout(new BorderLayout());
        JTabbedPane pane=new JTabbedPane();
        pane.addTab("单选题",new CheckQuestionPanel_Choice());
        pane.addTab("多选题",new CheckQuestionPanel_MultiChoice());
        pane.addTab("判断题",new CheckQuestionPanel_Judge());
        pane.addTab("主观题",new CheckQuestionPanel_Subjective());

        add(pane);
    }
}
