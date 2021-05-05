package Teacher.View.MyPapers.CheckPaperPanels;

import Teacher.Bean.Paper;
import Teacher.Function.ClientFuction.Paper.GetAllPaper_C;
import Teacher.Util.Component.MyTextArea.MyTextArea_Warning;
import Teacher.Util.Layout.VFlowLayout;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;

import static Teacher.Util.MyFont.Font_16;

public class CheckAllPaperPanel extends JScrollPane {
    Paper[] paper;
    int i;
    SelectPaperCard selectPaperCard;
    public CheckAllPaperPanel(){
        JPanel panel=new JPanel(new VFlowLayout());
        JLabel title=new JLabel("我的试卷库");
        title.setHorizontalAlignment(0);
        title.setFont(Font_16);

        //设边距
        Border border = title.getBorder();
        Border margin = new EmptyBorder(10,10,8,10);
        title.setBorder(new CompoundBorder(border, margin));
        panel.add(title);

        try{
            GetAllPaper_C getPaper=new GetAllPaper_C();
            paper=getPaper.getPapers();
            if (paper.length>0){
                for (i=0;i<paper.length;i++){
                    selectPaperCard=new SelectPaperCard(paper[i].getId(),i+1,paper[i].getTitle(),paper[i].getMark(),paper[i].getTime(),paper[i].getOwner(),paper[i].getOwnerID());
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
