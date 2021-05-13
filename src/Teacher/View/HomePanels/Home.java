package Teacher.View.HomePanels;


import Teacher.Bean.Teacher;
import Teacher.Util.t3;

import javax.swing.*;
import java.awt.*;

public class Home {
    public static HomeFrame homeFrame=new HomeFrame();
    public static Teacher teacher;
    public Home( Teacher teacher) {
        Home.teacher =teacher;
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
    }
}




