package Student.Function;

import javax.swing.*;
import java.awt.*;
import java.util.TimerTask;

public class TestTimerLabel extends JLabel {
    private int hour,min,sec;
    private String outTime="";
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
                    }
                }
            }
            outTime=String.format("%02d", hour)+":"+String.format("%02d", min)+":"+String.format("%02d", sec);
            setText(outTime);
        }
    };

    public TestTimerLabel(int hour, int min, int sec){
        super();
        this.hour=hour;
        this.min=min;
        this.sec=sec;
        setFont(new Font("微软雅黑",Font.BOLD,40));
        setText((outTime));
    }

    public TimerTask getTimeTask(){
        return timerTask;
    }
}
