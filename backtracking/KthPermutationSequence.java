package backtracking;

import java.util.ArrayList;

public class KthPermutationSequence {
    private String str = "";

    public String getPermutation(int A, int B) {
        if(B>fac(A)) return "";
        ArrayList<Integer> dig = new ArrayList<>(A);
        for(int i=0; i<A; i++){
            dig.add(i,i+1);
        }
        func(A,B,dig);
        return str;
    }

    public void func(int n, int k, ArrayList<Integer> dig) {
        //base case
        if (dig.size() == 1)
            str += dig.get(0);

        //recursion
        else {
            //compute index
            int elNum = fac(n-1);
            int inx = k/elNum;
            if(k%elNum == 0)
                inx--;

            //adding digit and removing from dig
            str += dig.remove(inx);

            // compute new k
            k -= (inx * elNum);

            //recursive call
            func(n-1,k,dig);
        }
    }

    /*private int fac(int n){
        int res = 1;
        for (int i=2; i<=n; i++)
            res *= i;
        return res;
    }*/

    private int fac(int n){
        if (n == 0)
            return 1;
        else
            return(n * fac(n-1));
    }

    public static void main(String[] args) {
        KthPermutationSequence a = new KthPermutationSequence();
        System.out.println(a.getPermutation(11,14));
    }
}
