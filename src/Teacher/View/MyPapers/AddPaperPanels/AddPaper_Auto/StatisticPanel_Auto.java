package Teacher.View.MyPapers.AddPaperPanels.AddPaper_Auto;

import Teacher.Bean.Statistician_AutoAdd;
import Teacher.Util.AdapterAndHelper.GBC;
import Teacher.Util.Component.MyButton.BackgroundButton;
import Teacher.Util.Component.MyTextArea.MyTextArea_Normal;
import Teacher.Util.MyFont;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class StatisticPanel_Auto extends JPanel {

    public StatisticPanel_Auto(Statistician_AutoAdd statistician){
        setLayout(new GridBagLayout());
        JLabel titleLabel= new JLabel("已选"+statistician.getAllChoseNum()+"题");
        titleLabel.setFont(MyFont.Font_14);
        JLabel averageDifficulty_Label=new JLabel("该份试卷总体难度系数:"+statistician.getAverageDifficulty());
        averageDifficulty_Label.setFont(MyFont.Font_14);

        JLabel paperNameLabel=new JLabel("试卷名称：");
        paperNameLabel.setFont(MyFont.Font_14);
        MyTextArea_Normal paperName=new MyTextArea_Normal(1,10);
        JLabel examTimeLabel=new JLabel("答题时间：");
        examTimeLabel.setFont(MyFont.Font_14);
        MyTextArea_Normal examTime=new MyTextArea_Normal(1,20);
        JLabel titleLabel4=new JLabel("分钟");
        titleLabel4.setFont(MyFont.Font_14);
        BackgroundButton submitBtn=new BackgroundButton(" 前往预览 ");

        add(titleLabel,new GBC(0,0,2,1).setInsets(0,40,10,0).setAnchor(GridBagConstraints.CENTER).setFill(GridBagConstraints.HORIZONTAL).setWeightx(1));
        add(averageDifficulty_Label,new GBC(0,1,2,1).setInsets(0,40,10,0).setAnchor(GridBagConstraints.CENTER).setFill(GridBagConstraints.HORIZONTAL).setWeightx(1));

        add(paperNameLabel,new GBC(0,2).setInsets(3,10,2,2));
        add(paperName,new GBC(1,2).setAnchor(GridBagConstraints.WEST).setFill(GridBagConstraints.HORIZONTAL).setInsets(0,0,10,0));
        add(examTimeLabel,new GBC(2,2).setInsets(3,18,2,20));
        add(examTime,new GBC(3,2).setAnchor(GridBagConstraints.WEST).setFill(GridBagConstraints.HORIZONTAL).setInsets(0,0,10,0));
        add(titleLabel4,new GBC(4,2).setInsets(3,8,2,20));
        add(submitBtn,new GBC(5,2).setInsets(3,28,2,20).setInsets(0,0,10,10));
        submitBtn.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);

            }
        });
    }
}
