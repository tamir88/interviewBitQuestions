package dynamicProgramming;

import java.util.HashMap;

public class LongestPalindromicSubsequence {

    public int solve(String A) {
        int s = 0;
        int e = A.length() - 1;
        HashMap<String, Integer> map = new HashMap<>();
        return solve(s, e, A, map);
    }

    public int solve(int s, int e, String A, HashMap<String, Integer> map){
        String key = s + "," + e;
        //memoized
        if(map.containsKey(key))    return map.get(key);
        //base cases
        if(s > e)   return 0;
        if(s == e)  return 1;

        //recursion
        if( A.charAt(s) == A.charAt(e))
            map.put(key, 2 + solve(s+1, e-1, A, map));
        else
            map.put(key, Math.max(solve(s+1,e,A,map), solve(s,e-1,A,map)));
        return map.get(key);
    }

    public static void main(String[] args) {
        LongestPalindromicSubsequence a = new LongestPalindromicSubsequence();
        String A = "bebeeed";
        System.out.println(a.solve(A));
    }
}
