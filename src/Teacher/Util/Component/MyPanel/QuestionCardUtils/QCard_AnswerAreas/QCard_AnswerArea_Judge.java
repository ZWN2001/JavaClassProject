package Teacher.Util.Component.MyPanel.QuestionCardUtils.QCard_AnswerAreas;

import javax.swing.*;
import java.awt.*;

public class QCard_AnswerArea_Judge extends JPanel {
    public QCard_AnswerArea_Judge(){
        setLayout(new FlowLayout());
        setAlignmentX(FlowLayout.RIGHT);
        ButtonGroup optionsGroup=new ButtonGroup();
        JRadioButton T=new JRadioButton("T");
        JRadioButton F=new JRadioButton("F");
        optionsGroup.add(T);
        optionsGroup.add(F);
        add(T);
        add(F);
    }
}
