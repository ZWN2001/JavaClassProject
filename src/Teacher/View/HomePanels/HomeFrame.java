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
//        addWindowListener(new WindowClose());

        Toolkit kit = Toolkit.getDefaultToolkit();
        Dimension screenSize = kit.getScreenSize();
        int width = screenSize.width;
        int height = screenSize.height;
        int x = (width - WIDTH) / 2;
        int y = (height - HEIGHT) / 2;
        setLocation(x, y);

//        JPanel rootPanel = new JPanel(new GridBagLayout());
//        setContentPane(rootPanel);

        DefaultContentPanel defaultContentPanel=new DefaultContentPanel();
        content.add(defaultContentPanel);
        add(showUnVisibleBtn,new GBC(0,1).setWeighty(0).setFill(GridBagConstraints.VERTICAL));
        add(leftPanel, new GBC(0, 1, 0.04, 1).setAnchor(GridBagConstraints.WEST).setFill(GridBagConstraints.BOTH));
        add(content, new GBC(1, 1, 0.96, 1).setAnchor(GridBagConstraints.EAST).setFill(GridBagConstraints.BOTH));
    }
}
//class WindowClose extends WindowAdapter {
//    public void windowClosing(WindowEvent e) {
//        int i = JOptionPane.showConfirmDialog(null, "是否关闭", "提示", JOptionPane.YES_NO_OPTION);
//        if (i == 0) {
//            System.exit(0);
//        }
//    }
//}
