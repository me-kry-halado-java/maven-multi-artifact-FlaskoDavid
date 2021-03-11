package hu.meiit.haladojava.calculator.logic;

public class Executor {
    public double add(int operand1, int operand2){
        return operand1+operand2;
    }
    public double sub(int operand1, int operand2){
        return operand1-operand2;
    }
    public double mult(int operand1, int operand2){
        return operand1*operand2;
    }
    public double div(int operand1, int operand2){
        Double ret=null;
        try {
            ret = (double)operand1/(double)operand2;
        }catch (Exception ex){}
        return ret;
    }
}
