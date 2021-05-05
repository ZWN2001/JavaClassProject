package Teacher.View.MyPapers.AddPaperPanels.AddPaper;

import Teacher.Util.AdapterAndHelper.GBC;

import Teacher.Util.MyFont;
import Teacher.View.MyPapers.AddPaperPanels.AddPaper.AddPaper_Auto.AddPaperAutoPanel;
import Teacher.View.MyPapers.AddPaperPanels.AddPaper.AddPaper_Self.AddPaperSelfPanel;

import javax.swing.*;
import java.awt.*;

public class MyTabbedPane_AddPaper extends JPanel {
    public  static Container addPaperContainer=new Container();
//    public static AddPaperSelfPanel addPaperSelfPanel;
    JComboBox<String> choose=new JComboBox<>();
    public MyTabbedPane_AddPaper(){

            setLayout(new GridBagLayout());
            JLabel choose_label=new JLabel("选择出卷方式：");
            choose_label.setFont(MyFont.Font_20);

            choose.addItem("手动组卷");
            choose.addItem("智能组卷");

            addPaperContainer.setLayout(new BorderLayout());
            addPaperContainer.removeAll();
            addPaperContainer.add(new AddPaperSelfPanel());
            updateUI();
            add(choose_label,new GBC(0,0).setFill(GridBagConstraints.HORIZONTAL).setAnchor(GridBagConstraints.EAST).setInsets(10,500,0,0));
            add(choose,new GBC(1,0).setInsets(10,0,0,100));
            add(addPaperContainer,new GBC(0,1,2,1).setFill(GridBagConstraints.BOTH).setWeight(1,1));

            choose.setSelectedIndex(0);

        choose.addItemListener(event -> {
            if (choose.getSelectedIndex()==0) {
              addPaperContainer.removeAll();
              addPaperContainer.add(new AddPaperSelfPanel());
                updateUI();
            }else if (choose.getSelectedIndex()==1) {
                addPaperContainer.removeAll();
                addPaperContainer.add(new AddPaperAutoPanel());
                updateUI();
            }
        });
        }
}
