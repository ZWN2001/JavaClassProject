package Teacher.View.MyQuestions;

import javax.swing.*;
import java.awt.*;

public class AddQuestionPanel extends JPanel {
    public AddQuestionPanel() {
        setLayout(new BorderLayout());
        JTabbedPane pane=new JTabbedPane();
        pane.addTab("1",new JPanel());
        pane.addTab("1",new JPanel());
        pane.addTab("1",new JPanel());
        add(pane);
    }

}
