package dynamicProgramming;

import java.util.HashMap;

public class ScrambleString {
    public int isScramble(final String A, final String B) {
        if(sameLetters(A,B)) {
            if (func(A, B, new HashMap<>()))
                return 1;
        }
        return 0;
    }

    public boolean func(String s1, String s2, HashMap<String, Boolean> q){
        //build key
        String key = s1 + "," + s2;

        //base case
        if(q.containsKey(key))  return q.get(key);
        if(s1.length() == 1)    return s1.equals(s2) ;
        if(s1.equals(s2))       return true;

        //recursion
        int n = s1.length();
        for(int i=1; i<n; i++){
            if((func(s1.substring(0,i),s2.substring(0,i),q) && func(s1.substring(i),s2.substring(i),q))
              || (func(s1.substring(0,i),s2.substring(n-i),q) && func(s1.substring(i),s2.substring(0,n-i),q))) {
                q.put(key,true);
                return q.get(key);
            }
        }
        q.put(key, false);
        return q.get(key);
    }

    private boolean sameLetters(String s1, String s2){
        HashMap<Character, Integer> q1 = new HashMap<>();
        HashMap<Character, Integer> q2 = new HashMap<>();

        for(int i=0; i<s1.length(); i++){
            Character key = s1.charAt(i);
            if(q1.containsKey(key))
                q1.put(key,q1.get(key)+1);
            else
                q1.put(key,1);
        }
        for(int i=0; i<s2.length(); i++){
            Character key = s2.charAt(i);
            if(q2.containsKey(key))
                q2.put(key,q2.get(key)+1);
            else
                q2.put(key,1);
        }
        return q1.equals(q2);
    }

    public static void main(String[] args) {
        ScrambleString a = new ScrambleString();
        //System.out.println(a.isScramble("abc", "cba"));
        //System.out.println(a.sameLetters("eebbc","cbebe"));

    }

}
