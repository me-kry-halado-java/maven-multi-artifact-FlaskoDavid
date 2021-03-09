package hu.meiit.haladojava.calculator;

import hu.meiit.haladojava.calculator.logic.Executor;
import hu.meiit.haladojava.calculator.logic.Expression;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class App 
{
    private static final String errorResponse="-";

    private static String[] parse(String expression){
        if(expression.contains(" ")){
            return expression.split(" ");
        }
        char sub;
        ArrayList<String> express=new ArrayList<String>();
        String[]other;
        String[] retvalue=new String[3];
        int index=0;
        if (expression.contains("+")){
            index=expression.indexOf("+");
        }else if(expression.contains("-")){
            index=expression.indexOf("-");
        }else if(expression.contains("*")){
            index=expression.indexOf("*");
        }else if(expression.contains("/")){
            index=expression.indexOf("/");
        }
        sub=expression.charAt(index);

        other=expression.split("[+ - * /]");
        express.add(other[0]);
        express.add(String.valueOf(sub));
        express.add(other[1]);
        for (int i=0;i<express.size();i++){
            retvalue[i]=express.get(i);
        }
        return retvalue;
    }
    private static String getExpressionFromStandardInput(){

        Scanner scanner = new Scanner(System.in);

        return scanner.nextLine();
    }

    private static void assertExpression(String[] parts) throws Exception {
        if (parts.length != 3) {
            throw new RuntimeException("wrong input");
        }
    }

    private static Expression getAsExpression(String[] parts){
        return new Expression(
                Integer.parseInt(parts[0]),
                Integer.parseInt(parts[2]),parts[1]);
    }

    private static String executeExpression(Expression expression){
        String result=errorResponse;
        Executor executor=new Executor();
        String valto=expression.getOperator();
        switch (valto){
            case "+": result = String.valueOf(executor.add(expression.getOperand1()
                    , expression.getOperand2()));
                break;
            case "-": result = String.valueOf(executor.sub(expression.getOperand1()
                    ,expression.getOperand2()));
                break;
            case "*": result=String.valueOf(executor.mult(expression.getOperand1()
                    ,expression.getOperand2()));
                break;
            case "/": result=String.valueOf(executor.div(expression.getOperand1()
                    ,expression.getOperand2()));
                break;
        }
        if (result==null) {
            result="-";}
        return result;
    }
    public static void main( String[] args )
    {
        String result="-";
        try {

            String expressionFromStandardInput =getExpressionFromStandardInput();
            String[] parts= parse(expressionFromStandardInput);
            assertExpression(parts);
            Expression expression = getAsExpression(parts);
            result=executeExpression(expression);


        }catch (Exception ex){}
        System.out.println(result);
    }
}
