package Basic;

import Teacher.Util.GBC;

import javax.swing.*;
import java.awt.*;

public class Login {
    public static void main(String[] args) {
        try {
            //设置样式
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Throwable e) {
            e.printStackTrace();
        }
        EventQueue.invokeLater(() ->{
            LoginFrame loginFrame=new LoginFrame();
            loginFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            loginFrame.setResizable(false);
            loginFrame.setVisible(true);
        });
    }
}
class LoginFrame extends JFrame{
    private static final int WIDTH = 300;
    private static final int HEIGHT = 200;

    public LoginFrame(){
        setSize(WIDTH,HEIGHT);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("欢迎登录");

        Toolkit kit = Toolkit.getDefaultToolkit();
        Dimension screenSize = kit.getScreenSize();
        int width = screenSize.width;
        int height = screenSize.height;
        int x = (width - WIDTH) / 2;
        int y = (height - HEIGHT) / 2;
        setLocation(x,y);
        JPanel rootPanel = new JPanel();
        setContentPane(rootPanel);

        JTextField accountText = new JTextField(25);
        JTextField passwordText = new JTextField(25);
        JButton studentLoginBtn = new JButton("学生登录");
        JButton teacherLoginBtn = new JButton("教师登录");
        JButton registerBtn = new JButton("注册");

        JLabel accountLabel = new JLabel("账号: ");
        accountText.setMaximumSize(accountText.getPreferredSize());
        JLabel passwordLabel = new JLabel("密码: ");
        passwordText.setMaximumSize(passwordText.getPreferredSize());
//
//        add(accountLabel,new GBC(0, 0,1,1).setInsets(10,0,0,0));
//        add(accountText,new GBC(1,0,4,1).setInsets(10,0,0,10));
//        add(passwordLabel,new GBC(0, 1,1,1).setInsets(20,0,10,0));
//        add(passwordText,new GBC(1,1,4,1).setInsets(20,0,10,10));
//        add(studentLoginBtn,new GBC(0,3,1,1).setInsets(25,15,5,5));
//        add(teacherLoginBtn,new GBC(2,3,1,1).setInsets(25,5,5,5));
//        add(registerBtn,new GBC(4,3,1,1).setInsets(25,5,5,15));

        Box accountBox=Box.createHorizontalBox();
        Box passwordBox=Box.createHorizontalBox();
        accountBox.add(accountLabel);
        accountBox.add(accountText);
        passwordBox.add(passwordLabel);
        passwordBox.add(passwordText);


        Box buttonBox=Box.createHorizontalBox();
        buttonBox.add(studentLoginBtn);
        buttonBox.add(Box.createHorizontalStrut(5));
        buttonBox.add(teacherLoginBtn);
        buttonBox.add(Box.createHorizontalStrut(5));
        buttonBox.add(registerBtn);

        Box rootBox=Box.createVerticalBox();
        rootBox.add(Box.createVerticalStrut(25));
        rootBox.add(accountBox);
        rootBox.add(Box.createVerticalStrut(15));
        rootBox.add(passwordBox);
        rootBox.add(Box.createVerticalStrut(35));
        rootBox.add(buttonBox);

        rootPanel.add(rootBox);

//        add(accountLabel,new GBC(0, 0).setWeightx(0.2));
//        add(accountText,new GBC(1,0).setWeightx(0.8).setFill(GridBagConstraints.HORIZONTAL));
//        add(passwordLabel,new GBC(0, 1).setWeightx(0.2));
//        add(passwordText,new GBC(1,1).setWeightx(0.8).setFill(GridBagConstraints.HORIZONTAL));
//        add(studentLoginBtn,new GBC(0,3));
//        add(teacherLoginBtn,new GBC(2,3));
//        add(registerBtn,new GBC(4,3));

//        add(accountLabel,new GBC(0, 0,1,1).setWeight(0.2,1));
//        add(accountText,new GBC(1,0,4,1).setWeight(0.8,1));
//        add(passwordLabel,new GBC(0, 1,1,1).setWeight(0.2,1));
//        add(passwordText,new GBC(1,1,4,1).setWeight(0.8,1));
//        add(studentLoginBtn,new GBC(0,3,1,1).setAnchor(GridBagConstraints.CENTER));
//        add(teacherLoginBtn,new GBC(2,3,1,1).setAnchor(GridBagConstraints.CENTER));
//        add(registerBtn,new GBC(4,3,1,1).setAnchor(GridBagConstraints.CENTER));
//
    }
}

