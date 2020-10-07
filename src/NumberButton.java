import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class NumberButton extends MyButton implements ActionListener {
    private Font font;
    private Calculator calculator;
    private TextPanel textPanel;
    private FlagStatus flagStatus;
    private int amount;
    private int startNum;
    DisplayListener displayListener;


    public NumberButton(String name, int width, int height, Font font, int amount, int startNumBtn){
        super(name, width, height);
        this.font = font;
        addActionListener(this);
        flagStatus = new FlagStatus();
        this.amount = amount;
        this.startNum = startNumBtn;
    }

    public void setDisplayListener(DisplayListener listener){
        this.displayListener = listener;
    }

    public void setTextPanel(TextPanel textPanel){
        this.textPanel = textPanel;
    }

    public void setFlagStatus(FlagStatus flag){
        this.flagStatus = flag;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String source = ((NumberButton)e.getSource()).getLabel();

        int maxNum = startNum + amount;
        for(int i = startNum ; i < maxNum ; i++) {
            String num = Integer.toString(i);
            if (source.equals(num)) {
                setNumberWriteFlag(true);
                if (isFirstNumberFlag()) {
                    setResult(getTEMP());
                    setTEMP(0);
                }

                if (isClearFlag()==true) {
                    setClearFlag(false);
                    textPanel.setTextArea("");
                }
                textPanel.appendText(Integer.toString(i));
                String number = textPanel.getTextArea();
                setTEMP(Double.parseDouble(number));
                System.out.println(textPanel.getTextArea());

                if (isFirstNumberFlag()) {
                    setResult(getTEMP());
                }
            }
        }
    }
}
