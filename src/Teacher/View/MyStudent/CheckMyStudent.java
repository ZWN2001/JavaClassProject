package Teacher.View.MyStudent;

import Teacher.Function.ClientFuction.MyStudent.GetMyStudent_C;
import Teacher.Util.Component.MyPanel.NullPanel;
import Teacher.Util.Component.MyTextArea.MyTextArea_Warning;
import Teacher.Util.Layout.VFlowLayout;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class CheckMyStudent extends JScrollPane {
    GetMyStudent_C getMyStudent;
    String[] studentName;
    int i;
    public CheckMyStudent() {
        JPanel rootPanel=new JPanel(new VFlowLayout(true,false));
        try {
            getMyStudent=new GetMyStudent_C("");//TODO
            studentName=getMyStudent.getStudentName();
        }catch (Exception ex){
            ex.printStackTrace();
            rootPanel.removeAll();
            MyTextArea_Warning warning=new MyTextArea_Warning(1,6,"错误","服务器错误");
            rootPanel.add(warning);
        }
        if (studentName!=null&&studentName.length>0){
            for (i=0;i<studentName.length;i++){
                CheckStudentCard card=new CheckStudentCard(studentName[i]);
                rootPanel.add(card);
                card.detailedBtn.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        super.mouseClicked(e);
                        System.out.println(studentName[i]);
                    }
                });
            }
        }else {
            rootPanel.add(new NullPanel());
        }
        getViewport().add(rootPanel);
    }
}
