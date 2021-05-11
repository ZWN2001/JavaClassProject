package Teacher.Util.Component.MyTextArea;

import Teacher.Util.Layout.VFlowLayout;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class MyTextArea_Colorful extends JPanel {
    private JTextArea textArea;
    private int row=0,col=0;
    private String title=" ";
    public  MyTextArea_Colorful(int row,int col,String title){
        this.row=row;
        this.col=col;
        this.title=title;
    init(row, col, title);
    }
    public  MyTextArea_Colorful(int row,int col,String title,String text){
        this.row=row;
        this.col=col;
        this.title=title;
        init(row, col, title);
        textArea.setText(text);
    }
    public  MyTextArea_Colorful(int row,int col,String title,String text,boolean able){
        this.row=row;
        this.col=col;
        this.title=title;
        init(row, col, title);
        textArea.setText(text);
        textArea.setEnabled(able);
    }
    public  MyTextArea_Colorful(int row,int col,String title,String text,boolean able,boolean onlyNumber){
        this.row=row;
        this.col=col;
        this.title=title;
        init(row, col, title);
        textArea.setText(text);
        textArea.setEnabled(able);
        if (onlyNumber){
            textArea.addKeyListener(new KeyAdapter() {
                public void keyTyped(KeyEvent e) {
                    if(e.getKeyChar()<KeyEvent.VK_0||e.getKeyChar()>KeyEvent.VK_9) {
                        e.consume();
                    }
                }
            });
        }
    }
    public void init(int row,int col,String title){
        setLayout(new VFlowLayout(true,true));

        textArea=new JTextArea(row,col);
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
        GradientPaint gradientPaint = new GradientPaint(200f, 15f, Color.GREEN, 350, 15f, Color.RED, false);//建立渐变颜色
        Border border = BorderFactory.createDashedBorder(gradientPaint, 10f, 10);
        Border border1 = BorderFactory.createTitledBorder(border, title);
        setBorder(border1);
        add(textArea);
    }
    public String getText(){
        return textArea.getText();
    }
    public void setText(String text){
        textArea.setText(text);
    }
    public void setAble(boolean able){
        textArea.setEnabled(able);
    }
}
