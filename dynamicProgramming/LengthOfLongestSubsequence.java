package dynamicProgramming;

import java.util.Arrays;
import java.util.List;

public class LengthOfLongestSubsequence {

    public int longestSubsequenceLength(final List<Integer> A) {
        if(A.isEmpty())
            return 0;

        int n = A.size();
        int max = -1;

        int[] LIS = new int[n];
        int[] LDS = new int[n];
        Arrays.fill(LIS, 1);
        Arrays.fill(LDS, 1);

        for(int i=1; i<n; i++){
            for(int j=0; j<i; j++){
                if(A.get(j) < A.get(i) && LIS[i] < LIS[j]+1)
                    LIS[i] = LIS[j]+1;
            }
        }

        for(int i=n-2; i>=0; i--){
            for(int j=n-1; j>i; j--){
                if(A.get(j) < A.get(i) && LIS[i] < LIS[j]+1)
                    LIS[i] = LIS[j]+1;
            }
        }
        for(int i=0; i<n; i++){
            int cur = LDS[i] + LIS[i] -1;
            max = Math.max(cur, max);
        }

        return max;
    }
}
