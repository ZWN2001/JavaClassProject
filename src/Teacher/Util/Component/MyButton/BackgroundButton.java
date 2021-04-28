package Teacher.Util.Component.MyButton;
/**
 * @ClassName:
 * @Description: 背景会因鼠标事件而相应的button
 * @author 赵炜宁
 * @date 2021.3 init
 *       2021.4.16 精简化
 */
import Teacher.Util.MyColor;
import Teacher.Util.MyFont;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class BackgroundButton extends JButton implements MouseListener {
    Color focusedColor=MyColor.focusedColor;
    Color unFocusedColor= MyColor.unFocusedColor;
    Color clickedColor=MyColor.clickedColor;
    Font myFont= MyFont.Font_16;
    String text=" ";

    //文字按钮
    public  BackgroundButton(String text){
        init(text);
    }

    //icon+文字
    public BackgroundButton(Icon icon, String text) {
        setHorizontalAlignment(SwingConstants.LEFT);
        setIcon(icon);
        init(text);
    }

    private void init(String text) {
        this.setBorderPainted(false);//不打印边框
        this.setFocusPainted(false);//除去焦点的框
        this.setFont(myFont);
        this.setText(text);
        this.setMargin(new Insets(5,5,5,5));
        this.addMouseListener(this);
    }

    public void setFocusedColor(Color color){
        this.focusedColor=color;
    }
    public void setUnFocusedColor(Color color){
        this.unFocusedColor=color;
    }
    public void setClickedColor(Color color){
        this.clickedColor=color;
    }
    public void setMyText(String text){
        this.text=text;
    }
    @Override
    public void mouseClicked(MouseEvent e) { }

    @Override
    public void mousePressed(MouseEvent e) {
        setBackground(clickedColor);
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        setBackground(focusedColor);
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        setBackground(focusedColor);
    }

    @Override
    public void mouseExited(MouseEvent e) {
        setBackground(unFocusedColor);
    }

}
