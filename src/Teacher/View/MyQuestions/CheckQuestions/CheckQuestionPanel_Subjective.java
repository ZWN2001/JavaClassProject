package Teacher.View.MyQuestions.CheckQuestions;

import Teacher.Function.ClientFuction.GetQuestionBank.GetQuestionBank_Subjective_C;
import Teacher.Util.Component.MyPanel.QuestionCards.Card_Check.QCard_Judge_Check;
import Teacher.Util.Component.MyTextArea.MyTextArea_Warning;
import Teacher.Util.Layout.VFlowLayout;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class CheckQuestionPanel_Subjective extends JScrollPane {
    public CheckQuestionPanel_Subjective(){
        JPanel panel=new JPanel(new VFlowLayout());
        try {
            GetQuestionBank_Subjective_C getQuestionBank_subjective_c=new GetQuestionBank_Subjective_C();
            int[] idList = getQuestionBank_subjective_c.getIdList();
            String[] stemList = getQuestionBank_subjective_c.getStemList();
            int[] markList = getQuestionBank_subjective_c.getMarkList();
            int[] difficulty = getQuestionBank_subjective_c.getDifficulty();
            String[] answerList = getQuestionBank_subjective_c.getAnswerList();
            panel.setPreferredSize(new Dimension(950,400*idList.length));
            if (idList.length>0) {
                for (int i = 0; i < idList.length; i++) {
                    QCard_Judge_Check panel1 = new QCard_Judge_Check(idList[i], i + 1, stemList[i], markList[i], difficulty[i], answerList[i]);
                    panel.add(panel1);
                }
            }else {
                panel.add(new MyTextArea_Warning(1,10,"提示","暂无数据"));
            }
        }catch (IOException ex){
            panel.add(new MyTextArea_Warning(1,10,"错误","加载失败"));
            ex.printStackTrace();
        }
        getViewport().add(panel);

    }
}
