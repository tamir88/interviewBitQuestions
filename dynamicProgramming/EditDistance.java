package dynamicProgramming;

import java.util.HashMap;

public class EditDistance {
    public int minDistance(String A, String B) {
        HashMap<String, Integer> q = new HashMap<>();
        return minDistance(A,B,q);
    }

    public int minDistance(String A, String B, HashMap<String, Integer> q){
        //variables
        int sizeA = A.length();
        int sizeB = B.length();
        String key = A + "," + B;

        //memoized
        if(q.containsKey(key))    return q.get(key);

        // base cases
        if(sizeA == 0)  return sizeB;
        if(sizeB == 0)  return sizeA;

        //String building
        String a2 = B.charAt(0) + A.substring(0);
        String a, b, a1;
        if(sizeB == 1)
            b = "";
        else
            b = B.substring(1);

        if(sizeA == 1){
            a = "";
            a1 = Character.toString(B.charAt(0));
        }else{
            a = A.substring(1);
            a1 = B.charAt(0) + A.substring(1);
        }

        //recursion
        if(A.charAt(0) == B.charAt(0)){
            q.put(key,minDistance(a, b, q));
            return q.get(key);
        }
        else
        {
            q.put(key,1 + Math.min(minDistance(a,B,q), Math.min(minDistance(a1,B,q), minDistance(a2,B,q))));
            return q.get(key);
        }
    }



    public static void main(String[] args) {
        EditDistance a = new EditDistance();
        String c =  "babaaabaaab", b = "ababaabbab";
        System.out.println(a.minDistance(c,b));


    }


}
