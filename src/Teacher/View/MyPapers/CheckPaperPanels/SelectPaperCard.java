package Teacher.View.MyPapers.CheckPaperPanels;

import Teacher.Bean.Paper;
import Teacher.Function.ClientFuction.Paper.GetAPaper_C;
import Teacher.Util.AdapterAndHelper.GBC;
import Teacher.Util.Component.MyButton.BackgroundButton;
import Teacher.View.HomePanels.HomeFrame;
import Teacher.View.MyPapers.AddPaperPanels.PaperPreview.PaperPreviewPanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;

import static Teacher.Util.MyFont.*;

public class SelectPaperCard extends JPanel {
    private final int id;
    private GetAPaper_C getAPaper;
    private Paper paper;
    BackgroundButton enterBtn;
    public SelectPaperCard(int id,int cid,String title,int mark,String time,String owner,int ownerID){
        this.id=id;
        setBackground(Color.WHITE);
        setLayout(new GridBagLayout());
//        setPreferredSize(new Dimension(900,60));
        JLabel cid_Label=new JLabel("No."+cid);
        JLabel ID=new JLabel("ID:"+id);
        ID.setFont(Font_14);
        JLabel titleLabel=new JLabel(title);
        titleLabel.setFont(Font_20);
        JLabel subTitle=new JLabel("由"+owner+"老师创建于"+time);
        subTitle.setFont(Font_14);
         enterBtn=new BackgroundButton("前往查看");

        add(cid_Label,new GBC(0,0).setInsets(0,10,0,0).setAnchor(GridBagConstraints.WEST));
        add(ID,new GBC(1,0).setInsets(0,10,0,0));
        add(titleLabel,new GBC(2,0).setInsets(0,20,0,0).setWeightx(1));
        add(subTitle,new GBC(3,0).setInsets(0,20,0,20));
        add(enterBtn,new GBC(4,0).setInsets(5,0,5,20).setAnchor(GridBagConstraints.EAST));
        enterBtn.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                try {
                    getAPaper=new GetAPaper_C(getId());
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
                paper=getAPaper.getPaper();
                System.out.println(paper.getId());
                PaperPreviewPanel paperPreviewPanel=new PaperPreviewPanel(paper.getTitle(),paper.getMark(),paper.getExamTime(),paper.getDifficulty(),paper.getQuestions(),false);
                HomeFrame.content.add(paperPreviewPanel,0);
                HomeFrame.content.repaint();
                HomeFrame.content.updateUI();
            }
        });
    }

    public int getId() {
        return id;
    }
}
