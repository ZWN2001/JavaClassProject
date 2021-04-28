package Student.Panel;

import Student.Bean.Student;

import javax.swing.*;
import java.awt.*;

public class AvatarPanel extends JPanel {
    public AvatarPanel(Student student,ImageIcon img) {
        setBounds(0, 0, 250, 250);
        setLayout(new BorderLayout());
        img.setImage(img.getImage().getScaledInstance(180, 180, Image.SCALE_DEFAULT));
        JLabel avatar = new JLabel(img);
        add(avatar);
        JLabel userId = new JLabel(student.getName(),JLabel.CENTER);
        Font idFont = new Font("微软雅黑",Font.PLAIN,25);
        userId.setFont(idFont);
        add("South",userId);
        setVisible(true);
    }

    /*@Override
    public void paint(Graphics g) {
        super.paint(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(Color.cyan);
        g2d.fillRoundRect(35, 35, 180, 180, 500, 500);
    }*/
}
