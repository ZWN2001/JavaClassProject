package Teacher.Util.Component.MyPanel;

import Teacher.Util.Adapter.GBC;
import Teacher.Util.Component.MyButton.BackgroundButton;
import Teacher.Util.Layout.VFlowLayout;

import javax.swing.*;
import java.awt.*;

public class QuestionCardPanel extends JPanel {
     String stemText="stem11111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111100000" +
             "stem11111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111100000" +
             "stem11111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111100000" +
             "stem11111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111100000" +
             "stem11111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111100000" +
             "stem11111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111100000" ;
     String optionA="";
     String optionB="";
     String optionC="";
     String optionD="";
    Font titleFont=new Font("宋体",Font.PLAIN,16);

    public QuestionCardPanel () {
        setBackground(Color.WHITE);
        setLayout(new VFlowLayout());
        setPreferredSize(new Dimension(900,240));

        JPanel titlePanel =new JPanel(new GridBagLayout());

        JLabel mark=new JLabel("分值：");
        mark.setFont(titleFont);
        JLabel difficulty=new JLabel("难度系数:");
        difficulty.setFont(titleFont);
        BackgroundButton change=new BackgroundButton("修改");
        change.setUnFocusedColor(Color.WHITE);
        change.setBackground(Color.WHITE);
        BackgroundButton delete= new BackgroundButton("删除");
        delete.setUnFocusedColor(Color.WHITE);
        delete.setBackground(Color.WHITE);

        titlePanel.add(mark,new GBC(0,0).setInsets(0,0,0,20));
        titlePanel.add(difficulty,new GBC(1,0).setInsets(0,0,0,300));
        titlePanel.add(change,new GBC(3,0).setInsets(0,0,0,20));
        titlePanel.add(delete,new GBC(4,0));
        titlePanel.setBackground(Color.WHITE);


        JTextArea stem=new JTextArea(stemText);
        JScrollPane stemScrollPane = new JScrollPane(stem);
        stem.setEnabled(false);
        stem.setLineWrap(true);
        stem.setWrapStyleWord(true);
//        add(mark,new GBC(0,0).setFill(GridBagConstraints.BOTH));
//        add(difficulty,new GBC(1,0).setFill(GridBagConstraints.BOTH));
//        add(change,new GBC(7,0).setFill(GridBagConstraints.BOTH));
//        add(delete,new GBC(8,0).setFill(GridBagConstraints.BOTH));
        add(titlePanel);
        add(stemScrollPane);
    }

}
