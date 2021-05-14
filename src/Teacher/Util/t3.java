package Teacher.Util;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class t3 extends JFrame{


    public void Tray() throws AWTException{

        if(SystemTray.isSupported()) {//判断系统是否支持托盘图标
            ImageIcon icon = new ImageIcon("src/Teacher/Util/Images/logo.png");
            PopupMenu pop = new PopupMenu();//创建弹出式菜单

            MenuItem menu = new MenuItem("exit");//创建菜单项
            //给菜单项添加事件监听器，单击时退出系统
            menu.addActionListener(e -> System.exit(0));
            pop.add(menu);
            TrayIcon tray = new TrayIcon(icon.getImage(),"考试平台",pop);
            tray.setImageAutoSize(true);
            // 获得系统托盘对象
            SystemTray systemTray = SystemTray.getSystemTray();
            systemTray.add(tray);// 将托盘图片添加到系统托盘中
        }

    }

}
