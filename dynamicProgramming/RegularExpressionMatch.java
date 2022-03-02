package dynamicProgramming;

import java.util.HashMap;

public class RegularExpressionMatch {
    public int isMatch(final String A, final String B) {
        if(func(A.length()-1,B.length()-1,false,A,B,new HashMap<>()))
            return 1;
        else
            return 0;
    }

    public boolean func(int inxA, int inxB, boolean flag, String A, String B, HashMap<String,Boolean> q){
        //build key
        String key = inxA + "," + inxB;

        //base case
        if(q.containsKey(key))                                  return q.get(key);
        if(inxB == 0 && flag)                                   return true;
        if(inxA < 0 && inxB == -1)                              return true;
        if((inxA == -1 && B.charAt(inxB)!='*') || inxB == -1)   return false;
        if(inxA < -1)                                           return false;


        //recursion
        if(B.charAt(inxB) == '*'){
            q.put(key, func(inxA,inxB-1,false,A,B,q) || func(inxA-1,inxB,true,A,B,q));
            return q.get(key);
        }
        else
        {
            if(A.charAt(inxA) == B.charAt(inxB) || B.charAt(inxB) == '?') {
                q.put(key, func(inxA - 1, inxB - 1, false, A, B,q));
                return q.get(key);
            }
            else
                return false;
        }
    }

    public static void main(String[] args) {
        RegularExpressionMatch a = new RegularExpressionMatch();
        System.out.println(a.isMatch("cc","***??"));
    }

}
