package Teacher.View.HomePanels;

import Teacher.Util.Adapter.GBC;
import Teacher.Util.Component.MyButton.ShowUnVisibleBtn;
import Teacher.Util.Layout.VFlowLayout;
import Teacher.View.MyQuestions.AddQuestion;
import Teacher.View.MyQuestions.CheckMyQuestionBank;
import Teacher.View.MyPapers.CheckMyPaperPanel;

import javax.swing.*;
import java.awt.*;

public class HomeFrame extends JFrame {
    private static final int WIDTH = 1200;
    private static final int HEIGHT = 700;
//    public  static JPanel contentPanel =new JPanel(new FlowLayout());
    public static Container content=new Container();
    public static LeftPanel leftPanel=new LeftPanel();
    public static ShowUnVisibleBtn showUnVisibleBtn=new ShowUnVisibleBtn();

    public HomeFrame() {
        setSize(WIDTH, HEIGHT);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("考试平台-教师端");
        setLayout(new GridBagLayout());

        Toolkit kit = Toolkit.getDefaultToolkit();
        Dimension screenSize = kit.getScreenSize();
        int width = screenSize.width;
        int height = screenSize.height;
        int x = (width - WIDTH) / 2;
        int y = (height - HEIGHT) / 2;
        setLocation(x, y);

        JPanel rootPanel = new JPanel(new GridBagLayout());
        setContentPane(rootPanel);

//        contentPanel.add(new DefaultContentPanel());
        content.setLayout(new VFlowLayout(true,true));
        DefaultContentPanel defaultContentPanel=new DefaultContentPanel();
        content.add(defaultContentPanel);
        CheckMyQuestionBank bank = new CheckMyQuestionBank();
        AddQuestion addQuestionPanel=new AddQuestion();
        CheckMyPaperPanel checkMyPaperPanel =new CheckMyPaperPanel();
        rootPanel.add(showUnVisibleBtn,new GBC(0,1).setWeighty(0).setFill(GridBagConstraints.VERTICAL));
        rootPanel.add(leftPanel, new GBC(0, 1, 0.02, 1).setAnchor(GridBagConstraints.WEST).setFill(GridBagConstraints.BOTH));
        rootPanel.add(content, new GBC(1, 1, 0.98, 1).setAnchor(GridBagConstraints.EAST).setFill(GridBagConstraints.BOTH));
    }
}
