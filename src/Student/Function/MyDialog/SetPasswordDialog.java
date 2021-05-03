package Student.Function.MyDialog;

import Basic.Command;
import Basic.Login;
import Student.Bean.Student;
import com.alibaba.fastjson.JSON;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.*;
import java.net.Socket;
import java.util.Arrays;

public class SetPasswordDialog extends JDialog implements MouseListener {
    private final JButton yes, no;
    private final JPasswordField prePs, newPs, confirmPs;
    private final Student student;

    public SetPasswordDialog(Student student) {
        super();
        setLayout(null);
        setTitle("修改密码");
        setSize(400, 500);
        setModal(true);
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        this.student = student;


        Font setPsFont = new Font("微软雅黑", Font.PLAIN, 20);

        JLabel preLabel = new JLabel("输入之前的密码");
        JLabel newLabel = new JLabel("输入新密码");
        JLabel confirmLabel = new JLabel("确认新密码");
        preLabel.setFont(setPsFont);
        newLabel.setFont(setPsFont);
        confirmLabel.setFont(setPsFont);
        preLabel.setBounds(20, 20, 200, 20);
        newLabel.setBounds(20, 140, 200, 20);
        confirmLabel.setBounds(20, 260, 200, 20);


        newPs = new JPasswordField(25);
        confirmPs = new JPasswordField(25);
        prePs = new JPasswordField(25);
        newPs.setFont(setPsFont);
        confirmPs.setFont(setPsFont);
        prePs.setFont(setPsFont);
        prePs.setBounds(20, 60, 350, 35);
        newPs.setBounds(20, 180, 350, 35);
        confirmPs.setBounds(20, 300, 350, 35);
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
            else if(newPs.getPassword().length>25)
                JOptionPane.showMessageDialog(null, "新密码过长！", "修改失败", JOptionPane.ERROR_MESSAGE);
            else {
                try {
                    NetPassword netPassword = new NetPassword(student, String.valueOf(prePs.getPassword()), String.valueOf(newPs.getPassword()));
                    switch (netPassword.getResultCode()) {
                        case "1":
                            JOptionPane.showMessageDialog(null, "修改成功！");
                            student.setPassword(String.valueOf(prePs.getPassword()));
                            this.dispose();
                            break;
                        case "0":
                            JOptionPane.showMessageDialog(null, "密码错误", "修改失败", JOptionPane.ERROR_MESSAGE);
                            break;
                        case "-1":
                            JOptionPane.showMessageDialog(null, "新密码与原密码相同", "修改失败", JOptionPane.ERROR_MESSAGE);
                            break;
                    }
                } catch (Exception exception) {
                    exception.printStackTrace();
                }
            }
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

    private static class NetPassword {
        private final String resultCode;

        public NetPassword(Student student, String pPassword, String newPassword) throws IOException {
            Socket socket = new Socket(Login.HOST, Login.PORT);
            DataOutputStream dos = new DataOutputStream(new BufferedOutputStream(socket.getOutputStream()));
            DataInputStream dis = new DataInputStream(new BufferedInputStream(socket.getInputStream()));
            PrintWriter opw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(socket.getOutputStream())), true);
            dos.writeUTF(Command.S_SET_PASSWORD);
            dos.flush();
            dos.writeUTF(pPassword);
            dos.flush();
            dos.writeUTF(newPassword);
            dos.flush();
            opw.println(JSON.toJSONString(student));
            resultCode = dis.readUTF();
            socket.close();
        }

        public String getResultCode() {
            return resultCode;
        }
    }
}
