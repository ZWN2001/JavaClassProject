package Student.Panel;

import Basic.Command;
import Student.Bean.Student;
import com.alibaba.fastjson.JSON;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.awt.geom.RoundRectangle2D;
import java.io.*;
import java.net.Socket;

import static Basic.Login.*;

public class AvatarPanel extends JPanel {
    private final Student student;
    private DataInputStream dis;
    private String path;
    private ImageIcon img;
    private final JLabel userId;
    private final RoundJLabel avatar;
    public AvatarPanel(Student student, ImageIcon img) {
        this.student = student;
        this.img = img;

        setBounds(0, 0, 250, 250);
        setLayout(new BorderLayout());
        img.setImage(img.getImage().getScaledInstance(180, 180, Image.SCALE_DEFAULT));
        avatar = new RoundJLabel(img);
        avatar.setSize(180,180);
        add(avatar);
        userId = new JLabel(student.getName(), JLabel.CENTER);
        Font idFont = new Font("微软雅黑", Font.PLAIN, 25);
        userId.setFont(idFont);
        add("South", userId);

        setVisible(true);
    }

    public void refresh() throws Exception {
        Socket socket = new Socket(HOST, PORT);
        dis = new DataInputStream(new BufferedInputStream(socket.getInputStream()));
        DataOutputStream dos = new DataOutputStream(new BufferedOutputStream(socket.getOutputStream()));
        PrintWriter opw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(socket.getOutputStream())), true);

        dos.writeUTF(Command.S_REFRESH_AVATAR);
        dos.flush();

        opw.println(JSON.toJSONString(student));

        getFile(PATH);

        img = new ImageIcon(ImageIO.read(new File(path)));
        img.setImage(img.getImage().getScaledInstance(180, 180, Image.SCALE_DEFAULT));
        avatar.setIcon(img);
        userId.setText(student.getName());
    }

    private static class RoundJLabel extends JLabel{
        public RoundJLabel(ImageIcon img){
            super(img);
        }
        @Override
        public void paint(Graphics g) {
            Ellipse2D ellipse=new Ellipse2D.Double(35,17,180,180);
            g.setClip(ellipse);
            super.paint(g);
        }
    }

    public void getFile(String filePath) throws IOException {//接收文件的方法，直接用即可,参数为存放文件夹路径，注意是文件夹
        FileOutputStream fos;
        String fileName = dis.readUTF();
        File directory = new File(filePath);
        if (!directory.exists()) {
            directory.mkdir();
        }
        File file = new File(directory.getAbsolutePath() + File.separatorChar + fileName);
        path = file.getAbsolutePath();
        fos = new FileOutputStream(file);
        byte[] bytes = new byte[1024];
        int length;
        while ((length = dis.read(bytes, 0, bytes.length)) != -1) {
            fos.write(bytes, 0, length);
            fos.flush();
        }
    }
}
