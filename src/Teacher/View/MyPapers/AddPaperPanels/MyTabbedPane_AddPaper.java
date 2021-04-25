package Teacher.View.MyPapers.AddPaperPanels;

import javax.swing.*;
import java.awt.*;

public class MyTabbedPane_AddPaper extends JPanel {
    public MyTabbedPane_AddPaper(){
        setLayout(new BorderLayout());
        JTabbedPane pane=new JTabbedPane();
        pane.addTab("手动组卷",new AddPaper_Self());
        pane.addTab("按试卷难度自动组卷",new AddPaper_Difficulty());
        pane.addTab("按题型数量自动组卷",new AddPaper_QuestionNum());
        add(pane);
    }
}
