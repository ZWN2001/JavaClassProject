package Student.Panel;

import Student.Function.MyScrollBarUI;

import javax.swing.*;
import java.awt.*;

public class GradeJSP extends JScrollPane {
    private final GradePanel gradePanel;

    public GradeJSP(GradePanel gradePanel) {
        super(gradePanel, VERTICAL_SCROLLBAR_ALWAYS, HORIZONTAL_SCROLLBAR_NEVER);
        this.gradePanel = gradePanel;
        JScrollBar bar = getVerticalScrollBar();
        bar.setUnitIncrement(20);
        bar.setUI(new MyScrollBarUI());
        setBounds(250, 0, 1345, 860);
        setBorder(null);
        setVisible(false);
    }

    public void refresh(){

    }

    public void setVisible(boolean visible) {
        super.setVisible(visible);
        gradePanel.setVisible(visible);
    }
}
