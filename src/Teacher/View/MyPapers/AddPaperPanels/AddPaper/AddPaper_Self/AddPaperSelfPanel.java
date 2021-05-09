package Teacher.View.MyPapers.AddPaperPanels.AddPaper.AddPaper_Self;

import Teacher.Bean.Statistician_SelfAdd;
import Teacher.Util.AdapterAndHelper.GBC;

import javax.swing.*;
import java.awt.*;

public class AddPaperSelfPanel extends JPanel {
    public static StatisticianPanel_Self statisticianPanel;
    public static Statistician_SelfAdd statistician=new Statistician_SelfAdd();
    public static Container container2=new Container();
    public static AddPaper_Self_CheckQuestion addPaper_self_checkQuestion;
    public AddPaperSelfPanel( ){
      addPaper_self_checkQuestion=new AddPaper_Self_CheckQuestion();
        statisticianPanel=new StatisticianPanel_Self(statistician);
        Container container=new Container();
        container.setLayout(new BorderLayout());
        container2.setLayout(new BorderLayout());
        container.add(addPaper_self_checkQuestion);
        container2.add(statisticianPanel);

        setLayout(new GridBagLayout());
        add(container,new GBC(0,0).setFill(GridBagConstraints.BOTH).setWeight(1,0.95));
        add(container2,new GBC(0,1).setFill(GridBagConstraints.BOTH).setWeight(1,0.05));
        repaint();
        updateUI();
    }
    public AddPaperSelfPanel( int n){
        addPaper_self_checkQuestion=new AddPaper_Self_CheckQuestion();
        statisticianPanel=new StatisticianPanel_Self(statistician);
        addPaper_self_checkQuestion.pane.setSelectedIndex(n);
        Container container=new Container();
        container.setLayout(new BorderLayout());
        container2.setLayout(new BorderLayout());
        container.add(addPaper_self_checkQuestion);
        container2.add(statisticianPanel);

        setLayout(new GridBagLayout());
        add(container,new GBC(0,0).setFill(GridBagConstraints.BOTH).setWeight(1,0.95));
        add(container2,new GBC(0,1).setFill(GridBagConstraints.BOTH).setWeight(1,0.05));
        repaint();
        updateUI();
    }
}
