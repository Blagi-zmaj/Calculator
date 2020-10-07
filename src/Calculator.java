import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class Calculator extends JFrame  {
    private String[] marks = {"."};        // zmienic tylko by byla .
    private String[] equationMark = {"+", "-", "x", "/", "="};      //dopisano =
    private String[] topMarks = {"CE", "C", "+/-"};
    private static boolean [] equationState = new boolean[4];      // include equationState of marks in order + - * /
    private boolean clearFlag = true;
    private boolean firstNumberFlag = true;
    private boolean dotFlag = false;
    private static double TEMP = 0;
    private static double result = 0;
    private boolean isDot = false;
    private boolean numberWriteFlag = false;
    private boolean isChangeMark = false;
    private double numberMark = 0;
    private boolean resetTEMPFlag = false;
    private static int rowNum = 0;
    private JPanel displayPanel;
    private JPanel mainPanel;

    GridBagConstraints c = new GridBagConstraints();
    Font font = new Font("Times New Roman", Font.PLAIN, 20);

    private TopButton[] topButton = new TopButton[3];
    private MarkButton[] markButton = new MarkButton[1];
    private NumberButton[] numberButton = new NumberButton[10];
    private EquationButton[] equaBtn = new EquationButton[5];
    private TextPanel textPanel;
    private FlagStatus flagStatus;

    public Calculator() {
        super("TEST");

        setPreferredSize(new Dimension(400, 300));
//        setLayout(new BorderLayout());
        setLayout(new GridBagLayout());

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        textPanel = new TextPanel();
        displayPanel = new JPanel();
        mainPanel = new JPanel();
        mainPanel.setLayout(new GridBagLayout());
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 0;
        c.gridy = 0;

        Border border = BorderFactory.createEtchedBorder();
        textPanel.setBorder(border);
        textPanel.setLayout(new GridBagLayout());
        textPanel.setFont(new Font("Times New Roman", Font.PLAIN, 60));
        displayPanel.add(textPanel, c);

        for(int i = 0; i < topMarks.length; i++){
            topButton[i] = new TopButton(topMarks[i], 50, 50, font);
            topButton[i].setTextPanel(textPanel);
            mainPanel.add(topButton[i], c);
            c.gridx++;
        }

        c.gridx = 0;
        c.gridy++;
        for(int i = 0; i < 3; i++){
            numberButton[i] = new NumberButton(Integer.toString(i+7), 50, 50, font, 3, 7);
            numberButton[i].setTextPanel(textPanel);
            mainPanel.add(numberButton[i], c);
            c.gridx++;
        }

        c.gridx = 0;
        c.gridy++;
        for(int i = 0; i < 3; i++){
            numberButton[i] = new NumberButton(Integer.toString(i+4), 50, 50, font, 3, 4);
            numberButton[i].setTextPanel(textPanel);
            mainPanel.add(numberButton[i], c);
            c.gridx++;
        }

        c.gridx = 0;
        c.gridy++;
        for(int i = 0; i < 4; i++){
            if(i == 0){
                c.gridy = 4;
                c.gridwidth = 2;
            } else {
                c.gridy = 3;
                c.gridwidth = 1;
            }
            numberButton[i] = new NumberButton(Integer.toString(i), 50, 50, font, 4, 0);
            numberButton[i].setTextPanel(textPanel);
            mainPanel.add(numberButton[i], c);
            if(i != 0){
                c.gridx++;
            }

        }

        c.gridx = 3;
        c.gridy = 0;
        for (int i = 0; i < equationMark.length; i++){
            equaBtn[i] = new EquationButton(equationMark[i], 50, 50, font);
            equaBtn[i].setTextPanel(textPanel);
            mainPanel.add(equaBtn[i], c);
            c.gridy++;
        }


        c.gridx = 2;
        c.gridy = 4;

        for(int i = 0; i < marks.length; i++){
            markButton[i] = new MarkButton(marks[i], 50, 50, font);
            markButton[i].setTextPanel(textPanel);
            mainPanel.add(markButton[i], c);
        }

        c.gridx = 0;
        c.gridy = 0;
        add(textPanel, c);
        c.gridy++;
        add(mainPanel, c);

        pack();
        setVisible(true);
    }
}

