/*
参数：titleButtonText  主按钮
     childButton   子按钮数组
     childButtonFlag  判断是否显示
     childButtonPanel  子按钮面板
     childButtonTitle  子按钮标题
*/
package Teacher.Util.Component.MyButton;

import Teacher.Util.Layout.VFlowLayout;
import Teacher.Util.MyColor;
import Teacher.Util.MyFont;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

/**
 * @author 赵炜宁
 * @ClassName:
 * @Description: 能够弹出子按钮的panel
 * @date
 */
public class PopButton extends JPanel {
    public boolean childButtonFlag = false;
    public final ArrayList<BackgroundButton> childButton = new ArrayList<>();
    private final Font myFont = MyFont.subTitleFont;
    public final JPanel childButtonPanel = new JPanel();
    BackgroundButton titleButton;
    int n;//子button个数

    public PopButton(int n, String titleButtonText, ArrayList<String> childButtonTitle) {
        this.n = n;
        setLayout(new VFlowLayout());
        childButtonPanel.setLayout(new VFlowLayout());
        childButtonPanel.setVisible(childButtonFlag);

        titleButton = new BackgroundButton(titleButtonText);
        add(titleButton);

        try {
            int i;
            for (i = 0; i < n; i++) {
                String title = childButtonTitle.get(i);
                childButton.add(new BackgroundButton(title));
                childButton.get(i).setFont(myFont);
                childButtonPanel.add(childButton.get(i));
            }
            add(childButtonPanel);
        } catch (IndexOutOfBoundsException e) {
            e.printStackTrace();
        }

        titleButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                childButtonFlag = !childButtonFlag;
                childButtonPanel.setVisible(childButtonFlag);
                repaint();
            }
        });
    }

    public void setUnFocusedColor_child(Color color, int n) {
        this.n = n;
        try {
            for (int i = 0; i < n; i++) {
                childButton.get(i).setUnFocusedColor(color);
                childButton.get(i).setBackground(color);
            }
        } catch (IndexOutOfBoundsException e) {
            e.printStackTrace();
        }
    }

    public void setUnFocusedColor_parent(Color color) {
        titleButton.setUnFocusedColor(color);
        titleButton.setBackground(color);
    }

    public void setFocusedColor_child(Color color, int n) {
        this.n = n;
        try {
            for (int i = 0; i < n; i++) {
                childButton.get(i).setFocusedColor(color);
            }
        } catch (IndexOutOfBoundsException e) {
            e.printStackTrace();
        }
    }

    public void setFocusedColor_parent(Color color) {
        titleButton.setFocusedColor(color);
    }

    public void setClickedColor_child(Color color, int n) {
        this.n = n;
        try {
            for (int i = 0; i < n; i++) {
                childButton.get(i).setClickedColor(color);
            }
        } catch (IndexOutOfBoundsException e) {
            e.printStackTrace();
        }
    }

    public void setClickedColor_parent(Color color) {
        titleButton.setClickedColor(color);
    }
}
