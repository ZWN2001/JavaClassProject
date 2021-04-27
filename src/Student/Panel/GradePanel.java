package Student.Panel;

import javax.swing.*;
import java.awt.*;


public class GradePanel extends JPanel {
    public GradePanel() {
        setBackground(Color.WHITE);
        setLayout(new GridLayout(0, 1, 10, 10));
        for (int i = 0; i <= 6; i++)
            add(new QueryPanel());
        setVisible(false);
    }
}
