package Teacher.Function.LeftPanelFuction;
/**
 * @ClassName:
 * @Description: leftPanel中的按钮点击后在右侧主区域显示相应Panel的方法
 * @parms: addedPanel 要显示到的panel
 *         mainPopButton popButton，用于收起相应的popButton
 * @author 赵炜宁
 * @date 2020.4.10
 */
import Teacher.Util.Component.MyButton.PopButton;
import Teacher.View.HomePanels.HomeFrame;
import java.awt.*;

public class LeftPanelIntent {
    public static void intent(Component addedPanel, PopButton mainPopButton){
        HomeFrame.content.removeAll();
        HomeFrame.content.add(addedPanel);
        HomeFrame.content.repaint();
        mainPopButton.childButtonFlag=!mainPopButton.childButtonFlag;
        mainPopButton.childButtonPanel.setVisible(mainPopButton.childButtonFlag);
    }
}
