package Student.Function.MyDialog;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UploadPaperDialog extends JDialog implements ActionListener {
    private final JButton yes;
    private int result=0;
    public UploadPaperDialog(){
        setLayout(null);
        setLocationRelativeTo(null);
        setSize(340,180);
        setModal(true);
        JLabel info = new JLabel("确定要提交吗");
        info.setBounds(110,20,150,40);
        info.setFont(new Font("微软雅黑",Font.PLAIN,15));
        yes = new JButton("确定");
        yes.setBounds(30,80,120,40);
        yes.setFocusable(false);
        yes.addActionListener(this);
        JButton no = new JButton("取消");
        no.setBounds(170,80,120,40);
        no.setFocusable(false);
        no.addActionListener(this);
        add(info);
        add(yes);
        add(no);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }

    public int getResult() {
        return result;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(yes)){
            result=1;
        }
        dispose();
    }
}
