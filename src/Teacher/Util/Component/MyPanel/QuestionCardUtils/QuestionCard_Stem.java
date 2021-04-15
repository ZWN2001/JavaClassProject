package Teacher.Util.Component.MyPanel.QuestionCardUtils;

import javax.swing.*;

public class QuestionCard_Stem extends JScrollPane{
    String stemText="aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa" +
            "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa" ;
    public QuestionCard_Stem(String stemText){
        JTextArea stem=new JTextArea(stemText);
        stem.setEnabled(false);
        stem.setLineWrap(true);
        stem.setWrapStyleWord(true);
        add(stem);
    }
}
