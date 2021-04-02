package Teacher.Fuction.LeftPanelFuction;

import Teacher.Util.Component.MyButton.ShowUnVisibleBtn;
import Teacher.View.LeftPanel;


/**
 * @ClassName:LeftPanelVisible
 * @Description: 设置左侧任务栏是否可见
 * @author 赵炜宁
 * @date
 *
 */
public class LeftPanelVisible {
    public static void setLeftPanelVisible(LeftPanel leftPanel, ShowUnVisibleBtn showUnVisibleBtn){
        leftPanel.setVisible(!leftPanel.LeftPanelFlag);
        showUnVisibleBtn.setVisible(!showUnVisibleBtn.ShowUnVisibleBtnFlag);
        System.out.println("LeftPanelVisibleChanged");
    }
}
