package Teacher.View.MyPapers.AddPaperPanels;

import Teacher.Bean.Statistician;
import Teacher.Util.AdapterAndHelper.GBC;
import Teacher.Util.Layout.VFlowLayout;
import Teacher.View.MyPapers.AddPaperPanels.AddPaper_Self.AddPaper_Self;
import Teacher.View.MyPapers.AddPaperPanels.AddPaper_Self.StatisticianPanel;

import javax.swing.*;
import java.awt.*;

public class MyTabbedPane_AddPaper extends JPanel {
    public static Statistician statistician=new Statistician();
    public static StatisticianPanel statisticianPanel;
    public MyTabbedPane_AddPaper(){
        setLayout(new BorderLayout());
        JTabbedPane pane=new JTabbedPane();

        Container AddPaperContainer=new Container();
        Container container=new Container();
        container.setLayout(new BorderLayout());
        container.add(new AddPaper_Self());
        AddPaperContainer.setLayout(new GridBagLayout());

        AddPaperContainer.add(container,new GBC(0,0).setFill(GridBagConstraints.BOTH).setWeight(1,1));
         statisticianPanel=new StatisticianPanel(statistician);
        AddPaperContainer.add(statisticianPanel,new GBC(0,1).setAnchor(GridBagConstraints.WEST).setFill(GridBagConstraints.BOTH).setWeight(1,0));

        pane.addTab("手动组卷",AddPaperContainer);
        pane.addTab("按试卷难度自动组卷",new AddPaper_Difficulty());
        pane.addTab("按题型数量自动组卷",new AddPaper_QuestionNum());
        add(pane);
    }
}
