package Teacher.View.MyQuestions.AddQuestion;

import Teacher.Util.Adapter.GBC;
import Teacher.Util.Component.MyButton.BackgroundButton;
import Teacher.Util.MyFont;

import javax.swing.*;
import java.awt.*;

public class AddQuestion_Choice extends JPanel {
    public AddQuestion_Choice(){
        setLayout(new GridBagLayout());
        JLabel addStemLabel=new JLabel("编写题干：");
        addStemLabel.setFont(MyFont.subTitleFont);

        JTextArea stem=new JTextArea();
        stem.setLineWrap(true);
        stem.setWrapStyleWord(true);
        stem.setRows(6);
        stem.setFont(MyFont.subTitleFont);
        stem.setColumns(this.getWidth());
        add(addStemLabel,new GBC(0,0,1,1).setInsets(5,40,0,0).setAnchor(GridBagConstraints.WEST));
        add(stem,new GBC(0,1,5,3).setInsets(15,40,0,20).setFill(GridBagConstraints.BOTH).setWeight(1,0));

        JLabel addOptions=new JLabel("添加选项：");
        addOptions.setFont(MyFont.subTitleFont);
        JLabel optA_Label=new JLabel("A:");
        JLabel optB_Label=new JLabel("B:");
        JLabel optC_Label=new JLabel("C:");
        JLabel optD_Label=new JLabel("D:");
        JLabel setAnswer=new JLabel("设置答案:");
        JTextArea optA =new JTextArea(1,90);
        optA.setLineWrap(true);
        JTextArea optB =new JTextArea( 1,90);
        optB.setLineWrap(true);
        JTextArea optC =new JTextArea(1,90);
        optC.setLineWrap(true);
        JTextArea optD =new JTextArea( 1,90);
        optD.setLineWrap(true);
        JComboBox<String> setAnswerComboBox=new JComboBox<>();
        setAnswerComboBox.addItem("A");
        setAnswerComboBox.addItem("B");
        setAnswerComboBox.addItem("C");
        setAnswerComboBox.addItem("D");
        add(addOptions,new GBC(0,4,1,1).setInsets(15,40,0,0));
        add(optA_Label,new GBC(0,5,1,1).setInsets(10,20,0,0));
        add(optA,new GBC(1,5,4,1).setInsets(10,10,0,20));
        add(optB_Label,new GBC(0,6,1,1).setInsets(10,20,0,0));
        add(optB,new GBC(1,6,4,1).setInsets(10,10,0,20));
        add(optC_Label,new GBC(0,7,1,1).setInsets(10,20,0,0));
        add(optC,new GBC(1,7,4,1).setInsets(10,10,0,20));
        add(optD_Label,new GBC(0,8,1,1).setInsets(10,20,0,0));
        add(optD,new GBC(1,8,4,1).setInsets(10,10,0,20));
        add(setAnswer,new GBC(3,9,1,1).setInsets(20,200,0,0));
        add(setAnswerComboBox,new GBC(4,9,1,1).setInsets(20,20,0,0).setAnchor(GridBagConstraints.WEST));

        JLabel setDifficulty_Label=new JLabel("设置难度：");
        JComboBox<Integer> setDifficultyComboBox=new JComboBox<>();
         setDifficultyComboBox.addItem(1);
         setDifficultyComboBox.addItem(2);
         setDifficultyComboBox.addItem(3);
         setDifficultyComboBox.addItem(4);
         setDifficultyComboBox.addItem(5);
         JLabel setMark_Label=new JLabel("设置分值：      ");
         JTextArea setMark=new JTextArea(1,5);
        BackgroundButton submitBtn=new BackgroundButton("  确定  ");
        submitBtn.setFont(MyFont.subTitleFont);
        add(setDifficulty_Label,new GBC(0,9).setInsets(25,100,0,10));
        add(setDifficultyComboBox,new GBC(1,9).setInsets(25,10,0,100));
        add(setMark_Label,new GBC(2,9).setInsets(25,50,0,0).setAnchor(GridBagConstraints.EAST));
        add(setMark,new GBC(3,9).setInsets(25,0,0,20).setAnchor(GridBagConstraints.WEST));
        add(submitBtn,new GBC(4,10,2,1).setInsets(25,20,0,20).setAnchor(GridBagConstraints.CENTER));


    }
}
