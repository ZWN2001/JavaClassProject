package Teacher.View.MyQuestions.SelectQuestion;

import Teacher.Function.ClientFuction.GetQuestionBank.GetQuestionBank_Choice_C;
import Teacher.Util.Component.MyPanel.QuestionCards.Card_Select.QCard_Choice_Select;
import Teacher.Util.Component.MyTextArea.MyTextArea_Warning;
import Teacher.Util.Layout.VFlowLayout;
import Teacher.View.MyPapers.AddPaperPanels.AddPaper.AddPaper_Self.AddPaperSelfPanel;
import Teacher.View.MyPapers.AddPaperPanels.AddPaper.AddPaper_Self.AddPaper_Self_CheckQuestion;
import Teacher.View.MyPapers.AddPaperPanels.AddPaper.AddPaper_Self.StatisticianPanel_Self;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.IOException;

public class SelectQuestionPanel_Choice extends JScrollPane{

    int i;
    public SelectQuestionPanel_Choice(){
     init();
    }
    public SelectQuestionPanel_Choice(int locate){
        init();
        getVerticalScrollBar().setValue(locate);
    }

    public void init(){
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
            panel.setPreferredSize(new Dimension(940,idList.length*350));
            if (idList.length>0) {
                for (  i = 0; i < idList.length; i++) {
                  QCard_Choice_Select  qCard_choice_select = new QCard_Choice_Select(idList[i], i + 1, stemList[i], optionA_List[i], optionB_List[i], optionC_List[i], optionD_List[i], markList[i], difficulty[i], answerList[i]);
                    panel.add(qCard_choice_select);
                       if (!AddPaperSelfPanel.statistician.getMyChoice().isEmpty()){
                        if (AddPaperSelfPanel.statistician.getMyChoiceIDList().contains(qCard_choice_select.getId())){
                            System.out.println(qCard_choice_select.getId());
                            qCard_choice_select.isSelected.setSelected(true);
                        }
                   }

                    qCard_choice_select.isSelected.addItemListener(e -> {
                        if (qCard_choice_select.isSelected.isSelected()) {
                            if (!AddPaperSelfPanel.statistician.getMyChoiceIDList().contains(qCard_choice_select.getId())) {
                                AddPaperSelfPanel.statistician.addMyChoice(qCard_choice_select.getQid());
                                AddPaperSelfPanel.statistician.addMyChoiceIDList(qCard_choice_select.getId());
                                AddPaperSelfPanel.statistician.addChoseNum();
                                AddPaperSelfPanel.statistician.difficulty_add(qCard_choice_select.getDifficulty());
                                AddPaperSelfPanel.statistician.addMark(qCard_choice_select.getMark());
                                AddPaperSelfPanel.container2.removeAll();
                                AddPaperSelfPanel.statisticianPanel=new StatisticianPanel_Self(AddPaperSelfPanel.statistician);
                                AddPaperSelfPanel.container2.add(AddPaperSelfPanel.statisticianPanel);
                                AddPaperSelfPanel.statisticianPanel.repaint();
                                AddPaperSelfPanel.statisticianPanel.updateUI();
                            }
                        }
                        else {
                            if (AddPaperSelfPanel.statistician.getMyChoiceIDList().contains(qCard_choice_select.getId())) {
                                AddPaperSelfPanel.statistician.removeChoice( qCard_choice_select.getQid());
                                AddPaperSelfPanel.statistician.removeChoiceIDList(qCard_choice_select.getId());
                                AddPaperSelfPanel.statistician.removeChoseNum();
                                AddPaperSelfPanel.statistician.difficulty_reduce(qCard_choice_select.getDifficulty());
                                AddPaperSelfPanel.statistician.reduceMark(qCard_choice_select.getMark());
                                AddPaperSelfPanel.container2.removeAll();
                                AddPaperSelfPanel.statisticianPanel=new StatisticianPanel_Self(AddPaperSelfPanel.statistician);
                                AddPaperSelfPanel.container2.add(AddPaperSelfPanel.statisticianPanel);
                                AddPaperSelfPanel.statisticianPanel.repaint();
                                AddPaperSelfPanel.statisticianPanel.updateUI();
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
        getVerticalScrollBar().addVetoableChangeListener(evt -> {
            AddPaper_Self_CheckQuestion.listener.setScrollBarLocation(getVerticalScrollBar().getValue());
        });
    }
}
