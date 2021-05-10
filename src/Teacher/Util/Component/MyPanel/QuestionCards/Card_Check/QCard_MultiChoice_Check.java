package Teacher.Util.Component.MyPanel.QuestionCards.Card_Check;

import Teacher.Util.AdapterAndHelper.MultiAnswerUtil;
import Teacher.Util.Component.MyPanel.QuestionCardUtils.QCard_AnswerAreas.QCard_AnswerArea_Choice;
import Teacher.Util.Component.MyPanel.QuestionCardUtils.QCard_AnswerAreas.QCard_AnswerArea_MultiChoice;
import Teacher.Util.Component.MyPanel.QuestionCardUtils.QCard_Titles.QuestionCard_CheckTitle;
import Teacher.Util.Component.MyPanel.QuestionCardUtils.QuestionCard_Stem;
import Teacher.Util.Layout.VFlowLayout;
import Teacher.View.HomePanels.HomeFrame;
import Teacher.View.MyQuestions.AlterQuestion.AlterQuestion_Choice;
import Teacher.View.MyQuestions.AlterQuestion.AlterQuestion_MultiChoice;
import com.alibaba.fastjson.JSON;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Arrays;

public class QCard_MultiChoice_Check extends JPanel {
    public QuestionCard_CheckTitle checkTitle;
    QuestionCard_Stem stemArea;
    QCard_AnswerArea_MultiChoice answerArea;

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

    public QCard_MultiChoice_Check(int id,int qid,String stem,String optionA,String optionB,String optionC,String optionD,int mark,int difficulty,String answer){
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
        String answer1= MultiAnswerUtil.getAnswerFromString(Arrays.toString(JSON.parseObject(answer, String[].class)));
        checkTitle=new QuestionCard_CheckTitle(qid,mark,difficulty,answer1);
        stemArea=new QuestionCard_Stem(stem);
        answerArea=new QCard_AnswerArea_MultiChoice(optionA,optionB,optionC,optionD);
        this.stem=stem;
        setLayout(new VFlowLayout(true,true));
        add(checkTitle);
        add(stemArea);
        add(answerArea);
        checkTitle.change.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                HomeFrame.content.removeAll();
                HomeFrame.content.add(new AlterQuestion_MultiChoice(id,stem,optionA,optionB,optionC,optionD,difficulty,mark,answer));
                HomeFrame.content.repaint();
                HomeFrame.content.updateUI();
            }
        });
    }
    public int getId(){
        return id;
    }
    public void removeBtn(){
        QCard_MultiChoice_Check.this.checkTitle.remove(checkTitle.change);
    }
}
