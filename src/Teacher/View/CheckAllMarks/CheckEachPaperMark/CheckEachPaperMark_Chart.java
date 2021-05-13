package Teacher.View.CheckAllMarks.CheckEachPaperMark;

import Teacher.Function.ClientFuction.CheckMark.GetEachPaperMark_C;
import Teacher.Function.ClientFuction.Paper.GetAPaper_C;
import Teacher.Test.PaperMark;
import Teacher.Util.Component.MyTextArea.MyTextArea_Warning;

import org.jfree.data.category.DefaultCategoryDataset;

import javax.swing.*;
import java.awt.*;

public class CheckEachPaperMark_Chart extends JPanel {
    private GetEachPaperMark_C getEachPaperMark;
    private GetAPaper_C getAPaper;
    private PaperMark[] paperMarks;
    private int maxMark,grads;//grads,梯度
    private int divide[]=new int[4];
    private int[] num=new int[5];
    private String[] columnKey=new String[5];
    private int i;
    public CheckEachPaperMark_Chart(int paperID) {
        setLayout(new BorderLayout());
        try{
            getEachPaperMark=new GetEachPaperMark_C(paperID);
            paperMarks=getEachPaperMark.getMarks();
            getAPaper=new GetAPaper_C(paperID);
            maxMark=getAPaper.getPaper().getMark();
        }catch (Exception e){
            e.printStackTrace();
           add(new MyTextArea_Warning(1,10,"错误","加载失败"));
        }
        grads=maxMark/5;
        divide[0]=grads;
        divide[1]=2*grads;
        divide[2]=3*grads;
        divide[3]=4*grads;
        columnKey[0]="0 ~ "+divide[0];
        columnKey[1]=""+(divide[0]+1)+" ~ "+divide[1];
        columnKey[2]=""+(divide[1]+1)+" ~ "+divide[2];
        columnKey[3]=""+(divide[2]+1)+" ~ "+divide[3];
        columnKey[4]=""+(divide[3]+1)+" ~ "+maxMark;
        if (paperMarks!=null){
            for (i=0;i<paperMarks.length;i++){
                if (paperMarks[i].getAll()>=divide[3]){
                    num[4]++;
                }else if(paperMarks[i].getAll()>=divide[2]){
                    num[3]++;
                }else if (paperMarks[i].getAll()>=divide[1]){
                    num[2]++;
                }else if (paperMarks[i].getAll()>=divide[0]){
                    num[1]++;
                }else {
                    num[0]++;
                }
            }
        }


        DefaultCategoryDataset dataset=new DefaultCategoryDataset();
        dataset.addValue(num[0],columnKey[0],columnKey[0]);
        dataset.addValue(num[1],columnKey[1],columnKey[1]);
        dataset.addValue(num[2],columnKey[2],columnKey[2]);
        dataset.addValue(num[3],columnKey[3],columnKey[3]);
        dataset.addValue(num[4],columnKey[4],columnKey[4]);

        add(new BarChart(dataset).getChartPanel());

    }
}
