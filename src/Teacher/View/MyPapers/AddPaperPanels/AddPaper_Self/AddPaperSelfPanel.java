package Teacher.View.MyPapers.AddPaperPanels.AddPaper_Self;

import Teacher.Bean.Statistician;
import Teacher.Util.AdapterAndHelper.GBC;

import javax.swing.*;
import java.awt.*;

public class AddPaperSelfPanel extends JPanel {
    public static StatisticianPanel statisticianPanel;
    public static Statistician statistician;
    public static Container container2=new Container();
    public AddPaperSelfPanel( ){
        statistician=new Statistician();
        statisticianPanel=new StatisticianPanel(statistician);
        Container container=new Container();
        container.setLayout(new BorderLayout());
        container2.setLayout(new BorderLayout());
        container.add(new AddPaper_Self_CheckQuestion());
        container2.add(statisticianPanel);
        setLayout(new GridBagLayout());
        add(container,new GBC(0,0).setFill(GridBagConstraints.BOTH).setWeight(1,0.7));
        add(container2,new GBC(0,1).setAnchor(GridBagConstraints.WEST).setFill(GridBagConstraints.BOTH).setWeight(1,0));

    }
}
