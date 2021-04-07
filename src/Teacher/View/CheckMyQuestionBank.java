package Teacher.View;

import Teacher.Util.Adapter.GBC;
import Teacher.Util.Component.MyPanel.QuestionCardPanel;

import javax.swing.*;
import java.awt.*;

public class CheckMyQuestionBank extends JScrollPane {
    Font titleFont=new Font("宋体",Font.PLAIN,26);
    public CheckMyQuestionBank(){
//        JScrollBar jScrollBar = getVerticalScrollBar();//获得垂直滚动条
////        jScrollBar.setValue(0);//设置垂直滚动条位置
//        System.out.println(jScrollBar.getValue());
        JPanel panel=new JPanel(new GridBagLayout());
        JLabel title=new JLabel("我的题库");
        title.setFont(titleFont);
        panel.add(title,new GBC(0,0).setAnchor(GridBagConstraints.CENTER).setInsets(10,0,0,0));
        for (int i=0;i<20;i++){
            QuestionCardPanel panel1=new QuestionCardPanel();
        panel.add(panel1,new GBC(0,i+1).setInsets(10));
        }
        getViewport().add(panel);
    }

}
