package Teacher.Util.Component.MyTextArea;

import Teacher.Util.Layout.VFlowLayout;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class MyTextArea_Colorful extends JPanel {
    int row=0,col=0;
    String title=" ";
    public  MyTextArea_Colorful(int row,int col,String title){
        this.row=row;
        this.col=col;
        this.title=title;
        setLayout(new VFlowLayout(true,true));

        JTextArea textArea=new JTextArea(row,col);
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
        GradientPaint gradientPaint = new GradientPaint(200f, 15f, Color.GREEN, 350, 15f, Color.RED, false);//建立渐变颜色
        Border border = BorderFactory.createDashedBorder(gradientPaint, 10f, 10);
        Border border1 = BorderFactory.createTitledBorder(border, title);
        setBorder(border1);
        add(textArea);
    }
}
