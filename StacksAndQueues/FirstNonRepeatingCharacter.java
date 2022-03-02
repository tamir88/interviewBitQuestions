package StacksAndQueues;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class FirstNonRepeatingCharacter {
    public String solve(String A) {
        Queue<Character> q = new LinkedList<>();
        HashMap<Character, Integer> map = new HashMap<>();
        String B = "" + A.charAt(0);
        q.add(A.charAt(0));
        map.put(A.charAt(0), 1);
        for (int i = 1; i < A.length(); i++) {
            char curChar = A.charAt(i);

            if(map.containsKey(curChar))
                map.put(curChar,map.get(curChar) + 1);
            else {
                map.put(curChar, 1);
                q.add(curChar);
            }

            while (!q.isEmpty() && map.get(q.peek()) > 1) {
                q.remove();
            }
            if(q.isEmpty())
                B += '#';
            else
                B += q.peek();
        }
        return B;
    }

}
