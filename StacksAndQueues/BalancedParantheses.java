package StacksAndQueues;

import java.util.List;
import java.util.Stack;

public class BalancedParantheses {
    public int solve(String A) {
        //base case
        if(A.charAt(0) == ')')  return 0;

        Stack<Integer> st = new Stack<>();
        st.add(1);
        for (int i = 1; i < A.length(); i++) {
            if(A.charAt(i) == '(')
                st.add(1);
            else {
                if(!st.isEmpty())
                    st.pop();
                else
                    return 0;
            }
        }
        return st.isEmpty() ? 1 : 0;
    }

}
