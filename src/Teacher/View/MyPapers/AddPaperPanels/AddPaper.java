package Teacher.View.MyPapers.AddPaperPanels;

import javax.swing.*;
import java.awt.*;

public class AddPaper extends JPanel {
    public AddPaper(){
        //        setLayout(new GridBagLayout());
//        JTabbedPane tabBar=new JTabbedPane();
//        tabBar.setTabPlacement(JTabbedPane.TOP);
//
//        tabBar.addTab(" 手动组卷 ",new JPanel());
//        tabBar.addTab(" 自动组卷 ",new JPanel());
//        tabBar.addTab(" 3 ",new JPanel());
//        tabBar.setSelectedIndex(0);
//        add(tabBar);
        final JTabbedPane tabbedPane = new JTabbedPane();


        // 创建第 1 个选项卡（选项卡只包含 标题）
        tabbedPane.addTab("Tab01", createTextPanel("TAB 01"));

        // 创建第 2 个选项卡（选项卡包含 标题 和 图标）
        tabbedPane.addTab("Tab02", createTextPanel("TAB 02"));

        // 创建第 3 个选项卡（选项卡包含 标题、图标 和 tip提示）
        tabbedPane.addTab("Tab03",  createTextPanel("TAB 03"));
        add(tabbedPane);

        // 设置默认选中的选项卡
        tabbedPane.setSelectedIndex(0);
    }

    private static JComponent createTextPanel(String text) {
        // 创建面板, 使用一个 1 行 1 列的网格布局（为了让标签的宽高自动撑满面板）
        JPanel panel = new JPanel(new BorderLayout());
        // 创建标签
        JLabel label = new JLabel(text);
        label.setFont(new Font(null, Font.PLAIN, 50));
        // 添加标签到面板
        panel.add(label,BorderLayout.CENTER);
        return panel;

    }
}
