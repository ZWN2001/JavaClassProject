package Basic;

import Student.Bean.Student;
import Student.Frame.Main;
import Student.Frame.MainFrame;
import Student.Server.Server;
import com.alibaba.fastjson.JSON;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.net.Socket;

import static Basic.Login.PATH;

public class Login {
    public static final String PATH = "D:/ExamAvatar/Client/";
    public static final String HOST = "LAPTOP-V7DQD3F1";
    public static int PORT = 2021;
    public static void main(String[] args) {
        try {
            //设置样式
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Throwable e) {
            e.printStackTrace();
        }
        EventQueue.invokeLater(() -> {
            LoginFrame loginFrame = new LoginFrame();
            loginFrame.setVisible(true);
        });
    }
}

class LoginFrame extends JFrame {
    private static final int WIDTH = 300;
    private static final int HEIGHT = 200;


    public LoginFrame() {
        Font myFont = new Font("宋体", Font.PLAIN, 16);
        setSize(WIDTH, HEIGHT);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setTitle("欢迎登录");
        setVisible(true);

        Toolkit kit = Toolkit.getDefaultToolkit();
        Dimension screenSize = kit.getScreenSize();
        int width = screenSize.width;
        int height = screenSize.height;
        int x = (width - WIDTH) / 2;
        int y = (height - HEIGHT) / 2;
        setLocation(x, y);
        JPanel rootPanel = new JPanel();
        setContentPane(rootPanel);

        JTextField accountText = new JTextField(25);
        JPasswordField passwordText = new JPasswordField(25);
        JButton studentLoginBtn = new JButton("学生登录");
        studentLoginBtn.setFont(myFont);
        studentLoginBtn.addActionListener(e -> {
            if (accountText.getText().equals("") || passwordText.getPassword().length == 0) {
                JOptionPane.showMessageDialog(null, "输入不能为空", "登录失败", JOptionPane.ERROR_MESSAGE);
            } else {
                Student student = new Student(accountText.getText(), String.valueOf(passwordText.getPassword()));
                try {
                    TempLogin tempLogin = new TempLogin(student);
                    if (tempLogin.getResultCode().equals("1")) {
                        student.setName(tempLogin.getName());
                        EventQueue.invokeLater(() -> new MainFrame(student, tempLogin.img));
                        this.dispose();
                    }
                    if (tempLogin.getResultCode().equals("0")) {
                        JOptionPane.showMessageDialog(null, "账号不存在", "登录失败", JOptionPane.ERROR_MESSAGE);
                    }
                    if (tempLogin.getResultCode().equals("-1")) {
                        JOptionPane.showMessageDialog(null, "密码错误", "登录失败", JOptionPane.ERROR_MESSAGE);
                    }
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
            }
        });


        JButton teacherLoginBtn = new JButton("教师登录");
        teacherLoginBtn.setFont(myFont);
        JButton registerBtn = new JButton("注册");
        registerBtn.setFont(myFont);
        registerBtn.addActionListener(e -> new TempRegister(this));
        JLabel accountLabel = new JLabel("账号: ");
        accountLabel.setFont(myFont);
        accountText.setPreferredSize(new Dimension(30, 25));
        JLabel passwordLabel = new JLabel("密码: ");
        passwordLabel.setFont(myFont);
        passwordText.setPreferredSize(new Dimension(30, 25));
//
//        add(accountLabel,new GBC(0, 0,1,1).setInsets(10,0,0,0));
//        add(accountText,new GBC(1,0,4,1).setInsets(10,0,0,10));
//        add(passwordLabel,new GBC(0, 1,1,1).setInsets(20,0,10,0));
//        add(passwordText,new GBC(1,1,4,1).setInsets(20,0,10,10));
//        add(studentLoginBtn,new GBC(0,3,1,1).setInsets(25,15,5,5));
//        add(teacherLoginBtn,new GBC(2,3,1,1).setInsets(25,5,5,5));
//        add(registerBtn,new GBC(4,3,1,1).setInsets(25,5,5,15));

        Box accountBox = Box.createHorizontalBox();
        Box passwordBox = Box.createHorizontalBox();
        accountBox.add(accountLabel);
        accountBox.add(accountText);
        passwordBox.add(passwordLabel);
        passwordBox.add(passwordText);


        Box buttonBox = Box.createHorizontalBox();
        buttonBox.add(studentLoginBtn);
        buttonBox.add(Box.createHorizontalStrut(5));
        buttonBox.add(teacherLoginBtn);
        buttonBox.add(Box.createHorizontalStrut(5));
        buttonBox.add(registerBtn);

        Box rootBox = Box.createVerticalBox();
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

    private static class TempLogin {
        Socket socket = new Socket("LAPTOP-V7DQD3F1", Server.PORT);
        PrintWriter opw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(socket.getOutputStream())),true);
        DataOutputStream dos = new DataOutputStream(new BufferedOutputStream(socket.getOutputStream()));
        DataInputStream dis = new DataInputStream(new BufferedInputStream(socket.getInputStream()));
        String resultCode;
        String name;
        ImageIcon img;
        String path;

        public TempLogin(Student student) throws IOException {
            dos.writeUTF(Command.S_LOGIN);
            dos.flush();
            opw.println(JSON.toJSONString(student));
            resultCode = dis.readUTF();
            if (resultCode.equals("1"))
            {
                name = dis.readUTF();
                getFile(PATH);
                img = new ImageIcon(ImageIO.read(new File(path)));
            }
            System.out.println("接收到返回值"+resultCode);
        }

        public String getResultCode() {
            return resultCode;
        }
        public String getName() {
            return name;
        }

        public void getFile(String filePath) throws IOException {//接收文件的方法，直接用即可,参数为存放文件夹路径，注意是文件夹
            FileOutputStream fos;
            // 文件名
            String fileName = dis.readUTF();
            System.out.println("接收到文件" + fileName);
            File directory = new File(filePath);
            if (!directory.exists()) {
                directory.mkdir();
            }
            File file = new File(directory.getAbsolutePath() + File.separatorChar + fileName);
            path = file.getAbsolutePath();
            fos = new FileOutputStream(file);
            // 开始接收文件
            byte[] bytes = new byte[1024];
            int length;
            while ((length = dis.read(bytes, 0, bytes.length)) != -1) {
                fos.write(bytes, 0, length);
                fos.flush();
            }
            System.out.println("======== 文件接收成功========");
        }
    }


}

