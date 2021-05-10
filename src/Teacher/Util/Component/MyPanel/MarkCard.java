package Teacher.Util.Component.MyPanel;

import Teacher.Util.AdapterAndHelper.GBC;
import Teacher.Util.MyColor;
import Teacher.Util.MyFont;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class MarkCard extends JPanel {
    Border border = BorderFactory.createTitledBorder("");
    Border margin = new EmptyBorder(5,10,5,10);//边距设置
    public MarkCard(int rank,String studentName,int objectiveMark,int subjectiveMark) {
        setLayout(new GridBagLayout());
        setBackground(MyColor.AMBER_50);
        JLabel rankLabel=new JLabel("排名："+rank);
        rankLabel.setFont(MyFont.Font_20);
       JLabel nameLabel=new JLabel(" 姓名："+studentName);
       nameLabel.setFont(MyFont.Font_20);
       JButton detailBtn=new JButton(" 详细信息 ");
       detailBtn.setFont(MyFont.Font_16);
       JLabel objMarkLabel=new JLabel("客观题得分："+objectiveMark);
       objMarkLabel.setBorder(new CompoundBorder(border, margin));
       objMarkLabel.setFont(MyFont.Font_16);
       JLabel subMarkLabel=new JLabel("主观题得分："+subjectiveMark);
       subMarkLabel.setBorder(new CompoundBorder(border, margin));
       subMarkLabel.setFont(MyFont.Font_16);
       JLabel allMarkLabel=new JLabel("总得分："+(objectiveMark+subjectiveMark));
       allMarkLabel.setBorder(new CompoundBorder(border, margin));
       allMarkLabel.setFont(MyFont.Font_16);

       add(rankLabel,new GBC(0,0).setInsets(4,18,4,4).setAnchor(GridBagConstraints.WEST));
       add(nameLabel,new GBC(1,0).setInsets(4,8,4,8));
       add(detailBtn,new GBC(2,0).setInsets(4,8,4,8).setFill(GridBagConstraints.HORIZONTAL));
       add(objMarkLabel,new GBC(0,1).setInsets(8,12,8,4).setWeightx(1));
       add(subMarkLabel,new GBC(1,1).setInsets(8,8,8,4).setWeightx(1));
       add(allMarkLabel,new GBC(2,1).setInsets(8,8,8,12).setWeightx(1));

    }
}
