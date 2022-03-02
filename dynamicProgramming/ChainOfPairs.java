package dynamicProgramming;

import java.util.Arrays;

public class ChainOfPairs {
    public int solve(int[][] A) {
        //variables
        int max = -1;
        int n = A.length;
        int[] LIS = new int[n];
        Arrays.fill(LIS, 1);

        for(int i=1; i<n; i++){
            for(int j=0; j<i; j++){
                if(A[j][1] < A[i][0] && LIS[i] < LIS[j] + 1)
                    LIS[i] = LIS[j] + 1;
            }
        }
        for (int temp: LIS) {
            max = Math.max(max, temp);
        }
        return max;
    }


}
