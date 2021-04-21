package Basic;

import Student.Bean.Student;
import Student.Server.Server;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.net.Socket;
import java.util.Arrays;

public class TempRegister extends JFrame {
    public TempRegister() {
        setSize(600, 400);
        setResizable(false);
        setLocationRelativeTo(null);
        JPanel panel = new JPanel(new GridLayout(5, 2));
        add(panel);

        JLabel accountLabel = new JLabel("输入账号");
        JLabel nameLabel = new JLabel("输入姓名");
        JLabel pwLabel = new JLabel("输入密码");
        JLabel conPwLabel = new JLabel("确认密码");

        JTextField accountText = new JTextField(20);
        JTextField nameText = new JTextField(20);
        JPasswordField passwordField = new JPasswordField("", 20);
        JPasswordField conPwField = new JPasswordField("", 20);

        JButton confirm = new JButton("确定");
        JButton cancel = new JButton("取消");
        confirm.addActionListener(e -> {
            if (accountText.getText().equals("") || nameText.getText().equals("") || passwordField.getPassword().length == 0 || conPwField.getPassword().length == 0)
                JOptionPane.showMessageDialog(null, "输入不能为空");
            else if (!Arrays.equals(passwordField.getPassword(), conPwField.getPassword()))
                JOptionPane.showMessageDialog(null, "前后输入密码不一致");
            else {
                Student student = new Student(nameText.getText(), accountText.getText(), String.valueOf(passwordField.getPassword()));
                try {
                    NetRegister netRegister = new NetRegister(student);
                    if (netRegister.getResultCode().equals("1")){
                        JOptionPane.showMessageDialog(null,"注册成功！");
                    }
                    else{
                        JOptionPane.showMessageDialog(null,"注册失败，可能是因为账号已被占用","注册失败",JOptionPane.ERROR_MESSAGE);
                    }
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
            }
        });
        cancel.addActionListener(e -> dispose());

        panel.add(accountLabel);
        panel.add(accountText);
        panel.add(nameLabel);
        panel.add(nameText);
        panel.add(pwLabel);
        panel.add(passwordField);
        panel.add(conPwLabel);
        panel.add(conPwField);
        panel.add(confirm);
        panel.add(cancel);

        setVisible(true);
    }

    private class NetRegister {
        Socket socket = new Socket("LAPTOP-V7DQD3F1", Server.PORT);
        DataInputStream dis = new DataInputStream(new BufferedInputStream(socket.getInputStream()));
        DataOutputStream dos = new DataOutputStream(new BufferedOutputStream(socket.getOutputStream()));
        ObjectOutputStream ous = new ObjectOutputStream(new BufferedOutputStream(socket.getOutputStream()));
        String resultCode;

        public NetRegister(Student student) throws IOException {
            System.out.println("进入构造方法");
            dos.writeUTF("REGISTER");
            System.out.println("写入指令");
            dos.flush();
            ous.writeObject(student);
            System.out.println("写入对象");
            ous.flush();
            System.out.println("等待服务端响应");
            resultCode = dis.readUTF();
        }

        public String getResultCode() {
            return resultCode;
        }
    }
}


