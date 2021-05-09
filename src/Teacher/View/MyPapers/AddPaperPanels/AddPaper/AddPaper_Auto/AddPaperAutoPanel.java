package Teacher.View.MyPapers.AddPaperPanels.AddPaper.AddPaper_Auto;

import Teacher.Bean.Statistician_AutoAdd;
import Teacher.Function.ClientFuction.GetQuestionBankSituation_C;
import Teacher.Function.ClientFuction.Paper.GetAutoPaper_C;
import Teacher.Function.MyNumberFormat;
import Teacher.Util.AdapterAndHelper.GBC;
import Teacher.Util.Component.MyButton.BackgroundButton;
import Teacher.Util.Component.MyTextArea.MyTextArea_Colorful;
import Teacher.Util.Component.MyTextArea.MyTextArea_Normal;
import Teacher.Util.Component.MyTextArea.MyTextArea_Warning;
import Teacher.Util.MyFont;
import Teacher.View.HomePanels.HomeFrame;
import Teacher.View.MyPapers.AddPaperPanels.PaperPreview.PaperPreviewPanel;
import com.alibaba.fastjson.JSON;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.IOException;

public class AddPaperAutoPanel extends JPanel {
    GetQuestionBankSituation_C getQuestionBankSituation_c;
    private GetAutoPaper_C getAutoPaper;

    BackgroundButton submitBtn;
    public static MyTextArea_Normal paperName,examTime;
    public static Row choice,multiChoice,judge,subjective;
    public static Container container=new Container();
    public static Statistician_AutoAdd statistician=new Statistician_AutoAdd();
    public static StatisticPanel_Auto statisticPanel;

    private String questionString;
    static int[] questionNum_each_Choice;
    static int[] questionNum_each_MultiChoice;
    static int[] questionNum_each_Judge;
    static int[] questionNum_each_Subjective;
    public AddPaperAutoPanel(){
        setLayout(new GridBagLayout());
        container.setLayout(new BorderLayout());
        try{
             getQuestionBankSituation_c=new GetQuestionBankSituation_C();
        }catch (IOException e){
            e.printStackTrace();
            add(new MyTextArea_Warning(1,10,"错误","获取题库数据失败"));
        }
        int questionNum_all_Choice = getQuestionBankSituation_c.getQuestionNum_all_Choice();
        int  questionNum_all_MultiChoice=getQuestionBankSituation_c.getQuestionNum_all_MultiChoice();
        int  questionNum_all_Judge=getQuestionBankSituation_c.getQuestionNum_all_Judge();
        int  questionNum_all_Subjective=getQuestionBankSituation_c.getQuestionNum_all_Subjective();
         questionNum_each_Choice=getQuestionBankSituation_c.getQuestionNum_each_Choice();
         questionNum_each_MultiChoice=getQuestionBankSituation_c.getQuestionNum_each_MultiChoice();
         questionNum_each_Judge=getQuestionBankSituation_c.getQuestionNum_each_Judge();
         questionNum_each_Subjective=getQuestionBankSituation_c.getQuestionNum_each_Subjective();

        choice=new Row("单选题：",questionNum_all_Choice,questionNum_each_Choice[0],questionNum_each_Choice[1],questionNum_each_Choice[2],questionNum_each_Choice[3],questionNum_each_Choice[4]);
        multiChoice=new Row("多选题：",questionNum_all_MultiChoice,questionNum_each_MultiChoice[0],questionNum_each_MultiChoice[1],questionNum_each_MultiChoice[2],questionNum_each_MultiChoice[3],questionNum_each_MultiChoice[4]);
        judge=new Row("判断题：",questionNum_all_Judge,questionNum_each_Judge[0],questionNum_each_Judge[1],questionNum_each_Judge[2],questionNum_each_Judge[3],questionNum_each_Judge[4]);
        subjective=new Row("主观题：",questionNum_all_Subjective,questionNum_each_Subjective[0],questionNum_each_Subjective[1],questionNum_each_Subjective[2],questionNum_each_Subjective[3],questionNum_each_Subjective[4]);

        JLabel paperNameLabel=new JLabel("试卷名称：");
        paperNameLabel.setFont(MyFont.Font_14);
        paperName=new MyTextArea_Normal(1,50,"","",false);
        JLabel examTimeLabel=new JLabel("答题时间：");
        examTimeLabel.setFont(MyFont.Font_14);
        examTime=new MyTextArea_Normal(1,20,"","",true);
        JLabel titleLabel4=new JLabel("分钟");
        titleLabel4.setFont(MyFont.Font_14);
         submitBtn=new BackgroundButton(" 前往预览 ");

        add(choice,new GBC(0,0,10,2).setFill(GridBagConstraints.HORIZONTAL).setWeightx(1));
        add(multiChoice,new GBC(0,2,10,2).setFill(GridBagConstraints.HORIZONTAL).setWeightx(1));
        add(judge,new GBC(0,4,10,2).setFill(GridBagConstraints.HORIZONTAL).setWeightx(1));
        add(subjective,new GBC(0,6,10,2).setFill(GridBagConstraints.HORIZONTAL).setWeightx(1));
        add(paperNameLabel,new GBC(0,9).setInsets(10,40,2,2));
        add(paperName,new GBC(1,9,2,1).setAnchor(GridBagConstraints.WEST).setFill(GridBagConstraints.HORIZONTAL).setInsets(10,0,2,0));
        add(examTimeLabel,new GBC(4,9).setInsets(10,18,2,20));
        add(examTime,new GBC(5,9).setAnchor(GridBagConstraints.WEST).setFill(GridBagConstraints.HORIZONTAL).setInsets(10,0,2,0));
        add(titleLabel4,new GBC(6,9).setInsets(10,8,2,20));
        add(submitBtn,new GBC(7,9).setInsets(10,0,2,40));

       statisticPanel=new StatisticPanel_Auto(statistician);
        container.add(statisticPanel);
        add(container,new GBC(0,8,10,1).setFill(GridBagConstraints.HORIZONTAL).setWeightx(1));

        submitBtn.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                //获取自动生成的预览
                if (ok()){
                    System.out.println("ok");
                    StatisticPanel_Auto.tipContainer.removeAll();
                    String demand=getDemand();
                    try {
                        getAutoPaper=new GetAutoPaper_C(demand);
                    } catch (IOException ioException) {
                        ioException.printStackTrace();
                    }
                    questionString=getAutoPaper.getQuestionString();
                    System.out.println(questionString);
                    HomeFrame.content.add(new PaperPreviewPanel(AddPaperAutoPanel.paperName.getText(), Integer.parseInt(AddPaperAutoPanel.examTime.getText()), questionString,true), 0);
                    HomeFrame.content.repaint();
                    HomeFrame.content.updateUI();
                }else {
                    String demand=getDemand();
                    System.out.println("不合法"+demand);
                    StatisticPanel_Auto.tipContainer.add(new MyTextArea_Warning(1,6,"error","数值不合法"));
                    repaint();
                    updateUI();
                }
            }
        });
    }
    public static String getDemand(){
        int[] demands=new int[20];
        demands[0]=Integer.parseInt(choice.d1_text.getText().equals("") ?""+0:choice.d1_text.getText()); demands[1]=Integer.parseInt(choice.d2_text.getText().equals("")?""+0:choice.d2_text.getText());
        demands[2]=Integer.parseInt(choice.d3_text.getText().equals("")?""+0:choice.d3_text.getText());demands[3]=Integer.parseInt(choice.d4_text.getText().equals("")?""+0:choice.d4_text.getText());
        demands[4]=Integer.parseInt(choice.d5_text.getText().equals("")?""+0:choice.d5_text.getText());
        demands[5]=Integer.parseInt(multiChoice.d1_text.getText().equals("")?""+0:multiChoice.d1_text.getText());demands[6]=Integer.parseInt(multiChoice.d2_text.getText().equals("")?""+0:multiChoice.d2_text.getText());
        demands[7]=Integer.parseInt(multiChoice.d3_text.getText().equals("")?""+0:multiChoice.d3_text.getText());demands[8]=Integer.parseInt(multiChoice.d4_text.getText().equals("")?""+0:multiChoice.d4_text.getText());
        demands[9]=Integer.parseInt(multiChoice.d5_text.getText().equals("")?""+0:multiChoice.d5_text.getText());
        demands[10]=Integer.parseInt(judge.d1_text.getText().equals("")?""+0:judge.d1_text.getText());  demands[11]=Integer.parseInt(judge.d2_text.getText().equals("")?""+0:judge.d2_text.getText());
        demands[12]=Integer.parseInt(judge.d3_text.getText().equals("")?""+0:judge.d3_text.getText());  demands[13]=Integer.parseInt(judge.d4_text.getText().equals("")?""+0:judge.d4_text.getText());
        demands[14]=Integer.parseInt(judge.d5_text.getText().equals("")?""+0:judge.d5_text.getText());
        demands[15]=Integer.parseInt(subjective.d1_text.getText().equals("")?""+0:subjective.d1_text.getText());   demands[16]=Integer.parseInt(subjective.d2_text.getText().equals("")?""+0:subjective.d2_text.getText());
        demands[17]=Integer.parseInt(subjective.d3_text.getText().equals("")?""+0:subjective.d3_text.getText());   demands[18]=Integer.parseInt(subjective.d4_text.getText().equals("")?""+0:subjective.d4_text.getText());
        demands[19]=Integer.parseInt(subjective.d5_text.getText().equals("")?""+0:subjective.d5_text.getText());
        return JSON.toJSONString(demands);
    }
    public static boolean ok(){
        boolean chooseNull=Integer.parseInt(choice.d1_text.getText())<=0&&Integer.parseInt(choice.d2_text.getText())<=0&&Integer.parseInt(choice.d3_text.getText())<=0&&
                Integer.parseInt(choice.d4_text.getText())<=0&&Integer.parseInt(choice.d5_text.getText())<=0&&Integer.parseInt(multiChoice.d1_text.getText())<=0&&
                Integer.parseInt(multiChoice.d2_text.getText())<=0&&Integer.parseInt(multiChoice.d3_text.getText())<=0&&Integer.parseInt(multiChoice.d4_text.getText())<=0&&
                Integer.parseInt(multiChoice.d5_text.getText())<=0&&Integer.parseInt(judge.d1_text.getText())<=0&&Integer.parseInt(judge.d2_text.getText())<=0&&Integer.parseInt(judge.d3_text.getText())<=0&&
                Integer.parseInt(judge.d4_text.getText())<=0&&Integer.parseInt(judge.d5_text.getText())<=0&&Integer.parseInt(subjective.d1_text.getText())<=0&&Integer.parseInt(subjective.d2_text.getText())<=0&&
                Integer.parseInt(subjective.d3_text.getText())<=0&&Integer.parseInt(subjective.d4_text.getText())<=0&&Integer.parseInt(subjective.d5_text.getText())<=0&&
                choice.d1_text.getText().equals("")&&choice.d2_text.getText().equals("")&&choice.d3_text.getText().equals("") &&choice.d4_text.getText().equals("")&&choice.d5_text.getText().equals("")&&
                multiChoice.d1_text.getText().equals("")&&multiChoice.d2_text.getText().equals("")&&multiChoice.d3_text.getText().equals("")&&multiChoice.d4_text.getText().equals("")&&multiChoice.d5_text.getText().equals("")&&
                judge.d1_text.getText().equals("")&&judge.d2_text.getText().equals("")&&judge.d3_text.getText().equals("")&&judge.d4_text.getText().equals("")&&judge.d5_text.getText().equals("")&&
                subjective.d1_text.getText().equals("")&&subjective.d2_text.getText().equals("")&&subjective.d3_text.getText().equals("")&&subjective.d4_text.getText().equals("")&&subjective.d5_text.getText().equals("");

        return  !AddPaperAutoPanel.paperName.getText().isEmpty()&&!AddPaperAutoPanel.examTime.getText().isEmpty()&& !chooseNull&&
                Integer.parseInt(choice.d1_text.getText())<=questionNum_each_Choice[0]&&Integer.parseInt(choice.d2_text.getText())<=questionNum_each_Choice[1]&&Integer.parseInt(choice.d3_text.getText())<=questionNum_each_Choice[2]&&
                Integer.parseInt(choice.d4_text.getText())<=questionNum_each_Choice[3]&&Integer.parseInt(choice.d5_text.getText())<=questionNum_each_Choice[4]&&Integer.parseInt(multiChoice.d1_text.getText())<=questionNum_each_MultiChoice[0]&&
                Integer.parseInt(multiChoice.d2_text.getText())<=questionNum_each_MultiChoice[1]&&Integer.parseInt(multiChoice.d3_text.getText())<=questionNum_each_MultiChoice[2]&&Integer.parseInt(multiChoice.d4_text.getText())<=questionNum_each_MultiChoice[3]&&
                Integer.parseInt(multiChoice.d5_text.getText())<=questionNum_each_MultiChoice[4]&&Integer.parseInt(judge.d1_text.getText())<=questionNum_each_Judge[0]&&Integer.parseInt(judge.d2_text.getText())<=questionNum_each_Judge[1]&&Integer.parseInt(judge.d3_text.getText())<=questionNum_each_Judge[2]&&
                Integer.parseInt(judge.d4_text.getText())<=questionNum_each_Judge[3]&&Integer.parseInt(judge.d5_text.getText())<=questionNum_each_Judge[4]&&Integer.parseInt(subjective.d1_text.getText())<=questionNum_each_Subjective[0]&&Integer.parseInt(subjective.d2_text.getText())<=questionNum_each_Subjective[1]&&
                Integer.parseInt(subjective.d3_text.getText())<=questionNum_each_Subjective[2]&&Integer.parseInt(subjective.d4_text.getText())<=questionNum_each_Subjective[3]&&Integer.parseInt(subjective.d5_text.getText())<=questionNum_each_Subjective[4];

    }


    private static class Row extends JPanel{
        MyTextArea_Normal d1_text;
        MyTextArea_Normal d2_text;
        MyTextArea_Normal d3_text;
        MyTextArea_Normal d4_text;
        MyTextArea_Normal d5_text;
        public Row(String labelText,int allAvailable,int questionNum_d1,int questionNum_d2,int questionNum_d3,int questionNum_d4,int questionNum_d5){
            setLayout(new GridBagLayout());
            MyTextArea_Colorful label=new MyTextArea_Colorful(1,2,"",labelText);
            label.setAble(false);
            JLabel d1_Label=new JLabel("难度系数 1 :");
             d1_text =new MyTextArea_Normal(1,2,"","0",true);
            JLabel availableQuestion_d1=new JLabel("道，"+questionNum_d1+"道题可用");
            JLabel d2_Label=new JLabel("难度系数 2 :");
             d2_text =new MyTextArea_Normal(1,2,"","0",true);
            JLabel availableQuestion_d2=new JLabel("道，"+questionNum_d2+"道题可用");
            JLabel d3_Label=new JLabel("难度系数 3 :");
             d3_text =new MyTextArea_Normal(1,2,"","0",true);
            JLabel availableQuestion_d3=new JLabel("道，"+questionNum_d3+"道题可用");
            JLabel d4_Label=new JLabel("难度系数 4 :");
             d4_text =new MyTextArea_Normal(1,2,"","0",true);
            JLabel availableQuestion_d4=new JLabel("道，"+questionNum_d4+"道题可用");
            JLabel d5_Label=new JLabel("难度系数 5 :");
             d5_text =new MyTextArea_Normal(1,2,"","0",true);
            JLabel availableQuestion_d5=new JLabel("道，"+questionNum_d5+"道题可用");
            MyTextArea_Normal allAvailable_Label=new MyTextArea_Normal(1,6,"","共计"+allAvailable+"道题可用");
            allAvailable_Label.setAble(false);

            add(label,new GBC(0,0,0.5,1).setAnchor(GridBagConstraints.WEST).setInsets(10,10,10,0));
            add(d1_Label,new GBC(1,0).setInsets(10,10,10,0));
            add(d1_text,new GBC(2,0).setInsets(10,0,10,0));
            add(availableQuestion_d1,new GBC(3,0).setInsets(10,0,10,10));

            add(d2_Label,new GBC(4,0).setInsets(10,10,10,0));
            add(d2_text,new GBC(5,0,0.5,1).setInsets(10,0,10,0));
            add(availableQuestion_d2,new GBC(6,0).setInsets(10,0,10,10));

            add(d3_Label,new GBC(7,0).setInsets(10,10,10,0));
            add(d3_text,new GBC(8,0,0.5,1).setInsets(10,0,10,0));
            add(availableQuestion_d3,new GBC(9,0).setInsets(10,0,10,10));

            add(d4_Label,new GBC(1,1).setInsets(10,10,10,0));
            add(d4_text,new GBC(2,1,0.5,1).setInsets(10,0,10,0));
            add(availableQuestion_d4,new GBC(3,1).setInsets(10,0,10,10));

            add(d5_Label,new GBC(4,1).setInsets(10,10,10,0));
            add(d5_text,new GBC(5,1,0.5,1).setInsets(10,0,10,0));
            add(availableQuestion_d5,new GBC(6,1).setInsets(10,0,10,10));

            add(allAvailable_Label,new GBC(7,1,3,1).setAnchor(GridBagConstraints.CENTER).setInsets(10,25,10,10));

            d1_text.textArea.addFocusListener(new FocusAdapter() {
                @Override
                public void focusLost(FocusEvent e) {
                    super.focusLost(e);
                    System.out.println("focus");
                    reCalculate();
                }
            });
            d2_text.textArea.addFocusListener(new FocusAdapter() {
                @Override
                public void focusLost(FocusEvent e) {
                    super.focusLost(e);
                    System.out.println("focus");
                    reCalculate();
                }
            });
            d3_text.textArea.addFocusListener(new FocusAdapter() {
                @Override
                public void focusLost(FocusEvent e) {
                    super.focusLost(e);
                    System.out.println("focus");
                    reCalculate();
                }
            });
            d4_text.textArea.addFocusListener(new FocusAdapter() {
                @Override
                public void focusLost(FocusEvent e) {
                    super.focusLost(e);
                    System.out.println("focus");
                    reCalculate();
                }
            });
            d5_text.textArea.addFocusListener(new FocusAdapter() {
                @Override
                public void focusLost(FocusEvent e) {
                    super.focusLost(e);
                    System.out.println("focus");
                    reCalculate();
                }
            });
            d1_text.textArea.addKeyListener(new KeyAdapter() {
                @Override
                public void keyTyped(KeyEvent e) {
                    super.keyTyped(e);
                    reCalculate();
                }
            });
            d2_text.textArea.addKeyListener(new KeyAdapter() {
                @Override
                public void keyTyped(KeyEvent e) {
                    super.keyTyped(e);
                    reCalculate();
                }
            });
            d3_text.textArea.addKeyListener(new KeyAdapter() {
                @Override
                public void keyTyped(KeyEvent e) {
                    super.keyTyped(e);
                    reCalculate();
                }
            });
            d4_text.textArea.addKeyListener(new KeyAdapter() {
                @Override
                public void keyTyped(KeyEvent e) {
                    super.keyTyped(e);
                    reCalculate();
                }
            });
            d5_text.textArea.addKeyListener(new KeyAdapter() {
                @Override
                public void keyTyped(KeyEvent e) {
                    super.keyTyped(e);
                    reCalculate();
                }
            });
        }
        public int getNum_d1(){
            return (d1_text.getText().equals("") ||d1_text.getText()==null)?0:Integer.parseInt(d1_text.getText());
        }
        public int getNum_d2(){
            return (d2_text.getText().equals("") ||d2_text.getText()==null)?0:Integer.parseInt(d2_text.getText());
        }
        public int getNum_d3(){
            return (d3_text.getText().equals("") ||d3_text.getText()==null)?0:Integer.parseInt(d3_text.getText());
        }
        public int getNum_d4(){
            return (d4_text.getText().equals("") ||d4_text.getText()==null)?0:Integer.parseInt(d4_text.getText());
        }
        public int getNum_d5(){
            return (d5_text.getText().equals("") ||d5_text.getText()==null)?0:Integer.parseInt(d5_text.getText());
        }
        public void reCalculate(){
            int allChoseNum=choice.getNum_d1()+choice.getNum_d2()+choice.getNum_d3()+choice.getNum_d4()+choice.getNum_d5()
                    +multiChoice.getNum_d1()+multiChoice.getNum_d2()+multiChoice.getNum_d3()+multiChoice.getNum_d4()+multiChoice.getNum_d5()
                    +judge.getNum_d1()+judge.getNum_d2()+judge.getNum_d3() +judge.getNum_d4()+judge.getNum_d5()
                    +subjective.getNum_d1()+subjective.getNum_d2()+subjective.getNum_d3()+subjective.getNum_d4()+subjective.getNum_d5();
            statistician.setAllChoseNum(allChoseNum);
            double aveDifficulty= allChoseNum==0?0: MyNumberFormat.formatDouble(((double) choice.getNum_d1()+2*choice.getNum_d2()+3*choice.getNum_d3()+4*choice.getNum_d4()+5*choice.getNum_d5()
                    +multiChoice.getNum_d1()+2*multiChoice.getNum_d2()+3*multiChoice.getNum_d3()+4*multiChoice.getNum_d4()+5*multiChoice.getNum_d5()
                    +judge.getNum_d1()+2*judge.getNum_d2()+3*judge.getNum_d3() +4*judge.getNum_d4()+5*judge.getNum_d5()
                    +subjective.getNum_d1()+2*subjective.getNum_d2()+3*subjective.getNum_d3()+4*subjective.getNum_d4()+5*subjective.getNum_d5())/allChoseNum);
            statistician.setAverageDifficulty(aveDifficulty);
            System.out.println(statistician);
            container.removeAll();
              statisticPanel=new StatisticPanel_Auto(statistician);
              container.add(statisticPanel);
             statisticPanel.repaint();
             statisticPanel.updateUI();
        }
    }

}
