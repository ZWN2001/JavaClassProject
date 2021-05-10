package Teacher.Util.Component.MyPanel;

import Teacher.Util.AdapterAndHelper.GBC;
import Teacher.Util.Component.MyButton.BackgroundButton;
import Teacher.Util.Component.MyTextArea.MyTextArea_Warning;

import javax.swing.*;
import java.awt.*;

public class MyWarningPanel extends JPanel {

    public BackgroundButton oKButton,cancelButton;
    public MyWarningPanel(String warningText) {
        setLayout(new GridBagLayout());
        MyTextArea_Warning warning=new MyTextArea_Warning(1,8,"warning",warningText);
        oKButton=new BackgroundButton("确定");
        cancelButton=new BackgroundButton("取消");
        add(warning,new GBC(0,0,2,1).setFill(GridBagConstraints.HORIZONTAL));
        add(oKButton,new GBC(0,1).setInsets(3,10,3,10));
        add(cancelButton,new GBC(1,1).setInsets(3,10,3,10));
    }
}
