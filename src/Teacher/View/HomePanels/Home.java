package Teacher.View.HomePanels;


import Teacher.Util.t3;

import javax.swing.*;
import java.awt.*;

public class Home {
    public static HomeFrame homeFrame=new HomeFrame();
    public static void main(String[] args) {
//        try {
//            //设置样式
//            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
//        } catch (Throwable e) {
//            e.printStackTrace();
//        }
        try
        {
            org.jb2011.lnf.beautyeye.BeautyEyeLNFHelper.launchBeautyEyeLNF();
        } catch(Exception e)
        {
            e.printStackTrace();
        }
        EventQueue.invokeLater(() ->{
            homeFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            homeFrame.setVisible(true);
        });

        t3 test = new t3();
        try {
            test.Tray();
        }catch(AWTException e) {
            e.printStackTrace();
        }
    }
}




