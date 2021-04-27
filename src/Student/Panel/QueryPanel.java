package Student.Panel;

import javax.swing.*;
import java.awt.*;

public class QueryPanel extends JPanel {
    Image queryImage;

    public QueryPanel() {
        Dimension size = new Dimension(1000, 270);
        setPreferredSize(size);
        setLayout(null);
        ImageIcon queryIcon = new ImageIcon("src/Student/Resource/QueryPanel.png");
        queryImage = queryIcon.getImage();

        JLabel examID = new JLabel("ID");
        JLabel examT1 = new JLabel("测试文本1");
        JLabel examT2 = new JLabel("测试文本2");
        JLabel examT3 = new JLabel("测试文本3");
        Font queryFont = new Font("微软雅黑", Font.BOLD, 30);
        examID.setFont(queryFont);
        examT1.setFont(queryFont);
        examT2.setFont(queryFont);
        examT3.setFont(queryFont);
        examID.setBounds(80, 20, 300, 100);
        examT1.setBounds(150, 20, 300, 100);
        examT2.setBounds(200, 120, 200, 100);
        examT3.setBounds(900, 160, 300, 100);
        add(examID);
        add(examT1);
        add(examT2);
        add(examT3);
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(queryImage, 0, 0, this.getWidth(), this.getHeight(), this);
    }
}
