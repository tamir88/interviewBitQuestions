package arrays;
/*Given an integer array A, find if an integer p exists in the array such that
the number of integers greater than p in the array equals to p.*/

import java.util.ArrayList;
import java.util.Collections;

public class NobleInteger {
    public int solve(ArrayList<Integer> A) {
        Collections.sort(A, Collections.reverseOrder());
        int check = A.get(0);
        if (check == 0)
            return 1;
        for (int i = 1; i < A.size(); i++) {
            if (A.get(i) == check)
                continue;
            if (A.get(i) == i)
                return 1;
            check = A.get(i);
        }
        return -1;
    }
}
