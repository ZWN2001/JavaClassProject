package Teacher.View.MyQuestions.CheckQuestions;

import Teacher.Function.GetQuestionBank.GetQuestionBank_Choice_C;
import Teacher.Function.GetQuestionBank.GetQuestionBank_Judge_C;
import Teacher.Util.Component.MyPanel.QuestionCards.Card_Check.QCard_Choice_Check;
import Teacher.Util.Component.MyPanel.QuestionCards.Card_Check.QCard_Judge_Check;
import Teacher.Util.Component.MyTextArea.MyTextArea_Warning;
import Teacher.Util.Layout.VFlowLayout;

import javax.swing.*;
import java.io.IOException;

public class CheckQuestionPanel_Judge extends JScrollPane {

    public CheckQuestionPanel_Judge(){
        JPanel panel=new JPanel(new VFlowLayout());
        try {
            GetQuestionBank_Judge_C getQuestionBank_judge_c=new GetQuestionBank_Judge_C();
            int[] idList = getQuestionBank_judge_c.getIdList();
            String[] stemList = getQuestionBank_judge_c.getStemList();
            int[] markList = getQuestionBank_judge_c.getMarkList();
            int[] difficulty = getQuestionBank_judge_c.getDifficulty();
            String[] answerList = getQuestionBank_judge_c.getAnswerList();
            if (idList.length>0) {
                for (int i = 0; i < idList.length; i++) {
                    QCard_Judge_Check panel1 = new QCard_Judge_Check(idList[i], i + 1, stemList[i], markList[i], difficulty[i], answerList[i]);
                    panel.add(panel1);
                }
            }else {
                panel.add(new MyTextArea_Warning(1,10,"提示","暂无数据"));
            }
        }catch (IOException ex){
            JOptionPane.showMessageDialog(this, "服务器不见了！", "Oops", JOptionPane.ERROR_MESSAGE);
            panel.add(new MyTextArea_Warning(1,10,"错误","加载失败"));
            ex.printStackTrace();
        }
        getViewport().add(panel);

    }
}
