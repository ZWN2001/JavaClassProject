package Teacher.Fuction.LeftPanelFuction;

import Teacher.Util.Component.MyButton.ShowUnVisibleBtn;
import Teacher.View.HomePanels.LeftPanel;
/**
 * @ClassName:LeftPanelVisible
 * @Description: 设置左侧任务栏是否可见
 * @author 赵炜宁
 * @date
 *
 */
public class LeftPanelVisible {
    public static void setLeftPanelVisible(LeftPanel leftPanel, ShowUnVisibleBtn showUnVisibleBtn){
        leftPanel.LeftPanelFlag=!leftPanel.LeftPanelFlag;
        showUnVisibleBtn.ShowUnVisibleBtnFlag=!showUnVisibleBtn.ShowUnVisibleBtnFlag;
        leftPanel.setVisible(!leftPanel.LeftPanelFlag);
        showUnVisibleBtn.setVisible(!showUnVisibleBtn.ShowUnVisibleBtnFlag);
        System.out.println("LeftPanelVisibleChanged");
        if (leftPanel.LeftPanelFlag) {
            leftPanel.repaint();
        }else {
            showUnVisibleBtn.repaint();
        }
    }
}
