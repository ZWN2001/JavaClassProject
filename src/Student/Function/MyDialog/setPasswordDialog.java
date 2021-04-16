package Student.Function.MyDialog;

import javax.swing.*;
import java.awt.*;

public class setPasswordDialog extends JDialog {
    public setPasswordDialog(){
        super();
        Container container = getContentPane();
        container.setLayout(null);
        setTitle("修改密码");
        setSize(400,500);
        setModal(true);
        setResizable(false);
        setLocationRelativeTo(null);


        Font setPsFont = new Font("微软雅黑", Font.PLAIN,20);

        JLabel preLabel = new JLabel("输入之前的密码");
        JLabel newLabel = new JLabel("输入新密码");
        JLabel confirmLabel = new JLabel("确认新密码");
        preLabel.setFont(setPsFont);
        newLabel.setFont(setPsFont);
        confirmLabel.setFont(setPsFont);
        preLabel.setBounds(20,-60,200,200);
        newLabel.setBounds(20,60,200,200);
        confirmLabel.setBounds(20,180,200,200);


        JPasswordField newPs = new JPasswordField(25);
        JPasswordField confirmPs = new JPasswordField(25);
        JPasswordField prePs = new JPasswordField(25);
        newPs.setFont(setPsFont);
        confirmPs.setFont(setPsFont);
        prePs.setFont(setPsFont);
        prePs.setBounds(20,70,350,35);
        newPs.setBounds(20,190,350,35);
        confirmPs.setBounds(20,310,350,35);


        JButton yes = new JButton("确定");
        JButton no = new JButton("取消");
        yes.setBounds(60,400,100,50);
        no.setBounds(240,400,100,50);
        yes.setFont(setPsFont);
        no.setFont(setPsFont);
        yes.setFocusPainted(false);
        no.setFocusPainted(false);


        add(newLabel);
        add(confirmLabel);
        add(preLabel);
        add(prePs);
        add(newPs);
        add(confirmPs);
        add(yes);
        add(no);

        setVisible(true);
    }
}
