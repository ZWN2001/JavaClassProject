package Student.Panel;


import Student.Bean.Student;
import Student.Frame.MainFrame;

import javax.swing.*;
import java.awt.*;

public class ExamPanel extends JPanel {
    private final MainFrame mainFrame;
    private final Student student;

    public ExamPanel(MainFrame mainFrame) {
        this.mainFrame = mainFrame;
        student=mainFrame.getStudent();
        setBackground(Color.WHITE);
        setLayout(new GridLayout(0, 1, 10, 10));
        setVisible(false);
    }


    public void loadExPanel() {
        for (int i = 0; i <= 6; i++)
            add(new ExExPanel(mainFrame));
    }
}

