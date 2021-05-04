package Teacher.View.MyPapers.AddPaperPanels.AddPaper_Self;

import Teacher.Bean.Statistician_SelfAdd;
import Teacher.Util.AdapterAndHelper.GBC;
import Teacher.Util.Component.MyButton.BackgroundButton;
import Teacher.Util.Component.MyTextArea.MyTextArea_Normal;
import Teacher.Util.MyFont;
import Teacher.View.HomePanels.HomeFrame;
import Teacher.View.MyPapers.AddPaperPanels.PaperPreview.PaperPreviewPanel;
import com.alibaba.fastjson.JSON;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Arrays;

import static Teacher.Util.AdapterAndHelper.MultiAnswerUtil.getChoseQuestionFromString;


public class StatisticianPanel_Self extends JPanel {
    public StatisticianPanel_Self(Statistician_SelfAdd statistician){
        setLayout(new GridBagLayout());
        JLabel titleLabel2= new JLabel("已选"+statistician.getChoseNum()+"题，共计"+statistician.getAllMark()+"分，平均难度为"+statistician.getDifficulty()+"其中:");
        titleLabel2.setFont(MyFont.Font_14);
        JLabel choiceSituation=new JLabel("选择题:"+(statistician.getMyChoice().isEmpty()?"无":getChoseQuestionFromString(statistician.getMyChoice().toString())));
        choiceSituation.setFont(MyFont.Font_14);
        JLabel judgeSituation=new JLabel("判断题:"+(statistician.getMyJudge().isEmpty()?"无":getChoseQuestionFromString(statistician.getMyJudge().toString())));
        judgeSituation.setFont(MyFont.Font_14);
        JLabel multiChoiceSituation=new JLabel("多选题:"+(statistician.getMyMultiChoice().isEmpty()?"无":getChoseQuestionFromString(statistician.getMyMultiChoice().toString())));
        multiChoiceSituation.setFont(MyFont.Font_14);
        JLabel subjectiveSituation=new JLabel("主观题:"+(statistician.getMySubjective().isEmpty()?"无":getChoseQuestionFromString(statistician.getMySubjective().toString())));
        subjectiveSituation.setFont(MyFont.Font_14);

        JLabel paperNameLabel=new JLabel("试卷名称：");
        paperNameLabel.setFont(MyFont.Font_14);
        MyTextArea_Normal paperName=new MyTextArea_Normal(1,10);
        JLabel examTimeLabel=new JLabel("答题时间：");
        examTimeLabel.setFont(MyFont.Font_14);
        MyTextArea_Normal examTime=new MyTextArea_Normal(1,20,"","",true);
        JLabel titleLabel4=new JLabel("分钟");
        titleLabel4.setFont(MyFont.Font_14);
        BackgroundButton submitBtn=new BackgroundButton(" 前往预览 ");

        add(titleLabel2,new GBC(0,0,2,1).setInsets(3,8,2,40).setAnchor(GridBagConstraints.WEST));
        add(choiceSituation,new GBC(0,1,2,1).setAnchor(GridBagConstraints.WEST).setInsets(3,10,2,2).setWeightx(1));
        add(judgeSituation,new GBC(0,3,2,1).setAnchor(GridBagConstraints.WEST).setInsets(3,10,2,2).setWeightx(1));
        add(multiChoiceSituation,new GBC(0,2,2,1).setAnchor(GridBagConstraints.WEST).setInsets(3,10,2,2).setWeightx(1));
        add(subjectiveSituation,new GBC(0,4,2,1).setAnchor(GridBagConstraints.WEST).setInsets(3,10,2,2).setWeightx(1));

        add(paperNameLabel,new GBC(0,5).setInsets(3,10,2,2));
        add(paperName,new GBC(1,5).setAnchor(GridBagConstraints.WEST).setFill(GridBagConstraints.HORIZONTAL).setInsets(0,0,10,0));
        add(examTimeLabel,new GBC(2,5).setInsets(3,18,2,20));
        add(examTime,new GBC(3,5).setAnchor(GridBagConstraints.WEST).setFill(GridBagConstraints.HORIZONTAL).setInsets(0,0,10,0));
        add(titleLabel4,new GBC(4,5).setInsets(3,8,2,20));
        add(submitBtn,new GBC(5,5).setInsets(3,28,2,20).setInsets(0,0,10,10));
    submitBtn.addMouseListener(new MouseAdapter() {
        @Override
        public void mouseClicked(MouseEvent e) {
            super.mouseClicked(e);//这里使用弹压栈策略
            String []questionString=new String[4];
            questionString[0]= JSON.toJSONString(statistician.getMyChoiceIDList());
            questionString[1]=JSON.toJSONString(statistician.getMyMultiChoiceIDList());
            questionString[2]=JSON.toJSONString(statistician.getMyJudgeIDList());
            questionString[3]=JSON.toJSONString(statistician.getMySubjectiveIDList());
            HomeFrame.content.add(new PaperPreviewPanel(paperName.getText(),statistician.getAllMark(),Integer.parseInt(examTime.getText()),statistician.getDifficulty(), JSON.toJSONString(questionString)));
        }
    });
    }
}
