package Teacher.View.CheckAllMarks;

import Teacher.Util.AdapterAndHelper.GBC;
import Teacher.Util.Component.MyButton.BackgroundButton;
import Teacher.View.CheckAllMarks.CheckEachPaperMark.CheckEachPaperMark;
import Teacher.View.HomePanels.HomeFrame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import static Teacher.Util.MyFont.Font_14;
import static Teacher.Util.MyFont.Font_20;

public class CheckPaperMarkCard extends JPanel {
    private final int id;

    BackgroundButton enterBtn;
    public CheckPaperMarkCard(int id,int cid,String title,String time,String owner){
        this.id=id;
        setBackground(Color.WHITE);
        setLayout(new GridBagLayout());
        JLabel cid_Label=new JLabel("No."+cid);
        JLabel ID=new JLabel("ID:"+id);
        ID.setFont(Font_14);
        JLabel titleLabel=new JLabel(title);
        titleLabel.setFont(Font_20);
        JLabel subTitle=new JLabel("由"+owner+"老师创建于"+time);
        subTitle.setFont(Font_14);
        enterBtn=new BackgroundButton(" 前往查看分数 ");

        add(cid_Label,new GBC(0,0).setInsets(0,10,0,0).setAnchor(GridBagConstraints.WEST));
        add(ID,new GBC(1,0).setInsets(0,10,0,0));
        add(titleLabel,new GBC(2,0).setInsets(0,20,0,0).setWeightx(1));
        add(subTitle,new GBC(3,0).setInsets(0,20,0,20));
        add(enterBtn,new GBC(4,0).setInsets(5,0,5,20).setAnchor(GridBagConstraints.EAST));
        enterBtn.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
            CheckEachPaperMark checkEachPaperMark=new CheckEachPaperMark(id);
            HomeFrame.content.removeAll();
            HomeFrame.content.add(checkEachPaperMark,0);
                HomeFrame.content.repaint();
                HomeFrame.content.updateUI();
            }
        });
    }

    public int getId() {
        return id;
    }
}
