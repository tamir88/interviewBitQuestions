package string;

import java.util.LinkedList;
import java.util.Queue;

public class ImplementStrStr {

    public int strStr(final String A, final String B) {

        //variables
        int p1 = 0; // pointer of String1
        int p2 = 0; // pointer of String2
        int index = 0; // the result to br return
        int n = A.length();
        int m = B.length();
        Queue<Integer> q = new LinkedList<>();

        //constrains
        if (A.isEmpty() || B.isEmpty())
            return -1;
        if (m > n)
            return -1;

        while (p1 < n && p2 < m){

            if (A.charAt(p1) == B.charAt(0)){
                q.add(p1);
            }
            if (A.charAt(p1) == B.charAt(p2)){
                p1++;
                p2++;
            }
            else{
                if(!q.isEmpty()) {
                    if (q.size() == 1) {
                        q.remove();
                        p1++;
                        p2 = 0;
                    } else {
                        q.remove();
                        p1 = q.peek() + 1;
                        p2 = 1;
                    }
                }
                else {
                    p1++;
                    p2 = 0;
                }
            }
        }
        // cases after while loop
        if (p2 < m)
            return -1;

        else
            return q.peek();
    }

    public static void main(String[] args) {
        ImplementStrStr a = new ImplementStrStr();
        System.out.println(a.strStr("babbbabbabbbaab", "bba"));
    }

}
