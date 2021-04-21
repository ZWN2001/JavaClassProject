package Student.Panel;

import Student.Function.MyScrollBarUI;

import javax.swing.*;

public class ExamJSP extends JScrollPane {
    private final ExamPanel examPanel;

    public ExamJSP(ExamPanel examPanel) {
        super(examPanel, VERTICAL_SCROLLBAR_ALWAYS, HORIZONTAL_SCROLLBAR_NEVER);
        this.examPanel = examPanel;
        JScrollBar bar = getVerticalScrollBar();
        bar.setUnitIncrement(20);
        bar.setUI(new MyScrollBarUI());
        setBounds(250, 0, 1345, 860);
        setBorder(null);
        setVisible(false);
    }

    public void setVisible(boolean visible) {
        super.setVisible(visible);
        examPanel.setVisible(visible);
    }
}
