package Teacher.Util.Component.MyPanel.QuestionCardUtils.QCard_AnswerAreas;

import Teacher.Util.Component.MyTextArea.MyTextArea_Normal;
import Teacher.Util.Layout.VFlowLayout;

import javax.swing.*;

public class QCard_AnswerArea_Subjective extends JPanel {
String answerText=" ";
public QCard_AnswerArea_Subjective(String answerText){
    this.answerText=answerText;
    setLayout(new VFlowLayout(true,true));
    MyTextArea_Normal answer=new MyTextArea_Normal(4,getWidth(),"答案样例：",answerText);
    add(answer);
}
    public QCard_AnswerArea_Subjective(){
        setLayout(new VFlowLayout(true,true));
        MyTextArea_Normal answerArea=new MyTextArea_Normal(4,getWidth(),"作答：");
        add(answerArea);
    }
}
