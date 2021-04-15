/*
 * Created by JFormDesigner on Sat Apr 10 22:31:06 CST 2021
 */

package Teacher.Test;

import java.awt.*;
import javax.swing.*;

/**
 * @author unknown
 */
public class Test extends JPanel {
    public Test() {
        initComponents();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        addQuestionPanel = new JPanel();
        setStem = new JLabel();
        setMark = new JLabel();
        textField1 = new JTextField();
        setDifficulty = new JLabel();
        difficultyBox = new JComboBox();
        setKind = new JLabel();
        kindBox = new JComboBox();
        scrollPane1 = new JScrollPane();
        textArea1 = new JTextArea();
        optionsPanel = new JPanel();
        submitButton = new JButton();

        //======== addQuestionPanel ========
        {
            addQuestionPanel.setLayout(new GridBagLayout());
            ((GridBagLayout)addQuestionPanel.getLayout()).columnWidths = new int[] {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
            ((GridBagLayout)addQuestionPanel.getLayout()).rowHeights = new int[] {0, 0, 0, 0, 0, 0, 0, 0, 0};
            ((GridBagLayout)addQuestionPanel.getLayout()).columnWeights = new double[] {0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0E-4};
            ((GridBagLayout)addQuestionPanel.getLayout()).rowWeights = new double[] {0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0E-4};

            //---- setStem ----
            setStem.setText("\u8bbe\u7f6e\u9898\u5e72");
            addQuestionPanel.add(setStem, new GridBagConstraints(1, 0, 1, 1, 0.0, 0.0,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                new Insets(5, 0, 5, 5), 0, 0));

            //---- setMark ----
            setMark.setText("\u5206\u503c");
            addQuestionPanel.add(setMark, new GridBagConstraints(3, 0, 1, 1, 0.0, 0.0,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                new Insets(5, 0, 5, 5), 0, 0));
            addQuestionPanel.add(textField1, new GridBagConstraints(4, 0, 2, 1, 0.0, 0.0,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                new Insets(5, 0, 5, 5), 0, 0));

            //---- setDifficulty ----
            setDifficulty.setText("\u96be\u5ea6");
            addQuestionPanel.add(setDifficulty, new GridBagConstraints(6, 0, 1, 1, 0.0, 0.0,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                new Insets(5, 0, 5, 5), 0, 0));
            addQuestionPanel.add(difficultyBox, new GridBagConstraints(7, 0, 1, 1, 0.0, 0.0,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                new Insets(5, 0, 5, 5), 0, 0));

            //---- setKind ----
            setKind.setText("\u9898\u578b");
            addQuestionPanel.add(setKind, new GridBagConstraints(8, 0, 1, 1, 0.0, 0.0,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                new Insets(5, 0, 5, 5), 0, 0));

            //---- kindBox ----
            kindBox.setToolTipText("1");
            addQuestionPanel.add(kindBox, new GridBagConstraints(9, 0, 1, 1, 0.0, 0.0,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                new Insets(5, 0, 5, 0), 0, 0));

            //======== scrollPane1 ========
            {
                scrollPane1.setViewportView(textArea1);
            }
            addQuestionPanel.add(scrollPane1, new GridBagConstraints(1, 1, 9, 4, 0.0, 0.0,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                new Insets(0, 0, 5, 0), 0, 0));

            //======== optionsPanel ========
            {
                optionsPanel.setLayout(new GridBagLayout());
                ((GridBagLayout)optionsPanel.getLayout()).columnWidths = new int[] {0, 0, 0};
                ((GridBagLayout)optionsPanel.getLayout()).rowHeights = new int[] {0, 0, 0, 0};
                ((GridBagLayout)optionsPanel.getLayout()).columnWeights = new double[] {0.0, 0.0, 1.0E-4};
                ((GridBagLayout)optionsPanel.getLayout()).rowWeights = new double[] {0.0, 0.0, 0.0, 1.0E-4};
            }
            addQuestionPanel.add(optionsPanel, new GridBagConstraints(1, 5, 9, 1, 0.0, 0.0,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                new Insets(0, 0, 5, 0), 0, 0));

            //---- submitButton ----
            submitButton.setText("\u786e\u5b9a");
            addQuestionPanel.add(submitButton, new GridBagConstraints(9, 7, 1, 1, 0.0, 0.0,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                new Insets(0, 0, 0, 0), 0, 0));
        }
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JPanel addQuestionPanel;
    private JLabel setStem;
    private JLabel setMark;
    private JTextField textField1;
    private JLabel setDifficulty;
    private JComboBox difficultyBox;
    private JLabel setKind;
    private JComboBox kindBox;
    private JScrollPane scrollPane1;
    private JTextArea textArea1;
    private JPanel optionsPanel;
    private JButton submitButton;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
