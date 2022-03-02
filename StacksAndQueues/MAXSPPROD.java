package StacksAndQueues;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

public class MAXSPPROD {
    public int maxSpecialProduct(int[] A) {
        int n = A.length;

        //Nearest Greater To Left
        int[] nll = new int[n];

        //Nearest Greater To Right
        int[] nlr = new int[n];

        Stack<Integer> st = new Stack<>();

        for(int i = 0; i < n; i++)
        {
            while(!st.isEmpty() && A[st.peek()] < A[i])
                nlr[st.pop()] = i;

            st.push(i);
        }

        st.empty();
        for(int i = n - 1; i >=  0; i--)
        {
            while(!st.isEmpty() && A[st.peek()] < A[i])
                nll[st.pop()] = i;

            st.push(i);
        }

        long ans = -1;
        int mod = (int)(1e9 + 7);

        for(int i = 0; i < n; i++)
            ans =  Math.max(ans, (long)nll[i] * nlr[i]);

        return (int)(ans % mod);
    }

    public static void main(String[] args) {
        MAXSPPROD a = new MAXSPPROD();
        System.out.println(a.maxSpecialProduct(new int[]{5, 9, 6, 8, 6, 4, 6, 9, 5, 4, 9}));
    }

}
