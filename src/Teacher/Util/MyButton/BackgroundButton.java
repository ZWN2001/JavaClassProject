package Teacher.Util.MyButton;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class BackgroundButton extends JButton {
    Color focusedColor=Color.LIGHT_GRAY;
    Color unFocusedColor= new Color(240,240,240);
    Color clickedColor=Color.GRAY;
    Font myFont=new Font("宋体",Font.PLAIN,16);

    //文字按钮
    public  BackgroundButton(String text){
        setBorderPainted(false);//不打印边框
//        setBorder(null);//除去边框
        setFocusPainted(false);//除去焦点的框
//        setContentAreaFilled(false);//除去默认的背景填充
        setMargin(new Insets(5,15,5,15));
        setText(text);
        setFont(myFont);
        addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                super.mouseClicked(e);
                setBackground(clickedColor);
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                super.mouseEntered(e);
                setBackground(focusedColor);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                super.mouseExited(e);
                setBackground(unFocusedColor);
            }
        });
    }

    //icon+文字
    public BackgroundButton(Icon icon, String text) {
        setBorderPainted(false);//不打印边框
//        setBorder(null);//除去边框
        setFocusPainted(false);//除去焦点的框
//        setContentAreaFilled(false);//除去默认的背景填充
        setMargin(new Insets(5,4,5,0));
        setHorizontalAlignment(SwingConstants.LEFT);
        setIcon(icon);
        setText(text);
        setFont(myFont);
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                super.mouseEntered(e);
                setBackground(focusedColor);
                repaint();
            }

            @Override
            public void mouseExited(MouseEvent e) {
                super.mouseExited(e);
                setBackground(unFocusedColor);
                repaint();
            }

            @Override
            public void mousePressed(MouseEvent e) {
                super.mouseClicked(e);
                setBackground(clickedColor);
            }
        });

    }
    void setFocusedColor(Color color){
        this.focusedColor=color;
    }
    void setUnFocusedColor(Color color){
        this.unFocusedColor=color;
    }
    void setClickedColor(Color color){
        this.clickedColor=color;
    }
}
