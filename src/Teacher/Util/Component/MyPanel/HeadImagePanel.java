package Teacher.Util.Component.MyPanel;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.RoundRectangle2D;

public class HeadImagePanel extends JPanel {
    String testHead="src/Teacher/Test/1.png";
    String defaultImage="src/Teacher/Util/Images/HomeImage/a.png";
    ImageIcon imageIcon = new ImageIcon(testHead);
    public void setImageIcon(ImageIcon imageIcon) {
        this.imageIcon = imageIcon;
    }

    private JLabel imageLabel;
    public HeadImagePanel () {
        setLayout(new BorderLayout());
        setOpaque(true);
//        setPreferredSize(new Dimension(120,120));
        Image img = imageIcon.getImage();
        img = img.getScaledInstance(100, 100, Image.SCALE_DEFAULT);
        imageIcon.setImage(img);
        imageLabel = new JLabel(imageIcon);
        imageLabel.setSize(100,100);
        add(imageLabel);
//        setBackground(Color.CYAN);
        setVisible(true);
    }

    @Override
    public void paint(Graphics g) {
        int fieldX = 0;
        int fieldY = 0;
        int fieldWeight = getSize().width;
        int fieldHeight = getSize().height;
        RoundRectangle2D rect = new RoundRectangle2D.Double(fieldX, fieldY, fieldWeight, fieldHeight, 500, 500);
        g.setClip(rect);
       // g.drawImage(image, fieldX, fieldY, fieldWeight, fieldHeight, null);
        super.paint(g);
    }


}
