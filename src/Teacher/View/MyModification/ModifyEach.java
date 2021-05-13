package Teacher.View.MyModification;

import Teacher.Function.ClientFuction.Modify.GetModifyQuestion_C;
import Teacher.Function.ClientFuction.Modify.SubmitModifiedMarks_C;
import Teacher.Test.AvailableQuestion;
import Teacher.Util.AdapterAndHelper.GBC;
import Teacher.Util.Component.MyButton.BackgroundButton;
import Teacher.Util.Component.MyButton.ChangeColorButton;
import Teacher.Util.Component.MyTextArea.MyTextArea_Warning;
import Teacher.Util.Layout.VFlowLayout;
import Teacher.View.HomePanels.HomeFrame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ModifyEach extends JPanel {
    public  JPanel questionPanel=new JPanel();
    public  JPanel navigationPanel=new JPanel();
    public static JPanel warningPanel=new JPanel(new BorderLayout());
    public static ModifyEach_LeftPanel modifyEach_leftPanel;
    int i;
    private String[] studentID;
    private String[] answers;
    private int[] subjectiveScore;
    private GetModifyQuestion_C getModifyQuestion;
    private SubmitModifiedMarks_C submitModifiedMarks;
    BackgroundButton lastBtn,nextBtn,exitBtn;
    public static int locate=0;
    public ModifyEach(int id){
        setLayout(new GridBagLayout());
        questionPanel.setLayout(new BorderLayout());
        navigationPanel.setLayout(new GridBagLayout());
        MyTextArea_Warning noLast=new MyTextArea_Warning(1,6,"提示","前面没有啦！");
        MyTextArea_Warning noNext=new MyTextArea_Warning(1,6,"提示","后面没有啦！");
        //get data
        try{
            getModifyQuestion=new GetModifyQuestion_C(id);
            studentID=getModifyQuestion.getStudentID();
            answers=getModifyQuestion.getModifyAnswers();
            if (answers.length>0){
                subjectiveScore=new int[answers.length];
                for ( i=0;i<subjectiveScore.length;i++){
                    subjectiveScore[i]=-1;
                }
            }else {
                subjectiveScore=new int[0];
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        //testData:
//        AvailableQuestion[] a=AvailableQuestion.getAvailableQuestion();

        JPanel buttonPanel=new JPanel(new VFlowLayout(true,false));
        for (i=0;i<answers.length;i++){
            ChangeColorButton changeColorButton=new ChangeColorButton(""+(i+1));
            buttonPanel.add(changeColorButton);
            changeColorButton.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    super.mouseClicked(e);
                    if (locate==19){
                        warningPanel.removeAll();
                        questionPanel.removeAll();
                        navigationPanel.remove(exitBtn);
                        navigationPanel.add(nextBtn,new GBC(1,1).setInsets(8,16,20,16));
                        modifyEach_leftPanel.setMark(Integer.parseInt(modifyEach_leftPanel.setMyMark.getText()));
                        subjectiveScore[locate]=Integer.parseInt(modifyEach_leftPanel.setMyMark.getText());
                        modifyEach_leftPanel = new ModifyEach_LeftPanel(answers[--locate]);
                        questionPanel.add(modifyEach_leftPanel);
                        questionPanel.repaint();
                        questionPanel.updateUI();
                        navigationPanel.repaint();
                        navigationPanel.updateUI();
                    }else {
                        questionPanel.removeAll();
                        locate=Integer.parseInt(changeColorButton.getText())-1;
                        modifyEach_leftPanel.setMark(Integer.parseInt(modifyEach_leftPanel.setMyMark.getText()));
                        modifyEach_leftPanel=new ModifyEach_LeftPanel(answers[locate]);
                        questionPanel.add(modifyEach_leftPanel);
                        questionPanel.repaint();
                        questionPanel.updateUI();
                    }
                }
            });
        }
        JScrollPane scrollPane=new JScrollPane();
        scrollPane.getViewport().add(buttonPanel);

        lastBtn=new BackgroundButton("上一个");
        nextBtn=new BackgroundButton("下一个");
        exitBtn=new BackgroundButton("提交并退出");

        navigationPanel.add(scrollPane,new GBC(0,0,2,1).setFill(GridBagConstraints.BOTH).setWeight(1,0.7).setInsets(8,4,4,4));
        navigationPanel.add(lastBtn,new GBC(0,1).setInsets(8,16,20,16));
        navigationPanel.add(nextBtn,new GBC(1,1).setInsets(8,16,20,16));
        navigationPanel.add(warningPanel,new GBC(0,2,2,1).setInsets(8,16,20,16).setAnchor(GridBagConstraints.CENTER));
        modifyEach_leftPanel=new ModifyEach_LeftPanel(answers[locate]);
        questionPanel.add(modifyEach_leftPanel);

        add(questionPanel,new GBC(0,0).setFill(GridBagConstraints.BOTH).setWeight(0.6,1).setAnchor(GridBagConstraints.WEST).setInsets(8,5,5,4));
        add(navigationPanel,new GBC(1,0).setFill(GridBagConstraints.BOTH).setWeight(0.4,1).setAnchor(GridBagConstraints.EAST).setInsets(8,5,5,4));
        lastBtn.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                if (locate==19){
                    warningPanel.removeAll();
                    questionPanel.removeAll();
                    navigationPanel.remove(exitBtn);
                    navigationPanel.add(nextBtn,new GBC(1,1).setInsets(8,16,20,16));
                    if (modifyEach_leftPanel.setMyMark.getText().equals("")){
                        modifyEach_leftPanel.setMark(0);
                        subjectiveScore[locate]=-1;
                    }else {
                        modifyEach_leftPanel.setMark(Integer.parseInt(modifyEach_leftPanel.setMyMark.getText()));
                        subjectiveScore[locate]=Integer.parseInt(modifyEach_leftPanel.setMyMark.getText());
                    }
                    modifyEach_leftPanel = new ModifyEach_LeftPanel(answers[--locate]);
                    questionPanel.add(modifyEach_leftPanel);
                    questionPanel.repaint();
                    questionPanel.updateUI();
                    navigationPanel.repaint();
                    navigationPanel.updateUI();
                } else if (locate>=1) {
                    warningPanel.removeAll();
                    questionPanel.removeAll();
                    if (modifyEach_leftPanel.setMyMark.getText().equals("")){
                        modifyEach_leftPanel.setMark(0);
                        subjectiveScore[locate]=-1;
                    }else {
                        modifyEach_leftPanel.setMark(Integer.parseInt(modifyEach_leftPanel.setMyMark.getText()));
                        subjectiveScore[locate]=Integer.parseInt(modifyEach_leftPanel.setMyMark.getText());
                    }
                    modifyEach_leftPanel = new ModifyEach_LeftPanel(answers[--locate]);
                    questionPanel.add(modifyEach_leftPanel);
                    questionPanel.repaint();
                    questionPanel.updateUI();
                    navigationPanel.repaint();
                    navigationPanel.updateUI();
                }else {
                    warningPanel.removeAll();
                    warningPanel.add(noLast);
                    warningPanel.updateUI();
                    navigationPanel.repaint();
                    navigationPanel.updateUI();
                }
            }
        });
        nextBtn.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                if (locate<answers.length-1) {
                    warningPanel.removeAll();
                    questionPanel.removeAll();
                    if (modifyEach_leftPanel.setMyMark.getText().equals("")){
                        modifyEach_leftPanel.setMark(0);
                        subjectiveScore[locate]=-1;
                    }else {
                        modifyEach_leftPanel.setMark(Integer.parseInt(modifyEach_leftPanel.setMyMark.getText()));
                        subjectiveScore[locate]=Integer.parseInt(modifyEach_leftPanel.setMyMark.getText());
                    }
                    modifyEach_leftPanel = new ModifyEach_LeftPanel(answers[++locate]);
                    questionPanel.add(modifyEach_leftPanel);
                    questionPanel.repaint();
                    questionPanel.updateUI();
                }else {
                    navigationPanel.remove(nextBtn);
                    navigationPanel.add(exitBtn,new GBC(1,1).setInsets(8,16,20,16));
                    warningPanel.removeAll();
                    warningPanel.add(noNext);
                    warningPanel.updateUI();
                }
                navigationPanel.repaint();
                navigationPanel.updateUI();
            }
        });
        exitBtn.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                try {
                    submitModifiedMarks=new SubmitModifiedMarks_C(id,studentID,subjectiveScore);
                    HomeFrame.content.removeAll();
                    HomeFrame.content.add(new ModifyAvailable());
                }catch (Exception ex){
                    ex.printStackTrace();
                    warningPanel.removeAll();
                    warningPanel.add(new MyTextArea_Warning(1,6,"警告","提交失败"));
                }
                HomeFrame.content.repaint();
                HomeFrame.content.updateUI();
            }
        });
    }
}
