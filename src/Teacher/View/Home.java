package Teacher.View;
import Teacher.Util.Adapter.GBC;
import Teacher.Util.MyButton.BackgroundButton;
import Teacher.Util.MyButton.PopButton;
import Teacher.Util.MyButton.TransparentButton;
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

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
class HomeFrame extends JFrame{
    private static final int WIDTH = 1200;
    private static final int HEIGHT = 700;
    JPanel contentPanel;

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

        JPanel rootPanel = new JPanel(new GridBagLayout());
        setContentPane(rootPanel);
        DefaultContentPanel defaultContentPanel=new DefaultContentPanel();

        contentPanel=(JPanel)defaultContentPanel;

        rootPanel.add(leftPanel(), new GBC(0,0,0.03,1).setAnchor(GridBagConstraints.WEST).setFill(GridBagConstraints.BOTH));
        rootPanel.add(contentPanel,new GBC(1,0,0.97,1).setAnchor(GridBagConstraints.EAST).setFill(GridBagConstraints.BOTH));

    }


    public static JPanel leftPanel(){
        JPanel leftPanel = new JPanel();
        leftPanel.setLayout(new GridBagLayout());

        Icon retractIcon=new ImageIcon("src/Teacher/Util/Images/retract.png");
        BackgroundButton  retractBtn=new BackgroundButton(retractIcon,"         收起");

        leftPanel.add(retractBtn,new GBC(0,0).setFill(GridBagConstraints.HORIZONTAL).setWeight(1,0.05));
        leftPanel.add(new JLabel("pic"),new GBC(0,1).setFill(GridBagConstraints.HORIZONTAL).setWeight(1,0.25));
        leftPanel.add(buttonsPanel(),new GBC(0,2).setWeight(1,0.6).setFill(GridBagConstraints.BOTH));
        leftPanel.add(bottomPanel(),new GBC(0,3).setWeight(1,0.1).setFill(GridBagConstraints.HORIZONTAL));
        return leftPanel;
    }

    private static JPanel  buttonsPanel(){
        JPanel  buttonsPanel = new JPanel();
        buttonsPanel.setLayout(new GridBagLayout());

        Font myFont=new Font("宋体",Font.PLAIN,16);

        ArrayList<String> maintainQuestionSubTitle=new ArrayList<>();
        maintainQuestionSubTitle.add("查看题库");
        maintainQuestionSubTitle.add("出题");
        PopButton maintainQuestionsBtn = new PopButton(2,"维护题库",maintainQuestionSubTitle);

//        maintainQuestionsBtn.setChildButtonTitle(maintainQuestionSubTitle);
        BackgroundButton myPaperBtn = new BackgroundButton("我的试卷");
        BackgroundButton addPaperBtn = new BackgroundButton("我的学生");
        BackgroundButton correctQuestionBtn = new BackgroundButton("批改");
        BackgroundButton paperMarkBtn = new BackgroundButton("查看成绩");

        maintainQuestionsBtn.setFont(myFont);
        myPaperBtn.setFont(myFont);
        addPaperBtn.setFont(myFont);
        correctQuestionBtn.setFont(myFont);
        paperMarkBtn.setFont(myFont);

        buttonsPanel.add(maintainQuestionsBtn,new GBC(0,0).setWeightx(1).setFill(GridBagConstraints.HORIZONTAL));
        buttonsPanel.add(myPaperBtn,new GBC(0,1).setWeightx(1).setFill(GridBagConstraints.HORIZONTAL));

        buttonsPanel.add(addPaperBtn,new GBC(0,2).setWeightx(1).setFill(GridBagConstraints.HORIZONTAL));
        buttonsPanel.add(correctQuestionBtn,new GBC(0,3).setWeightx(1).setFill(GridBagConstraints.HORIZONTAL));
        buttonsPanel.add(paperMarkBtn,new GBC(0,4).setWeightx(1).setFill(GridBagConstraints.HORIZONTAL));

        return buttonsPanel;
    }
    private  static JPanel bottomPanel(){
        JPanel bottonPanel = new JPanel();
        bottonPanel.setLayout(new BorderLayout());

         Icon settingsIcon=new ImageIcon("src/Teacher/Util/Images/settings.png");
         Icon exitIcon=new ImageIcon("src/Teacher/Util/Images/exit.png");
         Icon helpIcon=new ImageIcon("src/Teacher/Util/Images/help.png");
        Icon settingsIcon_L=new ImageIcon("src/Teacher/Util/Images/settings_L.png");
        Icon exitIcon_L=new ImageIcon("src/Teacher/Util/Images/exit_L.png");
        Icon helpIcon_L=new ImageIcon("src/Teacher/Util/Images/help_L.png");

        TransparentButton settings = new TransparentButton(settingsIcon,settingsIcon_L);
        TransparentButton exit = new TransparentButton(exitIcon,exitIcon_L);
        TransparentButton help = new TransparentButton(helpIcon,helpIcon_L);
         bottonPanel.add(settings,BorderLayout.WEST);
         bottonPanel.add(exit,BorderLayout.CENTER);
         bottonPanel.add(help,BorderLayout.EAST);

        return bottonPanel;
    }
}
