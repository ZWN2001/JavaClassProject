package Teacher.View.MyPapers.CheckPaperPanels;

import Teacher.Util.Layout.VFlowLayout;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;

import static Teacher.Util.MyFont.Font_16;

public class CheckAllPaperPanel extends JScrollPane {
    int id;
    String title;
    int mark;
    String owner;
    String ownerID;
    String time;
    public CheckAllPaperPanel(){
        JPanel panel=new JPanel(new VFlowLayout());
        JLabel title=new JLabel("  我的试卷库");
        title.setHorizontalAlignment(0);
        title.setFont(Font_16);

        //设边距
        Border border = title.getBorder();
        Border margin = new EmptyBorder(10,10,8,10);
        title.setBorder(new CompoundBorder(border, margin));
        panel.add(title);

//        for (int i=0;i<20;i++){
//            SelectPaperCard selectPaperCard=new SelectPaperCard();
//            panel.add(selectPaperCard);
//        }
        getViewport().add(panel);
    }
}
