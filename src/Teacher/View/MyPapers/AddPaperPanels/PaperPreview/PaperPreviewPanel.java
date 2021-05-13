package Teacher.View.MyPapers.AddPaperPanels.PaperPreview;

import Teacher.Bean.Paper;
import Teacher.Bean.Question.Question_Choice;
import Teacher.Bean.Question.Question_Judge;
import Teacher.Bean.Question.Question_MultiChoice;
import Teacher.Bean.Question.Question_Subjective;
import Teacher.Bean.Statistician_AutoAdd;
import Teacher.Bean.Statistician_SelfAdd;
import Teacher.Function.ClientFuction.GetPreviewQuestions_C;
import Teacher.Function.ClientFuction.Paper.SubmitPaper_C;
import Teacher.Function.MyNumberFormat;
import Teacher.Util.AdapterAndHelper.GBC;
import Teacher.Util.Component.MyButton.BackgroundButton;
import Teacher.Util.Component.MyPanel.QuestionCards.Card_Normal.QCard_Choice_Normal;
import Teacher.Util.Component.MyPanel.QuestionCards.Card_Normal.QCard_Judge_Normal;
import Teacher.Util.Component.MyPanel.QuestionCards.Card_Normal.QCard_MultiChoice_Normal;
import Teacher.Util.Component.MyPanel.QuestionCards.Card_Normal.QCard_Subjective_Normal;
import Teacher.Util.Component.MyTextArea.MyTextArea_Colorful;
import Teacher.Util.Component.MyTextArea.MyTextArea_Normal;
import Teacher.Util.Layout.VFlowLayout;
import Teacher.Util.MyFont;
import Teacher.View.HomePanels.Home;
import Teacher.View.HomePanels.HomeFrame;
import Teacher.View.MyPapers.AddPaperPanels.AddPaper.AddPaper_Auto.AddPaperAutoPanel;
import Teacher.View.MyPapers.AddPaperPanels.AddPaper.AddPaper_Self.AddPaperSelfPanel;
import Teacher.View.MyPapers.AddPaperPanels.AddPaper.AddPaper_Self.StatisticianPanel_Self;
import Teacher.View.MyPapers.AddPaperPanels.AddPaper.MyTabbedPane_AddPaper;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.text.SimpleDateFormat;

public class PaperPreviewPanel extends JScrollPane {
    GetPreviewQuestions_C getPreviewQuestions;
    Question_Choice[] choices;
    Question_MultiChoice[] multiChoices;
    Question_Judge[] judges;
    Question_Subjective[] subjectives;
    int i,qid=1;
    QCard_Choice_Normal qCard_choice_normal;
    QCard_MultiChoice_Normal qCard_multiChoice_normal;
    QCard_Judge_Normal qCard_judge_normal;
    QCard_Subjective_Normal qCard_subjective_normal;
    public static Container tipContainer=new Container();
    Paper paper;
    BackgroundButton submitBtn;
    JPanel buttonPanel;
    BackgroundButton backBtn;
    String paperName,questionString;
    int mark, examTime;
    double difficulty;
    boolean isPreview;

    public PaperPreviewPanel(String paperName,int examTime,String questionString, boolean isPreview) {
        this.paperName=paperName;
        this.examTime=examTime;
        this.questionString=questionString;
        this.isPreview=isPreview;

        try {
            getPreviewQuestions = new GetPreviewQuestions_C(questionString);
        }catch (IOException e){
            e.printStackTrace();
        }

        choices=getPreviewQuestions.getChoices();
        multiChoices=getPreviewQuestions.getMultiChoices();
        judges=getPreviewQuestions.getJudges();
        subjectives=getPreviewQuestions.getSubjective();

        mark=getMark();
        difficulty=getDifficulty();
        init();

    }

    public PaperPreviewPanel(String paperName, int mark, int examTime, double difficulty, String questionString, boolean isPreview){
       this.paperName=paperName;
       this.mark=mark;
       this.examTime=examTime;
       this.difficulty=difficulty;
       this.questionString=questionString;
       this.isPreview=isPreview;

        try {
            getPreviewQuestions = new GetPreviewQuestions_C(questionString);
        }catch (IOException e){
            e.printStackTrace();
        }

        choices=getPreviewQuestions.getChoices();
        multiChoices=getPreviewQuestions.getMultiChoices();
        judges=getPreviewQuestions.getJudges();
        subjectives=getPreviewQuestions.getSubjective();
        this.mark=getMark();
        this.difficulty=getDifficulty();
        init();
    }
    public void init(){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyy-MM-dd HH:mm:ss");
        String time=simpleDateFormat.format(System.currentTimeMillis());
        paper=new Paper(paperName,mark,difficulty,time,examTime, Home.teacher.getName(),Integer.parseInt(Home.teacher.getAccount()),questionString);
        JPanel rootPanel=new JPanel(new VFlowLayout(true,true));
        JPanel panel=new JPanel(new VFlowLayout());


        buttonPanel=new JPanel(new GridBagLayout());
        if (isPreview){
            JLabel previewTitle=new JLabel("试卷预览");
            previewTitle.setFont(MyFont.Font_20);
            backBtn=new BackgroundButton("  返回  ");
            submitBtn=new BackgroundButton("  确认添加到题库  ");
            tipContainer.setLayout(new BorderLayout());
            buttonPanel.add(previewTitle,new GBC(0,0).setInsets(10,0,0,0));
            buttonPanel.add(backBtn,new GBC(1,0).setInsets(10,80,0,0).setAnchor(GridBagConstraints.WEST));
            buttonPanel.add(submitBtn,new GBC(2,0,2,1).setInsets(10,20,0,0));
            buttonPanel.add(tipContainer,new GBC(3,0).setInsets(10,40,0,0));

            submitBtn.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    super.mouseClicked(e);
                    try {
                        SubmitPaper_C submitPaper=new SubmitPaper_C(paper);
                        if (submitPaper.getResultCode()==1){
                            StatisticianPanel_Self.tipContainer.add(new MyTextArea_Colorful(1,4,"","添加成功",false));
                            HomeFrame.content.removeAll();
                            AddPaperSelfPanel.statistician=new Statistician_SelfAdd();
                            AddPaperAutoPanel.statistician=new Statistician_AutoAdd();
                            AddPaperSelfPanel.statisticianPanel.repaint();
                            AddPaperSelfPanel.statisticianPanel.updateUI();
                            HomeFrame.content.add(new MyTabbedPane_AddPaper(),0);
                            AddPaperSelfPanel.container2.removeAll();
                            AddPaperSelfPanel.statisticianPanel=new StatisticianPanel_Self(AddPaperSelfPanel.statistician);
                            AddPaperSelfPanel.container2.add(AddPaperSelfPanel.statisticianPanel);
                            AddPaperSelfPanel.statisticianPanel.repaint();
                            AddPaperSelfPanel.statisticianPanel.updateUI();
                            HomeFrame.content.repaint();
                            HomeFrame.content.updateUI();
                        }else {
                            tipContainer.add(new MyTextArea_Colorful(1,4,"失败","添加失败",false));
                            repaint();
                            updateUI();
                        }
                    }catch (Exception ex){
                        ex.printStackTrace();
                    }
                }
            });

        }else {
            backBtn=new BackgroundButton("  返回  ");
            buttonPanel.add(backBtn,new GBC(0,0).setInsets(10,20,0,0).setAnchor(GridBagConstraints.WEST).setWeightx(1));
        }
        panel.add(buttonPanel);
        PaperPreview_Title mainTitle=new PaperPreview_Title(paperName,mark,examTime,difficulty);
        panel.add(mainTitle);

        if (choices!=null&&choices.length>0){
            MyTextArea_Normal choiceLabel=new MyTextArea_Normal(1,4,"","  选择题:");
            choiceLabel.setAble(false);
            choiceLabel.textArea.setFont(new Font("宋体",Font.BOLD,16));
            panel.add(choiceLabel);
            for (i=0;i<choices.length;i++){
                qCard_choice_normal = new QCard_Choice_Normal(choices[i].getId(),qid++,choices[i].getStem(),choices[i].getOptionA(),choices[i].getOptionB(),choices[i].getOptionC(),choices[i].getOptionD(),choices[i].getMark());
                panel.add(qCard_choice_normal);
            }
        }
        if (multiChoices!=null&&multiChoices.length>0){
            MyTextArea_Normal choiceLabel=new MyTextArea_Normal(1,4,"","  多选题:");
            choiceLabel.setAble(false);
            choiceLabel.textArea.setFont(new Font("宋体",Font.BOLD,16));
            panel.add(choiceLabel);
            for (i=0;i<multiChoices.length;i++){
                qCard_multiChoice_normal = new QCard_MultiChoice_Normal(multiChoices[i].getId(),qid++,multiChoices[i].getStem(),multiChoices[i].getOptionA(),multiChoices[i].getOptionB(),multiChoices[i].getOptionC(),multiChoices[i].getOptionD(),multiChoices[i].getMark());
                panel.add(qCard_multiChoice_normal);
            }
        }
        if (judges!=null&&judges.length>0){
            MyTextArea_Normal choiceLabel=new MyTextArea_Normal(1,4,"","  判断题:");
            choiceLabel.setAble(false);
            choiceLabel.textArea.setFont(new Font("宋体",Font.BOLD,16));
            panel.add(choiceLabel);
            for (i=0;i<judges.length;i++){
                qCard_judge_normal = new QCard_Judge_Normal(judges[i].getId(),qid++,judges[i].getStem(),judges[i].getMark());
                panel.add(qCard_judge_normal);
            }
        }
        if (subjectives!=null&&subjectives.length>0){
            MyTextArea_Normal choiceLabel=new MyTextArea_Normal(1,4,"","  主观题:");
            choiceLabel.setAble(false);
            choiceLabel.textArea.setFont(new Font("宋体",Font.BOLD,16));
            panel.add(choiceLabel);
            for (i=0;i<subjectives.length;i++){
                qCard_subjective_normal = new QCard_Subjective_Normal(subjectives[i].getId(),qid++,subjectives[i].getStem(),subjectives[i].getMark());
                panel.add(qCard_subjective_normal);
            }
        }
        rootPanel.add(panel);
        getViewport().add(rootPanel);

        backBtn.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                HomeFrame.content.remove(0);
                HomeFrame.content.repaint();
                HomeFrame.content.updateUI();
            }
        });
    }
    private int getMark(){
        mark=0;
        if (choices!=null){
            for (i=0;i<choices.length;i++){
                mark+=choices[i].getMark();
            }
        }
        if (multiChoices!=null){
            for (i=0;i<multiChoices.length;i++){
                mark+=multiChoices[i].getMark();
            }
        }
        if (judges!=null){
            for (i=0;i<judges.length;i++){
                mark+=judges[i].getMark();
            }
        }
        if (subjectives!=null){
            for (i=0;i<subjectives.length;i++){
                mark+=subjectives[i].getMark();
            }
        }

        return mark;
    }
    private double getDifficulty(){
        difficulty=0;
        int questionNum=0;
        if (choices!=null){
            for (i=0;i<choices.length;i++){
                difficulty+=choices[i].getDifficulty();
                questionNum++;
            }
        }
        if (multiChoices!=null){
            for (i=0;i<multiChoices.length;i++){
                difficulty+=multiChoices[i].getDifficulty();
                questionNum++;
            }
        }
        if (judges!=null){
            for (i=0;i<judges.length;i++){
                difficulty+=judges[i].getDifficulty();
                questionNum++;
            }
        }
        if (subjectives!=null){
            for (i=0;i<subjectives.length;i++){
                difficulty+=subjectives[i].getDifficulty();
                questionNum++;
            }
        }
        if (questionNum>0){
            difficulty=difficulty/(questionNum);
            difficulty=MyNumberFormat.formatDouble(difficulty);
        }
        return difficulty;
    }
}
