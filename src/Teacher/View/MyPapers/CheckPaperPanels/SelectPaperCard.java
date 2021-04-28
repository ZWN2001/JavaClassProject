package Teacher.View.MyPapers.CheckPaperPanels;

import Teacher.Util.AdapterAndHelper.GBC;
import Teacher.Util.Component.MyButton.BackgroundButton;

import javax.swing.*;
import java.awt.*;

import static Teacher.Util.MyFont.*;

public class SelectPaperCard extends JPanel {
    int id;
    String title;
    int mark;
    String owner;
    String ownerID;
    String time;
    public SelectPaperCard(int id,String title,int mark,String time,String owner,String ownerID){
        this.id=id;
        this.title=title;
        this.mark=mark;
        this.time=time;
        this.owner=owner;
        this.ownerID=ownerID;
        setBackground(Color.WHITE);
        setLayout(new GridBagLayout());
        setPreferredSize(new Dimension(900,60));
        JLabel ID=new JLabel("ID:"+id);
        ID.setFont(Font_14);
        JLabel titleLabel=new JLabel(title);
        titleLabel.setFont(Font_16);
        JLabel subTitle=new JLabel("由"+owner+"老师创建于"+time);
        subTitle.setFont(Font_14);
        BackgroundButton enterBtn=new BackgroundButton("enter");

        add(ID,new GBC(0,0).setInsets(0,10,0,0));
        add(titleLabel,new GBC(1,0).setInsets(0,20,0,0));
        add(subTitle,new GBC(2,0).setInsets(0,20,0,0));
        add(enterBtn,new GBC(3,0).setInsets(0,600,0,0));


    }

}
