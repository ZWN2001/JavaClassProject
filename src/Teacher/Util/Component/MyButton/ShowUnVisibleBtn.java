package Teacher.Util.Component.MyButton;
/**
 * @ClassName:ShowUnVisibleBtn
 * @Description: 弹出隐藏的左侧工具栏
 * @author 赵炜宁
 * @date
 *
 */
import Teacher.Function.LeftPanelFuction.LeftPanelVisible;
import Teacher.Util.MyColor;
import Teacher.View.HomePanels.HomeFrame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ShowUnVisibleBtn extends JButton {
    public  boolean ShowUnVisibleBtnFlag=false;
    Color focusedColor=MyColor.focusedColor;
    Color clickedColor=MyColor.clickedColor;
    Color unFocusedColor= MyColor.unFocusedColor;
    Icon icon=new ImageIcon("src/Teacher/Util/Images/HomeImage/showLeftPanel.png");
    public ShowUnVisibleBtn(){
        setBorderPainted(false);//不打印边框
        setMargin(new Insets(5,5,5,5));
        setFocusPainted(false);
        setIcon(icon);
        setVisible(ShowUnVisibleBtnFlag);
        addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                super.mousePressed(e);
                setBackground(clickedColor);
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                super.mouseReleased(e);
                setBackground(focusedColor);
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
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                LeftPanelVisible.setLeftPanelVisible(HomeFrame.leftPanel,HomeFrame.showUnVisibleBtn);
                HomeFrame.content.revalidate();
            }
        });
    }
}
