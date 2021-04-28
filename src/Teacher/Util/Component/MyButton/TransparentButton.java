package Teacher.Util.Component.MyButton;
/**
 * @ClassName:
 * @Description: 透明背景button,大小会发生变化
 * @author 赵炜宁
 * @date
 *
 */
import Teacher.Util.MyFont;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class TransparentButton extends JButton implements MouseListener {

    Font myFont= MyFont.Font_16;
    private final Icon smallIcon;
    private final Icon largeIcon;
    //IconButton,大小会发生变化
    public TransparentButton(Icon smallIcon,Icon largeIcon) {
        this.smallIcon=smallIcon;
        this.largeIcon=largeIcon;
        init(smallIcon);
    }

    //icon+文字
    public TransparentButton(Icon smallIcon,Icon largeIcon,String text) {
        this.smallIcon=smallIcon;
        this.largeIcon=largeIcon;

        setHorizontalAlignment(SwingConstants.LEFT);
        setText(text);
        setFont(myFont);
        init(smallIcon);
    }

    public void init(Icon smallIcon){
        this.setIcon(smallIcon);
        this.setMargin(new Insets(8,10,10,10));
        this.setBorderPainted(false);//不打印边框
        this.setFocusPainted(false);//除去焦点的框
        setContentAreaFilled(false);//除去默认的背景填充
        this.addMouseListener(this);
    }
    @Override
    public void mouseClicked(MouseEvent e) { }

    @Override
    public void mousePressed(MouseEvent e) { }

    @Override
    public void mouseReleased(MouseEvent e) { }

    @Override
    public void mouseEntered(MouseEvent e) {
        setIcon(largeIcon);
    }

    @Override
    public void mouseExited(MouseEvent e) {
        setIcon(smallIcon);
    }
}
