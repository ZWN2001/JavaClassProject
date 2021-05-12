package Teacher.Util.Component.MyPanel.QuestionCards.Card_Check;

import Teacher.Util.Component.MyPanel.QuestionCardUtils.QCard_AnswerAreas.QCard_AnswerArea_Judge;
import Teacher.Util.Component.MyPanel.QuestionCardUtils.QCard_Titles.QuestionCard_CheckTitle;
import Teacher.Util.Component.MyPanel.QuestionCardUtils.QuestionCard_Stem;
import Teacher.Util.Layout.VFlowLayout;
import Teacher.View.HomePanels.HomeFrame;
import Teacher.View.MyQuestions.AlterQuestion.AlterQuestion_Choice;
import Teacher.View.MyQuestions.AlterQuestion.AlterQuestion_Judge;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class QCard_Judge_Check extends JPanel {
    public QuestionCard_CheckTitle checkTitle;
    QuestionCard_Stem stemArea;
    QCard_AnswerArea_Judge answerArea;

    int id;
    int qid;
    String stem;
    int mark;
    int difficulty;
    String answer;

    public QCard_Judge_Check(int id,int qid,String stem,int mark,int difficulty,String answer){
        this.id=id;
        this.qid=qid;
        this.stem=stem;
        this.mark=mark;
        this.difficulty=difficulty;
        this.answer=answer;
        setLayout(new VFlowLayout());
        Border border=getBorder();
        Border margin = new EmptyBorder(4,10,8,10);//边距设置
        setBorder(new CompoundBorder(border, margin));//加到组件上
        checkTitle=new QuestionCard_CheckTitle(qid,mark,difficulty,answer);
        stemArea=new QuestionCard_Stem(stem);
        answerArea=new QCard_AnswerArea_Judge();
        add(checkTitle);
        add(stemArea);
        add(answerArea);
        checkTitle.change.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                HomeFrame.content.removeAll();
                HomeFrame.content.add(new AlterQuestion_Judge(id,stem,difficulty,mark,answer));
                HomeFrame.content.repaint();
                HomeFrame.content.updateUI();
            }
        });
    }
    public int getId(){
        return id;
    }
    public void removeBtn(){
        QCard_Judge_Check.this.checkTitle.remove(checkTitle.change);
    }
}
