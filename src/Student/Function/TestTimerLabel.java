package Student.Function;

import Student.Panel.PaperPanel;

import javax.swing.*;
import java.awt.*;
import java.util.TimerTask;

public class TestTimerLabel extends JLabel {
    private int hour,min,sec;
    private String outTime="";
    private final PaperPanel paperPanel;
    private final TimerTask timerTask = new TimerTask() {
        @Override
        public void run() {
            sec--;
            if (sec<0){
                sec=59;
                min--;
                if (min<0){
                    min=59;
                    hour--;
                    if(hour < 0){
                        JOptionPane.showMessageDialog(null,"考试结束，已自动提交");
                        paperPanel.getUploadPaperDialog().dispose();
                        paperPanel.getMainFrame().examEnd(paperPanel);
                        cancel();
                    }
                }
            }
            String time = "%02d:%02d:%02d";
            outTime=String.format(time,hour,min,sec);
            setText(outTime);
        }
    };

    public TestTimerLabel(PaperPanel paperPanel,int hour, int min, int sec){
        super();
        this.paperPanel=paperPanel;
        this.hour=hour;
        this.min=min;
        this.sec=sec;
        setFont(new Font("微软雅黑",Font.BOLD,40));
        setText((outTime));
    }

    public TestTimerLabel(PaperPanel paperPanel,int min){
        this(paperPanel,min/60,min%60,0);
    }

    public TimerTask getTimeTask(){
        return timerTask;
    }
}
