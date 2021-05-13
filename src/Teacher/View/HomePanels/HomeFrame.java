package Teacher.View.HomePanels;

import Teacher.Util.AdapterAndHelper.GBC;
import Teacher.Util.Component.MyButton.ShowUnVisibleBtn;
import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class HomeFrame extends JFrame {
    private static final int WIDTH = 1200;
    private static final int HEIGHT = 700;
    public static JPanel content=new JPanel(new BorderLayout());
    public static LeftPanel leftPanel=new LeftPanel();
    public static ShowUnVisibleBtn showUnVisibleBtn=new ShowUnVisibleBtn();

    public HomeFrame() {
        setSize(WIDTH, HEIGHT);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("考试平台-教师端");
        setLayout(new GridBagLayout());

        Toolkit kit = Toolkit.getDefaultToolkit();
        Image image=kit.createImage("src/Teacher/Util/Images/logo.png");
        this.setIconImage(image);
        Dimension screenSize = kit.getScreenSize();
        int width = screenSize.width;
        int height = screenSize.height;
        int x = (width - WIDTH) / 2;
        int y = (height - HEIGHT) / 2;
        setLocation(x, y);

        DefaultContentPanel defaultContentPanel=new DefaultContentPanel();
        content.add(defaultContentPanel);
        add(showUnVisibleBtn,new GBC(0,1).setWeighty(0).setFill(GridBagConstraints.VERTICAL));
        add(leftPanel, new GBC(0, 1, 0.01, 1).setAnchor(GridBagConstraints.WEST).setFill(GridBagConstraints.BOTH));
        add(content, new GBC(1, 1, 0.99, 1).setAnchor(GridBagConstraints.EAST).setFill(GridBagConstraints.BOTH));
    }
}

