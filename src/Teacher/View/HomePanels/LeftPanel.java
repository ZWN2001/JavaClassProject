package Teacher.View.HomePanels;

import Teacher.Function.LeftPanelFuction.LeftPanelVisible;
import Teacher.Function.LeftPanelFuction.PanelIntent;
import Teacher.Util.AdapterAndHelper.GBC;
import Teacher.Util.Component.MyButton.BackgroundButton;
import Teacher.Util.Component.MyButton.PopButton;
import Teacher.Util.Component.MyPanel.HeadImagePanel;
import Teacher.Util.MyColor;
import Teacher.Util.MyFont;
import Teacher.View.MyPapers.AddPaperPanels.AddPaper.MyTabbedPane_AddPaper;
import Teacher.View.MyPapers.CheckPaperPanels.CheckAllPaperPanel;
import Teacher.View.MyQuestions.CheckQuestions.MyTabbedPane_Question;
import Teacher.View.MyQuestions.AddQuestion.AddQuestionPane;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class LeftPanel extends JPanel {
    public boolean LeftPanelFlag=true;
    public  LeftPanel(){
//        setPreferredSize(new Dimension(120,700));
//        setSize(120,700);
        setBackground(MyColor.LIGHT_BLUE_100);
        setLayout(new GridBagLayout());
        String retract="src/Teacher/Util/Images/HomeImage/retract.png";
        Icon retractIcon=new ImageIcon(retract);
        BackgroundButton retractBtn=new BackgroundButton(retractIcon,"         收起");
        retractBtn.setBackground(MyColor.LIGHT_BLUE_100);
        retractBtn.setUnFocusedColor(MyColor.LIGHT_BLUE_100);
        retractBtn.setFocusedColor(MyColor.LIGHT_BLUE_300);
        retractBtn.setClickedColor(MyColor.LIGHT_BLUE_400);

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
                HomeFrame.content.repaint();
                HomeFrame.content.updateUI();
                EventQueue.invokeLater(() ->{
                    HomeFrame.content.repaint();
                });
                Home.homeFrame.repaint();
            }
        });
    }

    private JPanel  buttonsPanel(){
        JPanel  buttonsPanel = new JPanel(new GridBagLayout());
        buttonsPanel.setBackground(MyColor.LIGHT_BLUE_100);
        ArrayList<String> maintainQuestionSubTitle=new ArrayList<>();
        maintainQuestionSubTitle.add("查看题库");
        maintainQuestionSubTitle.add("出题");
        maintainQuestionSubTitle.add("题库数据");
        PopButton maintainQuestionsBtn = new PopButton(3,"维护题库",maintainQuestionSubTitle);

        maintainQuestionsBtn.setBackground(MyColor.LIGHT_BLUE_100);
        maintainQuestionsBtn.setUnFocusedColor_parent(MyColor.LIGHT_BLUE_100);
        maintainQuestionsBtn.setUnFocusedColor_child(MyColor.LIGHT_BLUE_100,3);
        maintainQuestionsBtn.setFocusedColor_parent(MyColor.LIGHT_BLUE_300);
        maintainQuestionsBtn.setFocusedColor_child(MyColor.LIGHT_BLUE_300,3);
        maintainQuestionsBtn.setClickedColor_parent(MyColor.LIGHT_BLUE_400);
        maintainQuestionsBtn.setClickedColor_child(MyColor.LIGHT_BLUE_400,3);

        maintainQuestionsBtn.childButton.get(0).addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                 MyTabbedPane_Question questionTabbedPane=new MyTabbedPane_Question();
                PanelIntent.intent(questionTabbedPane,maintainQuestionsBtn);
            }
        });
        maintainQuestionsBtn.childButton.get(1).addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                AddQuestionPane addQuestionPane=new AddQuestionPane();
                PanelIntent.intent(addQuestionPane,maintainQuestionsBtn);
            }
        });

        ArrayList<String> maintainPapersSubTitle=new ArrayList<>();
        maintainPapersSubTitle.add("查看试卷");
        maintainPapersSubTitle.add("出卷");
        PopButton myPaperBtn = new PopButton(2,"我的试卷",maintainPapersSubTitle);

        myPaperBtn.setUnFocusedColor_child(MyColor.LIGHT_BLUE_100,2);
        myPaperBtn.setUnFocusedColor_parent(MyColor.LIGHT_BLUE_100);
        myPaperBtn.setBackground(MyColor.LIGHT_BLUE_100);
        myPaperBtn.setFocusedColor_child(MyColor.LIGHT_BLUE_300,2);
        myPaperBtn.setFocusedColor_parent(MyColor.LIGHT_BLUE_300);
        myPaperBtn.setClickedColor_child(MyColor.LIGHT_BLUE_400,2);
        myPaperBtn.setClickedColor_parent(MyColor.LIGHT_BLUE_400);

        myPaperBtn.childButton.get(0).addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                CheckAllPaperPanel checkMyPaperPanel=new CheckAllPaperPanel();
                PanelIntent.intent(checkMyPaperPanel,myPaperBtn);
            }
        });
        myPaperBtn.childButton.get(1).addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                MyTabbedPane_AddPaper myTabbedPane_addPaper=new MyTabbedPane_AddPaper();
                PanelIntent.intent(myTabbedPane_addPaper,myPaperBtn);
            }
        });

        BackgroundButton addPaperBtn = new BackgroundButton("我的学生");
        addPaperBtn.setUnFocusedColor(MyColor.LIGHT_BLUE_100);
        addPaperBtn.setFocusedColor(MyColor.LIGHT_BLUE_300);
        addPaperBtn.setClickedColor(MyColor.LIGHT_BLUE_400);
        addPaperBtn.setBackground(MyColor.LIGHT_BLUE_100);

        BackgroundButton correctQuestionBtn = new BackgroundButton("批改");
        correctQuestionBtn.setUnFocusedColor(MyColor.LIGHT_BLUE_100);
        correctQuestionBtn.setFocusedColor(MyColor.LIGHT_BLUE_300);
        correctQuestionBtn.setClickedColor(MyColor.LIGHT_BLUE_400);
        correctQuestionBtn.setBackground(MyColor.LIGHT_BLUE_100);

        BackgroundButton paperMarkBtn = new BackgroundButton("查看成绩");
        paperMarkBtn.setUnFocusedColor(MyColor.LIGHT_BLUE_100);
        paperMarkBtn.setFocusedColor(MyColor.LIGHT_BLUE_300);
        paperMarkBtn.setClickedColor(MyColor.LIGHT_BLUE_400);
        paperMarkBtn.setBackground(MyColor.LIGHT_BLUE_100);

        maintainQuestionsBtn.setFont(MyFont.Font_16);
        myPaperBtn.setFont(MyFont.Font_16);
        addPaperBtn.setFont(MyFont.Font_16);
        correctQuestionBtn.setFont(MyFont.Font_16);
        paperMarkBtn.setFont(MyFont.Font_16);

        buttonsPanel.add(maintainQuestionsBtn,new GBC(0,0).setWeightx(1).setFill(GridBagConstraints.HORIZONTAL));
        buttonsPanel.add(myPaperBtn,new GBC(0,1).setWeightx(1).setFill(GridBagConstraints.HORIZONTAL));
        buttonsPanel.add(addPaperBtn,new GBC(0,2).setWeightx(1).setInsets(0,5,0,5).setFill(GridBagConstraints.HORIZONTAL));
        buttonsPanel.add(correctQuestionBtn,new GBC(0,3).setWeightx(1).setInsets(0,5,0,5).setFill(GridBagConstraints.HORIZONTAL));
        buttonsPanel.add(paperMarkBtn,new GBC(0,4).setWeightx(1).setInsets(0,5,0,5).setFill(GridBagConstraints.HORIZONTAL));

        return buttonsPanel;
    }
    private  static JPanel bottomPanel(){
        JPanel bottomPanel = new JPanel();
        bottomPanel.setBackground(MyColor.LIGHT_BLUE_100);
        bottomPanel.setLayout(new GridBagLayout());

        JLabel label=new JLabel("版本号：v1.0.0");
        label.setFont(MyFont.Font_16);
        JLabel label1=new JLabel("Developed by 赵炜宁");
        label1.setFont(MyFont.Font_16);
        bottomPanel.add(label,new GBC(0,0).setInsets(0,0,10,0).setFill(GridBagConstraints.HORIZONTAL).setAnchor(GridBagConstraints.CENTER).setWeightx(1));
        bottomPanel.add(label1,new GBC(0,1).setInsets(0,0,10,0).setFill(GridBagConstraints.HORIZONTAL).setAnchor(GridBagConstraints.CENTER).setWeightx(1));
//        Icon exitIcon=new ImageIcon("src/Teacher/Util/Images/HomeImage/exit.png");
//        Icon exitIcon_init=new ImageIcon("src/Teacher/Util/Images/HomeImage/exit_init.png");
//        Icon exitIcon_pressed=new ImageIcon("src/Teacher/Util/Images/HomeImage/exit_init.png");
//        TransparentButton exit = new TransparentButton(exitIcon_init,exitIcon,exitIcon_pressed);
//       exit.addMouseListener(new MouseAdapter() {
//           @Override
//           public void mouseClicked(MouseEvent e) {
//               super.mouseClicked(e);
////               int n = JOptionPane.showConfirmDialog(null, "你会了吗?", "标题",JOptionPane.YES_NO_OPTION); //返回值为0或1
////               if (n==0){
////                   System.exit(0);
////               }
//               JDialog dialog=new JDialog((Dialog) null,"tuichu",true);
//               dialog.setSize(30,40);
//               dialog.setVisible(true);
//           }
//       });
//        bottomPanel.add(exit,BorderLayout.CENTER);

        return bottomPanel;
    }
}

