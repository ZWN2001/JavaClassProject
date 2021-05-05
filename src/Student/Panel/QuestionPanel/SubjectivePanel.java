package Student.Panel.QuestionPanel;

import Student.Function.MyScrollBarUI;
import Teacher.Bean.Question.Question_Subjective;
import Teacher.Util.AdapterAndHelper.GBC;

import javax.swing.*;
import java.awt.*;

public class SubjectivePanel extends QuestionPanel{
    public SubjectivePanel(Question_Subjective question,int num){
        super(question,num);
        JLabel label = new JLabel("请在下面答题框中作答");
        label.setFont(new Font("微软雅黑",Font.BOLD,12));

        JTextArea answerArea = new JTextArea("",0,50);
        JScrollPane answerPane = new JScrollPane(answerArea,ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED,ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        /*设置UI
        JScrollBar bar = answerPane.getVerticalScrollBar();
        bar.setUI(new MyScrollBarUI(16));*/
        answerPane.setPreferredSize(new Dimension(1200,200));
        answerArea.setFont(new Font("宋体",Font.BOLD,20));
        answerArea.setLineWrap(true);
        answerArea.setEditable(true);
        add(label,new GBC(1,2,10,1).setAnchor(GridBagConstraints.WEST));
        add(answerPane,new GBC(1,3,1,1).setAnchor(GridBagConstraints.WEST));
    }
}
