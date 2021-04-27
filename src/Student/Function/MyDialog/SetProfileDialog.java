package Student.Function.MyDialog;

import Basic.Command;
import Student.Bean.Student;
import Student.Function.PictureFileFilter;
import com.alibaba.fastjson.JSON;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.net.Socket;

import static Basic.Login.HOST;
import static Basic.Login.PORT;

public class SetProfileDialog extends JDialog implements ActionListener {
    JButton uploadBtn;
    JButton confirmAvatarBtn;

    JFileChooser jfc;
    File newAvatar;
    ImageIcon imageIcon;
    JLabel avatar;
    Student student;

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

        imageIcon.setImage(imageIcon.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT));
        avatar = new JLabel(imageIcon);
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
        JLabel setClassLabel = new JLabel("加入班级");
        JLabel quitClassLabel = new JLabel("退出班级");
        setNameLabel.setFont(setProFont);
        setClassLabel.setFont(setProFont);
        quitClassLabel.setFont(setProFont);
        setNameLabel.setBounds(30, 180, 200, 20);
        setClassLabel.setBounds(30, 340, 200, 20);
        quitClassLabel.setBounds(30, 500, 200, 20);
        add(setNameLabel);
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
                uploadBtn.setText("重新上传");
                ImageIcon tempImage = new ImageIcon(newAvatar.getAbsolutePath());
                tempImage.setImage(tempImage.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT));
                avatar.setIcon(tempImage);
                confirmAvatarBtn.setVisible(true);
            }
        }
        if (e.getSource().equals(confirmAvatarBtn)) {
            try {
                NetSetAvatar netSetAvatar = new NetSetAvatar(student);
                if (netSetAvatar.getResultCode().equals("1")) {
                    JOptionPane.showMessageDialog(null, "修改成功");
                } else
                    JOptionPane.showMessageDialog(null, "修改失败");
            } catch (Exception exception) {
                exception.printStackTrace();
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
                int lastIndexOf = file.getName().lastIndexOf(".");
                //获取文件的后缀名
                String suffix = file.getName().substring(lastIndexOf);

                dos.writeUTF(suffix);
                dos.flush();

                // 开始传输文件
                System.out.println("======== 开始传输文件 ========");
                byte[] bytes = new byte[1024];
                int length;
                while ((length = fis.read(bytes, 0, bytes.length)) != -1) {
                    dos.write(bytes, 0, length);
                    dos.flush();
                }
                System.out.println("======== 文件传输成功 ========");
            }
        }
    }
}
