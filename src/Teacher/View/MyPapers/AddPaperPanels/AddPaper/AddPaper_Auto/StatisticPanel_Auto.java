package Teacher.View.MyPapers.AddPaperPanels.AddPaper.AddPaper_Auto;

import Teacher.Bean.Paper;
import Teacher.Bean.Statistician_AutoAdd;
import Teacher.Function.ClientFuction.Paper.GetAutoPaper_C;
import Teacher.Util.AdapterAndHelper.GBC;
import Teacher.Util.Component.MyButton.BackgroundButton;
import Teacher.Util.Component.MyTextArea.MyTextArea_Normal;
import Teacher.Util.Component.MyTextArea.MyTextArea_Warning;
import Teacher.Util.MyFont;
import Teacher.View.HomePanels.HomeFrame;
import Teacher.View.MyPapers.AddPaperPanels.PaperPreview.PaperPreviewPanel;
import com.alibaba.fastjson.JSON;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;

public class StatisticPanel_Auto extends JPanel {
    public static  Container tipContainer=new Container();
    public StatisticPanel_Auto(Statistician_AutoAdd statistician){
        setLayout(new GridBagLayout());
        tipContainer.setLayout(new BorderLayout());
        JLabel titleLabel= new JLabel("已选"+statistician.getAllChoseNum()+"题");
        titleLabel.setFont(MyFont.Font_14);
        JLabel averageDifficulty_Label=new JLabel("该份试卷总体难度系数:"+statistician.getAverageDifficulty());
        averageDifficulty_Label.setFont(MyFont.Font_14);

        add(titleLabel,new GBC(0,0,2,1).setInsets(0,40,5,0).setAnchor(GridBagConstraints.CENTER).setFill(GridBagConstraints.HORIZONTAL).setWeightx(1));
        add(tipContainer,new GBC(1,0,2,2).setInsets(0,50,5,0));
        add(averageDifficulty_Label,new GBC(0,1,2,1).setInsets(0,40,5,0).setAnchor(GridBagConstraints.CENTER).setFill(GridBagConstraints.HORIZONTAL));



    }
}
