package Teacher.View.MyQuestions.SelectQuestion;

import Teacher.Function.GetQuestionBank.GetQuestionBank_Judge_C;
import Teacher.Util.Component.MyPanel.QuestionCards.Card_Select.QCard_Judge_Select;
import Teacher.Util.Component.MyTextArea.MyTextArea_Warning;
import Teacher.Util.Layout.VFlowLayout;
import Teacher.View.MyPapers.AddPaperPanels.AddPaper_Self.AddPaper_Self;
import Teacher.View.MyPapers.AddPaperPanels.MyTabbedPane_AddPaper;

import javax.swing.*;
import java.io.IOException;

public class SelectQuestionPanel_Judge extends JScrollPane {
    public SelectQuestionPanel_Judge(){
        JPanel panel=new JPanel(new VFlowLayout());
        try {
            GetQuestionBank_Judge_C getQuestionBank_judge_c=new GetQuestionBank_Judge_C();
            int[] idList = getQuestionBank_judge_c.getIdList();
            String[] stemList = getQuestionBank_judge_c.getStemList();
            int[] markList = getQuestionBank_judge_c.getMarkList();
            int[] difficulty = getQuestionBank_judge_c.getDifficulty();
            String[] answerList = getQuestionBank_judge_c.getAnswerList();
            if (idList.length>0) {
                for (int i = 0; i < idList.length; i++) {
                    QCard_Judge_Select panel1 = new QCard_Judge_Select(idList[i], i + 1, stemList[i], markList[i], difficulty[i], answerList[i]);
                    panel.add(panel1);
                    panel1.isSelected.addItemListener(e -> {
                        if (panel1.isSelected.isSelected()) {
                            System.out.println("judge"+ MyTabbedPane_AddPaper.statistician.getMyJudge());
                            MyTabbedPane_AddPaper.statistician.addMyJudge(panel1.getId());
                            MyTabbedPane_AddPaper.statisticianPanel.updateUI();
                        } else {
                            if (MyTabbedPane_AddPaper.statistician.getMyJudge().contains((Integer)panel1.getId())) {
                                MyTabbedPane_AddPaper.statistician.removeJudge((Integer) panel1.getId());
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
