package Basic;

import Student.Bean.Student;
import Teacher.Bean.Teacher;
import Teacher.Util.AdapterAndHelper.GBC;
import com.alibaba.fastjson.JSON;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.net.Socket;
import java.util.Arrays;

public class RegisterFrame extends JFrame {

    public RegisterFrame(JFrame parentFrame) {
        parentFrame.setVisible(false);
        setSize(600, 400);
        setResizable(false);
        setLocationRelativeTo(null);
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                super.windowClosing(e);
                parentFrame.setVisible(true);
            }
        });


        JTabbedPane tabbedPane = new JTabbedPane();
        tabbedPane.setFocusable(false);
        tabbedPane.addTab("学生注册", new RegisterPanel(parentFrame, this, "s"));
        tabbedPane.addTab("教师注册", new RegisterPanel(parentFrame, this, "t"));
        add(tabbedPane);
        setVisible(true);
    }

    private static class NetStudentRegister {
        private final String resultCode;

        public NetStudentRegister(Student student) throws Exception {
            Socket socket = new Socket(Login.HOST, Login.PORT);
            DataOutputStream dos = new DataOutputStream(new BufferedOutputStream(socket.getOutputStream()));
            DataInputStream dis = new DataInputStream(new BufferedInputStream(socket.getInputStream()));
            PrintWriter opw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(socket.getOutputStream())), true);
            dos.writeUTF(Command.S_REGISTER);
            dos.flush();
            opw.println(JSON.toJSONString(student));
            resultCode = dis.readUTF();
            socket.close();
        }
        public String getResultCode() {
            return resultCode;
        }
    }

    private static class NetTeacherRegister {
        private final String resultCode;

        public NetTeacherRegister(Teacher teacher) throws Exception {
            Socket socket = new Socket(Login.HOST, Login.PORT);
            DataOutputStream dos = new DataOutputStream(new BufferedOutputStream(socket.getOutputStream()));
            DataInputStream dis = new DataInputStream(new BufferedInputStream(socket.getInputStream()));
            PrintWriter opw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(socket.getOutputStream())), true);
            dos.writeUTF(Command.T_REGISTER);
            dos.flush();
            opw.println(JSON.toJSONString(teacher));
            resultCode = dis.readUTF();
            socket.close();
        }

        public String getResultCode() {
            return resultCode;
        }


    }

    static class RegisterPanel extends JPanel {
        public RegisterPanel(JFrame parentFrame, JFrame registerFrame, String type) {
            setLayout(new GridBagLayout());

            Font registerFont = new Font("黑体",Font.PLAIN,27);
            JLabel accountLabel = new JLabel("输入账号");
            JLabel nameLabel = new JLabel("输入姓名");
            JLabel pwLabel = new JLabel("输入密码");
            JLabel conPwLabel = new JLabel("确认密码");

            accountLabel.setFont(registerFont);
            nameLabel.setFont(registerFont);
            pwLabel.setFont(registerFont);
            conPwLabel.setFont(registerFont);


            JTextField accountText = new JTextField(25);
            JTextField nameText = new JTextField(25);
            JPasswordField passwordField = new JPasswordField(25);
            JPasswordField conPwField = new JPasswordField(25);

            accountText.setFont(registerFont);
            nameText.setFont(registerFont);
            passwordField.setFont(registerFont);
            conPwField.setFont(registerFont);

            JButton confirm = new JButton("确定");
            confirm.setFont(registerFont);
            JButton cancel = new JButton("取消");
            cancel.setFont(registerFont);
            confirm.addActionListener(e ->
            {
                if (accountText.getText().equals("") || nameText.getText().equals("") || passwordField.getPassword().length == 0 || conPwField.getPassword().length == 0)
                    JOptionPane.showMessageDialog(null, "输入不能为空");
                else if (!Arrays.equals(passwordField.getPassword(), conPwField.getPassword()))
                    JOptionPane.showMessageDialog(null, "前后输入密码不一致");
                else {
                    if (type.equals("s")) {
                        Student student = new Student(nameText.getText(), accountText.getText(), String.valueOf(passwordField.getPassword()));
                        try {
                            NetStudentRegister netRegister = new NetStudentRegister(student);
                            if (netRegister.getResultCode().equals("1")) {
                                JOptionPane.showMessageDialog(null, "注册成功！");
                                parentFrame.setVisible(true);
                                registerFrame.dispose();
                            } else {
                                JOptionPane.showMessageDialog(null, "账号已被占用", "注册失败", JOptionPane.ERROR_MESSAGE);
                            }
                        } catch (Exception exception) {
                            JOptionPane.showMessageDialog(this, exception.getMessage(), "错误", JOptionPane.ERROR_MESSAGE);
                            exception.printStackTrace();
                        }
                    }else if (type.equals("t")){
                        Teacher teacher = new Teacher(accountText.getText(),nameText.getText(), String.valueOf(passwordField.getPassword()));
                        try{
                            NetTeacherRegister netRegister = new NetTeacherRegister(teacher);
                            if (netRegister.getResultCode().equals("1")) {
                                JOptionPane.showMessageDialog(null, "注册成功！");
                                parentFrame.setVisible(true);
                                registerFrame.dispose();
                            } else {
                                JOptionPane.showMessageDialog(null, "账号已被占用", "注册失败", JOptionPane.ERROR_MESSAGE);
                            }
                        } catch (Exception exception) {
                            exception.printStackTrace();
                        }
                    }
                }
            });
            cancel.addActionListener(e -> {
                registerFrame.dispose();
                parentFrame.setVisible(true);
            });

            add(accountLabel,new GBC(0,0,5,1).setAnchor(GridBagConstraints.WEST).setInsets(15));
            add(accountText,new GBC(5,0,5,1).setInsets(15));
            add(nameLabel,new GBC(0,5,5,1).setInsets(15));
            add(nameText,new GBC(5,5,5,1).setInsets(15));
            add(pwLabel,new GBC(0,10,5,1).setInsets(15));
            add(passwordField,new GBC(5,10,5,1).setInsets(15));
            add(conPwLabel,new GBC(0,15,5,1).setInsets(15));
            add(conPwField,new GBC(5,15,5,1).setInsets(15));
            add(confirm,new GBC(5,20).setInsets(0,10,0,10));
            add(cancel,new GBC(6,20).setInsets(0,10,0,10));

            setVisible(true);
        }
    }
}




