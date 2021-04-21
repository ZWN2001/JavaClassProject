package Student.Panel;

import javax.swing.*;
import java.awt.*;

public class AvatarPanel extends JPanel {
    public AvatarPanel() {
        setBounds(0, 0, 250, 250);
        setBackground(Color.WHITE);
        setLayout(null);
        setVisible(true);
        /*
        JLabel userId = new JLabel("testID",JLabel.CENTER);
        Font idFont = new Font("微软雅黑",Font.PLAIN,30);
        userId.setFont(idFont);
        add("South",userId);
        */
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(Color.cyan);
        g2d.fillRoundRect(35, 35, 180, 180, 500, 500);
    }
}
