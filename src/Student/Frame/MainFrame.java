package Student.Frame;

import Student.Bean.Student;
import Student.Panel.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class MainFrame extends JFrame {
    private static final int WIDTH = 1600;
    private static final int HEIGHT = 900;
    private final LeftPanel leftPanel;
    private final ExamPanel examPanel;
    private final Student student;
    private PaperPanel paperPanel;

    public MainFrame(Student student, ImageIcon imageIcon) {
        super("考试平台-学生端");
        setSize(WIDTH, HEIGHT);
        setLocationRelativeTo(null);
        setResizable(false);
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                super.windowClosing(e);
                if (paperPanel != null) {
                    if (JOptionPane.showConfirmDialog(null, "确定退出系统并要结束考试吗，已作答的题目将被自动提交", "", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
                        paperPanel.endTimer();
                        examEnd(paperPanel);
                        System.exit(0);
                    }
                }
            }
        });
        setLayout(null);

        this.student = student;

        Container con = this.getContentPane();
        AvatarPanel avatarPanel = new AvatarPanel(student, imageIcon);
        examPanel = new ExamPanel(this);
        GradePanel gradePanel = new GradePanel(student);
        RightPanel rightPanel = new RightPanel();
        SettingPanel settingPanel = new SettingPanel(this, imageIcon);
        ExamJSP examJSP = new ExamJSP(examPanel);
        GradeJSP gradeJSP = new GradeJSP(gradePanel);

        leftPanel = new LeftPanel(rightPanel, examJSP, gradeJSP, settingPanel, avatarPanel);
        examPanel.loadExPanel();
        gradePanel.loadQueryPanel();
        con.add(rightPanel);
        con.add(avatarPanel);
        con.add(leftPanel);
        con.add(settingPanel);
        con.add(gradeJSP);
        con.add(examJSP);

        setVisible(true);
    }

    public void examStart(PaperPanel paperPanel) {
        this.paperPanel = paperPanel;
        leftPanel.falseVisible();
        add(paperPanel);
    }

    public void examEnd(PaperPanel paperPanel) {
        leftPanel.examEnd();
        paperPanel.uploadAnswer();
        examPanel.refresh();
        paperPanel.setVisible(false);
    }

    public Student getStudent() {
        return student;
    }
}
