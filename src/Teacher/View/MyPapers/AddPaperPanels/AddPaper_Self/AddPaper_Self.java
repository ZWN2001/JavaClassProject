package Teacher.View.MyPapers.AddPaperPanels.AddPaper_Self;

import Teacher.Bean.Statistician;
import Teacher.Util.Layout.VFlowLayout;
import Teacher.Util.MyColor;
import Teacher.View.MyQuestions.SelectQuestion.SelectQuestionPanel_Choice;
import Teacher.View.MyQuestions.SelectQuestion.SelectQuestionPanel_Judge;
import Teacher.View.MyQuestions.SelectQuestion.SelectQuestionPanel_MultiChoice;
import Teacher.View.MyQuestions.SelectQuestion.SelectQuestionPanel_Subjective;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

import static Teacher.Util.MyFont.Font_16;
import static Teacher.Util.MyFont.Font_20;

/**
 * @ClassName:
 * @Description: 手动出题的导航栏与tooltip
 * @parms:
 * @author 赵炜宁
 * @date 2021.4.27
 *
 */
public class AddPaper_Self extends JPanel {
    public AddPaper_Self(){
        setLayout(new BorderLayout());
        JTabbedPane pane=new JTabbedPane();
        pane.addTab("单选题",new SelectQuestionPanel_Choice());
        pane.addTab("多选题",new SelectQuestionPanel_MultiChoice());
        pane.addTab("判断题",new SelectQuestionPanel_Judge());
        pane.addTab("主观题",new SelectQuestionPanel_Subjective());
        add(pane);



//        toolBar=new JToolBar(SwingConstants.VERTICAL);
//        JLabel l1= new JLabel("已选"+choseNum+"题，共计"+allMark+"分，其中:");
//        l1.setFont(Font_20);
//        JLabel choiceSituation=new JLabel("选择题:"+myChoice);
//        choiceSituation.setFont(Font_16);
//        JLabel judgeSituation=new JLabel("判断题:"+myJudge);
//        judgeSituation.setFont(Font_16);
//        JLabel multiChoiceSituation=new JLabel("多选题:"+myMultiChoice);
//        multiChoiceSituation.setFont(Font_16);
//        JLabel subjectiveSituation=new JLabel("主观题:"+mySubjective);
//        subjectiveSituation.setFont(Font_16);
//        JLabel tip=new JLabel("本框可以拖出到主窗口哦");
//        tip.setFont(Font_20);
//        tip.setBackground(MyColor.AMBER_A700);
//        toolBar.add(l1);
//        toolBar.add(choiceSituation);
//        toolBar.add(judgeSituation);
//        toolBar.add(multiChoiceSituation);
//        toolBar.add(subjectiveSituation);
//        pane.addTab("选题情况",toolBar);
    }
}
