package Teacher.View.CheckAllMarks;

import Teacher.Bean.Paper;
import Teacher.Function.ClientFuction.CheckMark.CheckAvailMarks_C;
import Teacher.Function.ClientFuction.Paper.GetAllPaper_C;
import Teacher.Server.Action.CheckMark.CheckAvailMarks_S;
import Teacher.Util.Component.MyPanel.NullPanel;
import Teacher.Util.Component.MyTextArea.MyTextArea_Warning;
import Teacher.Util.Layout.VFlowLayout;
import Teacher.Util.MyFont;
import Teacher.View.MyPapers.CheckPaperPanels.SelectPaperCard;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;

import java.util.Arrays;

import static Teacher.Util.MyFont.Font_16;

public class CheckAllMarkPanel extends JScrollPane {
    private Paper[] papers;
    private int i;
    private CheckPaperMarkCard checkPaperMarkCard;
    private CheckAvailMarks_C checkAvailMarks;

    public CheckAllMarkPanel(){
        JPanel panel=new JPanel(new VFlowLayout());
        JLabel title=new JLabel("成绩查看");
        title.setFont(MyFont.Font_20);
        title.setHorizontalAlignment(0);
        title.setFont(Font_16);

        //设边距
        Border border = title.getBorder();
        Border margin = new EmptyBorder(10,10,8,10);
        title.setBorder(new CompoundBorder(border, margin));
        panel.add(title);

        try{
            checkAvailMarks=new CheckAvailMarks_C();
            papers=checkAvailMarks.getAvailablePapers();
            if (papers!=null&&papers.length>0&& !Arrays.toString(papers).equals("[null]")){
                for (i=0; i< papers.length; i++){
                    checkPaperMarkCard=new CheckPaperMarkCard(papers[i].getId(),i+1,papers[i].getTitle(),papers[i].getTime(),papers[i].getOwner());
                    panel.add(checkPaperMarkCard);
                }
            }else {
                panel.add(new NullPanel());
                panel.repaint();
            }
        }catch (Exception e){
            e.printStackTrace();
            panel.add(new MyTextArea_Warning(1,10,"错误","加载失败"));
        }
        getViewport().add(panel);
    }
}
