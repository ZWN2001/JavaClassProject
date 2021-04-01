package Student.Panel;

import Teacher.Util.GBC;

import javax.swing.*;
import java.awt.*;

public class ExamPanel extends JPanel {
    public ExamPanel(){
        setBackground(Color.WHITE);
        GridLayout exGrid = new GridLayout(0,1,10,10);
        setLayout(exGrid);
        ExExPanel exTest = new ExExPanel();
        ExExPanel exTest1 = new ExExPanel();        ExExPanel exTest2 = new ExExPanel();        ExExPanel exTest3 = new ExExPanel();         ExExPanel exTest4 = new ExExPanel();        ExExPanel exTest5 = new ExExPanel();
        add(exTest);
        add(exTest1);add(exTest2);add(exTest3);add(exTest4);add(exTest5);
        setVisible(false);
    }
}
