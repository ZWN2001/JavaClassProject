package Teacher.View.MyPapers;

import Teacher.Util.Component.MyPanel.SelectPaperCard;
import Teacher.Util.Layout.VFlowLayout;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class CheckMyPaperPanel extends JScrollPane {
    Font titleFont=new Font("宋体",Font.PLAIN,26);
    public CheckMyPaperPanel(){
        JPanel panel=new JPanel();
        panel.setLayout(new VFlowLayout());

        JLabel title=new JLabel("  我的试卷");
        title.setHorizontalAlignment(0);
        title.setFont(titleFont);
        Border border = title.getBorder();
        Border margin = new EmptyBorder(10,10,8,10);
        title.setBorder(new CompoundBorder(border, margin));
        panel.add(title);

        for (int i=0;i<20;i++){
            panel.add(new SelectPaperCard());
        }
        getViewport().add(panel);
    }
}
