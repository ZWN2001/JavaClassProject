package Teacher.Util.Component.MyPanel.QuestionCads;

import Teacher.Util.Adapter.GBC;
import Teacher.Util.Component.MyButton.BackgroundButton;
import Teacher.Util.Layout.VFlowLayout;
import javax.swing.*;
import java.awt.*;
/**
 * @ClassName:
 * @Description: 试题卡片
 * @parms:
 * @author 赵炜宁
 * @date stem 题干
 *       titlePanel 顶部标题
 *       stemPanel 题目
 *       heightWeight 每一行高度所占的权重
 */
public class QuestionCardPanel extends JPanel {
     String stemText="aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa" +
             "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa" ;
    Font titleFont=new Font("宋体",Font.PLAIN,16);
    public QuestionCardPanel () {
        setBackground(Color.WHITE);
        setLayout(new VFlowLayout());
        JTextArea stem=new JTextArea(stemText);
        int heightWeight= stemText.length()/115+1;
        System.out.println(heightWeight);
        setPreferredSize(new Dimension(900,23*heightWeight+60));
        JPanel titlePanel =new JPanel(new GridBagLayout());

        JLabel mark=new JLabel("分值：");
        mark.setFont(titleFont);
        JLabel difficulty=new JLabel("难度系数:");
        difficulty.setFont(titleFont);
        JLabel answer=new JLabel("答案:");
        difficulty.setFont(titleFont);
        BackgroundButton change=new BackgroundButton("修改");
        change.setUnFocusedColor(Color.WHITE);
        change.setBackground(Color.WHITE);
        BackgroundButton delete= new BackgroundButton("删除");
        delete.setUnFocusedColor(Color.WHITE);
        delete.setBackground(Color.WHITE);

        titlePanel.add(mark,new GBC(0,0).setInsets(0,0,0,20));
        titlePanel.add(answer,new GBC(0,0).setInsets(0,0,0,20));
        titlePanel.add(difficulty,new GBC(1,0).setInsets(0,0,0,300));
        titlePanel.add(change,new GBC(3,0).setInsets(0,0,0,20));
        titlePanel.add(delete,new GBC(4,0));
        titlePanel.setBackground(Color.WHITE);

        JScrollPane stemPanel = new JScrollPane(stem);
        stem.setEnabled(false);
        stem.setLineWrap(true);
        stem.setWrapStyleWord(true);

        add(titlePanel);
        add(stemPanel);
//        setAutoscrolls(true);
    }

}
