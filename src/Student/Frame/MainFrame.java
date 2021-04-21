package Student.Frame;

import Student.Panel.*;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {
    private static final int WIDTH = 1600;
    private static final int HEIGHT = 900;
    private final LeftPanel leftPanel;

    public MainFrame() {
        super("考试平台-学生端");
        setSize(WIDTH, HEIGHT);
        setLocationRelativeTo(null);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        Container con = this.getContentPane();
        AvatarPanel avatarPanel = new AvatarPanel();
        ExamPanel examPanel = new ExamPanel(this);
        GradePanel gradePanel = new GradePanel();
        RightPanel rightPanel = new RightPanel();
        SettingPanel settingPanel = new SettingPanel(this);
        ExamJSP examJSP = new ExamJSP(examPanel);
        GradeJSP gradeJSP = new GradeJSP(gradePanel);

        leftPanel = new LeftPanel(rightPanel, examJSP, gradeJSP, settingPanel, avatarPanel);
        examPanel.loadExPanel();
        con.add(rightPanel);
        con.add(avatarPanel);
        con.add(leftPanel);
        con.add(settingPanel);
        con.add(gradeJSP);
        con.add(examJSP);

        setVisible(true);
    }

    public void examStart(PaperPanel paperPanel) {
        leftPanel.falseVisible();
        add(paperPanel);
    }

    public void examEnd(PaperPanel paperPanel) {
        leftPanel.examEnd();
        paperPanel.setVisible(false);
    }
}
