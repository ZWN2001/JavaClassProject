package Student.Panel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LeftPanel extends JPanel implements ActionListener {
    private final RightPanel rightPanel;
    private final GradePanel gradePanel;
    private final ExamJSP examJSP;
    private final SettingPanel settingPanel;
    private final JButton examBtn = new JButton("在线考试");
    private final JButton gradeBtn = new JButton("成绩查询");
    private final JButton settingBtn = new JButton("账号设置");

    public LeftPanel(RightPanel rightPanel,ExamJSP examJSP,GradePanel gradePanel,SettingPanel settingPanel){
        this.rightPanel = rightPanel;
        this.gradePanel = gradePanel;
        this.examJSP = examJSP;
        this.settingPanel = settingPanel;
        setBounds(0,250,250,650);
        setLayout(new GridLayout(8, 1, 10, 10));
        setBackground(new Color(240,250,255));
        setVisible(true);

        settingBtn.setFocusPainted(false);
        examBtn.setFocusPainted(false);
        gradeBtn.setFocusPainted(false);
        Font btnFont = new Font("微软雅黑", Font.PLAIN,25);
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


    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()){
            case "在线考试":
                examBtn.setContentAreaFilled(false);
                gradeBtn.setContentAreaFilled(true);
                settingBtn.setContentAreaFilled(true);
                rightPanel.setVisible(false);
                gradePanel.setVisible(false);
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
                gradePanel.setVisible(true);
                break;
            case "账号设置":
                examBtn.setContentAreaFilled(true);
                gradeBtn.setContentAreaFilled(true);
                settingBtn.setContentAreaFilled(false);
                rightPanel.setVisible(false);
                examJSP.setVisible(false);
                gradePanel.setVisible(false);
                settingPanel.setVisible(true);
                break;

        }
    }
}
