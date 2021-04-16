package Teacher.Util.Component.MyPanel.QuestionCardUtils;

import Teacher.Util.Layout.VFlowLayout;

import javax.swing.*;

public class QuestionCard_Stem extends JPanel{
    String stemText="aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa" +
            "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa" ;
    public QuestionCard_Stem(){
        setLayout(new VFlowLayout(true,true));
        JTextArea stem=new JTextArea(stemText);
        JScrollPane pane=new JScrollPane();
        stem.setEnabled(false);
        stem.setLineWrap(true);
        stem.setWrapStyleWord(true);
        pane.getViewport().add(stem);
        add(pane);
    }

    public void setStemText(String stemText) {
        this.stemText = stemText;
    }
}
