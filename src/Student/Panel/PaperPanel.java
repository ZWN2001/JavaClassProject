package Student.Panel;

import Student.Frame.MainFrame;
import Student.Function.*;

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

    public PaperPanel(MainFrame mainFrame) {
        paperJSP = new PaperJSP();
        add(paperJSP);
        this.mainFrame = mainFrame;

        setLayout(null);
        setBounds(0, 0, 1600, 860);
        add(new PaperRightPanel(this));
        setBackground(Color.white);


        setVisible(true);
        mainFrame.examStart(this);
    }

    public PaperJSP getPaperJSP() {
        return paperJSP;
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

        timerLabel = new TestTimerLabel(paperPanel,1, 0, 0);
        add(timerLabel);
        timerLabel.setBounds(50, 20, 200, 200);
        java.util.Timer timer = new Timer();
        timer.schedule(timerLabel.getTimeTask(), 0, 1000);
        setVisible(true);
    }


    @Override
    public void mouseClicked(MouseEvent e) {
        if (JOptionPane.showConfirmDialog(null, "确定要提交吗", "", JOptionPane.YES_NO_OPTION) == 0){
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
    }

}

class PaperLeftPanel extends JPanel {
    public PaperLeftPanel() {
        setBackground(Color.white);
        setLayout(new GridLayout(0, 1));
        for (int i = 0; i <= 50; i++)
            add(new JLabel("test1"));
        for (int i = 0; i <= 50; i++)
            add(new JLabel("test2"));
        setVisible(true);
    }

}
