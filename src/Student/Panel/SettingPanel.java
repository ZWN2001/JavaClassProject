package Student.Panel;


import Basic.Login;
import Student.Frame.MainFrame;
import Student.Function.MyDialog.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class SettingPanel extends JPanel implements MouseListener {
    JButton setPassword, setProfile, logOut;
    private final MainFrame mainFrame;
    ImageIcon setPwu = new ImageIcon("src/Student/Resource/setPwu.png");
    ImageIcon setPwd = new ImageIcon("src/Student/Resource/setPwd.png");
    ImageIcon setProU = new ImageIcon("src/Student/Resource/setProU.png");
    ImageIcon setProD = new ImageIcon("src/Student/Resource/setProD.png");
    ImageIcon logOutU = new ImageIcon("src/Student/Resource/logOutU.png");
    ImageIcon logOutD = new ImageIcon("src/Student/Resource/logOutD.png");

    public SettingPanel(MainFrame mainFrame) {
        setBackground(Color.WHITE);
        setBounds(250, 0, 1450, 860);
        setVisible(false);
        setLayout(null);
        this.mainFrame=mainFrame;


        setPassword = new JButton();
        setPassword.addMouseListener(this);
        setPassword.setIcon(setPwu);
        setPassword.setFocusPainted(false);
        setPassword.setBounds(900, 150, 200, 75);
        add(setPassword);

        setProfile = new JButton();
        setProfile.addMouseListener(this);
        setProfile.setIcon(setProU);
        setProfile.setFocusPainted(false);
        setProfile.setBounds(900, 300, 200, 75);
        add(setProfile);

        logOut = new JButton();
        logOut.addMouseListener(this);
        logOut.setIcon(logOutU);
        logOut.setFocusPainted(false);
        logOut.setBounds(900, 450, 200, 75);
        add(logOut);

        JLabel basicPro = new JLabel("基本信息");
        Font basicProFont = new Font("微软雅黑", Font.BOLD, 45);
        basicPro.setFont(basicProFont);
        basicPro.setBounds(100, 5, 200, 150);

        JLabel account = new JLabel("账号:");
        JLabel name = new JLabel("姓名:");
        JLabel beClass = new JLabel("班级：");
        Font profileFont = new Font("微软雅黑", Font.PLAIN, 30);
        account.setFont(profileFont);
        name.setFont(profileFont);
        beClass.setFont(profileFont);
        account.setBounds(120, 100, 150, 150);
        name.setBounds(120, 180, 150, 150);
        beClass.setBounds(120,260,150,150);
        add(basicPro);
        add(account);
        add(name);
        add(beClass);
    }


    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getSource().equals(setPassword))
            new setPasswordDialog();
        if (e.getSource().equals(setProfile))
            new setProfileDialog();
        if (e.getSource().equals(logOut)) {
            if (JOptionPane.showConfirmDialog(null, "               确定退出当前账号吗", "注销", JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE) == 0) {
                mainFrame.dispose();
                Login.main(null);
            }
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {
        if (e.getSource().equals(setPassword))
            setPassword.setIcon(setPwd);
        if (e.getSource().equals(setProfile))
            setProfile.setIcon(setProD);
        if (e.getSource().equals(logOut))
            logOut.setIcon(logOutD);
    }

    @Override
    public void mouseExited(MouseEvent e) {
        if (e.getSource().equals(setPassword))
            setPassword.setIcon(setPwu);
        if (e.getSource().equals(setProfile))
            setProfile.setIcon(setProU);
        if (e.getSource().equals(logOut))
            logOut.setIcon(logOutU);
    }
}
