package dynamicProgramming;

import java.util.HashMap;

public class RepeatingSubSequence {
    public int anytwo(String A) {
        HashMap<String, Integer> q = new HashMap<>();
         return anytwo(A,A,q) > 1 ? 1 : 0;
    }

    public int anytwo(String A, String B, HashMap<String, Integer> q){
        String key = A + B;

        //base cases---------------------
        if(q.containsKey(key))  return q.get(key);
        if(A.length() == 0)     return 0;
        if(B.length() == 0)     return 0;

        //variables----------------------
        int i = A.length() - 1;
        int j = B.length() - 1;
        String a = makeString(A);
        String b = makeString(B);

        //recursion section---------------
        if(A.charAt(i) == B.charAt(j) && i != j){
            q.put(key, 1 + anytwo(a,b,q));
            return q.get(key);
        }
        else{
            q.put(key, Math.max(anytwo(a,B,q), anytwo(A,b,q)));
            return q.get(key);
        }
    }

    //generate String as desired
    private String makeString(String A){
        int size = A.length();
        if(size == 1)
            return "";
        else
            return A.substring(0, size - 1);
    }

    public static void main(String[] args) {
        RepeatingSubSequence a = new RepeatingSubSequence();
        String s = "abba";
        System.out.println(a.anytwo(s));
    }
}
