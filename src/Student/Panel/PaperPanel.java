package Student.Panel;

import Student.Frame.MainFrame;
import Student.Function.*;
import Student.Function.MyDialog.UploadPaperDialog;
import Student.Panel.QuestionPanel.ChoicePanel;
import Student.Panel.QuestionPanel.JudgePanel;
import Student.Panel.QuestionPanel.MultiChoicePanel;
import Student.Panel.QuestionPanel.SubjectivePanel;
import Teacher.Bean.Question.Question_Choice;
import Teacher.Bean.Question.Question_Judge;
import Teacher.Bean.Question.Question_MultiChoice;
import Teacher.Bean.Question.Question_Subjective;
import Teacher.Util.AdapterAndHelper.GBC;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Timer;

public class PaperPanel extends JPanel {
    private final MainFrame mainFrame;
    private final PaperJSP paperJSP;
    private final PaperRightPanel paperRightPanel;

    public PaperPanel(MainFrame mainFrame) {
        paperJSP = new PaperJSP();
        add(paperJSP);
        this.mainFrame = mainFrame;

        setLayout(null);
        setBounds(0, 0, 1600, 860);
        paperRightPanel=new PaperRightPanel(this);
        add(paperRightPanel);
        setBackground(Color.white);


        setVisible(true);
        mainFrame.examStart(this);
    }

    public PaperJSP getPaperJSP() {
        return paperJSP;
    }

    public UploadPaperDialog getUploadPaperDialog(){
        return paperRightPanel.getUploadPaperDialog();
    }
    public MainFrame getMainFrame() {
        return mainFrame;
    }
}

class PaperRightPanel extends JPanel implements MouseListener {
    private final MainFrame mainFrame;
    private final PaperPanel paperPanel;
    private final JButton endExam;
    private final TestTimerLabel timerLabel;
    private final ImageIcon endExamD = new ImageIcon("src/Student/Resource/endExamD.png");
    private final ImageIcon endExamU = new ImageIcon("src/Student/Resource/endExamU.png");
    private final UploadPaperDialog temp=new UploadPaperDialog();

    public PaperRightPanel(PaperPanel paperPanel) {
        this.mainFrame = paperPanel.getMainFrame();
        this.paperPanel = paperPanel;
        setBounds(1300, 0, 300, 860);
        setLayout(null);
        setBackground(new Color(255,253,250));


        endExam = new JButton();
        endExam.setBounds(50, 500, 200, 75);
        endExam.setFocusPainted(false);
        endExam.addMouseListener(this);
        endExam.setIcon(endExamU);
        add(endExam);

        JButton switchBtn = new JButton("switch");
        switchBtn.addActionListener(new ActionListener() {
                                        @Override
                                        public void actionPerformed(ActionEvent e) {

                                        }
                                    });
                switchBtn.setBounds(50, 300, 200, 75);
        switchBtn.setFocusPainted(false);
        add(switchBtn);

        JLabel remainTime = new JLabel("剩余时间：");
        remainTime.setFont(new Font("微软雅黑", Font.PLAIN, 30));
        remainTime.setBounds(50, -30, 200, 200);
        add(remainTime);

        timerLabel = new TestTimerLabel(paperPanel,2, 0, 0);
        add(timerLabel);
        timerLabel.setBounds(50, 20, 200, 200);
        java.util.Timer timer = new Timer();
        timer.schedule(timerLabel.getTimeTask(), 0, 1000);
        setVisible(true);
    }

    public UploadPaperDialog getUploadPaperDialog() {
        return temp;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        temp.setVisible(true);
        if (temp.getResult()==1){
            timerLabel.getTimeTask().cancel();
            mainFrame.examEnd(paperPanel);
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {
        endExam.setIcon(endExamD);
    }

    @Override
    public void mouseExited(MouseEvent e) {
        endExam.setIcon(endExamU);
    }
}

class PaperJSP extends JScrollPane {
    public PaperJSP() {
        super(new PaperLeftPanel(),VERTICAL_SCROLLBAR_ALWAYS, HORIZONTAL_SCROLLBAR_NEVER);
        setBounds(0, 0, 1300, 860);
        JScrollBar bar = getVerticalScrollBar();
        bar.setUnitIncrement(15);
        bar.setUI(new MyScrollBarUI(17));
        javax.swing.SwingUtilities.invokeLater(() -> bar.setValue(0));
    }

}

class PaperLeftPanel extends JPanel {
    private int count = 1;
    public PaperLeftPanel() {
        setLayout(new GridBagLayout());

        Question_Choice test1= new Question_Choice("暗示法撒旦分公司大股东符合好几天金阿萨德嘎哈改进改进阿斯顿发阿打孤男寡女案说法按时发噶双方大大的飒飒的华火腿加拿大和孤男寡女案说法按时发噶双方大大的飒飒的华火腿加拿大和孤男寡女案说法按时发噶双方大大的飒飒的华火腿加拿大和孤男寡女案说法按时发噶双方大大的飒飒的华火腿加拿大和孤男寡女案说法按时发噶双方大大的飒飒的华火腿加拿大和孤男寡女案说法按时发噶双方大大的飒飒的华火腿加拿大和孤男寡女案说法按时发噶双方大大的飒飒的华火腿加拿大和孤男寡女案说法按时发噶双方大大的飒飒的华火腿加拿大和孤男寡女案说法按时发噶双方大大的飒飒的华火腿加拿大和孤男寡女案说法按时发噶双方大大的飒飒的华火腿加拿大和孤男寡女案说法按时发噶双方大大的飒飒的华火腿加拿大和孤男寡女案说法按时发噶双方阿斯蒂芬好几十是放大后东符合好几天金华火腿加拿大和孤男寡女案说法是放大后东符合好几天金华火腿加拿大和孤男寡女案说法是放大后突然回一趟家二姨家",2,2,
                "AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA","BBBBBBBBBB","CCCCCCCCCC","DDDDD","A");
        Question_MultiChoice test4= new Question_MultiChoice("暗示法撒旦分asdasdasd萨德嘎哈改进改进阿斯顿发阿打孤男寡女案说法按时发噶双方大大的飒飒的华火腿加拿大和孤男寡女案说法按时发噶双方大大的飒飒的华火腿加拿大和孤男寡女案说法按时发噶双方大大的飒飒的华火腿加拿大和孤男寡女案说法按时发噶双方大大的飒飒的华火腿加拿大和孤男寡女案说法按时发噶双方大大的飒飒的华火腿加拿大和孤男寡女案说法按时发噶双方大大的飒飒的华火腿加拿大和孤男寡女案说法按时发噶双方大大的飒飒的华火腿加拿大和孤男寡女案说法按时发噶双方大大的飒飒的华火腿加拿大和孤男寡女案说法按时发噶双方大大的飒飒的华火腿加拿大和孤男寡女案说法按时发噶双方大大的飒飒的华火腿加拿大和孤男寡女案说法按时发噶双方大大的飒飒的华火腿加拿大和孤男寡女案说法按时发噶双方阿斯蒂芬好几十是放大后东符合好几天金华火腿加拿大和孤男寡女案说法是放大后东符合好几天金华火腿加拿大和孤男寡女案说法是放大后突然回一趟家二姨家",2,2,
                "AAAAAAAAAAA","BBBBBBBBBB","CCCCCCCCCC","DDDDD","A");
        Question_Subjective test2 = new Question_Subjective("暗示法所大大所大所多",2,2,"按时打算大所大所多多撒多撒多所多撒");
        Question_Judge test3 = new Question_Judge("按时发生的更是给大使馆的范德萨发",2,2,"对");
        for (int i=1;i<4;i++){
            add(new ChoicePanel(test1,i));
        }
        add(new MultiChoicePanel(test4,4));
        for (int i=5;i<10;i++){
            add(new SubjectivePanel(test2,i));
        }
        add(new JudgePanel(test3,10));

        setVisible(true);
    }


    public Component add(Component comp){
        super.add(comp,new GBC(0,count,0,1).setFill(GridBagConstraints.BOTH).setInsets(10));
        count++;
        return comp;
    }
}
