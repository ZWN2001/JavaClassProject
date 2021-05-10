package Teacher.View.MyPapers.AddPaperPanels.AddPaper.AddPaper_Self;

import Teacher.Bean.Statistician_SelfAdd;
import Teacher.Util.AdapterAndHelper.GBC;
import Teacher.Util.Component.MyButton.BackgroundButton;
import Teacher.Util.Component.MyTextArea.MyTextArea_Normal;
import Teacher.Util.Component.MyTextArea.MyTextArea_Warning;
import Teacher.Util.MyFont;
import Teacher.View.HomePanels.Home;
import Teacher.View.HomePanels.HomeFrame;
import Teacher.View.MyPapers.AddPaperPanels.PaperPreview.PaperPreviewPanel;
import com.alibaba.fastjson.JSON;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import static Teacher.Util.AdapterAndHelper.MultiAnswerUtil.getChoseQuestionFromString;


public class StatisticianPanel_Self extends JPanel {
    String paperName1,examTime1;
    public static Container tipContainer=new Container();
    Statistician_SelfAdd statistician;
    public StatisticianPanel_Self(Statistician_SelfAdd statistician){
        this.statistician=statistician;
        setLayout(new GridBagLayout());
        tipContainer.setLayout(new BorderLayout());

        JLabel titleLabel2= new JLabel("已选"+statistician.getChoseNum()+"题，共计"+statistician.getAllMark()+"分，平均难度为"+statistician.getDifficulty()+",其中:");
        titleLabel2.setFont(MyFont.Font_14);
        JLabel choiceSituation=new JLabel("选择题:"+(statistician.getMyChoice().isEmpty()?"无":getChoseQuestionFromString(statistician.getMyChoice().toString())));
        choiceSituation.setFont(MyFont.Font_14);
        JLabel judgeSituation=new JLabel("判断题:"+(statistician.getMyJudge().isEmpty()?"无":getChoseQuestionFromString(statistician.getMyJudge().toString())));
        judgeSituation.setFont(MyFont.Font_14);
        JLabel multiChoiceSituation=new JLabel("多选题:"+(statistician.getMyMultiChoice().isEmpty()?"无":getChoseQuestionFromString(statistician.getMyMultiChoice().toString())));
        multiChoiceSituation.setFont(MyFont.Font_14);
        JLabel subjectiveSituation=new JLabel("主观题:"+(statistician.getMySubjective().isEmpty()?"无":getChoseQuestionFromString(statistician.getMySubjective().toString())));
        subjectiveSituation.setFont(MyFont.Font_14);

        paperName1=statistician.getPaperName();
        examTime1=statistician.getExamTime();
        JLabel paperNameLabel=new JLabel("试卷名称：");
        paperNameLabel.setFont(MyFont.Font_14);
        MyTextArea_Normal paperName=new MyTextArea_Normal(1,10,"",paperName1,false);
        JLabel examTimeLabel=new JLabel("答题时间：");
        examTimeLabel.setFont(MyFont.Font_14);
        MyTextArea_Normal examTime=new MyTextArea_Normal(1,20,"",examTime1,true);
        JLabel titleLabel4=new JLabel("分钟");
        titleLabel4.setFont(MyFont.Font_14);
        BackgroundButton submitBtn=new BackgroundButton(" 前往预览 ");
//
        add(titleLabel2,new GBC(0,0,2,1).setInsets(10,8,10,20).setAnchor(GridBagConstraints.WEST));
        add(tipContainer,new GBC(6,5,1,1).setAnchor(GridBagConstraints.EAST));
        add(choiceSituation,new GBC(0,1,2,1).setAnchor(GridBagConstraints.WEST).setInsets(3,10,2,2).setWeightx(1));
        add(judgeSituation,new GBC(0,3,2,1).setAnchor(GridBagConstraints.WEST).setInsets(3,10,2,2).setWeightx(1));
        add(multiChoiceSituation,new GBC(0,2,2,1).setAnchor(GridBagConstraints.WEST).setInsets(3,10,2,2).setWeightx(1));
        add(subjectiveSituation,new GBC(0,4,2,1).setAnchor(GridBagConstraints.WEST).setInsets(3,10,2,2).setWeightx(1));

        add(paperNameLabel,new GBC(0,5).setInsets(3,10,2,2));
        add(paperName,new GBC(1,5).setAnchor(GridBagConstraints.WEST).setFill(GridBagConstraints.HORIZONTAL).setInsets(0,0,10,0));
        add(examTimeLabel,new GBC(2,5).setInsets(3,18,2,20));
        add(examTime,new GBC(3,5).setAnchor(GridBagConstraints.WEST).setFill(GridBagConstraints.HORIZONTAL).setInsets(0,0,10,0));
        add(titleLabel4,new GBC(4,5).setInsets(3,8,2,20));
        add(submitBtn,new GBC(5,5).setInsets(3,28,2,20));

        paperName.textArea.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                super.keyPressed(e);
                statistician.setPaperName(paperName.textArea.getText());
            }
        });
        examTime.textArea.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                super.keyPressed(e);
                statistician.setExamTime(examTime.textArea.getText());
            }
        });

    submitBtn.addMouseListener(new MouseAdapter() {
        @Override
        public void mouseClicked(MouseEvent e) {
            super.mouseClicked(e);//这里使用弹压栈策略
            if (!paperName.getText().equals("") && !examTime.getText().equals("") &&Integer.parseInt(examTime.getText())>0) {
                tipContainer.removeAll();
                String[] questionString = new String[4];
                questionString[0] = JSON.toJSONString(statistician.getMyChoiceIDList());
                questionString[1] = JSON.toJSONString(statistician.getMyMultiChoiceIDList());
                questionString[2] = JSON.toJSONString(statistician.getMyJudgeIDList());
                questionString[3] = JSON.toJSONString(statistician.getMySubjectiveIDList());
                HomeFrame.content.add(new PaperPreviewPanel(paperName.getText(),Integer.parseInt(examTime.getText()),  JSON.toJSONString(questionString),true), 0);
                HomeFrame.content.repaint();
                HomeFrame.content.updateUI();
            }else {
                MyTextArea_Warning warning=new MyTextArea_Warning(1,6,"错误","信息不合法");
                warning.textArea.setEnabled(false);
                tipContainer.removeAll();
                tipContainer.add(warning);
                AddPaperSelfPanel.statisticianPanel.repaint();
                AddPaperSelfPanel.statisticianPanel.updateUI();
                repaint();
                updateUI();
            }
        }
    });
    }
}
