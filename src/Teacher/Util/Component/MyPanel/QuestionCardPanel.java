package Teacher.Util.Component.MyPanel;

import Teacher.Util.Adapter.GBC;
import Teacher.Util.Component.MyButton.TransparentButton;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.RoundRectangle2D;

public class QuestionCardPanel extends JPanel {
     String stemText="stem";
     String optionA="";
     String optionB="";
     String optionC="";
     String optionD="";

    public QuestionCardPanel () {
        setBackground(Color.WHITE);
        setLayout(new GridBagLayout());
        setPreferredSize(new Dimension(300,300));
        TransparentButton change=new TransparentButton("change");
        TransparentButton delete= new TransparentButton("delete");
        JTextArea stem=new JTextArea(stemText);
        add(stem,new GBC(0,1));

        add(change,new GBC(0,0).setAnchor(GridBagConstraints.EAST));
        add(delete,new GBC(1,0));
    }

//    @Override
//    public void paint(Graphics g) {
//        int fieldX = 0;
//        int fieldY = 0;
//        int fieldWeight = getSize().width;
//        int fieldHeight = getSize().height;
//        RoundRectangle2D rect = new RoundRectangle2D.Double(fieldX, fieldY, fieldWeight, fieldHeight, 20, 20);
//        g.setClip(rect);
//        super.paint(g);
//    }

}
