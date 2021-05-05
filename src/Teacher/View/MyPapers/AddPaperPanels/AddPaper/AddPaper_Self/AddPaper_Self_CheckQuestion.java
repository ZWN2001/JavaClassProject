package Teacher.View.MyPapers.AddPaperPanels.AddPaper.AddPaper_Self;
import Teacher.View.MyQuestions.SelectQuestion.SelectQuestionPanel_Choice;
import Teacher.View.MyQuestions.SelectQuestion.SelectQuestionPanel_Judge;
import Teacher.View.MyQuestions.SelectQuestion.SelectQuestionPanel_MultiChoice;
import Teacher.View.MyQuestions.SelectQuestion.SelectQuestionPanel_Subjective;

import javax.swing.*;
import java.awt.*;


/**
 * @ClassName:
 * @Description: 手动出题的导航栏与tooltip
 * @parms:
 * @author 赵炜宁
 * @date 2021.4.27
 *
 */
public class AddPaper_Self_CheckQuestion extends JPanel {
    public static AddPaperSelfPanelListener listener=new AddPaperSelfPanelListener();
    public AddPaper_Self_CheckQuestion(){
        setLayout(new BorderLayout());
        JTabbedPane pane=new JTabbedPane();
        pane.addTab("单选题",new SelectQuestionPanel_Choice(listener.getScrollBarLocation()));
        pane.addTab("多选题",new SelectQuestionPanel_MultiChoice(listener.getScrollBarLocation()));
        pane.addTab("判断题",new SelectQuestionPanel_Judge(listener.getScrollBarLocation()));
        pane.addTab("主观题",new SelectQuestionPanel_Subjective(listener.getScrollBarLocation()));
        add(pane);
        pane.setSelectedIndex(listener.getIndex());
        pane.addChangeListener(e -> listener.setIndex(pane.getSelectedIndex()));
    }

}
