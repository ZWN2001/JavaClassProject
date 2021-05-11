package Student.Panel;

import Student.Frame.MainFrame;
import Teacher.Bean.Paper;
import com.alibaba.fastjson.JSON;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ExExPanel extends JPanel implements MouseListener {
    private final Image exExImage;
    private final JButton exStart;
    private final MainFrame mainFrame;
    private final Paper paper;
    private static final ImageIcon exStartU = new ImageIcon("src/Student/Resource/exStartU.png");
    private static final ImageIcon exStartD = new ImageIcon("src/Student/Resource/exStartD.png");
    private static final ImageIcon exExIcon = new ImageIcon("src/Student/Resource/ExExPanel.png");

    public ExExPanel(MainFrame mainFrame, Paper paper) {
        this.mainFrame = mainFrame;
        this.paper=paper;
        setPreferredSize(new Dimension(1345, 270));
        setLayout(null);
        exExImage = exExIcon.getImage();

        JLabel exTitle = new JLabel(paper.getTitle());
        JLabel exTime = new JLabel("考试时间："+String.format("%02d:%02d:%02d",paper.getExamTime()/60,paper.getExamTime()%60,0));
        JLabel paperOwner = new JLabel("创建人:"+paper.getOwner()+"("+paper.getOwnerID()+")");
        JLabel paperDiff = new JLabel("试题难度:"+paper.getDifficulty());
        JLabel paperMark = new JLabel("试题总分:"+paper.getMark());
        exStart = new JButton();
        exStart.setIcon(exStartU);
        exStart.setContentAreaFilled(false);
        exStart.addMouseListener(this);
        Font exFont = new Font("微软雅黑", Font.BOLD, 30);


        //exTitle.setForeground(Color.WHITE);
        //exTime.setForeground(Color.WHITE);

        exTitle.setFont(exFont);
        exTitle.setBounds(40, 20, 1000, 100);
        exTime.setFont(exFont);
        exTime.setBounds(100, 130, 600, 100);
        paperOwner.setFont(exFont);
        paperOwner.setBounds(700,50,600,100);
        paperDiff.setFont(exFont);
        paperDiff.setBounds(450,50,600,100);
        paperMark.setFont(exFont);
        paperMark.setBounds(500,130,600,100);
        exStart.setFocusPainted(false);
        exStart.setBounds(1100, 160, 200, 75);
        add(exTitle);
        add(exTime);
        add(paperOwner);
        add(exStart);
        add(paperDiff);
        add(paperMark);

        setVisible(true);
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(exExImage, 0, 0, this.getWidth(), this.getHeight(), this);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        new PaperPanel(mainFrame,paper);
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


