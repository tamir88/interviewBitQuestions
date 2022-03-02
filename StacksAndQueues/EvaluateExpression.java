package StacksAndQueues;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class EvaluateExpression {
    public int evalRPN(ArrayList<String> A) {
        Stack<Integer> st = new Stack<>();

        for (int i = 0; i < A.size(); i++) {
            String operator = A.get(i);
            if(isOperator(operator)){
                int valueOperation = arithmeticOpr(st, operator);
                st.push(valueOperation);
            }
            else {
                st.push(Integer.parseInt(operator));
            }
        }
        return st.peek();
    }
    private int arithmeticOpr(Stack<Integer> st, String operator){
        int oprRight = st.pop();
        int oprLeft = st.pop();
        int ans = 0;
        switch (operator){
            case "/":
                ans = oprLeft / oprRight;
                break;
            case "*":
                ans = oprLeft * oprRight;
                break;
            case "-":
                ans = oprLeft - oprRight;
                break;
            case "+":
                ans = oprLeft + oprRight;
                break;
        }
        return ans;
    }

    private boolean isOperator(String opr){
        if(!opr.equals("/") && !opr.equals("*") && !opr.equals("-") && !opr.equals("+"))
            return false;
        else
            return true;
    }

    public static void main(String[] args) {
        EvaluateExpression a = new EvaluateExpression();
        System.out.println(a.evalRPN(new ArrayList<>(Arrays.asList("4", "13", "5", "/", "+"))));

    }

}
