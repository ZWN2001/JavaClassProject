package Teacher.Util.Component.MyButton;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class TransparentButton extends JButton {

    Font myFont=new Font("宋体",Font.PLAIN,16);

    //纯白按钮
    public TransparentButton() {
        setBorderPainted(false);//不打印边框
        setBorder(null);//除去边框
        setFocusPainted(false);//除去焦点的框
        setContentAreaFilled(false);//除去默认的背景填充
    }

     //IconButton
     public TransparentButton(Icon icon) {
         setBorderPainted(false);//不打印边框
//         setBorder(null);//除去边框
         setMargin(new Insets(0,15,0,15));
         setFocusPainted(false);//除去焦点的框
         setContentAreaFilled(false);//除去默认的背景填充
         setIcon(icon);
     }

    //IconButton,大小会发生变化
    public TransparentButton(Icon smallIcon,Icon largeIcon) {
        setBorderPainted(false);//不打印边框
//        setBorder(null);//除去边框
        setFocusPainted(false);//除去焦点的框
        setContentAreaFilled(false);//除去默认的背景填充
        setIcon(smallIcon);
        setMargin(new Insets(10,10,3,10));
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                super.mouseEntered(e);
                setIcon(largeIcon);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                super.mouseExited(e);
                setIcon(smallIcon);
            }
        });

    }

    //文字按钮
    public  TransparentButton(String text){
        setBorderPainted(false);//不打印边框
//        setBorder(null);//除去边框
        setFocusPainted(false);//除去焦点的框
//        setContentAreaFilled(false);//除去默认的背景填充
        setMargin(new Insets(5,15,5,15));
        setText(text);
        setFont(myFont);
    }

    //icon+文字
    public TransparentButton(Icon icon,String text) {
        setBorderPainted(false);//不打印边框
//        setBorder(null);//除去边框
        setFocusPainted(false);//除去焦点的框
//        setContentAreaFilled(false);//除去默认的背景填充
        setMargin(new Insets(5,4,5,0));
        setHorizontalAlignment(SwingConstants.LEFT);
        setIcon(icon);
        setText(text);
        setFont(myFont);

    }
}
