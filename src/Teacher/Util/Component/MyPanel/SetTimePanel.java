package Teacher.Util.Component.MyPanel;

import javax.swing.*;
import java.text.SimpleDateFormat;

public class SetTimePanel extends JPanel {
    private int year, month, day, hour, minute, second;
    private int i;
    JComboBox<Integer> chooseYear;
    JComboBox<Integer> chooseMonth;
    JComboBox chooseDay;
    JComboBox chooseHour;
    JComboBox chooseMinute;
    JComboBox chooseSecond;

    public SetTimePanel() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String nowTime = simpleDateFormat.format(System.currentTimeMillis());
        year = Integer.parseInt(nowTime.substring(0, 4));
        month = Integer.parseInt(nowTime.substring(5, 7));
        day = Integer.parseInt(nowTime.substring(8, 10));
        hour = Integer.parseInt(nowTime.substring(11, 13));
        minute = Integer.parseInt(nowTime.substring(14, 16));
        second = Integer.parseInt(nowTime.substring(17, 19));
        System.out.println(nowTime);
        System.out.println(month);
        System.out.println(day);
        System.out.println(hour);
        System.out.println(minute);
        System.out.println(second);
        chooseYear = new JComboBox<Integer>();
        for (i = 0; i < 5; i++) {
            chooseYear.addItem(year++);
        }
        chooseMonth = new JComboBox<Integer>();
        for (i = 1; i < 13; i++) {
            chooseMonth.addItem(i);
        }
//        chooseDay=new JComboBox();
//        for ()
//        }

    }
}

