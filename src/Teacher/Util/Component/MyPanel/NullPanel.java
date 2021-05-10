package Teacher.Util.Component.MyPanel;

import javax.swing.*;
import java.awt.*;

public class NullPanel extends JPanel {
    public NullPanel() {
        setLayout(new BorderLayout());
        setSize(200,200);
        ImageIcon image=new ImageIcon("src/Teacher/Util/Images/nullResult.png");
        JLabel label=new JLabel(image);
        add(label);
    }
}
