package Teacher.Util.Component.MyButton;

import Teacher.Util.MyColor;
import Teacher.Util.MyFont;

import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class ChangeColorButton extends JButton implements MouseListener{
    private String text;
    public ChangeColorButton(String text) {
        this.text=text;
        setText(text);
        setFont(MyFont.Font_16);
        setFocusPainted(false);//除去焦点的框
        setBackground(MyColor.BLUE_100);
    }

    @Override
    public String getText() {
        return text;
    }

    @Override
    public void mouseClicked(MouseEvent e) { }

    @Override
    public void mousePressed(MouseEvent e) {
        setBackground(MyColor.BLUE_300);
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        setBackground(MyColor.BLUE_200);
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        setBackground(MyColor.BLUE_200);
    }

    @Override
    public void mouseExited(MouseEvent e) {
        setBackground(MyColor.BLUE_100);
    }
}
