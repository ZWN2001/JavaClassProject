package Teacher.View.MyQuestions.AddQuestion;

import Teacher.Util.Adapter.GBC;
import Teacher.Util.Layout.VFlowLayout;
import Teacher.Util.MyFont;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class AddQuestionPane extends JPanel {
    public static Container addQuestionContainer=new Container();
    public AddQuestionPane(){
        setLayout(new GridBagLayout());
        addQuestionContainer.setLayout(new VFlowLayout(true,true));
        JPanel chooseKind=new JPanel(new GridBagLayout());
        JLabel title=new JLabel("添加题目");
        title.setFont(MyFont.mainTitleFont);

        JLabel choose_label=new JLabel("选择题型：");
        choose_label.setFont(MyFont.subTitleFont);
        JComboBox<String> choose=new JComboBox<>();
        choose.addItem("单选题");
        choose.addItem("判断题");
        choose.addItem("多选题");
        choose.addItem("主观题");
      //  chooseKind.setBackground(Color.CYAN);
        chooseKind.add(title,new GBC(0,0,4,0).setInsets(10,20,0,400));
        chooseKind.add(choose_label,new GBC(5,0).setInsets(10,0,0,20).setAnchor(GridBagConstraints.EAST));
        chooseKind.add(choose,new GBC(6,0).setInsets(10,0,0,100).setAnchor(GridBagConstraints.EAST));
        add(chooseKind,new GBC(0,0).setFill(GridBagConstraints.HORIZONTAL).setInsets(10,0,0,0));

        addQuestionContainer.add(new AddQuestion_Choice());
        addQuestionContainer.setBackground(Color.blue);
        add(addQuestionContainer,new GBC(0,1).setFill(GridBagConstraints.BOTH).setWeight(1,1));


        choose.addItemListener(event -> {
            if (choose.getSelectedIndex()==0) {
                addQuestionContainer.removeAll();
                addQuestionContainer.add(new AddQuestion_Choice());
               updateUI();
            }else if (choose.getSelectedIndex()==1) {
                addQuestionContainer.removeAll();
                addQuestionContainer.add(new AddQuestion_Judge());
                updateUI();
            }else if (choose.getSelectedIndex()==2) {
                addQuestionContainer.removeAll();
                addQuestionContainer.add(new AddQuestion_MultiChoice());
                updateUI();
            }else if (choose.getSelectedIndex()==3) {
                addQuestionContainer.removeAll();
                addQuestionContainer.add(new AddQuestion_Subjective());
                updateUI();
            }
        });

    }
}
