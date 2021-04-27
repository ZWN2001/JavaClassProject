package Teacher.Util.Component.MyPanel.QuestionCardUtils;

import Teacher.Util.Layout.VFlowLayout;

import javax.swing.*;

public class QuestionCard_Stem extends JPanel{
    String stemText=" ";
    JTextArea stem;

    public QuestionCard_Stem(String stemText){
        this.stemText=stemText;
        stem=new JTextArea(stemText);
      init();
    }

    public void init(){
        setLayout(new VFlowLayout(true,true));
        JScrollPane pane=new JScrollPane();
        stem.setEnabled(false);
        stem.setLineWrap(true);
        stem.setWrapStyleWord(true);
        pane.getViewport().add(stem);
        add(pane);
    }

    public void setStemText(String stemText) {
        this.stemText=stemText;
      stem.setText(stemText);
    }
}
