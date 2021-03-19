package Teacher.View;
import Teacher.Util.GBC;

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
            homeFrame.setResizable(false);
            homeFrame.setVisible(true);
        });
    }
}
class HomeFrame extends JFrame{
    private static final int WIDTH = 1000;
    private static final int HEIGHT = 700;

    public HomeFrame(){
        setSize(WIDTH,HEIGHT);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("考试平台-教师端");
        setLayout(new GridBagLayout());

        Toolkit kit = Toolkit.getDefaultToolkit();
        Dimension screenSize = kit.getScreenSize();
        int width = screenSize.width;
        int height = screenSize.height;
        int x = (width - WIDTH) / 2;
        int y = (height - HEIGHT) / 2;
        setLocation(x,y);

    }

}
