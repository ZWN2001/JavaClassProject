package Teacher.View.HomePanels;

import Teacher.Fuction.LeftPanelFuction.LeftPanelVisible;
import Teacher.Util.Adapter.GBC;
import Teacher.Util.Component.MyButton.BackgroundButton;
import Teacher.Util.Component.MyButton.PopButton;
import Teacher.Util.Component.MyButton.TransparentButton;
import Teacher.Util.Component.MyPanel.HeadImagePanel ;
import Teacher.View.MyPapers.CheckMyPaperPanel;
import Teacher.View.MyQuestions.CheckMyQuestionBank;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class LeftPanel extends JPanel {
    public boolean LeftPanelFlag=true;
    public  LeftPanel(){
        setLayout(new GridBagLayout());
        Icon retractIcon=new ImageIcon("src/Teacher/Util/Images/HomeImage/retract.png");
        BackgroundButton retractBtn=new BackgroundButton(retractIcon,"         收起");

        add(retractBtn,new GBC(0,0,3,2).setFill(GridBagConstraints.HORIZONTAL).setAnchor(GridBagConstraints.NORTH).setWeight(1,0));
        add(new HeadImagePanel(),new GBC(0,3,3,3).setInsets(20).setFill(GridBagConstraints.NONE).setWeight(1,0));
        add(buttonsPanel(),new GBC(0,6,3,8).setFill(GridBagConstraints.BOTH).setWeight(1,1));
        add(bottomPanel(),new GBC(0,14,3,2).setInsets(0,5,0,5).setWeight(0,0).setAnchor(GridBagConstraints.SOUTH));

        setVisible(LeftPanelFlag);
        retractBtn.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                LeftPanelVisible.setLeftPanelVisible(HomeFrame.leftPanel,HomeFrame.showUnVisibleBtn);
                HomeFrame.content.revalidate();
            }
        });
    }

    private JPanel  buttonsPanel(){
        JPanel  buttonsPanel = new JPanel(new GridBagLayout());
        JPanel checkMyQuestionPanel=new JPanel(new BorderLayout());
        CheckMyQuestionBank bank = new CheckMyQuestionBank();
        checkMyQuestionPanel.add(new JLabel("aaaaa"));

        Font myFont=new Font("宋体",Font.PLAIN,16);

        ArrayList<String> maintainQuestionSubTitle=new ArrayList<>();
        maintainQuestionSubTitle.add("查看题库");
        maintainQuestionSubTitle.add("出题");
        maintainQuestionSubTitle.add("题库数据");
        PopButton maintainQuestionsBtn = new PopButton(3,"维护题库",maintainQuestionSubTitle);
        maintainQuestionsBtn.childButton.get(0).addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                HomeFrame.content.removeAll();
                 CheckMyQuestionBank checkMyQuestionBank=new CheckMyQuestionBank();
                HomeFrame.content.add(checkMyQuestionBank);
                HomeFrame.content.repaint();
                maintainQuestionsBtn.childButtonFlag=!maintainQuestionsBtn.childButtonFlag;
                maintainQuestionsBtn.childButtonPanel.setVisible(maintainQuestionsBtn.childButtonFlag);
            }
        });

        ArrayList<String> maintainPapersSubTitle=new ArrayList<>();
        maintainPapersSubTitle.add("查看试卷");
        maintainPapersSubTitle.add("出卷");
        PopButton myPaperBtn = new PopButton(2,"我的试卷",maintainPapersSubTitle);
        myPaperBtn.childButton.get(0).addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                HomeFrame.content.removeAll();
                CheckMyPaperPanel checkMyPaperPanel=new CheckMyPaperPanel();
                HomeFrame.content.add(checkMyPaperPanel);
                HomeFrame.content.repaint();
                myPaperBtn.childButtonFlag=!myPaperBtn.childButtonFlag;
                myPaperBtn.childButtonPanel.setVisible(myPaperBtn.childButtonFlag);
            }
        });

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

        Icon settingsIcon=new ImageIcon("src/Teacher/Util/Images/HomeImage/settings.png");
        Icon exitIcon=new ImageIcon("src/Teacher/Util/Images/HomeImage/exit.png");
        Icon helpIcon=new ImageIcon("src/Teacher/Util/Images/HomeImage/help.png");
        Icon settingsIcon_L=new ImageIcon("src/Teacher/Util/Images/HomeImage/settings_L.png");
        Icon exitIcon_L=new ImageIcon("src/Teacher/Util/Images/HomeImage/exit_L.png");
        Icon helpIcon_L=new ImageIcon("src/Teacher/Util/Images/HomeImage/help_L.png");

        TransparentButton settings = new TransparentButton(settingsIcon,settingsIcon_L);
        TransparentButton exit = new TransparentButton(exitIcon,exitIcon_L);
        TransparentButton help = new TransparentButton(helpIcon,helpIcon_L);
        bottonPanel.add(settings,BorderLayout.WEST);
        bottonPanel.add(exit,BorderLayout.CENTER);
        bottonPanel.add(help,BorderLayout.EAST);

        return bottonPanel;
    }
}

