package Teacher.View.MyPapers.AddPaperPanels.AddPaper_Self;

import Teacher.Bean.Statistician;
import Teacher.Util.AdapterAndHelper.GBC;
import Teacher.Util.Component.MyTextArea.MyTextArea_Normal;
import Teacher.Util.MyFont;

import javax.swing.*;
import java.awt.*;

import static Teacher.Util.AdapterAndHelper.MultiAnswerUtil.getAnswerFromString;


public class StatisticianPanel extends JPanel {
    public StatisticianPanel(Statistician statistician){
        setLayout(new GridBagLayout());
        setPreferredSize(new Dimension(800,100));
        JLabel titleLabel1=new JLabel("试卷名称：");
        titleLabel1.setFont(MyFont.Font_14);
        MyTextArea_Normal paperName=new MyTextArea_Normal(1,30);
        JLabel titleLabel=new JLabel("答题时间：");
        JLabel titleLabel2= new JLabel("已选"+statistician.getChoseNum()+"题，共计"+statistician.getAllMark()+"分，其中:");
        titleLabel2.setFont(MyFont.Font_14);
        JLabel choiceSituation=new JLabel("选择题:"+(statistician.getMyChoice().isEmpty()?"无":getAnswerFromString(statistician.getMyChoice().toString())));
        choiceSituation.setFont(MyFont.Font_14);
        JLabel judgeSituation=new JLabel("判断题:"+(statistician.getMyJudge().isEmpty()?"无":getAnswerFromString(statistician.getMyJudge().toString())));
        judgeSituation.setFont(MyFont.Font_14);
        JLabel multiChoiceSituation=new JLabel("多选题:"+(statistician.getMyMultiChoice().isEmpty()?"无":getAnswerFromString(statistician.getMyMultiChoice().toString())));
        multiChoiceSituation.setFont(MyFont.Font_14);
        JLabel subjectiveSituation=new JLabel("主观题:"+(statistician.getMySubjective().isEmpty()?"无":getAnswerFromString(statistician.getMySubjective().toString())));
        subjectiveSituation.setFont(MyFont.Font_14);
        add(titleLabel1,new GBC(0,0).setAnchor(GridBagConstraints.WEST).setInsets(3,10,2,2));
        add(paperName,new GBC(1,0,2,1).setAnchor(GridBagConstraints.WEST));
        add(titleLabel2,new GBC(2,0,1,1).setAnchor(GridBagConstraints.WEST).setInsets(3,8,2,2));
        add(choiceSituation,new GBC(0,1,2,1).setAnchor(GridBagConstraints.WEST).setInsets(3,10,2,2).setWeightx(1));
        add(judgeSituation,new GBC(0,2,2,1).setAnchor(GridBagConstraints.WEST).setInsets(3,10,2,2).setWeightx(1));
        add(multiChoiceSituation,new GBC(0,3,2,1).setAnchor(GridBagConstraints.WEST).setInsets(3,10,2,2).setWeightx(1));
        add(subjectiveSituation,new GBC(0,4,2,1).setAnchor(GridBagConstraints.WEST).setInsets(3,10,2,2).setWeightx(1));
    }
}
