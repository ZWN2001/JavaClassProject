package Teacher.View.MyQuestions.CheckQuestions;

import Teacher.Function.ClientFuction.GetQuestionBank.GetQuestionBank_Choice_C;
import Teacher.Util.Component.MyPanel.QuestionCards.Card_Check.QCard_Choice_Check;
import Teacher.Util.Component.MyTextArea.MyTextArea_Warning;
import Teacher.Util.Layout.VFlowLayout;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class CheckQuestionPanel_Choice extends JScrollPane {

    public CheckQuestionPanel_Choice(){
            JPanel panel=new JPanel(new VFlowLayout());
            try {
                GetQuestionBank_Choice_C getQuestionBank_choice_c=new GetQuestionBank_Choice_C();
                int[] idList = getQuestionBank_choice_c.getIdList();
                String[] stemList = getQuestionBank_choice_c.getStemList();
                String[] optionA_List = getQuestionBank_choice_c.getOptionA_List();
                String[] optionB_List = getQuestionBank_choice_c.getOptionB_List();
                String[] optionC_List = getQuestionBank_choice_c.getOptionC_List();
                String[] optionD_List = getQuestionBank_choice_c.getOptionD_List();
                int[] markList = getQuestionBank_choice_c.getMarkList();
                int[] difficulty = getQuestionBank_choice_c.getDifficulty();
                String[] answerList = getQuestionBank_choice_c.getAnswerList();
               panel.setPreferredSize(new Dimension(950,350*idList.length));
                if (idList.length>0) {
                    for (int i = 0; i < idList.length; i++) {
                        QCard_Choice_Check panel1 = new QCard_Choice_Check(idList[i], i + 1, stemList[i], optionA_List[i], optionB_List[i], optionC_List[i], optionD_List[i], markList[i], difficulty[i], answerList[i]);
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
