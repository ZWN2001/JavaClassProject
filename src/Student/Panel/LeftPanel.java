package Student.Panel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LeftPanel extends JPanel implements ActionListener {
    private final RightPanel rightPanel;
    private final GradeJSP gradeJSP;
    private final ExamJSP examJSP;
    private final SettingPanel settingPanel;
    private final AvatarPanel avatarPanel;
    private final JButton examBtn = new JButton("在线考试");
    private final JButton gradeBtn = new JButton("成绩查询");
    private final JButton settingBtn = new JButton("账号设置");

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

        ImageIcon test = new ImageIcon("src/Student/Resource/test.png");
        ImageIcon grade = new ImageIcon("src/Student/Resource/grade.png");
        ImageIcon setting = new ImageIcon("src/Student/Resource/setting.png");
        examBtn.setIcon(test);
        gradeBtn.setIcon(grade);
        settingBtn.setIcon(setting);
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
        examBtn.addActionListener(this);
        gradeBtn.addActionListener(this);
        settingBtn.addActionListener(this);

        add(examBtn);
        add(gradeBtn);
        add(settingBtn);
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
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {
            case "在线考试":
                examBtn.setContentAreaFilled(false);
                gradeBtn.setContentAreaFilled(true);
                settingBtn.setContentAreaFilled(true);
                rightPanel.setVisible(false);
                gradeJSP.setVisible(false);
                settingPanel.setVisible(false);
                examJSP.setVisible(true);
                break;
            case "成绩查询":
                examBtn.setContentAreaFilled(true);
                gradeBtn.setContentAreaFilled(false);
                settingBtn.setContentAreaFilled(true);
                rightPanel.setVisible(false);
                settingPanel.setVisible(false);
                examJSP.setVisible(false);
                gradeJSP.setVisible(true);
                break;
            case "账号设置":
                examBtn.setContentAreaFilled(true);
                gradeBtn.setContentAreaFilled(true);
                settingBtn.setContentAreaFilled(false);
                rightPanel.setVisible(false);
                examJSP.setVisible(false);
                gradeJSP.setVisible(false);
                settingPanel.setVisible(true);
                break;

        }
    }
}
