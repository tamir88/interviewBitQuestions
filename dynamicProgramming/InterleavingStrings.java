package dynamicProgramming;

import java.util.HashMap;

public class InterleavingStrings {
    public int isInterleave(String A, String B, String C) {
        //base case (for best case complexity)
        if (!sameLetters(A, B, C))
            return 0;
        HashMap<String, Boolean> map = new HashMap<>();
        if (func(1, 0, 0, A.charAt(0), A, B, C, map) || func(0, 1, 0, B.charAt(0), A, B, C, map))
            return 1;
        else
            return 0;
    }

    private boolean func(int inxA, int inxB, int inxC, char curr, String A, String B, String C, HashMap<String, Boolean> map) {
        //build key
        String key = inxA + "," + inxB + "," + inxC;
        //base cases
        if (map.containsKey(key)) return map.get(key);
        if (curr != C.charAt(inxC)) return false;
        if (inxC + 1 == C.length()) return true;

        //recursion
        if (inxA == A.length()) {
            map.put(key, func(inxA, inxB + 1, inxC + 1, B.charAt(inxB), A, B, C, map));
            return map.get(key);
        }
        if (inxB == B.length()) {
            map.put(key, func(inxA + 1, inxB, inxC + 1, A.charAt(inxA), A, B, C, map));
            return map.get(key);
        }
        //recursion
        Boolean bool = func(inxA + 1, inxB, inxC + 1, A.charAt(inxA), A, B, C, map) || func(inxA, inxB + 1, inxC + 1, B.charAt(inxB), A, B, C, map);
        map.put(key, bool);
        return map.get(key);
    }

    private boolean sameLetters(String A, String B, String C) {
        //base case
        if (A.length() + B.length() != C.length())
            return false;

        HashMap<Character, Integer> map_ab = new HashMap<>();
        HashMap<Character, Integer> map_c = new HashMap<>();
        for (int i = 0; i < A.length(); i++) {
            char key = A.charAt(i);
            if (map_ab.containsKey(key)) {
                int newValue = map_ab.get(key) + 1;
                map_ab.put(key, newValue);
            } else
                map_ab.put(key, 1);
        }
        for (int i = 0; i < B.length(); i++) {
            char key = B.charAt(i);
            if (map_ab.containsKey(key)) {
                int newValue = map_ab.get(key) + 1;
                map_ab.put(key, newValue);
            } else
                map_ab.put(key, 1);
        }
        for (int i = 0; i < C.length(); i++) {
            char key = C.charAt(i);
            if (map_c.containsKey(key)) {
                int newValue = map_c.get(key) + 1;
                map_c.put(key, newValue);
            } else
                map_c.put(key, 1);
        }
        if (map_ab.equals(map_c))
            return true;
        else
            return false;
    }

    public static void main (String[]args){
        InterleavingStrings a = new InterleavingStrings();
        System.out.println(a.isInterleave("aabcc", "dbbca", "aadbbcbcac"));

    }

}
