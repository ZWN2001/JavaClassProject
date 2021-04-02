package Teacher.View;


import javax.swing.*;
import java.awt.*;

public class Home {
    public static void main(String[] args) {
        try {
            //设置样式
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Throwable e) {
            e.printStackTrace();
        }
        EventQueue.invokeLater(() ->{
            HomeFrame homeFrame=new HomeFrame();
            homeFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
           // homeFrame.setResizable(false);
            homeFrame.setVisible(true);
        });
    }
}




