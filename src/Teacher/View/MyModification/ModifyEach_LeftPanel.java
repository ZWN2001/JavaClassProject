package Teacher.View.MyModification;

import Teacher.Util.AdapterAndHelper.GBC;
import Teacher.Util.Component.MyButton.BackgroundButton;
import Teacher.Util.Component.MyTextArea.MyTextArea_Colorful;
import Teacher.Util.Component.MyTextArea.MyTextArea_Normal;

import javax.swing.*;
import java.awt.*;

/**
 * @ClassName:
 * @Description: 批改题目界面左侧的展示单个题目答案的panel
 * @parms:
 * @author 赵炜宁
 * @date
 *
 */
public class ModifyEach_LeftPanel extends JPanel {

    private static int mark=0;
    public MyTextArea_Colorful setMyMark;
    public ModifyEach_LeftPanel(String answerText){
        setLayout(new GridBagLayout());
        MyTextArea_Normal answer=new MyTextArea_Normal(10,40,"",answerText);
        answer.setAble(false);
        JLabel markLabel=new JLabel("打分：");
        JLabel l1=new JLabel("");
        add(l1,new GBC(0,1));
        add(l1,new GBC(1,1));
        setMyMark=new MyTextArea_Colorful(1,4,"",""+mark,true,true);
        add(answer,new GBC(0,0,4,1).setFill(GridBagConstraints.HORIZONTAL).setWeight(1,0.7).setInsets(10,5,5,5));
        add(markLabel,new GBC(2,1).setAnchor(GridBagConstraints.EAST).setInsets(4,40,14,4));
        add(setMyMark,new GBC(3,1).setAnchor(GridBagConstraints.WEST).setInsets(4,4,14,4));
    }
    public int getMark() {
        return mark;
    }
    public void setMark(int mark) {
        ModifyEach_LeftPanel.mark = mark;
    }
}

