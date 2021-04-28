package Teacher.View.MyQuestions.AddQuestion;

import Teacher.Bean.Question.Question_Judge;
import Teacher.Function.SubmitQuestion.SubmitQuestion_C;
import Teacher.Util.AdapterAndHelper.GBC;
import Teacher.Util.AdapterAndHelper.IsNumber;
import Teacher.Util.Component.MyButton.BackgroundButton;
import Teacher.Util.Component.MyTextArea.MyTextArea_Colorful;
import Teacher.Util.Component.MyTextArea.MyTextArea_Normal;
import Teacher.Util.Component.MyTextArea.MyTextArea_Warning;
import Teacher.Util.MyFont;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class AddQuestion_Judge extends JPanel {
    Container warningArea=new Container();
    private Question_Judge question_judge;

    public AddQuestion_Judge(){
        setLayout(new GridBagLayout());
        JLabel addStemLabel=new JLabel("编写题干：");
        addStemLabel.setFont(MyFont.Font_14);

        MyTextArea_Normal stem=new MyTextArea_Normal(6,this.getWidth());
        stem.setFont(MyFont.Font_14);

        add(addStemLabel,new GBC(0,0,1,1).setInsets(5,40,0,0).setAnchor(GridBagConstraints.WEST));
        add(stem,new GBC(0,1,5,3).setInsets(15,40,0,20).setFill(GridBagConstraints.BOTH).setWeight(1,0));
        JLabel setAnswer=new JLabel("设置答案:");
        JComboBox<String> setAnswerComboBox=new JComboBox<>();
        setAnswerComboBox.addItem("对");
        setAnswerComboBox.addItem("错");
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
        submitBtn.setFont(MyFont.Font_14);
        add(setDifficulty_Label,new GBC(0,9).setInsets(25,100,0,10));
        add(setDifficultyComboBox,new GBC(1,9).setInsets(25,10,0,100));
        add(setMark_Label,new GBC(2,9).setInsets(25,50,0,0).setAnchor(GridBagConstraints.EAST));
        add(setMark,new GBC(3,9).setInsets(25,0,0,20).setAnchor(GridBagConstraints.WEST));
        add(submitBtn,new GBC(4,10,2,1).setInsets(25,20,0,20).setAnchor(GridBagConstraints.CENTER));
        warningArea.setLayout(new BorderLayout());
        add(warningArea,new GBC(0,10,6,1).setAnchor(GridBagConstraints.CENTER).setInsets(10,0,0,0));

        submitBtn.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                if (stem.getText().isEmpty()||setMark.getText().isEmpty()){
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
                    String answer;
                    if(setAnswerComboBox.getSelectedIndex()==0){
                        answer="T";
                    }else {
                        answer="F";
                    }
                    question_judge=new Question_Judge(stem.getText(),Integer.parseInt(setMark.getText()),setDifficultyComboBox.getSelectedIndex()+1, answer);
                    try {
                        SubmitQuestion_C submitQuestion_c=new SubmitQuestion_C(question_judge,"SUBMIT_QUESTION_JUDGE");
                        if (submitQuestion_c.getResultCode()==1) {
                            MyTextArea_Colorful log=new MyTextArea_Colorful(1,4,"成功","添加成功");
                            warningArea.removeAll();
                            warningArea.add(log);
                            updateUI();
                            stem.setText("");
                            setMark.setText("");
                            setDifficultyComboBox.setSelectedIndex(0);
                            setAnswerComboBox.setSelectedIndex(0);
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
