package Student.Panel;

import Student.Function.TestTimerLabel;

import javax.swing.*;
import java.util.Timer;

public class PaperPanel extends JPanel {
    public PaperPanel(){
        TestTimerLabel timerLabel = new TestTimerLabel(2,0,0);
        add(timerLabel);
        java.util.Timer timer = new Timer();
        timer.schedule(timerLabel.getTimeTask(),0,1000);
    }
}
