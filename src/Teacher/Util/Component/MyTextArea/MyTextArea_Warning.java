package Teacher.Util.Component.MyTextArea;

import Teacher.Util.Layout.VFlowLayout;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
import java.awt.*;

public class MyTextArea_Warning extends JPanel{
    int row=0,col=0;
    String title=" ";
    String warningText=" ";
    JTextArea textArea;
    public  MyTextArea_Warning(int row,int col,String title,String warningText){
        this.row=row;
        this.col=col;
        this.title=title;
        this.warningText=warningText;
        Border border1 = BorderFactory.createDashedBorder(Color.RED, 15f, 10);
        Border border = BorderFactory.createTitledBorder(border1,title);
        init(border,warningText);
    }

    public void init(Border border,String warningText){
        this.warningText=warningText;
        setLayout(new VFlowLayout(true,true));
        ((TitledBorder) border).setTitleColor(Color.RED);
        setBorder(border);
        textArea = new JTextArea(row ,col);
        textArea.setText(warningText);
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
        textArea.setEnabled(false);
        add(textArea);
    }
}
