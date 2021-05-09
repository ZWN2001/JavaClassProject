package Teacher.View.MyQuestions.CheckQuestionSituation;

import Teacher.Function.ClientFuction.GetQuestionBankSituation_C;
import Teacher.Util.AdapterAndHelper.GBC;
import Teacher.Util.Component.MyTextArea.MyTextArea_Colorful;
import Teacher.Util.Layout.VFlowLayout;
import Teacher.Util.MyFont;
import org.jfree.data.general.DefaultPieDataset;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;


public class CheckQuestionSituationPanel extends JPanel {
    private  Container chartContainer=new Container();
    private  JPanel tableContainer=new JPanel();
    GetQuestionBankSituation_C getQuestionBankSituation;
    private int questionNum_all_Choice, questionNum_all_MultiChoice,questionNum_all_Judge,questionNum_all_Subjective;
    int[] questionNum_each_Choice,questionNum_each_MultiChoice,questionNum_each_Judge,questionNum_each_Subjective;
    public CheckQuestionSituationPanel() {
        try {
            getQuestionBankSituation = new GetQuestionBankSituation_C();
            questionNum_all_Choice=getQuestionBankSituation.getQuestionNum_all_Choice();
            questionNum_all_MultiChoice=getQuestionBankSituation.getQuestionNum_all_MultiChoice();
            questionNum_all_Judge=getQuestionBankSituation.getQuestionNum_all_Judge();
            questionNum_all_Subjective=getQuestionBankSituation.getQuestionNum_all_Subjective();
            questionNum_each_Choice = getQuestionBankSituation.getQuestionNum_each_Choice();
            questionNum_each_MultiChoice = getQuestionBankSituation.getQuestionNum_each_MultiChoice();
            questionNum_each_Judge = getQuestionBankSituation.getQuestionNum_each_Judge();
            questionNum_each_Subjective = getQuestionBankSituation.getQuestionNum_each_Subjective();
        } catch (IOException e) {
            e.printStackTrace();
        }
        setLayout(new GridBagLayout());
        add(chartContainer,new GBC(0,0).setWeight(0.9,1).setFill(GridBagConstraints.BOTH));
        add(tableContainer,new GBC(1,0).setWeight(0.1,1));
        chartContainer.setLayout(new GridBagLayout());
        tableContainer.setLayout(new VFlowLayout());
        chartContainer.add(new PieChart("选择题",getDataSet(questionNum_each_Choice)).getChartPanel(),new GBC(0,0).setFill(GridBagConstraints.BOTH).setWeight(0.5,0.5));
        chartContainer.add(new PieChart("多选题",getDataSet(questionNum_each_MultiChoice)).getChartPanel(),new GBC(1,0).setFill(GridBagConstraints.BOTH).setWeight(0.5,0.5));
        chartContainer.add(new PieChart("判断题",getDataSet(questionNum_each_Judge)).getChartPanel(),new GBC(0,1).setFill(GridBagConstraints.BOTH).setWeight(0.5,0.5));
        chartContainer.add(new PieChart("主观题",getDataSet(questionNum_each_Subjective)).getChartPanel(),new GBC(1,1).setFill(GridBagConstraints.BOTH).setWeight(0.5,0.5));

        JLabel questionDataTitle=new JLabel("题库数据");
        questionDataTitle.setFont(MyFont.Font_20);
        JLabel choiceDataTitle=new JLabel("选择题:");
        choiceDataTitle.setFont(MyFont.Font_16);
        JLabel choiceData0=new JLabel("  共有题目："+questionNum_all_Choice+"道");
        JLabel choiceData1=new JLabel("  难度系数 1 共有题目："+questionNum_each_Choice[0]+"道");
        JLabel choiceData2=new JLabel("  难度系数 2 共有题目："+questionNum_each_Choice[1]+"道");
        JLabel choiceData3=new JLabel("  难度系数 3 共有题目："+questionNum_each_Choice[2]+"道");
        JLabel choiceData4=new JLabel("  难度系数 4 共有题目："+questionNum_each_Choice[3]+"道");
        JLabel choiceData5=new JLabel("  难度系数 5 共有题目："+questionNum_each_Choice[4]+"道");
        JLabel multiChoiceDataTitle=new JLabel("多选题:");
        multiChoiceDataTitle.setFont(MyFont.Font_16);
        JLabel multiChoiceData0=new JLabel("  共有题目："+questionNum_all_MultiChoice+"道");
        JLabel multiChoiceData1=new JLabel("  难度系数 1 共有题目："+questionNum_each_MultiChoice[0]+"道");
        JLabel multiChoiceData2=new JLabel("  难度系数 2 共有题目："+questionNum_each_MultiChoice[1]+"道");
        JLabel multiChoiceData3=new JLabel("  难度系数 3 共有题目："+questionNum_each_MultiChoice[2]+"道");
        JLabel multiChoiceData4=new JLabel("  难度系数 4 共有题目："+questionNum_each_MultiChoice[3]+"道");
        JLabel multiChoiceData5=new JLabel("  难度系数 5 共有题目："+questionNum_each_MultiChoice[4]+"道");
        JLabel judgeDataTitle=new JLabel("判断题:");
        judgeDataTitle.setFont(MyFont.Font_16);
        JLabel judgeData0=new JLabel("  共有题目："+questionNum_all_Judge+"道");
        JLabel judgeData1=new JLabel("  难度系数 1 共有题目："+questionNum_each_Judge[0]+"道");
        JLabel judgeData2=new JLabel("  难度系数 2 共有题目："+questionNum_each_Judge[1]+"道");
        JLabel judgeData3=new JLabel("  难度系数 3 共有题目："+questionNum_each_Judge[2]+"道");
        JLabel judgeData4=new JLabel("  难度系数 4 共有题目："+questionNum_each_Judge[3]+"道");
        JLabel judgeData5=new JLabel("  难度系数 5 共有题目："+questionNum_each_Judge[4]+"道");
        JLabel subjectiveDataTitle=new JLabel("主观题:");
        subjectiveDataTitle.setFont(MyFont.Font_16);
        JLabel subjectiveData0=new JLabel("  共有题目："+questionNum_all_Subjective+"道");
        JLabel subjectiveData1=new JLabel("  难度系数 1 共有题目："+questionNum_each_Subjective[0]+"道");
        JLabel subjectiveData2=new JLabel("  难度系数 2 共有题目："+questionNum_each_Subjective[1]+"道");
        JLabel subjectiveData3=new JLabel("  难度系数 3 共有题目："+questionNum_each_Subjective[2]+"道");
        JLabel subjectiveData4=new JLabel("  难度系数 4 共有题目："+questionNum_each_Subjective[3]+"道");
        JLabel subjectiveData5=new JLabel("  难度系数 5 共有题目："+questionNum_each_Subjective[4]+"道");        tableContainer.add(choiceDataTitle,new GBC(0,0).setAnchor(GridBagConstraints.WEST).setFill(GridBagConstraints.HORIZONTAL));
        tableContainer.add(questionDataTitle);
        tableContainer.add(choiceData0);
        tableContainer.add(choiceData1);
        tableContainer.add(choiceData2);
        tableContainer.add(choiceData3);
        tableContainer.add(choiceData4);
        tableContainer.add(choiceData5);
        tableContainer.add(multiChoiceDataTitle);
        tableContainer.add(multiChoiceData0);
        tableContainer.add(multiChoiceData1);
        tableContainer.add(multiChoiceData2);
        tableContainer.add(multiChoiceData3);
        tableContainer.add(multiChoiceData4);
        tableContainer.add(multiChoiceData5);
        tableContainer.add(judgeDataTitle);
        tableContainer.add(judgeData0);
        tableContainer.add(judgeData1);
        tableContainer.add(judgeData2);
        tableContainer.add(judgeData3);
        tableContainer.add(judgeData4);
        tableContainer.add(judgeData5);
        tableContainer.add(subjectiveDataTitle);
        tableContainer.add(subjectiveData0);
        tableContainer.add(subjectiveData1);
        tableContainer.add(subjectiveData2);
        tableContainer.add(subjectiveData3);
        tableContainer.add(subjectiveData4);
        tableContainer.add(subjectiveData5);
    }
    private static DefaultPieDataset getDataSet(int[] questionNum_each) {
        DefaultPieDataset dataset = new DefaultPieDataset();
        dataset.setValue("难度：1",questionNum_each[0]);
        dataset.setValue("难度：2",questionNum_each[1]);
        dataset.setValue("难度：3",questionNum_each[2]);
        dataset.setValue("难度：4",questionNum_each[3]);
        dataset.setValue("难度：5",questionNum_each[4]);
        return dataset;
    }
    private static String getQuestionDataText(int allNum,int[] each){
        return "<html><body>"+"共有题目："+allNum+"道"+"<br>"+
                "难度系数 1 共有题目："+each[0]+"道"+"<br>"+
                "难度系数 2 共有题目："+each[1]+"道"+"<br>"+
                "难度系数 3 共有题目："+each[2]+"道"+"<br>"+
                "难度系数 4 共有题目："+each[3]+"道"+"<br>"+
                "难度系数 5 共有题目："+each[4]+"道"+"<body></html>";
    }
}
