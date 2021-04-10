package Teacher.Util.Component.MyPanel;

import Teacher.Util.Adapter.GBC;
import Teacher.Util.Component.MyButton.BackgroundButton;
import Teacher.Util.Layout.VFlowLayout;

import javax.swing.*;
import java.awt.*;

public class SelectPaperCard extends JPanel {
    Font titleFont=new Font("宋体",Font.PLAIN,24);
    Font subTitleFont =new Font("宋体",Font.PLAIN,12);

    public SelectPaperCard(){
        setBackground(Color.WHITE);
        setLayout(new GridBagLayout());
        setPreferredSize(new Dimension(900,60));
        JLabel ID=new JLabel("ID");
        ID.setFont(subTitleFont);
        JLabel title=new JLabel("title");
        title.setFont(titleFont);
        JLabel subTitle=new JLabel("createTime");
        subTitle.setFont(subTitleFont);
        BackgroundButton enterBtn=new BackgroundButton("enter");

        add(ID,new GBC(0,0).setInsets(0,20,0,0));
        add(title,new GBC(1,0).setInsets(0,20,0,0));
        add(subTitle,new GBC(2,0).setInsets(0,20,0,0));
        add(enterBtn,new GBC(3,0).setInsets(0,600,0,0));


    }

}
