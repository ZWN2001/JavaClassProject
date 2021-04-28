package Teacher.View.MyQuestions.SelectQuestion;

import Teacher.Function.GetQuestionBank.GetQuestionBank_MultiChoice_C;
import Teacher.Util.Component.MyPanel.QuestionCards.Card_Check.QCard_MultiChoice_Check;
import Teacher.Util.Component.MyPanel.QuestionCards.Card_Select.QCard_MultiChoice_Select;
import Teacher.Util.Component.MyTextArea.MyTextArea_Warning;
import Teacher.Util.Layout.VFlowLayout;
import Teacher.View.MyPapers.AddPaperPanels.AddPaper_Self.AddPaper_Self;
import Teacher.View.MyPapers.AddPaperPanels.MyTabbedPane_AddPaper;

import javax.swing.*;
import java.io.IOException;

public class SelectQuestionPanel_MultiChoice extends JScrollPane {
    public SelectQuestionPanel_MultiChoice(){
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
            if (idList.length>0) {
                for (int i = 0; i < idList.length; i++) {
                    QCard_MultiChoice_Select panel1 = new QCard_MultiChoice_Select(idList[i], i + 1, stemList[i], optionA_List[i], optionB_List[i], optionC_List[i], optionD_List[i], markList[i], difficulty[i], answerList[i]);
                    panel.add(panel1);
                    panel1.isSelected.addItemListener(e -> {
                        if (panel1.isSelected.isSelected()) {
                            System.out.println("multiChoice"+ MyTabbedPane_AddPaper.statistician.getMyMultiChoice());
                            MyTabbedPane_AddPaper.statistician.addMyMultiChoice(panel1.getId());
                            MyTabbedPane_AddPaper.statisticianPanel.updateUI();
                        } else {
                            if (MyTabbedPane_AddPaper.statistician.getMyMultiChoice().contains((Integer)panel1.getId())) {
                                MyTabbedPane_AddPaper.statistician.removeMultiChoice((Integer) panel1.getId());
                                System.out.println("choice"+MyTabbedPane_AddPaper.statistician.getMyMultiChoice());
                                MyTabbedPane_AddPaper.statisticianPanel.updateUI();
                            }
                        }
                    });
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
