public class FlagStatus {


    private boolean clearFlag = true;
    private boolean firstNumberFlag = true;
    private boolean dotFlag = false;
    private double TEMP = 0;
    private double result = 0;
    private boolean isDot = false;
    private boolean numberWriteFlag = false;
    private boolean isChangeMark = false;
    private double numberMark = 0;
    private boolean resetTEMPFlag = false;
    private static int rowNum = 0;


    public FlagStatus(){
    }

    public boolean isClearFlag() {
        return clearFlag;
    }

    public void setClearFlag(boolean clearFlag) {
        this.clearFlag = clearFlag;
    }

    public boolean isFirstNumberFlag() {
        return firstNumberFlag;
    }

    public void setFirstNumberFlag(boolean firstNumberFlag) {
        this.firstNumberFlag = firstNumberFlag;
    }

    public boolean isDotFlag() {
        return dotFlag;
    }

    public void setDotFlag(boolean dotFlag) {
        this.dotFlag = dotFlag;
    }

    public double getTEMP() {
        return TEMP;
    }

    public void setTEMP(double TEMP) {
        this.TEMP = TEMP;
    }

    public double getResult() {
        return result;
    }

    public void setResult(double result) {
        this.result = result;
    }

    public boolean isDot() {
        return isDot;
    }

    public void setDot(boolean dot) {
        isDot = dot;
    }

    public boolean isNumberWriteFlag() {
        return numberWriteFlag;
    }

    public void setNumberWriteFlag(boolean numberWriteFlag) {
        this.numberWriteFlag = numberWriteFlag;
    }

    public boolean isChangeMark() {
        return isChangeMark;
    }

    public void setChangeMark(boolean changeMark) {
        isChangeMark = changeMark;
    }

    public double getNumberMark() {
        return numberMark;
    }

    public void setNumberMark(double numberMark) {
        this.numberMark = numberMark;
    }

    public boolean isResetTEMPFlag() {
        return resetTEMPFlag;
    }

    public void setResetTEMPFlag(boolean resetTEMPFlag) {
        this.resetTEMPFlag = resetTEMPFlag;
    }

    public static int getRowNum() {
        return rowNum;
    }

    public static void setRowNum(int rowNum) {
        FlagStatus.rowNum = rowNum;
    }
}
