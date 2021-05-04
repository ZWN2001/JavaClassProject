package Teacher.View.MyPapers.AddPaperPanels.PaperPreview;

import Teacher.Util.Layout.VFlowLayout;

import javax.swing.*;

public class PaperPreviewPanel extends JPanel {
    String paperName;
    int mark;
    int examTime;
    int difficulty;

    public PaperPreviewPanel(String paperName,int mark,int examTime,int difficulty,String QuestionString){
        PaperPreview_Title mainTitle=new PaperPreview_Title(paperName,mark,examTime,difficulty);
        setLayout(new VFlowLayout());
        add(mainTitle);

    }
}
