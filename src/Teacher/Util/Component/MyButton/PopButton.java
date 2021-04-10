/*
参数：titleButtonText  主按钮
     childButton   子按钮数组
     childButtonFlag  判断是否显示
     childButtonPanel  子按钮面板
     childButtonTitle  子按钮标题
*/
package Teacher.Util.Component.MyButton;
import Teacher.Util.Layout.VFlowLayout;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
/**
 * @ClassName:
 * @Description: 能够弹出子按钮的panel
 * @author 赵炜宁
 * @date
 *
 */
public class PopButton extends JPanel {
    public boolean childButtonFlag=false;
    public final ArrayList<BackgroundButton> childButton = new ArrayList<>();
    private final Font myFont=new Font("宋体",Font.PLAIN,12);
    public final JPanel childButtonPanel= new JPanel();

    public PopButton(int n,String titleButtonText,ArrayList<String> childButtonTitle ){
        setLayout(new VFlowLayout());
        childButtonPanel.setLayout(new VFlowLayout());
        childButtonPanel.setVisible(childButtonFlag);

        BackgroundButton titleButton=new BackgroundButton(titleButtonText);
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
        }catch (IndexOutOfBoundsException e){
            e.printStackTrace();
        }

        titleButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                childButtonFlag=!childButtonFlag;
                childButtonPanel.setVisible(childButtonFlag);
                repaint();
            }
        });
    }
}
