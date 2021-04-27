package Student.Function.MyDialog;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Arrays;

public class setPasswordDialog extends JDialog implements MouseListener {
    private final JButton yes, no;
    private final JPasswordField prePs, newPs, confirmPs;

    public setPasswordDialog() {
        super();
        setLayout(null);
        setTitle("修改密码");
        setSize(400, 500);
        setModal(true);
        setResizable(false);
        setLocationRelativeTo(null);


        Font setPsFont = new Font("微软雅黑", Font.PLAIN, 20);

        JLabel preLabel = new JLabel("输入之前的密码");
        JLabel newLabel = new JLabel("输入新密码");
        JLabel confirmLabel = new JLabel("确认新密码");
        preLabel.setFont(setPsFont);
        newLabel.setFont(setPsFont);
        confirmLabel.setFont(setPsFont);
        preLabel.setBounds(20, -70, 200, 200);
        newLabel.setBounds(20, 40, 200, 200);
        confirmLabel.setBounds(20, 160, 200, 200);


        newPs = new JPasswordField(25);
        confirmPs = new JPasswordField(25);
        prePs = new JPasswordField(25);
        newPs.setFont(setPsFont);
        confirmPs.setFont(setPsFont);
        prePs.setFont(setPsFont);
        prePs.setBounds(20, 60, 350, 35);
        newPs.setBounds(20, 170, 350, 35);
        confirmPs.setBounds(20, 290, 350, 35);
        newPs.addMouseListener(this);
        confirmPs.addMouseListener(this);
        prePs.addMouseListener(this);


        yes = new JButton("确定");
        no = new JButton("取消");
        yes.setBounds(60, 400, 100, 50);
        no.setBounds(220, 400, 100, 50);
        yes.setFont(setPsFont);
        no.setFont(setPsFont);
        yes.setFocusPainted(false);
        no.setFocusPainted(false);
        yes.addMouseListener(this);
        no.addMouseListener(this);


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

    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getSource().equals(yes)) {
            if ((prePs.getPassword().length == 0) || (newPs.getPassword().length == 0) || (confirmPs.getPassword().length == 0))
                JOptionPane.showMessageDialog(null, "输入不能为空！", "修改失败", JOptionPane.ERROR_MESSAGE);
            else if (!Arrays.equals(newPs.getPassword(), confirmPs.getPassword()))
                JOptionPane.showMessageDialog(null, "新密码前后输入不一致！", "修改失败", JOptionPane.ERROR_MESSAGE);
        }
        if (e.getSource().equals(no))
            dispose();
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {
        if (e.getSource().equals(prePs) || e.getSource().equals(confirmPs) || e.getSource().equals(newPs))
            setCursor(new Cursor(Cursor.TEXT_CURSOR));
    }

    @Override
    public void mouseExited(MouseEvent e) {
        setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
    }
}
