package dynamicProgramming;

import java.util.HashMap;

public class DistinctSubsequences {
    public int numDistinct(String A, String B) {
        HashMap<String, Integer> q = new HashMap<>();
        int i = A.length() - 1;
        int j = B.length() - 1;
        return numDistinct(A, B, i, j, q);
    }

    public int numDistinct(String A, String B, int i, int j,  HashMap<String, Integer> q){
        //key builder
        String key = i + "," + j;

        //base cases
        if(q.containsKey(key))  return q.get(key);
        if(j == -1)     return 1;
        if(i == -1)     return 0;

        //recursion section
        if(B.charAt(j) == A.charAt(i)){
            q.put(key, numDistinct(A,B,i-1, j, q) + numDistinct(A,B,i-1,j-1,q));
        }
        else{
            q.put(key,  numDistinct(A,B,i-1,j,q));
        }
        return q.get(key);
    }

    public static void main(String[] args) {
        DistinctSubsequences a = new DistinctSubsequences();
        String s = "aaaababbababbaabbaaababaaabbbaaabbb";
        String s2 = "bbababa";
        System.out.println(a.numDistinct(s,s2));
    }

}
