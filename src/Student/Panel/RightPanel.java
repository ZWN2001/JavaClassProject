package Student.Panel;

import javax.swing.*;
import java.awt.*;

public class RightPanel extends JPanel {
    private final ImageIcon bg = new ImageIcon("src/Student/Resource/RightPanel.png");
    public RightPanel() {
        setBounds(250, 0, 1345, 860);
        setLayout(null);

        /*Font btnFont = new Font("宋体", Font.PLAIN, 50);
        JLabel intiJLabel = new JLabel("欢迎来到在线考试平台");
        intiJLabel.setFont(btnFont);
        intiJLabel.setBounds(400, 400, 600, 50);
        add(intiJLabel);
        setBackground(new Color(240, 240, 240));*/
        setVisible(true);
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(bg.getImage(), 0, 0, this.getWidth(), this.getHeight(), this);
    }
}
