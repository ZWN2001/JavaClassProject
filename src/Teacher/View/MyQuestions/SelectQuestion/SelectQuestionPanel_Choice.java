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
import java.io.IOException;

public class SelectQuestionPanel_Choice extends JScrollPane{
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
                for ( int i = 0; i < idList.length; i++) {
                    QCard_Choice_Select panel1 = new QCard_Choice_Select(idList[i], i + 1, stemList[i], optionA_List[i], optionB_List[i], optionC_List[i], optionD_List[i], markList[i], difficulty[i], answerList[i]);
                    panel.add(panel1);
                        if (!AddPaperSelfPanel.statistician.getMyChoice().isEmpty()){
                        if (AddPaperSelfPanel.statistician.getMyChoice().contains((Integer)(idList[i]))){
                            panel1.isSelected.setSelected(true);
                        }
                    }

                    int finalI = i;
                    panel1.isSelected.addItemListener(e -> {
                        if (panel1.isSelected.isSelected()) {
                            if (!AddPaperSelfPanel.statistician.getMyChoice().contains((Integer)panel1.getQid())) {
                                AddPaperSelfPanel.statistician.addMyChoice(panel1.getQid());
                                AddPaperSelfPanel.statistician.addMyChoiceIDList(panel1.getId());
                                AddPaperSelfPanel.statistician.addChoseNum();
                                AddPaperSelfPanel.statistician.difficulty_add(panel1.getDifficulty());
                                AddPaperSelfPanel.statistician.addMark(markList[finalI]);
                                AddPaperSelfPanel.container2.removeAll();
                                AddPaperSelfPanel.statisticianPanel=new StatisticianPanel_Self(AddPaperSelfPanel.statistician);
                                AddPaperSelfPanel.container2.add(AddPaperSelfPanel.statisticianPanel);
                                AddPaperSelfPanel.statisticianPanel.repaint();
                                AddPaperSelfPanel.statisticianPanel.updateUI();
                            }
                        }
                        else {
                            if (AddPaperSelfPanel.statistician.getMyChoice().contains((Integer)panel1.getQid())) {
                                AddPaperSelfPanel.statistician.removeChoice((Integer) panel1.getQid());
                                AddPaperSelfPanel.statistician.removeChoiceIDList(panel1.getId());
                                AddPaperSelfPanel.statistician.removeChoseNum();
                                AddPaperSelfPanel.statistician.difficulty_reduce(panel1.getDifficulty());
                                AddPaperSelfPanel.statistician.reduceMark(markList[finalI]);
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
