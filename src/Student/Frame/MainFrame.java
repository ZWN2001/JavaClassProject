package Student.Frame;

import Student.Panel.*;

import javax.swing.*;
import java.awt.*;


public class MainFrame extends JFrame {
    private static final int WIDTH = 1600;
    private static final int HEIGHT = 900;
    public MainFrame() {
        super("考试平台-学生端");
        Toolkit toolKit = Toolkit.getDefaultToolkit();
        Dimension screenSize = toolKit.getScreenSize();
        int width = screenSize.width;
        int height = screenSize.height;
        int x = (width - WIDTH) / 2;
        int y = (height - HEIGHT) / 2;
        setSize(WIDTH,HEIGHT);
        setLocation(x,y);
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

        LeftPanel leftPanel = new LeftPanel(rightPanel,examJSP,gradePanel,settingPanel);
        con.add(rightPanel);
        con.add(avatarPanel);
        con.add(leftPanel);
        con.add(settingPanel);
        con.add(gradePanel);
        con.add(examJSP);

        setVisible(true);
    }
}

