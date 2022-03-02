package dynamicProgramming;

import java.util.HashMap;

public class RegularExpressionI2 {
    public int isMatch(final String A, final String B) {
        if(func(A.length()-1,B.length()-1,false,A,B,new HashMap<>()))
            return 1;
        else
            return 0;
    }

    public boolean func(int inxA, int inxB, boolean fg, String A, String B, HashMap<String,Boolean> q){
        //build key
        String key = inxA + "," + inxB;

        //base case
        if(q.containsKey(key))                                      return q.get(key);
        if(inxA == inxB && inxA == -1)                              return true;
        if((inxA == -1 && B.charAt(inxB) != '*') || inxB == -1)     return false;

        //recursion
        if(B.charAt(inxB) == '*'){
            q.put(key, (func(inxA,inxB-2,false,A,B,q) || func(inxA,inxB-1,true,A,B,q)));
            return q.get(key);
        }
        else
        {
            if(A.charAt(inxA) == B.charAt(inxB)){
                if(fg){
                    q.put(key, (func(inxA-1,inxB-1,false,A,B,q) || func(inxA-1,inxB,true,A,B,q)));
                }
                else{
                    q.put(key, func(inxA-1,inxB-1,false,A,B,q));
                }
                return q.get(key);
            }
            else if(B.charAt(inxB) == '.') {
                if(fg){
                    q.put(key, (func(inxA-1,inxB-1,false,A,B,q) || func(inxA-1,inxB,true,A,B,q)));
                }
                else {
                    q.put(key, func(inxA - 1, inxB - 1, false, A, B, q));
                }
                return q.get(key);
            }
            else
                return false;
        }

    }

    public static void main(String[] args) {
        RegularExpressionI2 a = new RegularExpressionI2();
        System.out.println(a.isMatch("aab", "c*a*b"));
    }
}
