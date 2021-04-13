package Student.Function.MyDialog;

import javax.swing.*;
import java.awt.*;

public class setProfileDialog extends JDialog {
    public setProfileDialog(){
        super();
        Container container = getContentPane();
        container.setLayout(new GridLayout(0,1));
        setTitle("修改个人资料");
        setModal(true);
        setSize(500,600);
        setLocationRelativeTo(null);
        setVisible(true);
    }
}
