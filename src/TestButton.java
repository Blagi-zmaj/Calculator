import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TestButton extends MyButton implements ActionListener {

    private Font font;
    private TextPanel textPanel;
    DisplayListener displayListener;

    public TestButton(String name, int width, int height, Font font){
        super(name, width, height);
        this.font = font;
        addActionListener(this);
    }

    public void setDisplayListener(DisplayListener listener){
        this.displayListener = listener;
    }

    public void setTextPanel(TextPanel textPanel){
        this.textPanel = textPanel;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String source = ((TestButton)e.getSource()).getLabel();
        if(source == "CE"){
            System.out.println("CE");
            textPanel.appendText("CE");
            displayListener.textEmitted("CE");
        } else if(source == "C"){
            textPanel.appendText("C");
            System.out.println("C");
            displayListener.textEmitted("C");
        } else if(source == "+/-"){
            textPanel.appendText("+/-");
            System.out.println("+/-");
            displayListener.textEmitted("+/-");
        }
    }
}
