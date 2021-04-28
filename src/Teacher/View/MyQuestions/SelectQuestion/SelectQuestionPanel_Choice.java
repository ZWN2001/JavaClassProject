package Teacher.View.MyQuestions.SelectQuestion;

import Teacher.Function.GetQuestionBank.GetQuestionBank_Choice_C;
import Teacher.Util.Component.MyPanel.QuestionCards.Card_Select.QCard_Choice_Select;
import Teacher.Util.Component.MyTextArea.MyTextArea_Warning;
import Teacher.Util.Layout.VFlowLayout;
import Teacher.View.MyPapers.AddPaperPanels.AddPaper_Self.AddPaper_Self;
import Teacher.View.MyPapers.AddPaperPanels.MyTabbedPane_AddPaper;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.IOException;

public class SelectQuestionPanel_Choice extends JScrollPane{
    public SelectQuestionPanel_Choice(){
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
            if (idList.length>0) {
                for (int i = 0; i < idList.length; i++) {
                    QCard_Choice_Select panel1 = new QCard_Choice_Select(idList[i], i + 1, stemList[i], optionA_List[i], optionB_List[i], optionC_List[i], optionD_List[i], markList[i], difficulty[i], answerList[i]);
                    panel.add(panel1);
                    panel1.isSelected.addItemListener(e -> {
                        if (panel1.isSelected.isSelected()) {
                            System.out.println("choice"+MyTabbedPane_AddPaper.statistician.getMyChoice());
                            MyTabbedPane_AddPaper.statistician.addMyChoice(panel1.getId());
                            MyTabbedPane_AddPaper.statisticianPanel.updateUI();
                        } else {
                            if (MyTabbedPane_AddPaper.statistician.getMyChoice().contains((Integer)panel1.getId())) {
                                MyTabbedPane_AddPaper.statistician.removeChoice((Integer) panel1.getId());
                                System.out.println("choice"+MyTabbedPane_AddPaper.statistician.getMyChoice());
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
