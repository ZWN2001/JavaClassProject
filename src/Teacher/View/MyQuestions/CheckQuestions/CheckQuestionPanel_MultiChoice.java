package Teacher.View.MyQuestions.CheckQuestions;

import Teacher.Function.ClientFuction.GetQuestionBank.GetQuestionBank_MultiChoice_C;
import Teacher.Util.Component.MyPanel.QuestionCards.Card_Check.QCard_MultiChoice_Check;
import Teacher.Util.Component.MyTextArea.MyTextArea_Warning;
import Teacher.Util.Layout.VFlowLayout;
import com.alibaba.fastjson.JSON;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.util.Arrays;

public class CheckQuestionPanel_MultiChoice extends JScrollPane {
    int i;
    QCard_MultiChoice_Check qCard_multiChoice_check;
    public CheckQuestionPanel_MultiChoice(){
        JPanel panel=new JPanel(new VFlowLayout());
        try {
            GetQuestionBank_MultiChoice_C getQuestionBank_multiChoice_c=new GetQuestionBank_MultiChoice_C();
            int[] idList = getQuestionBank_multiChoice_c.getIdList();
            String[] stemList = getQuestionBank_multiChoice_c.getStemList();
            String[] optionA_List = getQuestionBank_multiChoice_c.getOptionA_List();
            String[] optionB_List = getQuestionBank_multiChoice_c.getOptionB_List();
            String[] optionC_List = getQuestionBank_multiChoice_c.getOptionC_List();
            String[] optionD_List = getQuestionBank_multiChoice_c.getOptionD_List();
            int[] markList = getQuestionBank_multiChoice_c.getMarkList();
            int[] difficulty = getQuestionBank_multiChoice_c.getDifficulty();
            String[] answerList = getQuestionBank_multiChoice_c.getAnswerList();
            panel.setPreferredSize(new Dimension(950,350*idList.length));
            if (idList.length>0) {
                for ( i = 0; i < idList.length; i++) {
                    qCard_multiChoice_check = new QCard_MultiChoice_Check(idList[i], i + 1, stemList[i], optionA_List[i], optionB_List[i], optionC_List[i], optionD_List[i], markList[i], difficulty[i], Arrays.toString(JSON.parseObject(answerList[i], String[].class)));
                    panel.add(qCard_multiChoice_check);
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
