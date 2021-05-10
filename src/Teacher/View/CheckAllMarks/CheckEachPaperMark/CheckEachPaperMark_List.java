package Teacher.View.CheckAllMarks.CheckEachPaperMark;

import Teacher.Bean.Paper;
import Teacher.Function.ClientFuction.Paper.GetAllPaper_C;
import Teacher.Test.PaperMark;
import Teacher.Util.Component.MyPanel.MarkCard;
import Teacher.Util.Component.MyPanel.NullPanel;
import Teacher.Util.Component.MyTextArea.MyTextArea_Warning;
import Teacher.Util.Layout.VFlowLayout;
import Teacher.View.CheckAllMarks.CheckPaperMarkCard;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;

import static Teacher.Util.MyFont.Font_16;

public class CheckEachPaperMark_List extends JScrollPane{
    private PaperMark[] paperMarks;
    private int i;
    private MarkCard markCard;

    public CheckEachPaperMark_List(int paperID) {
            JPanel panel=new JPanel(new VFlowLayout());

            try{
                paperMarks=PaperMark.getTestPaperMark();
                if (paperMarks!=null){
                    for (i=0; i< paperMarks.length; i++){
                     markCard=new MarkCard(i+1,paperMarks[i].getName(),paperMarks[i].getObj(),paperMarks[i].getSub());
                    panel.add(markCard);
                    }
                }else {
                    // panel.add(new MyTextArea_Warning(1,10,"提示","暂无试卷"));
                    panel.add(new NullPanel());
                }
            }catch (Exception e){
                e.printStackTrace();
                panel.add(new MyTextArea_Warning(1,10,"错误","加载失败"));
            }
            getViewport().add(panel);
        }

}
