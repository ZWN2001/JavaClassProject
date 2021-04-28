package Student.Frame;


import Student.Bean.Student;

import javax.swing.*;
import java.awt.*;

import static Basic.Login.PATH;

public class Main {
    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Throwable e) {
            e.printStackTrace();
        }
        Student testStudent = new Student("123456","123456","123456");
        testStudent.setImage(PATH+"defaultHeadImage.png");
        EventQueue.invokeLater(() -> new MainFrame(testStudent,new ImageIcon(testStudent.getImage())));
    }
}

