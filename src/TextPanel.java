import javax.swing.*;
import java.awt.*;

public class TextPanel extends JPanel {

    private JTextArea textArea;

    public TextPanel(){
        setSize(new Dimension(1, 15));
        textArea = new JTextArea(1,15);
        add(textArea, BorderLayout.CENTER);
    }

    public void appendText(String text){
        textArea.append(text);
    }

    public void setTextArea(String text){
        this.textArea.setText(text);
    }

    public String getTextArea() {
        return textArea.getText();
    }
}
