package Teacher.View.MyModification;

import Teacher.Bean.Paper;
import Teacher.Function.ClientFuction.Modify.GetAvailableModifyPaperID_C;
import Teacher.Function.ClientFuction.Paper.GetAPaper_C;
import Teacher.Function.ClientFuction.Paper.GetAllPaper_C;
import Teacher.Util.Component.MyPanel.NullPanel;
import Teacher.Util.Component.MyTextArea.MyTextArea_Warning;
import Teacher.Util.Layout.VFlowLayout;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;

import static Teacher.Util.MyFont.Font_20;


public class ModifyAvailable extends JScrollPane {
    private Paper[] papers;
    private int i;
    private SelectPaperToModify_Card card;
    private int[] ID;
    GetAvailableModifyPaperID_C getAvailableModifyPaperID;
    GetAPaper_C getAPaper;

    public ModifyAvailable(){
        JPanel panel=new JPanel(new VFlowLayout());
        JLabel title=new JLabel("待批改的试题");
        title.setHorizontalAlignment(0);
        title.setFont(Font_20);

        //设边距
        Border border = title.getBorder();
        Border margin = new EmptyBorder(10,10,8,10);
        title.setBorder(new CompoundBorder(border, margin));
        panel.add(title);

        //获取数据
        try {
            getAvailableModifyPaperID = new GetAvailableModifyPaperID_C();
            ID=getAvailableModifyPaperID.getModifyID();
        }catch (Exception e){
            e.printStackTrace();
        }
        papers=new Paper[ID.length];
        for (i=0;i<ID.length;i++){
            try {
                getAPaper=new GetAPaper_C(ID[i]);
                papers[i]=getAPaper.getPaper();
            }catch (Exception e){
                e.printStackTrace();
            }
        }

        try{
            if (papers!=null&&papers.length>0){
                for (i=0; i< papers.length; i++){
                    card=new SelectPaperToModify_Card(papers[i].getId(),i+1,papers[i].getTitle(),papers[i].getTime(),papers[i].getOwner());
                    panel.add(card);
                }
            }else {
                panel.add(new NullPanel());
            }
        }catch (Exception e){
            e.printStackTrace();
            panel.add(new MyTextArea_Warning(1,10,"错误","加载失败"));
        }
        getViewport().add(panel);
    }
}
