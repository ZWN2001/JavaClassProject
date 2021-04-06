package Student.Panel;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ExExPanel extends JPanel implements ActionListener {
    Image exExImage;
    public ExExPanel() {
        Dimension size = new Dimension(1000, 270);
        setPreferredSize(size);
        setLayout(null);
        ImageIcon exExIcon = new ImageIcon("src/Student/Resource/ExExPanel.png");
        exExImage = exExIcon.getImage();

        JLabel exTitle = new JLabel("这是一次考试的标题");
        JLabel exTime = new JLabel("这里是考试的时间");
        JButton exStart = new JButton("开始考试");
        Font exFont = new Font("微软雅黑", Font.BOLD, 30);
        Font exStFont = new Font("宋体", Font.BOLD, 25);

        exTitle.setFont(exFont);
        exTitle.setBounds(20, 20, 600, 100);
        exTime.setFont(exFont);
        exTime.setBounds(200, 130, 600, 100);
        exStart.addActionListener(this);
        exStart.setFocusPainted(false);
        exStart.setPreferredSize(new Dimension(60, 60));
        exStart.setBounds(1100, 160, 200, 75);
        exStart.setFont(exStFont);
        add(exTitle);
        add(exTime);
        add(exStart);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {

    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(exExImage, 0, 0, this.getWidth(), this.getHeight(), this);
    }
}


