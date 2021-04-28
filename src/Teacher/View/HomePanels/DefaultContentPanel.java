package Teacher.View.HomePanels;

import java.awt.Graphics;

import javax.swing.*;
import java.awt.*;

class DefaultContentPanel extends JPanel {
String imgPath="src/Teacher/Util/Images/HomeImage/welcome.png";
    final ImageIcon bgImageIcon = new ImageIcon(imgPath);
    final Image image = bgImageIcon.getImage();
    public void paint(Graphics g) {
        g.drawImage(image, 0, 0, this.getWidth(), this.getHeight(), null);
    }

}