package Teacher.Util.Component.MyPanel;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.RoundRectangle2D;

public class HeadImagePanel extends JPanel {

    ImageIcon imageIcon = new ImageIcon("src/Teacher/Util/Images/HomeImage/a.png");
//    final Image image = imageIcon.getImage();
    public void setImageIcon(ImageIcon imageIcon) {
        this.imageIcon = imageIcon;
    }

    private JLabel imageLabel;
    public HeadImagePanel () {
        setOpaque(true);
        setPreferredSize(new Dimension(120,120));
        imageLabel = new JLabel(imageIcon);
      //  add(imageLabel);
        setBackground(Color.CYAN);
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
