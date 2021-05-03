package Student.Panel.QuestionPanel;

import Teacher.Bean.Question.Question;
import Teacher.Util.AdapterAndHelper.GBC;

import javax.swing.*;
import java.awt.*;

public abstract class QuestionPanel extends JPanel {
    protected Font font = new Font("微软雅黑",Font.PLAIN,25);
    public QuestionPanel(Question question, int num){
        setLayout(new GridBagLayout());
        setBackground(Color.white);
        JLabel numLabel = new JLabel(num+".  ");
        numLabel.setFont(font);
        JTextArea stemArea = new JTextArea(question.getStem(),0,50);
        stemArea.setLineWrap(true);
        stemArea.setEditable(false);
        stemArea.setBackground(this.getBackground());
        stemArea.setFont(font);
        add(numLabel,new GBC(0,0,1,1).setAnchor(GridBagConstraints.WEST));
        add(stemArea,new GBC(1,0,1,2).setAnchor(GridBagConstraints.WEST));

    }
}
