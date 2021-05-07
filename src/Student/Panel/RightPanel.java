package Student.Panel;

import javax.swing.*;
import java.awt.*;

public class RightPanel extends JPanel {
    private final ImageIcon bg = new ImageIcon("src/Student/Resource/RightPanel.png");
    public RightPanel() {
        setBounds(250, 0, 1345, 860);
        setLayout(null);
        setVisible(true);
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(bg.getImage(), 0, 0, this.getWidth(), this.getHeight(), this);
    }
}
