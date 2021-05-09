package Teacher.View.MyPapers.AddPaperPanels.PaperPreview;

import Teacher.Util.AdapterAndHelper.GBC;
import Teacher.Util.MyFont;

import javax.swing.*;
import java.awt.*;

public class PaperPreview_Title extends JPanel {
    public PaperPreview_Title(String paperName,int mark,int examTime,double difficulty){
        setLayout(new GridBagLayout());
        JLabel paperNameLabel=new JLabel(paperName);
        paperNameLabel.setFont(MyFont.Font_24);
        JLabel markLabel=new JLabel("试卷总分："+mark+"分");
        markLabel.setFont(MyFont.Font_16);
        JLabel examTimeLabel=new JLabel("考试时长："+examTime+"分钟");
        examTimeLabel.setFont(MyFont.Font_16);
        JLabel difficultyLabel=new JLabel("试卷难度："+difficulty);
        difficultyLabel.setFont(MyFont.Font_16);

        add(paperNameLabel,new GBC(0,0,3,1).setAnchor(GridBagConstraints.CENTER).setInsets(10,0,10,0));
        add(markLabel,new GBC(0,1,1,1).setInsets(0,0,0,40));
        add(examTimeLabel,new GBC(1,1,1,1).setInsets(0,40,0,40));
        add(difficultyLabel,new GBC(2,1,1,1).setInsets(0,40,0,0));
    }
}
