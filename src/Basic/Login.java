package Basic;

import Teacher.Util.GBC;

import javax.swing.*;
import java.awt.*;

public class Login {
    public static void main(String[] args) {
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
        setLayout(new GridBagLayout());

        Toolkit kit = Toolkit.getDefaultToolkit();
        Dimension screenSize = kit.getScreenSize();
        int width = screenSize.width;
        int height = screenSize.height;
        int x = (width - WIDTH) / 2;
        int y = (height - HEIGHT) / 2;
        setLocation(x,y);

        JTextField accountText = new JTextField(14);
        JTextField passwordText = new JTextField(14);
        JButton studentLoginBtn = new JButton("学生登录");
        JButton teacherLoginBtn = new JButton("教师登录");
        JButton registerBtn = new JButton("注册");

        JLabel accountLabel = new JLabel("账号:");
        accountText.setMaximumSize(accountText.getPreferredSize());
        JLabel passwordLabel = new JLabel("密码:");
        passwordText.setMaximumSize(passwordText.getPreferredSize());

        add(accountLabel, new GBC(0, 0).setInsets(10,10,0,0));
        add(accountText,new GBC(1,0,2,1).setWeight(2,1).setInsets(10,0,0,10));
        add(passwordLabel, new GBC(0, 1).setInsets(10,10,10,0));
        add(passwordText,new GBC(1,1,2,1).setWeight(2,1).setInsets(10,0,10,10));
        add(studentLoginBtn,new GBC(0,3).setInsets(5,15,10,5));
        add(teacherLoginBtn,new GBC(1,3).setInsets(5,5,10,5));
        add(registerBtn,new GBC(2,3).setInsets(5,5,10,15));
    }
}

