import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MarkButton extends MyButton implements ActionListener {

    private Font font;
    private Calculator calculator;
    private TextPanel textPanel;
    private FlagStatus flagStatus;
    DisplayListener displayListener;
    EquationButton equationButton;

    public MarkButton(String name, int width, int height, Font font){
        super(name, width, height);
        this.font = font;
        addActionListener(this);
        flagStatus = new FlagStatus();

    }

    public void setDisplayListener(DisplayListener listener){
        this.displayListener = listener;
    }

    public void setTextPanel(TextPanel textPanel){
        this.textPanel = textPanel;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String source = ((MarkButton)e.getSource()).getLabel();
        if(source == "."){
            String displayNumber = textPanel.getTextArea();
            if(displayNumber.indexOf('.') < 0){
                textPanel.appendText(".");
            }
        }
    }
}
