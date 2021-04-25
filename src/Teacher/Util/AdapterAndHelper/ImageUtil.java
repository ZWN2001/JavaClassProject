package Teacher.Util.AdapterAndHelper;

import javax.swing.*;
import java.awt.*;

public class ImageUtil {
    /**
     * @Description 指定宽度缩放图片，若宽度或高度为0，则按照长宽比缩放
     * @param filename 图片的地址
     * @param description 描述
     * @param height 缩放后图片的宽度
     * @param width 缩放后图片的高度
     * @return javax.swing.ImageIcon
     * @author zwn
     * @Date 2021/4/14
     */
    public static ImageIcon getImageIcon(String filename, String description, int width, int height){
        ImageIcon imageIcon = new ImageIcon(filename,description);
        return getImageIcon(imageIcon,description,width,height);
    }
    public static ImageIcon getImageIcon(String filename, Dimension dimension){
        return getImageIcon(filename,null,dimension.width,dimension.height);
    }
    public static ImageIcon getImageIcon(ImageIcon imageIcon, String description, int width,int height){
        assert (width != 0 || height != 0);
        return new ImageIcon(imageIcon.getImage(),description){
            @Override
            public int getIconWidth() {
                if (width != 0){
                    return width;
                } else {
                    if (imageIcon.getIconHeight() > 0){
                        return imageIcon.getIconWidth() / (imageIcon.getIconHeight() / height);
                    } else {
                        return width;
                    }
                }
            }

            @Override
            public int getIconHeight() {
                if (height != 0){
                    return height;
                } else {
                    if (imageIcon.getIconWidth() > 0){
                        return imageIcon.getIconHeight() / (imageIcon.getIconWidth() / width);
                    } else {
                        return height;
                    }
                }

            }

            @Override
            public synchronized void paintIcon(Component c, Graphics g, int x, int y) {
                Graphics2D graphics2D = (Graphics2D) g.create();
                graphics2D.setRenderingHint(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON);
                graphics2D.drawImage(getImage(),x,y,getIconWidth(),getIconHeight(),c);
                graphics2D.dispose();
            }
        };
    }
}
