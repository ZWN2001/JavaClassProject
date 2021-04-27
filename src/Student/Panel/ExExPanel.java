package Student.Panel;

import Student.Frame.MainFrame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ExExPanel extends JPanel implements MouseListener {
    private final Image exExImage;
    private final JButton exStart;
    private final MainFrame mainFrame;
    private static final ImageIcon exStartU = new ImageIcon("src/Student/Resource/exStartU.png");
    private static final ImageIcon exStartD = new ImageIcon("src/Student/Resource/exStartD.png");
    private static final ImageIcon exExIcon = new ImageIcon("src/Student/Resource/ExExPanel.png");

    public ExExPanel(MainFrame mainFrame) {
        this.mainFrame = mainFrame;
        Dimension size = new Dimension(1000, 270);
        setPreferredSize(size);
        setLayout(null);
        exExImage = exExIcon.getImage();

        JLabel exTitle = new JLabel("考试标题");
        JLabel exTime = new JLabel("考试时间");
        exStart = new JButton();
        exStart.setIcon(exStartU);
        exStart.setContentAreaFilled(false);
        exStart.addMouseListener(this);
        Font exFont = new Font("微软雅黑", Font.BOLD, 30);
        //exTitle.setForeground(Color.WHITE);
        //exTime.setForeground(Color.WHITE);

        exTitle.setFont(exFont);
        exTitle.setBounds(40, 20, 600, 100);
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
        new PaperPanel(mainFrame);
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


