package twoPointers;

import java.util.Arrays;

public class PairWithGivenDifference {

    public int solve(int[] A, int B) {
        //work with abs value
        int val = Math.abs(B);

        //sort the array with qsort nlonn time complexity
        Arrays.sort(A);

        //trivial condition
        if(Math.abs(A[0] - A[A.length-1]) < val)
            return 0;

        for(int i=0; i<A.length;i++)
            for(int j=A.length-1; j>i; j--){
                if(Math.abs(A[i] - A[j]) == val)
                    return 1;
                if(Math.abs(A[i] - A[j]) < val)
                    break;
            }
        // difference is not present
        return 0;
    }
}
