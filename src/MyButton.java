import java.awt.*;

class MyButton extends Button {

    private static boolean [] equationState = new boolean[4];      // include equationState of marks in order + - * /
    private static boolean plusState = false;
    private static boolean clearFlag = true;
    private static boolean firstNumberFlag = true;
    private static boolean dotFlag = false;
    private static double TEMP = 0;
    private static double result = 0;
    private static boolean isDot = false;
    private static boolean numberWriteFlag = false;
    private static boolean isChangeMark = false;
    private static double numberMark = 0;
    private static boolean resetTEMPFlag = false;
    private static int rowNum = 0;
    private String name;
    private int width;
    private int height;
    private FlagStatus flagStatus;


    public MyButton(String name, int width, int height){
        super(name);
        setPreferredSize(new Dimension(width, height));
        this.name = name;
        this.width = width;
        this.height = height;
        flagStatus = new FlagStatus();
        for(int i = 0; i < equationState.length; i++){
            equationState[i] = false;
        }
    }

    public static boolean[] getEquationState() {
        return equationState;
    }

    public static void setEquationState(boolean[] equationState) {
        MyButton.equationState = equationState;
    }

    public static boolean isClearFlag() {
        return clearFlag;
    }

    public static void setClearFlag(boolean clearFlag) {
        MyButton.clearFlag = clearFlag;
    }

    public static boolean isFirstNumberFlag() {
        return firstNumberFlag;
    }

    public static void setFirstNumberFlag(boolean firstNumberFlag) {
        MyButton.firstNumberFlag = firstNumberFlag;
    }

    public static boolean isDotFlag() {
        return dotFlag;
    }

    public static void setDotFlag(boolean dotFlag) {
        MyButton.dotFlag = dotFlag;
    }

    public static boolean isIsDot() {
        return isDot;
    }

    public static void setIsDot(boolean isDot) {
        MyButton.isDot = isDot;
    }

    public static boolean isNumberWriteFlag() {
        return numberWriteFlag;
    }

    public static void setNumberWriteFlag(boolean numberWriteFlag) {
        MyButton.numberWriteFlag = numberWriteFlag;
    }

    public static boolean isIsChangeMark() {
        return isChangeMark;
    }

    public static void setIsChangeMark(boolean isChangeMark) {
        MyButton.isChangeMark = isChangeMark;
    }

    public static double getNumberMark() {
        return numberMark;
    }

    public static void setNumberMark(double numberMark) {
        MyButton.numberMark = numberMark;
    }

    public static boolean isResetTEMPFlag() {
        return resetTEMPFlag;
    }

    public static void setResetTEMPFlag(boolean resetTEMPFlag) {
        MyButton.resetTEMPFlag = resetTEMPFlag;
    }

    public double getResult(){
        return result;
    }

    public double getTEMP(){
        return TEMP;
    }

    public void setResult(double result){
        MyButton.result = result;
    }

    public void setTEMP(double temp){
        MyButton.TEMP = temp;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public String deleteOneChar(String number){
        if(number.length()==0){
            return "0";
        } else {
            return number.substring(0, number.length()-1);
        }
    }

    public int checkIsDot(String number, char c){
        for(int i = 0; i < number.length(); i++){
            if(c == number.charAt(i)){
                int num = Integer.parseInt( number.substring(i+1, number.length()));
                flagStatus.setDot(true);
                return num;
            }
        }
        return 0;
    }

    public void checkState(boolean[] tabState){
        for(int i=0; i<tabState.length; i++){
            if(tabState[i] == true){
                resetState(tabState);
            }
        }
    }

    public void resetState(boolean[] tabState){
        for(int i = 0 ; i < tabState.length; i++){
            tabState[i] = false;
        }
    }

}

