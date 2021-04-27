package Teacher.View.MyQuestions.AddQuestion;

import Teacher.Bean.Question.Question_Choice;
import Teacher.Bean.Question.Question_MultiChoice;
import Teacher.Function.SubmitQuestion.SubmitQuestion_C;
import Teacher.Util.AdapterAndHelper.GBC;
import Teacher.Util.AdapterAndHelper.IsNumber;
import Teacher.Util.Component.MyButton.BackgroundButton;
import Teacher.Util.Component.MyTextArea.MyTextArea_Colorful;
import Teacher.Util.Component.MyTextArea.MyTextArea_Normal;
import Teacher.Util.Component.MyTextArea.MyTextArea_Warning;
import Teacher.Util.MyFont;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Arrays;

public class AddQuestion_MultiChoice extends JPanel {
private Question_MultiChoice question_multiChoice;
    Container warningArea=new Container();
 String[] answer ={"","","",""};
    public AddQuestion_MultiChoice(){
        setLayout(new GridBagLayout());
        JLabel addStemLabel=new JLabel("编写题干：");
        addStemLabel.setFont(MyFont.subTitleFont);

        MyTextArea_Normal stem=new MyTextArea_Normal(6,this.getWidth());
        stem.setFont(MyFont.subTitleFont);
        add(addStemLabel,new GBC(0,0,1,1).setInsets(5,40,0,0).setAnchor(GridBagConstraints.WEST));
        add(stem,new GBC(0,1,5,3).setInsets(15,40,0,20).setFill(GridBagConstraints.BOTH).setWeight(1,0));

        JLabel addOptions=new JLabel("添加选项：");
        addOptions.setFont(MyFont.subTitleFont);
        JLabel optA_Label=new JLabel("A:");
        JLabel optB_Label=new JLabel("B:");
        JLabel optC_Label=new JLabel("C:");
        JLabel optD_Label=new JLabel("D:");

        JPanel setAnswerPanel=new JPanel();
        GradientPaint gradientPaint = new GradientPaint(200f, 15f, Color.GREEN, 350, 15f, Color.RED, false);//建立渐变颜色
        Border border = BorderFactory.createDashedBorder(gradientPaint, 10f, 10);
        Border border1 = BorderFactory.createTitledBorder(border, "设置答案:");
        setAnswerPanel.setBorder(border1);
        setAnswerPanel.setLayout(new FlowLayout());

        JCheckBox optA_Box = new JCheckBox("A");
        setAnswerPanel.add(optA_Box);
        JCheckBox optB_Box = new JCheckBox("B");
        setAnswerPanel.add(optB_Box);
        JCheckBox optC_Box = new JCheckBox("C");
        setAnswerPanel.add(optC_Box);
        JCheckBox optD_Box = new JCheckBox("D");
        setAnswerPanel.add(optD_Box);

        MyTextArea_Normal optA =new MyTextArea_Normal(1,90);
        MyTextArea_Normal optB =new MyTextArea_Normal( 1,90);
        MyTextArea_Normal optC =new MyTextArea_Normal(1,90);
        MyTextArea_Normal optD =new MyTextArea_Normal( 1,90);

        add(addOptions,new GBC(0,4,1,1).setInsets(15,40,0,0));
        add(optA_Label,new GBC(0,5,1,1).setInsets(10,20,0,0));
        add(optA,new GBC(1,5,4,1).setInsets(10,10,0,20));
        add(optB_Label,new GBC(0,6,1,1).setInsets(10,20,0,0));
        add(optB,new GBC(1,6,4,1).setInsets(10,10,0,20));
        add(optC_Label,new GBC(0,7,1,1).setInsets(10,20,0,0));
        add(optC,new GBC(1,7,4,1).setInsets(10,10,0,20));
        add(optD_Label,new GBC(0,8,1,1).setInsets(10,20,0,0));
        add(optD,new GBC(1,8,4,1).setInsets(10,10,0,20));
        add(setAnswerPanel,new GBC(4,9,1,1).setInsets(20,20,0,0));


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
        add(submitBtn,new GBC(4,10,1,1).setInsets(25,20,0,20).setAnchor(GridBagConstraints.CENTER));

        warningArea.setLayout(new BorderLayout());
        add(warningArea,new GBC(0,10,6,1).setAnchor(GridBagConstraints.CENTER).setInsets(10,0,0,0));

        optA_Box.addActionListener(e -> {
            if (optA_Box.isSelected()){
                answer[0]="A";
            }else {
                answer[0]="";
            }
        });
        optB_Box.addActionListener(e -> {
            if (optB_Box.isSelected()){
                answer[1]="B";
            }else {
                answer[1]="";
            }
        });
        optC_Box.addActionListener(e -> {
            if (optC_Box.isSelected()){
                answer[2]="C";
            }else {
                answer[2]="";
            }
        });
        optD_Box.addActionListener(e -> {
            if (optD_Box.isSelected()){
                answer[3]="D";
            }else {
                answer[3]="";
            }
        });
        submitBtn.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                boolean answerSet=false;
                if (optA_Box.isSelected()||optB_Box.isSelected()||optC_Box.isSelected()||optD_Box.isSelected()){
                    answerSet=true;
                }
                if (stem.getText().isEmpty()||optA.getText().isEmpty()||optB.getText().isEmpty()||optC.getText().isEmpty()||optD.getText().isEmpty()||setMark.getText().isEmpty()||!answerSet){
                    MyTextArea_Warning warning=new MyTextArea_Warning(1,8,"警告","题目信息不完善");
                    warningArea.removeAll();
                    warningArea.add(warning);
                    updateUI();
                }else if (!IsNumber.isNumber(setMark.getText())){
                    MyTextArea_Warning warning=new MyTextArea_Warning(1,22,"警告","分值不合法，请检查输入");
                    warningArea.removeAll();
                    warningArea.add(warning);
                    updateUI();
                }   else{
                    question_multiChoice=new Question_MultiChoice(stem.getText(),Integer.parseInt(setMark.getText()),setDifficultyComboBox.getSelectedIndex()+1,optA.getText()
                            ,optB.getText(),optC.getText(),optD.getText(), Arrays.toString(answer));
                    try {
                        SubmitQuestion_C submitQuestion_c=new SubmitQuestion_C(question_multiChoice,"SUBMIT_QUESTION_MULTICHOICE");
                           if (submitQuestion_c.getResultCode()==1) {
                            MyTextArea_Colorful log=new MyTextArea_Colorful(1,4,"成功","添加成功");
                            warningArea.removeAll();
                            warningArea.add(log);
                            updateUI();
                            stem.setText("");
                            setMark.setText("");
                            setDifficultyComboBox.setSelectedIndex(0);
                            answer= new String[]{" ", " ", " ", ""};
                            optA.setText("");
                            optA_Box.setSelected(false);
                            optB.setText("");
                            optB_Box.setSelected(false);
                            optC.setText("");
                            optC_Box.setSelected(false);
                            optD.setText("");
                            optD_Box.setSelected(false);
                       } else {
                            MyTextArea_Warning warning=new MyTextArea_Warning(1,8,"错误","添加失败");
                            warningArea.removeAll();
                            warningArea.add(warning);
                            updateUI();
                        }
                    }catch (Exception exception){
                        exception.printStackTrace();
                    }
                }
            }
        });
    }
}
