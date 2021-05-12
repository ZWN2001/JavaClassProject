package Teacher.View.MyStudent;

import Teacher.Util.AdapterAndHelper.GBC;
import Teacher.Util.Component.MyButton.BackgroundButton;
import Teacher.Util.MyFont;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class CheckStudentCard extends JPanel {
    public BackgroundButton detailedBtn;
    String studentNameText;
    public CheckStudentCard(String studentNameText) {
        this.studentNameText=studentNameText;
        setLayout(new GridBagLayout());
        setBackground(Color.WHITE);
        Border border=getBorder();
        Border margin = new EmptyBorder(10,10,8,10);//边距设置
        setBorder(new CompoundBorder(border, margin));//加到组件上

        JLabel studentName=new JLabel("学生姓名:"+studentNameText);
        studentName.setFont(MyFont.Font_16);
         detailedBtn=new BackgroundButton("查看信息");
        detailedBtn.setFont(MyFont.Font_16);

        add(studentName,new GBC(0,0).setWeightx(1).setFill(GridBagConstraints.HORIZONTAL).setAnchor(GridBagConstraints.WEST).setInsets(4,6,5,4));
        add(detailedBtn,new GBC(1,0).setAnchor(GridBagConstraints.EAST).setInsets(4,6,5,4));
    }

    public String getStudentNameText() {
        return studentNameText;
    }
}
