//import javax.swing.*;
//import javax.swing.border.Border;
//import java.awt.*;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//
//public class test {
//
//    public class Calculator extends JFrame implements ActionListener {
//
//        private JButton[] numButtons = new JButton[9];
//        private JButton[] markButtons = new JButton[2];
//        private JButton[] equationButtons = new JButton[5];
//        private JButton[] topButtons = new JButton[3];
//        private String[] mark ={"0", "."};
//        private String[] equationMark = {"+", "-", "x", "/", "="};
//        private String[] topMarks = {"CE", "C", "+/-"};
//
//        JPanel mainPanel = new JPanel();
//        JPanel displayPanel = new JPanel();
//        JTextArea display = new JTextArea(1, 8);
//        private static boolean [] equationState = new boolean[5];      // include equationState of marks in order + - * / =
//        private boolean clearFlag = true;
//        private boolean firstNumberFlag = true;
//        private boolean dotFlag = false;
//        private static double TEMP = 0;
//        private static double result = 0;
//        private boolean isDot = false;
//        private boolean numberWriteFlag = false;
//        private boolean isChangeMark = false;
//        private double numberMark = 0;
//        private boolean resetTEMPFlag = false;
//        private static int rowNumber = 0;
//        private int columnNum = 0;
//
//        GridBagConstraints gbc = new GridBagConstraints();
//        Font font = new Font("Times New Roman", Font.PLAIN, 20);
//
//        private void setDisplay(){
//            display.setFont(new Font("Calibri", Font.PLAIN, 30));
//            Border border = BorderFactory.createEtchedBorder();
//            displayPanel.setBorder(border);
//            displayPanel.add(display);
//        }
//
//        private JButton[] setButtonLayout(int numButton, JButton[] buttons, String[] label, int gridNum) {
//            JButton button[] = new JButton[numButton];
//            gbc.fill = GridBagConstraints.HORIZONTAL;
//            gbc.gridy = rowNumber;
//            gbc.gridx = gridNum;
//            for(int i = 0; i < numButton; i++){
//                if(gridNum > 0){
//                    gbc.gridx = gridNum;
//                    gbc.gridy = i;
//                } else {
//                    gbc.gridx = i;
//                }
//                button[i] = buttons[i];
//                button[i] = new JButton(label[i]);
//
//                button[i].setPreferredSize(new Dimension(60,60));
//                button[i].setFont(new Font("Calibri", Font.PLAIN, 20));
//                button[i].setMaximumSize(new Dimension(100, 80));
//                button[i].addActionListener(this);
//                mainPanel.add(button[i], gbc);
//            }
//            return button;
//        }
//
//        private void setNumButtons(int startNum){
//            for(int i=startNum; i < startNum+3; i++){
//                gbc.gridy = rowNumber;
//                gbc.gridx = columnNum++;
//                numButtons[i] = new JButton(Integer.toString(i+1));
//                numButtons[i].setPreferredSize(new Dimension(60,60));
//                numButtons[i].setFont(font);
//                numButtons[i].addActionListener(this);
//                mainPanel.add(numButtons[i], gbc);
//                int a = i;
//                char numToChar = (char)(a+48);
//            }
//            columnNum = 0;
//            rowNumber++;
//            gbc.gridy = rowNumber;
//        }
//
//        private void setTopButtons(){
//            for(int i=0; i < topMarks.length; i++){
//                setButtonLayout(topButtons.length, topButtons, topMarks, 0);
//            }
//            columnNum = 0;
//            rowNumber++;
//            gbc.gridy = rowNumber;
//        }
//
//        private void setBottomButtons(){
//            for(int i=0; i < mark.length; i++){
//                gbc.gridx = columnNum++;
//                if(i == 0){
//                    gbc.gridwidth = 2;
//                    setButtonLayout(markButtons.length-1, markButtons, mark, 0);
//                } else {
//                    gbc.gridwidth = 1;
//                    gbc.gridx = 2;
//                    markButtons[i] = new JButton(mark[i]);
//                    markButtons[i].setPreferredSize(new Dimension(60,60));
//                    markButtons[i].setFont(new Font("Calibri", Font.PLAIN, 20));
//                    markButtons[i].setMaximumSize(new Dimension(100, 80));
//                    markButtons[i].addActionListener(this);
//                    mainPanel.add(markButtons[i], gbc);
//                }
//
//            }
//            columnNum = 0;
//            rowNumber++;
//            gbc.gridy = rowNumber;
//        }
//
//        private void setEquationButtons(){
//            for(int i=0; i < equationMark.length; i++){
//                setButtonLayout(equationButtons.length, equationButtons, equationMark, 3);
//            }
//            columnNum = 0;
//            rowNumber++;
//            gbc.gridy = rowNumber;
//        }
//
//
//        public Calculator(){
//            super("Calculator");
//
//            setSize(new Dimension(240,180));
//            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//            setLayout(new BorderLayout());
//            mainPanel.setLayout(new GridBagLayout());
//            displayPanel.setLayout(new BorderLayout());
//            displayPanel.add(display, BorderLayout.NORTH);
//            setTopButtons();
//            setNumButtons(6);
//            setNumButtons(3);
//            setNumButtons(0);
//            setBottomButtons();
//            setEquationButtons();
//            setDisplay();
//            add(display, BorderLayout.NORTH);
//            add(mainPanel, BorderLayout.SOUTH);
//
//            resetState(equationState);
//            display.setEditable(false);
//
//            display.append("0");
//            displayPanel.setPreferredSize(new Dimension(240, 60));
//            setVisible(true);
//            pack();
//        }
//
//        @Override
//        public void actionPerformed(ActionEvent e) {
//
//            ////////////////////////////TOP BUTTONS/////////////////////////////////////////
//
//            JButton source = (JButton) e.getSource();
//            if(source == topButtons[0]) {
//                display.setText("0");
//                clearFlag = true;
//                firstNumberFlag = true;
//                dotFlag = false;
//                TEMP = 0;
//                result = 0;
//                isDot = false;
//                numberWriteFlag = false;
//                isChangeMark = false;
//                numberMark = 0;
//                resetTEMPFlag = false;
//                System.out.println("CE pressed");
//            } else if (source == topButtons[1]){
//
//                ////////////////////Przycisk usuwania znaku ////////////////////
//
//                try{
//                    String charToRemove = display.getText();
//                    System.out.println("Pobrany tekst: " + charToRemove);
//                    String oneCharLess = deleteOneChar(charToRemove);
//                    System.out.println("Tekst po usunięciu znaku" + oneCharLess);
//                    display.setText("");
//                    display.append(oneCharLess);
//                    result = Double.parseDouble(oneCharLess);
//                } catch (NumberFormatException exception){
//                    System.err.println("Wrong number format");
//                }
//
//
//
//            } else if (source == topButtons[2]){
//                if(result > 0){
//                    display.setText("");
//                    int num = checkIsDot(Double.toString(result), '.');
//                    String numb = Integer.toString(num);
//                    System.out.println("reszta z wyniku: " + num);
//                    int fullNumber = (int)result;
//                    System.out.println("Result jako INT before bitwise: " + fullNumber);
//                    fullNumber = (~(fullNumber-1));
//                    System.out.println("Result jako INT after bitwise: " + fullNumber);
//
//                    String reversedNumber = Integer.toString(fullNumber);
//                    System.out.println("reversedNumber before add DOT = " + reversedNumber);
//                    reversedNumber = reversedNumber + '.';
//                    System.out.println("reversedNumber after add DOT = " + reversedNumber);
//                    reversedNumber = reversedNumber + numb;
//                    System.out.println("reversedNumber after add DOT and REST = " + reversedNumber);
//
//                    System.out.println("Result przed castowaniem do double: " + result);
//                    result = (double) fullNumber;
//                    System.out.println("Result po castowaniu do double: " + result);
//
//                    display.append(reversedNumber);
//                    result = Double.parseDouble(reversedNumber);
//                    numberWriteFlag = false;
//                } else if(result < 0){
//                    display.setText("");
//                    int num = checkIsDot(Double.toString(result), '.');
//                    String numb = Integer.toString(num);
//                    System.out.println("reszta z wyniku: " + num);
//                    int fullNumber = (int)result;
//                    System.out.println("Result jako INT before bitwise: " + fullNumber);
//                    fullNumber = (~(fullNumber-1));
//                    System.out.println("Result jako INT after bitwise: " + fullNumber);
//
//                    String reversedNumber = Integer.toString(fullNumber);
//                    System.out.println("reversedNumber before add DOT = " + reversedNumber);
//                    reversedNumber = reversedNumber + '.';
//                    System.out.println("reversedNumber after add DOT = " + reversedNumber);
//                    reversedNumber = reversedNumber + numb;
//                    System.out.println("reversedNumber after add DOT and REST = " + reversedNumber);
//
//                    System.out.println("Result przed castowaniem do double: " + result);
//                    result = Double.parseDouble(reversedNumber);
//                    System.out.println("Result po castowaniu do double: " + result);
//
//                    display.append(reversedNumber);
//                    result = Double.parseDouble(reversedNumber);
//                    numberWriteFlag = false;
//                } else {
////                display.append(Double.toString(result));
//                }
//            }
//
//            ////////////////////////////NUMBER BUTTONS//////////////////////////////////////
//            for(int i = 0 ; i < numButtons.length; i++){
//                if(source == numButtons[i]){
//                    numberWriteFlag = true;
//                    if(firstNumberFlag){
//                        result = TEMP;
//                        TEMP = 0;
//                    }
//                    System.out.println(display.getText());
//
//                    if(clearFlag == true) {
//                        System.out.println("Wyczyszczone pole");
//                        clearFlag = false;
//                        display.setText("");
//                    }
//                    showStates(equationState);
//                    display.append(Integer.toString(i+1));
//                    String number = display.getText();
//                    TEMP = Double.parseDouble(number);
//
//                    if(firstNumberFlag){
//                        result = TEMP;
//                    }
//
//                    System.out.println("First number = " + firstNumberFlag);
//                    System.out.println("TEMP = " + TEMP);
//                    System.out.println("result = " + result);
//                    System.out.println();
//                }
//            }
//
//            //////////////////////////////////////////MARK BUTTONS/////////////////////////////
//            if(source == markButtons[0]){
//                display.append("0");
//
//            } else {
//                System.out.println(" . ");
//                int restNumber = checkIsDot(Double.toString(result), 'c');
//                System.out.println("Mark button IS DOT = " + isDot);
//                if(restNumber > 0){
//                    isDot = true;
//                }
//                if(!isDot){
//                    display.append(".");
//                    String number = display.getText();
//                    System.out.println(number);
//                    isDot = true;
//                }
//            }
//
//            //////////////////////////////////////EQUATION BUTTONS////////////////////////////////////////
//
//            for(int i = 0 ; i < equationButtons.length; i++){
//                if(source == equationButtons[i]){
//                    checkState(equationState);
//                    equationState[i] = true;
//                    doEquation(i);
//                    clearFlag = true;
//                    firstNumberFlag = false;
//                    isDot = false;
//                    showStates(equationState);
//                    numberWriteFlag = false;
//                }
//            }
//        }
//
//        private String deleteOneChar(String number){
//            if(number.length()==0){
//                return "0";
//            } else {
//                return number.substring(0, number.length()-1);
//            }
//        }
//
//        private int checkIsDot(String number, char c){
//            for(int i = 0; i < number.length(); i++){
//                if(c == number.charAt(i)){
//                    int num = Integer.parseInt( number.substring(i+1, number.length()));
////                System.out.println("Kropka znaleziona pod indeksem" + i);
//                    isDot = true;
//                    return num;
//                } else {
//                    return 0;
//                }
//            }
//            return 0;
//        }
//
//        private void doEquation(int number){
//            switch(number) {
//                case 0:
//                    int restNumber = checkIsDot(display.getText(), '.');
//                    display.setText(null);
//                    if (!(firstNumberFlag == true)) {
//                        result = add(TEMP);
//                    }
////                System.out.println("Rest number =" + restNumber);
//                    String strResult = Double.toString(result);
//                    if (restNumber > 0) {
//                        String addResult = Double.toString(result);
////                    System.out.println("Add result = " + addResult);
//                        display.append(addResult);
//                    } else {
//                        if (checkIsDot(strResult, '.') > 0) {
//                            String addResult = Double.toString(result);
////                        System.out.println("Add result v2 = " + addResult);
//                            display.append(addResult);
//                        } else {
//                            display.append(Double.toString(result));
//                        }
////                    System.out.println("INT Add result = ");
//                    }
//                    firstNumberFlag = false;
//                    TEMP = 0;
//                    isDot = false;
//                    numberWriteFlag = false;
//                    break;
//                case 1:
//                    restNumber = checkIsDot(display.getText(), '.');
//                    display.setText(null);
//                    if (!(firstNumberFlag == true)) {
//                        result = sub(TEMP);
//                    }
////                System.out.println("Rest number =" + restNumber);
//                    strResult = Double.toString(result);
//                    if (restNumber > 0) {
//                        String subResult = Double.toString(result);
////                    System.out.println("Add result = " + addResult);
//                        display.append(subResult);
//                    } else {
//                        if (checkIsDot(strResult, '.') > 0) {
//                            String subResult = Double.toString(result);
////                        System.out.println("Add result v2 = " + addResult);
//                            display.append(subResult);
//                        } else {
//                            display.append(Double.toString(result));
//                        }
////                    System.out.println("INT Add result = ");
//                    }
//                    firstNumberFlag = false;
//                    TEMP = 0;
//                    isDot = false;
//                    numberWriteFlag = false;
//                    break;
//
//                case 2:
//                    display.setText(null);
//                    System.out.println("doEquation METHOD");
//                    System.out.println("FirstNumberFlag = " + firstNumberFlag);
//                    System.out.println("numberWriteFlag = "+ numberWriteFlag);
//                    System.out.println("TEMP = " + TEMP);
//                    System.out.println("result = " + result);
//                    System.out.println();
//                    if (!(firstNumberFlag == true)) {
//                        if (result > 0) {
//                            System.out.println("RESULT > 0");
//                            if ((TEMP == 0) && (numberWriteFlag == true)) {
//                                result = mul(TEMP);
//                                display.append(Double.toString(result));
//                            } else if ((TEMP == 0) && (numberWriteFlag == false)) {
//                                display.append(Double.toString(result));
//                            } else {
//                                result = mul(TEMP);
//                                display.append(Double.toString(result));
//                            }
//
//                            if (TEMP > 0) {
////                            resetTEMPFlag = true;
//                                TEMP = 0;
//                            }
//
//                        } else if (result < 0) {
//                            System.out.println("RESULT < 0");
//
//                            if ((TEMP == 0) && (numberWriteFlag == true)) {
//                                result = mul(TEMP);
//                                display.append(Double.toString(result));
//                            } else if ((TEMP == 0) && (numberWriteFlag == false)) {
//                                display.append(Double.toString(result));
//                            } else {
//                                result = mul(TEMP);
//                                display.append(Double.toString(result));
//                            }
//
//                            if (TEMP > 0 || TEMP < 0) {
////                            resetTEMPFlag = true;
//                                TEMP = 0;
//                            }
//                        }
//                    } else {
//                        TEMP = 0;
//                        display.append(Double.toString(result));
//                    }
//                    firstNumberFlag = false;
//                    numberWriteFlag = false;
//                    break;
//                case 3:
//                    display.setText(null);
//
//                    if (!(firstNumberFlag == true)) {
//                        if (result > 0) {
//                            System.out.println("RESULT > 0");
//                            if ((TEMP == 0) && (numberWriteFlag == true)) {
//                                result = div(TEMP);
//                                display.append(Double.toString(result));
//                            } else if ((TEMP == 0) && (numberWriteFlag == false)) {
//                                display.append(Double.toString(result));
//                            } else {
//                                result = div(TEMP);
//                                display.append(Double.toString(result));
//                            }
//
//                            if (TEMP > 0) {
////                            resetTEMPFlag = true;
//                                TEMP = 0;
//                            }
//
//                        } else if (result < 0) {
//                            System.out.println("RESULT < 0");
//
//                            if ((TEMP == 0) && (numberWriteFlag == true)) {
//                                result = div(TEMP);
//                                display.append(Double.toString(result));
//                            } else if ((TEMP == 0) && (numberWriteFlag == false)) {
//                                display.append(Double.toString(result));
//                            } else {
//                                result = div(TEMP);
//                                display.append(Double.toString(result));
//                            }
//
//                            if (TEMP > 0 || TEMP < 0) {
////                            resetTEMPFlag = true;
//                                TEMP = 0;
//                            }
//                        }
//                    } else {
//                        TEMP = 0;
//                        display.append(Double.toString(result));
//                    }
//
//
//
//
//                    firstNumberFlag = false;
//                    numberWriteFlag = false;
//                    break;
//
//                case 4:
//                    showStates(equationState);
//                    System.out.println("=");
//                    System.out.println(result);
//                    for(int i = 0 ; i < equationState.length; i++){
//                        if(equationState[i] == true){
//                            firstNumberFlag = false;
//                            display.setText(null);
//                            doEquation(i);
//                            resetState(equationState);
//                        }
//                    }
//                    showStates(equationState);
//                    clearFlag = true;
//                    firstNumberFlag = false;
//                    numberWriteFlag = false;
//                    break;
//            }
//        }
//
//        private void showStates(boolean [] tab){
//            for(int i=0; i < tab.length; i++){
//                if(tab[i] == true){
////                System.out.println(equationMark[i] + " ustawiony " +  tab[i]);
//                }
//            }
//        }
//
//        private void checkState(boolean[] tabState){
//            for(int i=0; i<tabState.length; i++){
//                if(tabState[i] == true){
//                    resetState(tabState);
//                }
//            }
//        }
//
//        private void resetState(boolean[] tabState){
//            for(int i = 0 ; i < tabState.length; i++){
//                tabState[i] = false;
////            System.out.println(tabState[i]);
//            }
//        }
//
//        private double add(double num){
//            return result += num;
//        }
//
//        private double sub(double num){
//            return result -= num;
//        }
//
//        private double mul(double num){
//            if(num == 0){
//                return 0;
//            }
//            return result *= num;
//        }
//
//        private double div(double num){
//            if(num == 0){
//                return 0;
//            }
//            return result /= num;
//        }
//
//    }
//
//
//}
