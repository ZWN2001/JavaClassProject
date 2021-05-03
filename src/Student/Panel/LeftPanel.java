package Student.Panel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class LeftPanel extends JPanel implements MouseListener {
    private final RightPanel rightPanel;
    private final GradeJSP gradeJSP;
    private final ExamJSP examJSP;
    private final SettingPanel settingPanel;
    private final AvatarPanel avatarPanel;

    private final JButton examBtn = new JButton("在线考试");
    private final JButton gradeBtn = new JButton("成绩查询");
    private final JButton settingBtn = new JButton("账号设置");

    private final JButton homeBtn = new JButton();
    private final JButton refreshBtn = new JButton();
    private final JButton infoBtn = new JButton();

    private String visiblePart="rightPanel";

    public LeftPanel(RightPanel rightPanel, ExamJSP examJSP, GradeJSP gradeJSP, SettingPanel settingPanel, AvatarPanel avatarPanel) {
        this.rightPanel = rightPanel;
        this.gradeJSP = gradeJSP;
        this.examJSP = examJSP;
        this.settingPanel = settingPanel;
        this.avatarPanel = avatarPanel;
        setBounds(0, 250, 250, 650);
        setLayout(new GridLayout(8, 1, 10, 10));
        setBackground(new Color(245, 245, 246));
        setVisible(true);

        examBtn.setIcon(new ImageIcon("src/Student/Resource/test.png"));
        gradeBtn.setIcon(new ImageIcon("src/Student/Resource/grade.png"));
        settingBtn.setIcon(new ImageIcon("src/Student/Resource/setting.png"));
        examBtn.setFocusable(false);
        gradeBtn.setFocusable(false);
        settingBtn.setFocusable(false);
        settingBtn.setFocusPainted(false);
        examBtn.setFocusPainted(false);
        gradeBtn.setFocusPainted(false);
        Font btnFont = new Font("微软雅黑", Font.PLAIN, 25);
        examBtn.setFont(btnFont);
        gradeBtn.setFont(btnFont);
        settingBtn.setFont(btnFont);
        examBtn.addMouseListener(this);
        gradeBtn.addMouseListener(this);
        settingBtn.addMouseListener(this);

        add(examBtn);
        add(gradeBtn);
        add(settingBtn);

        for (int i = 0; i < 3; i++)
            add(new NullPanel(this));


        JPanel buttonPanel = new JPanel();
        homeBtn.setIcon(new ImageIcon("src/Student/Resource/homeButton.png"));
        homeBtn.setContentAreaFilled(false);
        homeBtn.setFocusPainted(false);
        homeBtn.addMouseListener(this);
        refreshBtn.setIcon(new ImageIcon("src/Student/Resource/refreshButton.png"));
        refreshBtn.setContentAreaFilled(false);
        refreshBtn.setFocusPainted(false);
        refreshBtn.addMouseListener(this);
        infoBtn.setIcon(new ImageIcon("src/Student/Resource/infoButton.png"));
        infoBtn.setContentAreaFilled(false);
        infoBtn.setFocusPainted(false);
        infoBtn.addMouseListener(this);
        buttonPanel.setBackground(this.getBackground());
        buttonPanel.add(homeBtn);
        buttonPanel.add(refreshBtn);
        buttonPanel.add(infoBtn);
        buttonPanel.setLayout(new GridLayout(1, 3, 0, 0));
        add(buttonPanel);
    }

    private static class NullPanel extends JPanel {
        public NullPanel(JPanel parentPanel) {
            setBackground(parentPanel.getBackground());
        }
    }

    public void falseVisible() {
        avatarPanel.setVisible(false);
        rightPanel.setVisible(false);
        gradeJSP.setVisible(false);
        settingPanel.setVisible(false);
        examJSP.setVisible(false);
        setVisible(false);
    }

    public void examEnd() {
        avatarPanel.setVisible(true);
        setVisible(true);
        examJSP.setVisible(true);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getSource().equals(examBtn)) {
            examBtn.setContentAreaFilled(false);
            gradeBtn.setContentAreaFilled(true);
            settingBtn.setContentAreaFilled(true);
            rightPanel.setVisible(false);
            gradeJSP.setVisible(false);
            settingPanel.setVisible(false);
            examJSP.setVisible(true);
            visiblePart="examJSP";
        } else if (e.getSource().equals(gradeBtn)) {
            examBtn.setContentAreaFilled(true);
            gradeBtn.setContentAreaFilled(false);
            settingBtn.setContentAreaFilled(true);
            rightPanel.setVisible(false);
            settingPanel.setVisible(false);
            examJSP.setVisible(false);
            gradeJSP.setVisible(true);
            visiblePart="gradeJSP";
        } else if (e.getSource().equals(settingBtn)) {
            examBtn.setContentAreaFilled(true);
            gradeBtn.setContentAreaFilled(true);
            settingBtn.setContentAreaFilled(false);
            rightPanel.setVisible(false);
            examJSP.setVisible(false);
            gradeJSP.setVisible(false);
            settingPanel.setVisible(true);
            visiblePart="settingPanel";
        } else if (e.getSource().equals(homeBtn)) {
            examBtn.setContentAreaFilled(true);
            gradeBtn.setContentAreaFilled(true);
            settingBtn.setContentAreaFilled(true);
            rightPanel.setVisible(true);
            examJSP.setVisible(false);
            gradeJSP.setVisible(false);
            settingPanel.setVisible(false);
            visiblePart="rightPanel";
        } else if (e.getSource().equals(refreshBtn)) {
            try {
                avatarPanel.refresh();
            } catch (Exception exception) {
                exception.printStackTrace();
            }
            switch (visiblePart){
                case "examJSP":
                    examJSP.refresh();
                    break;
                case "gradeJSP":
                    gradeJSP.refresh();
                    break;
                case "settingPanel":
                    settingPanel.refresh();
                    break;
            }
        } else if (e.getSource().equals(infoBtn)) {
            JOptionPane.showMessageDialog(null, "null");
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {
        if (e.getSource().equals(homeBtn)) {
            homeBtn.setIcon(new ImageIcon("src/Student/Resource/homeButtonL.png"));
        } else if (e.getSource().equals(refreshBtn)) {
            refreshBtn.setIcon(new ImageIcon("src/Student/Resource/refreshButtonL.png"));
        } else if (e.getSource().equals(infoBtn)) {
            infoBtn.setIcon(new ImageIcon("src/Student/Resource/infoButtonL.png"));
        }
    }

    @Override
    public void mouseExited(MouseEvent e) {
        if (e.getSource().equals(homeBtn)) {
            homeBtn.setIcon(new ImageIcon("src/Student/Resource/homeButton.png"));
        } else if (e.getSource().equals(refreshBtn)) {
            refreshBtn.setIcon(new ImageIcon("src/Student/Resource/refreshButton.png"));
        } else if (e.getSource().equals(infoBtn)) {
            infoBtn.setIcon(new ImageIcon("src/Student/Resource/infoButton.png"));
        }

    }


}
