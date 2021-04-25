package Teacher.View.MyQuestions.AddQuestion;

import Teacher.Bean.Question.Question_Choice;
import Teacher.Function.SubmitQuestion.SubmitQuestion_Choice_C;
import Teacher.Util.AdapterAndHelper.GBC;
import Teacher.Util.AdapterAndHelper.IsNumber;
import Teacher.Util.Component.MyButton.BackgroundButton;
import Teacher.Util.Component.MyTextArea.MyTextArea_Normal;
import Teacher.Util.MyFont;
import Teacher.View.HomePanels.HomeFrame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class AddQuestion_Choice extends JPanel {
    Question_Choice question_choice;
    public AddQuestion_Choice(){
        setLayout(new GridBagLayout());
        JLabel addStemLabel=new JLabel("编写题干：");
        addStemLabel.setFont(MyFont.subTitleFont);
        int width=this.getWidth();
        MyTextArea_Normal stem=new MyTextArea_Normal(6,width);
        stem.setFont(MyFont.subTitleFont);
        add(addStemLabel,new GBC(0,0,1,1).setInsets(15,40,0,0).setAnchor(GridBagConstraints.WEST));
        add(stem,new GBC(0,1,5,3).setInsets(15,40,0,20).setFill(GridBagConstraints.BOTH).setWeight(1,0));

        JLabel addOptions=new JLabel("添加选项：");
        addOptions.setFont(MyFont.subTitleFont);
        JLabel optA_Label=new JLabel("A:");
        JLabel optB_Label=new JLabel("B:");
        JLabel optC_Label=new JLabel("C:");
        JLabel optD_Label=new JLabel("D:");
        JLabel setAnswer=new JLabel("设置答案:");
        MyTextArea_Normal optA =new MyTextArea_Normal(1,90);
        MyTextArea_Normal optB =new MyTextArea_Normal( 1,90);
        MyTextArea_Normal optC =new MyTextArea_Normal(1,90);
        MyTextArea_Normal optD =new MyTextArea_Normal( 1,90);

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
        MyTextArea_Normal setMark=new MyTextArea_Normal(1,5);
        BackgroundButton submitBtn=new BackgroundButton("  确定  ");
        submitBtn.setFont(MyFont.subTitleFont);
        add(setDifficulty_Label,new GBC(0,9).setInsets(25,100,0,10));
        add(setDifficultyComboBox,new GBC(1,9).setInsets(25,10,0,100));
        add(setMark_Label,new GBC(2,9).setInsets(25,50,0,0).setAnchor(GridBagConstraints.EAST));
        add(setMark,new GBC(3,9).setInsets(25,0,0,20).setAnchor(GridBagConstraints.WEST));
        add(submitBtn,new GBC(4,10,2,1).setInsets(25,20,0,20).setAnchor(GridBagConstraints.CENTER));

        submitBtn.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                if (stem.getText().isEmpty()||optA.getText().isEmpty()||optB.getText().isEmpty()||optC.getText().isEmpty()||optD.getText().isEmpty()||setMark.getText().isEmpty()){
                    JOptionPane.showMessageDialog(AddQuestion_Choice.this, "信息不完整！");
                }else if (!IsNumber.isNumber(setMark.getText())){
                    JOptionPane.showMessageDialog(AddQuestion_Choice.this, "分值不合法，请重新输入");
                }   else{
                    question_choice=new Question_Choice(stem.getText(),Integer.parseInt(setMark.getText()),setDifficultyComboBox.getSelectedIndex()+1,optA.getText()
                            ,optB.getText(),optC.getText(),optD.getText(),(String) setAnswerComboBox.getSelectedItem());
                    try {
                        SubmitQuestion_Choice_C submitQuestion_choice_c=new SubmitQuestion_Choice_C(question_choice);
                        if (submitQuestion_choice_c.getResultCode()==1) {
                            JOptionPane.showMessageDialog(AddQuestion_Choice.this, "添加成功！");
                        } else JOptionPane.showMessageDialog(AddQuestion_Choice.this, "添加失败","错误",JOptionPane.ERROR_MESSAGE);
                    }catch (Exception exception){
                        exception.printStackTrace();
                    }
                }
            }
        });
    }
}
