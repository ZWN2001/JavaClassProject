package Teacher.Util.Component.MyTextArea;

import Teacher.Util.Layout.VFlowLayout;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
import java.awt.*;

public class MyTextArea_Normal extends JPanel {
    int row=0,col=0;
    String title=" ";
    String initText=" ";
    JTextArea textArea;
    public  MyTextArea_Normal(int row,int col){
        this.row=row;
        this.col=col;
        Border border = BorderFactory.createTitledBorder("");
        init(border);
    }
    public  MyTextArea_Normal(int row,int col,String title){
        this.row=row;
        this.col=col;
        this.title=title;
        Border border = BorderFactory.createTitledBorder(title);
     init(border);
    }

    public  MyTextArea_Normal(String initText,int row,int col){
        this.initText=initText;
        this.row=row;
        this.col=col;

        Border border = BorderFactory.createTitledBorder("");
        init1(border,initText);
    }
    public  MyTextArea_Normal(int row,int col,String title,String initText){
        this.row=row;
        this.col=col;
        this.title=title;
        this.initText=initText;
        Border border = BorderFactory.createTitledBorder(title);
        init1(border,initText);
    }

    public void init(Border border){
        setLayout(new VFlowLayout(true,true));
        ((TitledBorder) border).setTitleColor(Color.BLACK);
        setBorder(border);
        textArea = new JTextArea(row ,col);
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
        add(textArea);
    }
    public void init1(Border border,String initText){
        this.initText=initText;
        setLayout(new VFlowLayout(true,true));
        ((TitledBorder) border).setTitleColor(Color.BLACK);
        setBorder(border);
        JTextArea textArea = new JTextArea(row ,col);
        textArea.setText(initText);
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
        add(textArea);
    }
    public String getText(){
        return textArea.getText();
    }
}
