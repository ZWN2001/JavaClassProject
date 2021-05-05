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
    public PaperPreviewPanel(String paperName,int mark,int examTime,int difficulty,String questionString){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyy-MM-dd HH:mm:ss");
        String time=simpleDateFormat.format(System.currentTimeMillis());
        paper=new Paper(paperName,mark,time,examTime,"admin",123,questionString);
        JPanel panel=new JPanel(new VFlowLayout(true,true));
        try {
             getPreviewQuestions = new GetPreviewQuestions_C(questionString);
        }catch (IOException e){
            e.printStackTrace();
        }
        choices=getPreviewQuestions.getChoices();
        multiChoices=getPreviewQuestions.getMultiChoices();
        judges=getPreviewQuestions.getJudges();
        subjectives=getPreviewQuestions.getSubjective();

        JLabel previewTitle=new JLabel("试卷预览");
        previewTitle.setFont(MyFont.Font_20);
        BackgroundButton backBtn=new BackgroundButton("  返回  ");
        BackgroundButton submitBtn=new BackgroundButton("  确认添加到题库  ");
        tipContainer.setLayout(new BorderLayout());
        JPanel buttonPanel=new JPanel(new GridBagLayout());
        buttonPanel.add(previewTitle,new GBC(0,0).setInsets(10,0,0,0));
        buttonPanel.add(backBtn,new GBC(1,0).setInsets(10,80,10,0).setAnchor(GridBagConstraints.WEST));
        buttonPanel.add(submitBtn,new GBC(2,0,2,1).setInsets(10,20,10,0));
        buttonPanel.add(tipContainer,new GBC(3,0).setInsets(10,40,10,0));
        panel.add(buttonPanel);
        PaperPreview_Title mainTitle=new PaperPreview_Title(paperName,mark,examTime,difficulty);
        panel.add(mainTitle);

        if (choices.length>0){
            MyTextArea_Normal choiceLabel=new MyTextArea_Normal(1,4,"","  选择题:");
            choiceLabel.setAble(false);
            panel.add(choiceLabel);
            for (i=0;i<choices.length;i++){
                 qCard_choice_normal = new QCard_Choice_Normal(choices[i].getId(),qid++,choices[i].getStem(),choices[i].getOptionA(),choices[i].getOptionB(),choices[i].getOptionC(),choices[i].getOptionD(),choices[i].getMark());
                panel.add(qCard_choice_normal);
            }
        }
        if (multiChoices.length>0){
            MyTextArea_Normal choiceLabel=new MyTextArea_Normal(1,4,"","  多选题:");
            choiceLabel.setAble(false);
            panel.add(choiceLabel);
            for (i=0;i<choices.length;i++){
                qCard_multiChoice_normal = new QCard_MultiChoice_Normal(multiChoices[i].getId(),qid++,multiChoices[i].getStem(),multiChoices[i].getOptionA(),multiChoices[i].getOptionB(),multiChoices[i].getOptionC(),multiChoices[i].getOptionD(),multiChoices[i].getMark());
                panel.add(qCard_multiChoice_normal);
            }
        }
        if (judges.length>0){
            MyTextArea_Normal choiceLabel=new MyTextArea_Normal(1,4,"","  判断题:");
            choiceLabel.setAble(false);
            panel.add(choiceLabel);
            for (i=0;i<judges.length;i++){
                qCard_judge_normal = new QCard_Judge_Normal(judges[i].getId(),qid++,judges[i].getStem(),judges[i].getMark());
                panel.add(qCard_judge_normal);
            }
        }
        if (subjectives.length>0){
            MyTextArea_Normal choiceLabel=new MyTextArea_Normal(1,4,"","  主观题:");
            choiceLabel.setAble(false);
            panel.add(choiceLabel);
            for (i=0;i<subjectives.length;i++){
                qCard_subjective_normal = new QCard_Subjective_Normal(subjectives[i].getId(),qid++,subjectives[i].getStem(),subjectives[i].getMark());
                panel.add(qCard_subjective_normal);
            }
        }
        getViewport().add(panel);

        backBtn.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                HomeFrame.content.remove(0);
                HomeFrame.content.repaint();
                HomeFrame.content.updateUI();
            }
        });
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
                        HomeFrame.content.add(new MyTabbedPane_AddPaper());
                        HomeFrame.content.repaint();
                        HomeFrame.content.updateUI();
                    }else {
                        tipContainer.add(new MyTextArea_Colorful(1,4,"失败","添加失败",false));
                    }
                }catch (Exception ex){
                    ex.printStackTrace();
                }

            }
        });
    }
}
