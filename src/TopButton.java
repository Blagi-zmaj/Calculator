import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TopButton extends MyButton implements ActionListener {
    private Font font;
    private Calculator calculator;
    private TextPanel textPanel;
    private FlagStatus flagStatus;
    DisplayListener displayListener;

    public TopButton(String name, int width, int height, Font font){
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
        String source = ((TopButton)e.getSource()).getLabel();
        if(source == "CE") {
            textPanel.setTextArea("0");
            setClearFlag(true);
            setFirstNumberFlag(true);
            setDotFlag(false);
            setTEMP(0);
            setResult(0);
            setIsDot(false);
            setNumberWriteFlag(false);
            setIsChangeMark(false);
            setNumberMark(0);
            setResetTEMPFlag(false);
        } else if (source == "C"){
            try{
                String charToRemove = textPanel.getTextArea();
                String oneCharLess = deleteOneChar(charToRemove);
                textPanel.setTextArea("");
                textPanel.appendText(oneCharLess);
                setResult(Double.parseDouble(oneCharLess));
            } catch (NumberFormatException exception){
                System.err.println("Wrong number format");
            }
        } else if (source == "+/-"){
            double result = getResult();

            if(getResult() > 0){
                textPanel.setTextArea("");

                int restNum = checkIsDot(Double.toString(getResult()), '.');
                boolean stopFlag = false;
                int exponentation = 0;
                while(!stopFlag){
                    restNum /= 10;
                    exponentation++;
                    if(restNum <= 0){
                        stopFlag = true;
                    }
                }
                result *= (10 * exponentation);
                result -= (result * 2);
                result /= (10 * exponentation);
                setResult(result);
                exponentation = 0;
                textPanel.setTextArea("");
                textPanel.appendText(Double.toString(getResult()));
                setNumberWriteFlag(false);

            } else if(getResult() < 0){
                textPanel.setTextArea("");
                int num = checkIsDot(Double.toString(getResult()), '.');
                String numb = Integer.toString(num);
                int fullNumber = (int)getResult();
                fullNumber = (~(fullNumber-1));
                String reversedNumber = Integer.toString(fullNumber);
                reversedNumber = reversedNumber + '.';
                reversedNumber = reversedNumber + numb;
                setResult(Double.parseDouble(reversedNumber));
                textPanel.appendText(reversedNumber);
                result = Double.parseDouble(reversedNumber);
                setNumberWriteFlag(false);
            } else {
//                display.append(Double.toString(result));
            }

        }
    }
}
