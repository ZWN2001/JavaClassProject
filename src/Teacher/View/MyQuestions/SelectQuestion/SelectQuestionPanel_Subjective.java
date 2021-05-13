package Teacher.View.MyQuestions.SelectQuestion;

import Teacher.Function.ClientFuction.GetQuestionBank.GetQuestionBank_Subjective_C;
import Teacher.Util.Component.MyPanel.QuestionCards.Card_Select.QCard_Subjective_Select;
import Teacher.Util.Component.MyTextArea.MyTextArea_Warning;
import Teacher.Util.Layout.VFlowLayout;
import Teacher.View.MyPapers.AddPaperPanels.AddPaper.AddPaper_Self.AddPaperSelfPanel;
import Teacher.View.MyPapers.AddPaperPanels.AddPaper.AddPaper_Self.AddPaper_Self_CheckQuestion;
import Teacher.View.MyPapers.AddPaperPanels.AddPaper.AddPaper_Self.StatisticianPanel_Self;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class SelectQuestionPanel_Subjective extends JScrollPane {
    public SelectQuestionPanel_Subjective(){
      init();
    }
    public SelectQuestionPanel_Subjective(int location){
      init();
      getVerticalScrollBar().setValue(location);
    }
    public void init(){
        JPanel panel=new JPanel(new VFlowLayout());
        panel.setPreferredSize(new Dimension(950,700));
        try {
            GetQuestionBank_Subjective_C getQuestionBank_subjective_c=new GetQuestionBank_Subjective_C();
            int[] idList = getQuestionBank_subjective_c.getIdList();
            String[] stemList = getQuestionBank_subjective_c.getStemList();
            int[] markList = getQuestionBank_subjective_c.getMarkList();
            int[] difficulty = getQuestionBank_subjective_c.getDifficulty();
            String[] answerList = getQuestionBank_subjective_c.getAnswerList();
            panel.setPreferredSize(new Dimension(950,idList.length*400));
            if (idList.length>0) {
                for (int i = 0; i < idList.length; i++) {
                    QCard_Subjective_Select qCard_subjective_select = new QCard_Subjective_Select(idList[i], i + 1, stemList[i], markList[i], difficulty[i], answerList[i]);
                    panel.add(qCard_subjective_select);
                    if (!AddPaperSelfPanel.statistician.getMySubjective().isEmpty()){
                        if (AddPaperSelfPanel.statistician.getMySubjectiveIDList().contains((Integer)(idList[i]))){
                            qCard_subjective_select.isSelected.setSelected(true);
                        }
                    }
                    int finalI = i;
                    qCard_subjective_select.isSelected.addItemListener(e -> {
                        if (qCard_subjective_select.isSelected.isSelected()) {
                            if (!AddPaperSelfPanel.statistician.getMySubjective().contains((Integer)qCard_subjective_select.getQid())) {
                                AddPaperSelfPanel.statistician.addMySubjective(qCard_subjective_select.getQid());
                                AddPaperSelfPanel.statistician.addMySubjectiveIDList(qCard_subjective_select.getId());
                                AddPaperSelfPanel.statistician.addChoseNum();
                                AddPaperSelfPanel.statistician.difficulty_add(qCard_subjective_select.getDifficulty());
                                AddPaperSelfPanel.statistician.addMark(markList[finalI]);
                                AddPaperSelfPanel.container2.removeAll();
                                AddPaperSelfPanel.statisticianPanel=new StatisticianPanel_Self(AddPaperSelfPanel.statistician);
                                AddPaperSelfPanel.container2.add(AddPaperSelfPanel.statisticianPanel);
                                AddPaperSelfPanel.statisticianPanel.repaint();
                                AddPaperSelfPanel.statisticianPanel.updateUI();
                            }
                        } else {
                            if (AddPaperSelfPanel.statistician.getMySubjective().contains((Integer)qCard_subjective_select.getQid())) {
                               AddPaperSelfPanel.statistician.removeSubjective(qCard_subjective_select.getQid());
                                AddPaperSelfPanel.statistician.removeSubjectiveIDList(qCard_subjective_select.getId());
                                AddPaperSelfPanel.statistician.removeChoseNum();
                                AddPaperSelfPanel.statistician.difficulty_reduce(qCard_subjective_select.getDifficulty());
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
