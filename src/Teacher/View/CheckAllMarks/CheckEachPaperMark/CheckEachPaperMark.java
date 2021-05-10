package Teacher.View.CheckAllMarks.CheckEachPaperMark;

import Teacher.View.MyQuestions.CheckQuestions.CheckQuestionPanel_Choice;
import Teacher.View.MyQuestions.CheckQuestions.CheckQuestionPanel_Judge;
import Teacher.View.MyQuestions.CheckQuestions.CheckQuestionPanel_MultiChoice;
import Teacher.View.MyQuestions.CheckQuestions.CheckQuestionPanel_Subjective;

import javax.swing.*;
import java.awt.*;

public class CheckEachPaperMark extends JPanel {
    public CheckEachPaperMark(int paperID){
        setLayout(new BorderLayout());
        JTabbedPane pane=new JTabbedPane();
        pane.addTab("成绩单",new CheckEachPaperMark_List(paperID));
        pane.addTab("统计图",new CheckEachPaperMark_Chart(paperID));
        add(pane);
    }
}
