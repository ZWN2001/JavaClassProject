package Student.Function;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class MyCheckBox extends JPanel {
    private final JCheckBox button = new JCheckBox("");
    private final JTextArea textArea;

    public MyCheckBox(String text){
        textArea = new JTextArea(text, 0, 50);
        textArea.setEditable(false);
        textArea.setLineWrap(true);
        textArea.setFocusable(false);
        textArea.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                button.doClick();
            }

            @Override
            public void mousePressed(MouseEvent e) {
            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });

        add(button);
        add(textArea);
    }

    public JCheckBox getButton() {
        return button;
    }

    public void setFont(Font font) {
        if (button != null && textArea != null) {
            button.setFont(font);
            textArea.setFont(font);
        }
    }

    public void setBackground(Color color) {
        if (button != null && textArea != null) {
            textArea.setBackground(color);
            button.setBackground(color);
        }
    }
}
