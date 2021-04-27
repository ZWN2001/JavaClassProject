package Teacher.Util.Component.MyPanel.QuestionCards.Card_Check;

import Teacher.Util.Component.MyPanel.QuestionCardUtils.QCard_AnswerAreas.QCard_AnswerArea_Subjective;
import Teacher.Util.Component.MyPanel.QuestionCardUtils.QCard_Titles.QuestionCard_CheckTitle;
import Teacher.Util.Component.MyPanel.QuestionCardUtils.QuestionCard_Stem;
import Teacher.Util.Layout.VFlowLayout;

import javax.swing.*;

public class QCard_Subjective_Check extends JPanel {
    QuestionCard_CheckTitle checkTitle;
    QuestionCard_Stem stemArea;
    QCard_AnswerArea_Subjective answerArea;
    int id;
    int qid;
    String stem;
    int mark;
    int difficulty;
    String answer;

    public QCard_Subjective_Check(int id,int qid,String stem,int mark,int difficulty,String answer){
        this.id=id;
        this.qid=qid;
        this.stem=stem;
        this.mark=mark;
        this.difficulty=difficulty;
        this.answer=answer;
        setLayout(new VFlowLayout(true,true));
      checkTitle=new QuestionCard_CheckTitle(qid, mark, difficulty, "见下框");
      stemArea=new QuestionCard_Stem(stem);
      answerArea=new QCard_AnswerArea_Subjective(answer);
        add(checkTitle);
        add(stemArea);
        add(answerArea);
    }
    public int getId(){
        return id;
    }
}
