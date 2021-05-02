package Teacher.View.MyPapers.AddPaperPanels.PaperPreview;

import Teacher.Util.Layout.VFlowLayout;

import javax.swing.*;

public class PaperPreviewPanel extends JPanel {
    String paperName;
    int mark;
    int examTime;
    int difficulty;

    public PaperPreviewPanel(){
        PaperPreview_Title mainTitle=new PaperPreview_Title("test",2,2,2);
        setLayout(new VFlowLayout());
        add(mainTitle);
    }
}
