package Teacher.View.MyPapers.CheckPaperPanels;

import Teacher.Bean.Paper;
import Teacher.Function.ClientFuction.Paper.GetAPaper_C;
import Teacher.Function.ClientFuction.Paper.GetAllPaper_C;
import Teacher.Util.Component.MyTextArea.MyTextArea_Warning;
import Teacher.Util.Layout.VFlowLayout;
import Teacher.View.HomePanels.Home;
import Teacher.View.HomePanels.HomeFrame;
import Teacher.View.MyPapers.AddPaperPanels.PaperPreview.PaperPreviewPanel;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.util.Objects;

import static Teacher.Util.MyFont.Font_16;
import static Teacher.Util.MyFont.Font_20;

public class CheckAllPaperPanel extends JScrollPane {
    private Paper[] papers;
    private int i;
    private SelectPaperCard selectPaperCard;

    public CheckAllPaperPanel(){
        JPanel panel=new JPanel(new VFlowLayout());
        JLabel title=new JLabel("我的试卷库");
        title.setHorizontalAlignment(0);
        title.setFont(Font_20);

        //设边距
        Border border = title.getBorder();
        Border margin = new EmptyBorder(10,10,8,10);
        title.setBorder(new CompoundBorder(border, margin));
        panel.add(title);

        try{
            GetAllPaper_C getPaper=new GetAllPaper_C(Home.teacher.getAccount());
            papers=getPaper.getPapers();
            if (papers!=null){
                for (i=0; i< papers.length; i++){
                    selectPaperCard=new SelectPaperCard(papers[i].getId(),i+1,papers[i].getTitle(),papers[i].getMark(),papers[i].getTime(),papers[i].getOwner(),papers[i].getOwnerID());
                   panel.add(selectPaperCard);

                }
            }else {
                panel.add(new MyTextArea_Warning(1,10,"提示","暂无试卷"));
            }
        }catch (Exception e){
            e.printStackTrace();
            panel.add(new MyTextArea_Warning(1,10,"错误","加载失败"));
        }
        getViewport().add(panel);
    }
}
