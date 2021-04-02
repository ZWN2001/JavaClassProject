package Teacher.View;

import java.awt.Graphics;

import javax.swing.*;
import java.awt.*;

class DefaultContentPanel extends JPanel {

String imgPath="src/Teacher/Util/Images/HomeImage/welcome.png";
    final ImageIcon bgImageIcon = new ImageIcon(imgPath);
    final Image image = bgImageIcon.getImage();
    public DefaultContentPanel(){
        setLayout(new GridBagLayout());

        //  setBackground(Color.CYAN);

//        ImageIcon welcomeImage = new ImageIcon("src/Teacher/Util/Images/welcome.png");
//
//        JLabel imageLabel=new JLabel(welcomeImage);

//        setVisible(true);
    }
//    @Override
//    public void paintComponent(Graphics gs) {
//        Graphics2D g = (Graphics2D) gs;
//        super.paintComponent(g);
//        //画背景图片
//        Image image = Toolkit.getDefaultToolkit().getImage(getClass().getResource(imgPath));
//        g.drawImage(image, 0, 0,width,height, this);
//    }
    public void paint(Graphics g) {
        g.drawImage(image, 0, 0, this.getWidth(), this.getHeight(), null
        );
    }
}