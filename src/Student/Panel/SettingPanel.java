package Student.Panel;


import Basic.Command;
import Basic.Login;
import Student.Bean.Student;
import Student.Frame.MainFrame;
import Student.Function.MyDialog.*;
import Teacher.Bean.Teacher;
import com.alibaba.fastjson.JSON;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.net.Socket;

import static Basic.Login.HOST;
import static Basic.Login.PORT;

public class SettingPanel extends JPanel implements MouseListener {
    private final JButton setPassword, setProfile, logOut;
    private final MainFrame mainFrame;
    private final Student student;
    private ImageIcon imageIcon;
    private final JLabel netName;
    private final JTextArea classArea;
    ImageIcon setPwu = new ImageIcon("src/Student/Resource/setPwu.png");
    ImageIcon setPwd = new ImageIcon("src/Student/Resource/setPwd.png");
    ImageIcon setProU = new ImageIcon("src/Student/Resource/setProU.png");
    ImageIcon setProD = new ImageIcon("src/Student/Resource/setProD.png");
    ImageIcon logOutU = new ImageIcon("src/Student/Resource/logOutU.png");
    ImageIcon logOutD = new ImageIcon("src/Student/Resource/logOutD.png");

    public SettingPanel(MainFrame mainFrame, ImageIcon imageIcon) {
        setBackground(Color.WHITE);
        setBounds(250, 0, 1450, 860);
        setVisible(false);
        setLayout(null);
        this.mainFrame = mainFrame;
        student = mainFrame.getStudent();
        this.imageIcon = imageIcon;


        setPassword = new JButton();
        setPassword.addMouseListener(this);
        setPassword.setIcon(setPwu);
        setPassword.setFocusPainted(false);
        setPassword.setBounds(900, 150, 200, 75);
        setPassword.setContentAreaFilled(false);
        add(setPassword);

        setProfile = new JButton();
        setProfile.addMouseListener(this);
        setProfile.setIcon(setProU);
        setProfile.setFocusPainted(false);
        setProfile.setBounds(900, 300, 200, 75);
        setProfile.setContentAreaFilled(false);
        add(setProfile);

        logOut = new JButton();
        logOut.addMouseListener(this);
        logOut.setIcon(logOutU);
        logOut.setFocusPainted(false);
        logOut.setBounds(900, 450, 200, 75);
        logOut.setContentAreaFilled(false);
        add(logOut);

        JLabel basicPro = new JLabel("基本信息");
        Font basicProFont = new Font("微软雅黑", Font.BOLD, 45);
        basicPro.setFont(basicProFont);
        basicPro.setBounds(100, 5, 200, 150);

        JLabel account = new JLabel("账号:");
        JLabel name = new JLabel("姓名:");
        JLabel beClass = new JLabel("班级:");
        Font profileFont = new Font("微软雅黑", Font.PLAIN, 30);
        account.setFont(profileFont);
        name.setFont(profileFont);
        beClass.setFont(profileFont);
        account.setBounds(120, 150, 70, 40);
        name.setBounds(120, 240, 70, 40);
        beClass.setBounds(120, 330, 70, 40);
        add(basicPro);
        add(account);
        add(name);
        add(beClass);

        JLabel netAccount = new JLabel(student.getAccount());
        netName = new JLabel(student.getName());
        netAccount.setFont(profileFont);
        netName.setFont(profileFont);
        netAccount.setBounds(220, 150, 200, 40);
        netName.setBounds(220, 240, 200, 40);
        add(netAccount);
        add(netName);

        classArea = new JTextArea();
        classArea.setLineWrap(true);
        classArea.setEditable(false);
        try {
            new NetGetClass(student,classArea);
        } catch (IOException e) {
            e.printStackTrace();
        }
        JScrollPane classPane = new JScrollPane(classArea,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        classPane.setBounds(220,340,600,400);
        classPane.setBorder(null);
        add(classPane);
    }

    private static class NetGetClass {

        public NetGetClass(Student student, JTextArea classArea) throws IOException {
            Socket socket = new Socket(HOST, PORT);
            DataOutputStream dos = new DataOutputStream(new BufferedOutputStream(socket.getOutputStream()));
            DataInputStream dis = new DataInputStream(new BufferedInputStream(socket.getInputStream()));
            PrintWriter opw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(socket.getOutputStream())), true);
            BufferedReader obr = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            dos.writeUTF(Command.S_GET_CLASS);
            dos.flush();
            opw.println(JSON.toJSONString(student));
            String resultCode = dis.readUTF();
            if (resultCode.equals("0")) {
                classArea.setBorder(null);
                classArea.setFont(new Font("微软雅黑",Font.PLAIN,25));
                classArea.setText("当前还未加入任何班级");
                socket.close();
            } else if (resultCode.equals("1")) {
                classArea.setBorder(new JScrollPane().getBorder());
                String text = "";
//                while (true) {
//                    Teacher teacher = JSON.parseObject(obr.readLine(), Teacher.class);
//                    if (teacher.getAccount().equals(""))
//                        break;
//                    text = text.concat(teacher+"\n");
//                    classArea.setFont(new Font("宋体",Font.PLAIN,25));
//                    classArea.setText(text);
//                }
            }
        }
    }

    public void refresh() {
        netName.setText(student.getName());
        try {
            new NetGetClass(student,classArea);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getSource().equals(setPassword))
            new SetPasswordDialog(student);
        if (e.getSource().equals(setProfile))
            new SetProfileDialog(student, imageIcon,this);
        if (e.getSource().equals(logOut)) {
            if (JOptionPane.showConfirmDialog(null, "                 确定退出当前账号吗", "注销", JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE) == 0) {
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

    public void setImageIcon(ImageIcon imageIcon) {
        this.imageIcon = imageIcon;
    }
}
