package Teacher.Util.Component.MyPanel.QuestionCards.Card_Check;

import Teacher.Util.Component.MyPanel.QuestionCardUtils.QCard_AnswerAreas.QCard_AnswerArea_Choice;
import Teacher.Util.Component.MyPanel.QuestionCardUtils.QCard_Titles.QuestionCard_CheckTitle;
import Teacher.Util.Component.MyPanel.QuestionCardUtils.QuestionCard_Stem;
import Teacher.Util.Layout.VFlowLayout;
import Teacher.View.HomePanels.HomeFrame;
import Teacher.View.MyQuestions.AlterQuestion.AlterQuestion_Choice;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class QCard_Choice_Check extends JPanel {
    public QuestionCard_CheckTitle checkTitle;
    QuestionCard_Stem stemArea;
    QCard_AnswerArea_Choice answerArea;
 int id;
    int qid;
    String stem;
    String optionA;
    String optionB;
    String optionC;
    String optionD;
    int mark;
    int difficulty;
    String answer;

    public QCard_Choice_Check(int id,int qid,String stem,String optionA,String optionB,String optionC,String optionD,int mark,int difficulty,String answer){
       this.id=id;
        this.qid=qid;
        this.stem=stem;
        this.optionA=optionA;
        this.optionB=optionB;
        this.optionC=optionC;
        this.optionD=optionD;
        this.mark=mark;
        this.difficulty=difficulty;
        this.answer=answer;
        checkTitle=new QuestionCard_CheckTitle(qid,mark,difficulty,answer);
        stemArea=new QuestionCard_Stem(stem);
        answerArea=new QCard_AnswerArea_Choice(optionA,optionB,optionC,optionD);
        this.stem=stem;
        setLayout(new VFlowLayout(true,true));
        Border border=getBorder();
        Border margin = new EmptyBorder(4,10,8,10);//边距设置
        setBorder(new CompoundBorder(border, margin));//加到组件上
        add(checkTitle);
        add(stemArea);
        add(answerArea);
        checkTitle.change.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                HomeFrame.content.removeAll();
                HomeFrame.content.add(new AlterQuestion_Choice(id,stem,optionA,optionB,optionC,optionD,difficulty,mark,answer));
                HomeFrame.content.repaint();
                HomeFrame.content.updateUI();
            }
        });
    }

    public int getId(){
        return id;
    }

    public int getQid() {
        return qid;
    }

    public void removeBtn(){
        QCard_Choice_Check.this.checkTitle.remove(checkTitle.change);
    }
}
