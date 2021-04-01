package Student.Frame;

import javax.swing.*;

public class Main {
    public static void main(String[] args){
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Throwable e) {
            e.printStackTrace();
        }
        new MainFrame();
    }
}
