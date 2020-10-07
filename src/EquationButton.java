import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EquationButton extends MyButton implements ActionListener {
    private Font font;
    private String[] equationMark = {"+", "-", "x", "/"};
    private Calculator calculator;
    private TextPanel textPanel;
    private FlagStatus flagStatus;
    private double result;
    private double TEMP;
    DisplayListener displayListener;
    private static boolean [] equationState = new boolean[4];

    public EquationButton(String name, int width, int height, Font font){
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
        String source = ((EquationButton)e.getSource()).getLabel();
        if (source == "=") {
            for(int i = 0 ; i < equationState.length; i++){
                if(equationState[i] == true){
                    setFirstNumberFlag(false);
                    textPanel.setTextArea(null);
                    doEquation(i);
                    resetState(getEquationState());
                }
            }
            setClearFlag(true);
        }

        for(int i = 0 ; i < equationState.length; i++){
            if(source == equationMark[i]){
                checkState(equationState);
                equationState[i] = true;
                doEquation(i);
                setClearFlag(true);
                setFirstNumberFlag(false);
                setIsDot(false);
                setNumberWriteFlag(false);
            }
        }
    }

    public void doEquation(int number){
        switch(number) {
            case 0:
                int restNumber = checkIsDot(textPanel.getTextArea(), '.');
                textPanel.setTextArea(null);
                if (!(isFirstNumberFlag())) {
                    setResult(add(getTEMP()));
                }
                String strResult = Double.toString(getResult());
                if (restNumber > 0) {
                    String addResult = Double.toString(getResult());
                    textPanel.appendText(addResult);
                } else {
                    if (checkIsDot(strResult, '.') > 0) {
                        String addResult = Double.toString(getResult());
                        textPanel.appendText(addResult);
                    } else {
                        textPanel.appendText(Integer.toString((int) getResult()));
                    }
                }
                setFirstNumberFlag(false);
                setTEMP(0);
                setIsDot(false);
                setNumberWriteFlag(false);
                break;
            case 1:
                restNumber = checkIsDot(textPanel.getTextArea(), '.');
                textPanel.setTextArea(null);
                if (!(isFirstNumberFlag() == true)) {
                    setResult(sub(getTEMP()));
                }
                strResult = Double.toString(getResult());
                if (restNumber > 0) {
                    String subResult = Double.toString(getResult());
                    textPanel.appendText(subResult);
                } else {
                    if (checkIsDot(strResult, '.') > 0) {
                        String subResult = Double.toString(getResult());
                        textPanel.appendText(subResult);
                    } else {
                        textPanel.appendText(Integer.toString((int) getResult()));
                    }
                }
                setFirstNumberFlag(false);
                setTEMP(0);
                setIsDot(false);
                setNumberWriteFlag(false);
                break;

            case 2:
                textPanel.setTextArea(null);
                if (!(isFirstNumberFlag() == true)) {
                    if (getResult() > 0) {
                        if ((getTEMP() == 0) && (isNumberWriteFlag() == true)) {
                            setResult(mul(getTEMP()));
                            textPanel.appendText(Double.toString(getResult()));
                        } else if ((getTEMP() == 0) && (isNumberWriteFlag() == false)) {
                            textPanel.appendText(Double.toString(getResult()));
                        } else {
                            setResult(mul(getTEMP()));
                            textPanel.appendText(Double.toString(getResult()));
                        }

                        if (getTEMP() > 0) {
                             setTEMP(0);
                        }

                    } else if (getResult() < 0) {
                        if ((getTEMP() == 0) && (isNumberWriteFlag() == true)) {
                            setResult(mul(getTEMP()));
                            textPanel.appendText(Double.toString(getResult()));
                        } else if ((getTEMP() == 0) && (isNumberWriteFlag() == false)) {
                            textPanel.appendText(Double.toString(getResult()));
                        } else {
                            setResult(mul(getTEMP()));
                            textPanel.appendText(Double.toString(getResult()));
                        }

                        if (getTEMP() > 0 || getTEMP() < 0) {
                             setTEMP(0);
                        }
                    }
                } else {
                    setTEMP(0);
                    textPanel.appendText(Double.toString(getResult()));
                }
                 setFirstNumberFlag(false);
                 setNumberWriteFlag(false);
                break;
            case 3:
                textPanel.setTextArea(null);

                if (!(isFirstNumberFlag() == true)) {
                    if (getResult() > 0) {
                        if ((getTEMP() == 0) && (isNumberWriteFlag() == true)) {
                            setResult(div(getTEMP()));
                            textPanel.appendText(Double.toString(getResult()));
                        } else if ((getTEMP() == 0) && (isNumberWriteFlag() == false)) {
                            textPanel.appendText(Double.toString(getResult()));
                        } else {
                            setResult(div(getTEMP()));
                            textPanel.appendText(Double.toString(getResult()));
                        }

                        if (getTEMP() > 0) {
                            setTEMP(0);
                        }

                    } else if (getResult() < 0) {
                        if ((getTEMP() == 0) && (isNumberWriteFlag() == true)) {
                            setResult(div(getTEMP()));
                            textPanel.appendText(Double.toString(getResult()));
                        } else if ((TEMP == 0) && (isNumberWriteFlag() == false)) {
                            textPanel.appendText(Double.toString(getResult()));
                        } else {
                            setResult(div(getTEMP()));
                            textPanel.appendText(Double.toString(getResult()));
                        }

                        if (getTEMP() > 0 || getTEMP() < 0) {
                            setTEMP(0);
                        }
                    }
                } else {
                    setTEMP(0);
                    textPanel.appendText(Double.toString(getResult()));
                }
                setFirstNumberFlag(false);
                setNumberWriteFlag(false);
                break;
        }
    }

    private double add(double num){
        double result = getResult();
        return result += num;
    }

    private double sub(double num){
        double result = getResult();
        return result -= num;
    }

    private double mul(double num){
        if(num == 0){
            return 0;
        }
        double result = getResult();
        return result *= num;
    }

    private double div(double num){
        if(num == 0){
            return 0;
        }
        double result = getResult();
        return result /= num;
    }
}
