package Student.Panel;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ExExPanel extends JPanel implements MouseListener {
    Image exExImage;
    JButton exStart;
    ImageIcon exStartU = new ImageIcon("src/Student/Resource/exStartU.png");
    ImageIcon exStartD = new ImageIcon("src/Student/Resource/exStartD.png");
    public ExExPanel() {
        Dimension size = new Dimension(1000, 270);
        setPreferredSize(size);
        setLayout(null);
        ImageIcon exExIcon = new ImageIcon("src/Student/Resource/ExExPanel.png");
        exExImage = exExIcon.getImage();

        JLabel exTitle = new JLabel("这是一次考试的标题");
        JLabel exTime = new JLabel("这里是考试的时间");
        exStart = new JButton();
        exStart.setIcon(exStartU);
        exStart.addMouseListener(this);
        Font exFont = new Font("微软雅黑", Font.BOLD, 30);
        //exTitle.setForeground(Color.WHITE);
        //exTime.setForeground(Color.WHITE);

        exTitle.setFont(exFont);
        exTitle.setBounds(20, 20, 600, 100);
        exTime.setFont(exFont);
        exTime.setBounds(200, 130, 600, 100);
        exStart.setFocusPainted(false);
        exStart.setBounds(1100, 160, 200, 75);
        add(exTitle);
        add(exTime);
        add(exStart);

        setVisible(true);
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(exExImage, 0, 0, this.getWidth(), this.getHeight(), this);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
    }

    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        exStart.setIcon(exStartD);
    }

    @Override
    public void mouseExited(MouseEvent e) {
        exStart.setIcon(exStartU);
    }
}


