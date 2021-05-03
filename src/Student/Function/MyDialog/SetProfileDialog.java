package Student.Function.MyDialog;

import Basic.Command;
import Student.Bean.Student;
import Student.Function.PictureFileFilter;
import com.alibaba.fastjson.JSON;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.*;
import java.net.Socket;
import java.util.Locale;

import static Basic.Login.HOST;
import static Basic.Login.PORT;

public class SetProfileDialog extends JDialog implements ActionListener {
    JButton uploadBtn, confirmAvatarBtn, confirmNameBtn;

    JFileChooser jfc;
    File newAvatar;
    ImageIcon imageIcon;
    JLabel avatar;
    JTextField setNameField;

    Student student;

    String suffix;

    public SetProfileDialog(Student student, ImageIcon imageIcon) {
        super();
        setLayout(null);
        setTitle("修改个人资料");
        setModal(true);
        setSize(600, 700);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        this.imageIcon = imageIcon;
        this.student = student;

        Font setProFont = new Font("微软雅黑", Font.PLAIN, 20);
        Font setAvatarFont = new Font("宋体", Font.BOLD, 19);

        JLabel setAvatarLabel = new JLabel("修改头像");
        setAvatarLabel.setFont(setProFont);
        setAvatarLabel.setBounds(30, 20, 200, 20);
        add(setAvatarLabel);

        ImageIcon tempImage = new ImageIcon();
        tempImage.setImage(imageIcon.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT));
        avatar = new JLabel(tempImage);
        avatar.setBounds(130, 55, 100, 100);
        add(avatar);

        uploadBtn = new JButton("上传头像");
        uploadBtn.setBounds(280, 70, 110, 65);
        uploadBtn.setFont(setAvatarFont);
        uploadBtn.setFocusPainted(false);
        uploadBtn.setFocusable(false);
        jfc = new JFileChooser();
        jfc.setCurrentDirectory(new File("D:/"));
        jfc.setFileSelectionMode(JFileChooser.FILES_ONLY);
        jfc.setFileFilter(new PictureFileFilter());
        uploadBtn.addActionListener(this);

        confirmAvatarBtn = new JButton("确定修改");
        confirmAvatarBtn.setBounds(400, 70, 110, 65);
        confirmAvatarBtn.setFont(setAvatarFont);
        confirmAvatarBtn.setFocusPainted(false);
        confirmAvatarBtn.setFocusable(false);
        confirmAvatarBtn.setVisible(false);
        confirmAvatarBtn.addActionListener(this);


        add(uploadBtn);
        add(confirmAvatarBtn);

        JLabel setNameLabel = new JLabel("修改姓名");
        setNameLabel.setFont(setProFont);
        setNameLabel.setBounds(30, 180, 200, 20);
        add(setNameLabel);
        setNameField = new JTextField(null, student.getName(), 25);
        setNameField.setFont(setProFont);
        setNameField.setBounds(50, 250, 300, 40);
        add(setNameField);
        confirmNameBtn = new JButton("确定修改");
        confirmNameBtn.setFont(setAvatarFont);
        confirmNameBtn.setFocusable(false);
        confirmNameBtn.setFocusPainted(false);
        confirmNameBtn.setBounds(400, 240, 110, 65);
        confirmNameBtn.addActionListener(this);
        add(confirmNameBtn);


        JLabel setClassLabel = new JLabel("加入班级");
        JLabel quitClassLabel = new JLabel("退出班级");
        setClassLabel.setFont(setProFont);
        quitClassLabel.setFont(setProFont);
        setClassLabel.setBounds(30, 340, 200, 20);
        quitClassLabel.setBounds(30, 500, 200, 20);
        add(setClassLabel);
        add(quitClassLabel);


        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(uploadBtn)) {
            jfc.showDialog(new JLabel(), "选择");
            newAvatar = jfc.getSelectedFile();
            if (newAvatar != null) {
                int lastIndexOf = newAvatar.getName().lastIndexOf(".");
                //获取文件的后缀名
                suffix = newAvatar.getName().substring(lastIndexOf).toLowerCase(Locale.ROOT);
                System.out.println(suffix);
                if ((suffix.equals(".gif")) || (suffix.equals(".jpg")) || suffix.equals(".jpeg") || suffix.equals(".png")) {
                    uploadBtn.setText("重新上传");
                    ImageIcon tempImage = new ImageIcon(newAvatar.getAbsolutePath());
                    tempImage.setImage(tempImage.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT));
                    avatar.setIcon(tempImage);
                    confirmAvatarBtn.setVisible(true);
                } else {
                    JOptionPane.showMessageDialog(null, "图片格式错误！");
                    newAvatar = null;
                }
            }
        }
        if (e.getSource().equals(confirmAvatarBtn)) {
            try {
                NetSetAvatar netSetAvatar = new NetSetAvatar(student);
                if (netSetAvatar.getResultCode().equals("1"))
                    JOptionPane.showMessageDialog(null, "修改成功");
                else
                    JOptionPane.showMessageDialog(null, "修改失败");
            } catch (Exception exception) {
                exception.printStackTrace();
            }
        }
        if (e.getSource().equals(confirmNameBtn)) {
            try {
                String newName = setNameField.getText();
                if (newName.length() > 25)
                    JOptionPane.showMessageDialog(null, "名称过长");
                else if (!newName.equals(student.getName())) {
                    NetSetName netSetName = new NetSetName(student, newName);
                    if (netSetName.getResultCode().equals("1")) {
                        JOptionPane.showMessageDialog(null, "修改成功");
                        student.setName(newName);
                    } else
                        JOptionPane.showMessageDialog(null, "修改失败");
                }
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
        }
    }


    private class NetSetAvatar {
        private final DataOutputStream dos;
        private final String resultCode;

        public NetSetAvatar(Student student) throws Exception {
            Socket socket = new Socket(HOST, PORT);
            dos = new DataOutputStream(new BufferedOutputStream(socket.getOutputStream()));
            DataInputStream dis = new DataInputStream(new BufferedInputStream(socket.getInputStream()));
            PrintWriter opw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(socket.getOutputStream())), true);
            dos.writeUTF(Command.S_SET_AVATAR);
            dos.flush();
            opw.println(JSON.toJSONString(student));
            resultCode = dis.readUTF();
            sendFile(newAvatar.getAbsolutePath());
            socket.close();
        }

        public String getResultCode() {
            return resultCode;
        }

        private void sendFile(String path) throws Exception {//传图方法，直接用就行
            FileInputStream fis;
            File file = new File(path);
            if (file.exists()) {
                fis = new FileInputStream(file);
                dos.writeUTF(suffix);
                dos.flush();
                byte[] bytes = new byte[1024];
                int length;
                while ((length = fis.read(bytes, 0, bytes.length)) != -1) {
                    dos.write(bytes, 0, length);
                    dos.flush();
                }
            }
        }
    }

    private static class NetSetName {
        private final String resultCode;

        public NetSetName(Student student, String newName) throws IOException {
            Socket socket = new Socket(HOST, PORT);
            DataOutputStream dos = new DataOutputStream(new BufferedOutputStream(socket.getOutputStream()));
            DataInputStream dis = new DataInputStream(new BufferedInputStream(socket.getInputStream()));
            PrintWriter opw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(socket.getOutputStream())), true);
            dos.writeUTF(Command.S_SET_NAME);
            dos.flush();
            dos.writeUTF(newName);
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
