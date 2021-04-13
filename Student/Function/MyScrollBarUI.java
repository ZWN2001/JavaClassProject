package Student.Function;

import javax.swing.*;
import javax.swing.plaf.basic.BasicScrollBarUI;
import java.awt.*;

public class MyScrollBarUI extends BasicScrollBarUI {

        @Override
        public Dimension getPreferredSize(JComponent c) {
            // TODO Auto-generated method stub
            c.setPreferredSize(new Dimension(17, 0));
            return super.getPreferredSize(c);
        }


        public void paintTrack(Graphics g, JComponent c, Rectangle trackBounds) {
            Graphics2D g2 = (Graphics2D) g;
            GradientPaint gp = null;
            if (this.scrollbar.getOrientation() == JScrollBar.VERTICAL) {
                gp = new GradientPaint(0, 0, new Color(220, 240, 255), trackBounds.width, 0, new Color(220, 240, 255));
            }
            if (this.scrollbar.getOrientation() == JScrollBar.HORIZONTAL) {
                gp = new GradientPaint(0, 0, new Color(220, 240, 255), trackBounds.height, 0, new Color(220, 240, 255));
            }
            g2.setPaint(gp);
            //填充Track
            g2.fillRect(trackBounds.x, trackBounds.y, trackBounds.width, trackBounds.height);
        }

        @Override
        protected void paintThumb(Graphics g, JComponent c, Rectangle thumbBounds) {
            //把绘制区的x，y点坐标定义为坐标系的原点
            g.translate(thumbBounds.x, thumbBounds.y);
            g.setColor(new Color(100,170,210));
             g.drawRoundRect(0, 0, 15, thumbBounds.height - 1, 5, 5);
            Graphics2D g2 = (Graphics2D) g;
            //半透明
            g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.5f));
            //填充圆角矩形
            g2.fillRoundRect(0, 0, 40, thumbBounds.height - 1, 5, 5);
        }


        @Override
        protected JButton createIncreaseButton(int orientation) {
            JButton button = new JButton();
            button.setBorderPainted(false);
            button.setContentAreaFilled(false);
            button.setBorder(null);
            return button;
        }

        @Override
        protected JButton createDecreaseButton(int orientation) {
            JButton button = new JButton();
            button.setBorderPainted(false);
            button.setContentAreaFilled(false);
            button.setFocusable(false);
            button.setBorder(null);
            return button;
        }
    }

