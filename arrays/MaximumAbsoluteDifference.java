package arrays;/*You are given an array of N integers, A1, A2 ,…, AN. Return maximum value of f(i, j) for all 1 ≤ i, j ≤ N.
        f(i, j) is defined as |A[i] - A[j]| + |i - j|, where |x| denotes absolute value of x.*/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MaximumAbsoluteDifference {
    public static int maxArr(ArrayList<Integer> A) {
        int maxAk1 = Integer.MIN_VALUE;
        int minAk1 = Integer.MAX_VALUE;
        int maxAk2 = Integer.MIN_VALUE;
        int minAk2 = Integer.MAX_VALUE;
        for(int i=0;i<A.size();i++){
            maxAk1= Math.max(A.get(i)+i, maxAk1);
            minAk1 = Math.min(A.get(i)+i, minAk1);
            maxAk2= Math.max(A.get(i)-i, maxAk2);
            minAk2 = Math.min(A.get(i)-i, minAk2);
        }
        return Math.max(maxAk1-minAk1, maxAk2-minAk2);
    }

    public static void main(String[] args) {
        ArrayList<Integer> A = new ArrayList<>(Arrays.asList(1,3,-1));
        System.out.println(maxArr(A));
    }

}
