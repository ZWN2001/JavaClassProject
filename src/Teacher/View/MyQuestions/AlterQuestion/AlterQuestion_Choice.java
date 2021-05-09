package Teacher.View.MyQuestions.AlterQuestion;

import Teacher.Bean.Question.Question_Choice;
import Teacher.Function.ClientFuction.SubmitQuestion.SubmitQuestion_C;
import Teacher.Util.AdapterAndHelper.GBC;
import Teacher.Util.AdapterAndHelper.IsNumber;
import Teacher.Util.Component.MyButton.BackgroundButton;
import Teacher.Util.Component.MyPanel.MyWarningPanel;
import Teacher.Util.Component.MyTextArea.MyTextArea_Colorful;
import Teacher.Util.Component.MyTextArea.MyTextArea_Normal;
import Teacher.Util.Component.MyTextArea.MyTextArea_Warning;
import Teacher.Util.MyFont;
import Teacher.View.HomePanels.HomeFrame;
import Teacher.View.MyPapers.AddPaperPanels.AddPaper.AddPaper_Self.AddPaperSelfPanel;
import Teacher.View.MyQuestions.CheckQuestions.MyTabbedPane_Question;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class AlterQuestion_Choice extends JPanel  {
    Question_Choice question_choice;
    MyTextArea_Normal stem;
    MyTextArea_Normal optA;
    MyTextArea_Normal optB;
    MyTextArea_Normal optC;
    MyTextArea_Normal optD;
    JComboBox<String> setAnswerComboBox;
    JComboBox<Integer> setDifficultyComboBox;
    MyTextArea_Normal setMark;
    BackgroundButton submitBtn;
    BackgroundButton deleteBtn;
    Container warningArea=new Container();
    public AlterQuestion_Choice(int id,String stemText,String optAText,String optBText,String optCText,String optDText,int difficulty,int mark,String answer ){
        setLayout(new GridBagLayout());
        JLabel addStemLabel=new JLabel("修改题干：");
        addStemLabel.setFont(MyFont.Font_14);
        int width=this.getWidth();
        stem=new MyTextArea_Normal(6,width);
        stem.setFont(MyFont.Font_14);
        stem.textArea.setText(stemText);
        add(addStemLabel,new GBC(0,0,1,1).setInsets(15,40,0,0).setAnchor(GridBagConstraints.WEST));
        add(stem,new GBC(0,1,5,3).setInsets(15,40,0,20).setFill(GridBagConstraints.BOTH).setWeight(1,0));

        JLabel addOptions=new JLabel("修改选项：");
        addOptions.setFont(MyFont.Font_14);
        JLabel optA_Label=new JLabel("A:");
        JLabel optB_Label=new JLabel("B:");
        JLabel optC_Label=new JLabel("C:");
        JLabel optD_Label=new JLabel("D:");
        JLabel setAnswer=new JLabel("设置答案:");
        optA =new MyTextArea_Normal(1,90);
        optA.textArea.setText(optAText);
        optB =new MyTextArea_Normal( 1,90);
        optB.textArea.setText(optBText);
        optC =new MyTextArea_Normal(1,90);
        optC.textArea.setText(optCText);
        optD =new MyTextArea_Normal( 1,90);
        optD.textArea.setText(optDText);

        setAnswerComboBox=new JComboBox<>();
        setAnswerComboBox.addItem("A");
        setAnswerComboBox.addItem("B");
        setAnswerComboBox.addItem("C");
        setAnswerComboBox.addItem("D");
        switch (answer){
            case "A":
                setAnswerComboBox.setSelectedIndex(0);
                break;
            case "B":
                setAnswerComboBox.setSelectedIndex(1);
                break;
            case "C":
                setAnswerComboBox.setSelectedIndex(2);
                break;
            case "D":
                setAnswerComboBox.setSelectedIndex(3);
                break;
            default:
                break;
        }

        add(addOptions,new GBC(0,4,1,1).setInsets(15,40,0,0));
        add(optA_Label,new GBC(0,5,1,1).setInsets(10,20,0,0));
        add(optA,new GBC(1,5,4,1).setInsets(10,0,0,20));
        add(optB_Label,new GBC(0,6,1,1).setInsets(10,20,0,0));
        add(optB,new GBC(1,6,4,1).setInsets(10,0,0,20));
        add(optC_Label,new GBC(0,7,1,1).setInsets(10,20,0,0));
        add(optC,new GBC(1,7,4,1).setInsets(10,0,0,20));
        add(optD_Label,new GBC(0,8,1,1).setInsets(10,20,0,0));
        add(optD,new GBC(1,8,4,1).setInsets(10,0,0,20));
        add(setAnswer,new GBC(3,9,1,1).setInsets(20,200,0,0));
        add(setAnswerComboBox,new GBC(4,9,1,1).setInsets(20,20,0,0).setAnchor(GridBagConstraints.WEST));

        JLabel setDifficulty_Label=new JLabel("设置难度：");
        setDifficultyComboBox=new JComboBox<>();
        setDifficultyComboBox.addItem(1);
        setDifficultyComboBox.addItem(2);
        setDifficultyComboBox.addItem(3);
        setDifficultyComboBox.addItem(4);
        setDifficultyComboBox.addItem(5);
        setDifficultyComboBox.setSelectedIndex(difficulty-1);
        JLabel setMark_Label=new JLabel("设置分值：  ");
        setMark=new MyTextArea_Normal(1,5);
        setMark.textArea.setText(""+mark);
        submitBtn=new BackgroundButton("  确定  ");
        submitBtn.setFont(MyFont.Font_14);
        deleteBtn=new BackgroundButton("  删除  ");
        deleteBtn.setFont(MyFont.Font_14);
        add(setDifficulty_Label,new GBC(0,9).setInsets(25,100,0,10));
        add(setDifficultyComboBox,new GBC(1,9).setInsets(25,10,0,100));
        add(setMark_Label,new GBC(2,9).setInsets(25,50,0,0).setAnchor(GridBagConstraints.EAST));
        add(setMark,new GBC(3,9).setInsets(25,0,0,20).setAnchor(GridBagConstraints.WEST));
        add(submitBtn,new GBC(5,10,2,1).setInsets(25,20,0,10).setAnchor(GridBagConstraints.CENTER));
        add(deleteBtn,new GBC(7,10).setInsets(25,10,0,20).setAnchor(GridBagConstraints.CENTER));
        warningArea.setLayout(new BorderLayout());
        add(warningArea,new GBC(2,10,2,1).setAnchor(GridBagConstraints.CENTER).setInsets(10,0,0,0));

        submitBtn.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                if (stem.getText().isEmpty()||optA.getText().isEmpty()||optB.getText().isEmpty()||optC.getText().isEmpty()||optD.getText().isEmpty()||setMark.getText().isEmpty()){
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
                    question_choice=new Question_Choice(id,stem.getText(),Integer.parseInt(setMark.getText()),setDifficultyComboBox.getSelectedIndex()+1,optA.getText()
                            ,optB.getText(),optC.getText(),optD.getText(),(String) setAnswerComboBox.getSelectedItem());
                    try {
                        SubmitQuestion_C submitQuestion_c=new SubmitQuestion_C(question_choice,"CHANGE_QUESTION_CHOICE");
                        if (submitQuestion_c.getResultCode()==1) {
                            HomeFrame.content.removeAll();
                            HomeFrame.content.add(new MyTabbedPane_Question(0));
                        } else {
                            MyTextArea_Warning warning=new MyTextArea_Warning(1,8,"错误","修改失败");
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

        deleteBtn.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                warningArea.removeAll();
                MyWarningPanel warningPanel=new MyWarningPanel("确定删除？");
                warningArea.add(warningPanel);
                repaint();
                updateUI();
                warningPanel.oKButton.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        super.mouseClicked(e);
                        //TODO shanchu
                    }
                });
                warningPanel.cancelButton.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        super.mouseClicked(e);
                        warningArea.removeAll();
                        repaint();
                        updateUI();
                    }
                });
            }
        });
    }
}

