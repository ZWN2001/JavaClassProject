package Student.Panel;

import javax.swing.*;
import java.awt.*;

public class RightPanel extends JPanel {
    public RightPanel(){
        setBounds(250, 0, 1450, 900);
        setLayout(null);
        Font btnFont = new Font("宋体", Font.PLAIN,50);
        JLabel intiJLabel = new JLabel("欢迎来到在线考试平台");
        intiJLabel.setFont(btnFont);
        intiJLabel.setBounds(400,400,600,50);
        this.add(intiJLabel);
        setVisible(true);
    }
}
