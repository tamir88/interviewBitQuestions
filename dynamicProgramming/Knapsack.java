package dynamicProgramming;

public class Knapsack {
    public int solve(int[] A, int[] B, int C) {
        //variables
        int m = A.length+1;
        int n = C+1;
        int[][] dp = new int[m][n];

        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(i==0 || j==0)
                    dp[i][j] = 0;
                else if(B[i-1] <= j) {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - B[i-1]] + A[i-1]);
                }
                else
                    dp[i][j] = dp[i-1][j];
            }
        }
        return dp[m-1][n-1];
    }

}
