package Teacher.View.MyQuestions.SelectQuestion;

import Teacher.Function.ClientFuction.GetQuestionBank.GetQuestionBank_MultiChoice_C;
import Teacher.Util.Component.MyPanel.QuestionCards.Card_Select.QCard_MultiChoice_Select;
import Teacher.Util.Component.MyTextArea.MyTextArea_Warning;
import Teacher.Util.Layout.VFlowLayout;
import Teacher.View.MyPapers.AddPaperPanels.AddPaper.AddPaper_Self.AddPaperSelfPanel;
import Teacher.View.MyPapers.AddPaperPanels.AddPaper.AddPaper_Self.AddPaper_Self_CheckQuestion;
import Teacher.View.MyPapers.AddPaperPanels.AddPaper.AddPaper_Self.StatisticianPanel_Self;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class SelectQuestionPanel_MultiChoice extends JScrollPane {
    public SelectQuestionPanel_MultiChoice(){
     init();
    }
    public SelectQuestionPanel_MultiChoice(int location){
        init();
        getVerticalScrollBar().setValue(location);
    }

    public void init(){
        JPanel panel=new JPanel(new VFlowLayout());
        panel.setPreferredSize(new Dimension(950,700));
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
            panel.setPreferredSize(new Dimension(950,idList.length*250));
            if (idList.length>0) {
                for (int i = 0; i < idList.length; i++) {
                    QCard_MultiChoice_Select qCard_multiChoice_select = new QCard_MultiChoice_Select(idList[i], i + 1, stemList[i], optionA_List[i], optionB_List[i], optionC_List[i], optionD_List[i], markList[i], difficulty[i], answerList[i]);
                    panel.add(qCard_multiChoice_select);
                    if (!AddPaperSelfPanel.statistician.getMyMultiChoice().isEmpty()){
                        if (AddPaperSelfPanel.statistician.getMyMultiChoiceIDList().contains((Integer)(idList[i]))){
                            qCard_multiChoice_select.isSelected.setSelected(true);
                        }
                    }
                    int finalI = i;
                    qCard_multiChoice_select.isSelected.addItemListener(e -> {
                        if (qCard_multiChoice_select.isSelected.isSelected()) {
                            if (!AddPaperSelfPanel.statistician.getMyMultiChoice().contains((Integer)qCard_multiChoice_select.getQid())) {
                                AddPaperSelfPanel.statistician.addMyMultiChoice(qCard_multiChoice_select.getQid());
                                AddPaperSelfPanel.statistician.addMyMultiChoiceIDList(qCard_multiChoice_select.getId());
                                AddPaperSelfPanel.statistician.addChoseNum();
                                AddPaperSelfPanel.statistician.difficulty_add(qCard_multiChoice_select.getDifficulty());
                                AddPaperSelfPanel.statistician.addMark(markList[finalI]);
                                AddPaperSelfPanel.container2.removeAll();
                                AddPaperSelfPanel.statisticianPanel=new StatisticianPanel_Self(AddPaperSelfPanel.statistician);
                                AddPaperSelfPanel.container2.add(AddPaperSelfPanel.statisticianPanel);
                                AddPaperSelfPanel.statisticianPanel.repaint();
                                AddPaperSelfPanel.statisticianPanel.updateUI();
                            }
                        } else {
                            if (AddPaperSelfPanel.statistician.getMyMultiChoice().contains((Integer)qCard_multiChoice_select.getQid())) {
                                AddPaperSelfPanel.statistician.removeMultiChoice((Integer) qCard_multiChoice_select.getQid());
                                AddPaperSelfPanel.statistician.removeMultiChoiceIDList(qCard_multiChoice_select.getId());
                                AddPaperSelfPanel.statistician.removeChoseNum();
                                AddPaperSelfPanel.statistician.difficulty_reduce(qCard_multiChoice_select.getDifficulty());
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
