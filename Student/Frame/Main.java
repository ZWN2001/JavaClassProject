package Student.Frame;

import Student.Panel.*;

import javax.swing.*;
import java.awt.*;

public class Main {
    public static void main(String[] args){
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Throwable e) {
            e.printStackTrace();
        }
        new MainFrame();
    }
}

class MainFrame extends JFrame {
    private static final int WIDTH = 1600;
    private static final int HEIGHT = 900;
    public MainFrame() {
        super("考试平台-学生端");
        setSize(WIDTH,HEIGHT);
        setLocationRelativeTo(null);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        Container con = this.getContentPane();
        AvatarPanel avatarPanel = new AvatarPanel();
        ExamPanel examPanel = new ExamPanel();
        GradePanel gradePanel = new GradePanel();
        RightPanel rightPanel = new RightPanel();
        SettingPanel settingPanel = new SettingPanel();
        ExamJSP examJSP = new ExamJSP(examPanel);
        GradeJSP gradeJSP = new GradeJSP(gradePanel);

        LeftPanel leftPanel = new LeftPanel(rightPanel,examJSP,gradeJSP,settingPanel);
        con.add(rightPanel);
        con.add(avatarPanel);
        con.add(leftPanel);
        con.add(settingPanel);
        con.add(gradeJSP);
        con.add(examJSP);

        setVisible(true);
    }
}
