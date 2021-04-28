package Teacher.View.MyQuestions.SelectQuestion;

import Teacher.Function.GetQuestionBank.GetQuestionBank_Subjective_C;
import Teacher.Util.Component.MyPanel.QuestionCards.Card_Check.QCard_Judge_Check;
import Teacher.Util.Component.MyPanel.QuestionCards.Card_Select.QCard_Judge_Select;
import Teacher.Util.Component.MyTextArea.MyTextArea_Warning;
import Teacher.Util.Layout.VFlowLayout;
import Teacher.View.MyPapers.AddPaperPanels.AddPaper_Self.AddPaper_Self;
import Teacher.View.MyPapers.AddPaperPanels.MyTabbedPane_AddPaper;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.io.IOException;

public class SelectQuestionPanel_Subjective extends JScrollPane {
    public SelectQuestionPanel_Subjective(){
        JPanel panel=new JPanel(new VFlowLayout());
        try {
            GetQuestionBank_Subjective_C getQuestionBank_subjective_c=new GetQuestionBank_Subjective_C();
            int[] idList = getQuestionBank_subjective_c.getIdList();
            String[] stemList = getQuestionBank_subjective_c.getStemList();
            int[] markList = getQuestionBank_subjective_c.getMarkList();
            int[] difficulty = getQuestionBank_subjective_c.getDifficulty();
            String[] answerList = getQuestionBank_subjective_c.getAnswerList();
            if (idList.length>0) {
                for (int i = 0; i < idList.length; i++) {
                    QCard_Judge_Select panel1 = new QCard_Judge_Select(idList[i], i + 1, stemList[i], markList[i], difficulty[i], answerList[i]);
                    panel.add(panel1);
                    panel1.isSelected.addItemListener(e -> {
                        if (panel1.isSelected.isSelected()) {
                            System.out.println("subjective"+ MyTabbedPane_AddPaper.statistician.getMySubjective());
                            MyTabbedPane_AddPaper.statistician.addMySubjective(panel1.getId());
                            MyTabbedPane_AddPaper.statisticianPanel.updateUI();
                        } else {
                            if (MyTabbedPane_AddPaper.statistician.getMySubjective().contains((Integer)panel1.getId())) {
                                MyTabbedPane_AddPaper.statistician.removeSubject((Integer) panel1.getId());
                                System.out.println("subjective"+MyTabbedPane_AddPaper.statistician.getMySubjective());
                                MyTabbedPane_AddPaper.statisticianPanel.updateUI();
                            }
                        }
                    });
//                    panel1.isSelected.addChangeListener(new ChangeListener() {
//                        @Override
//                        public void stateChanged(ChangeEvent e) {
////                            AddPaper_Self.toolBar.updateUI();
////                            AddPaper_Self.toolBar.repaint();
//                        }
//                    });
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
