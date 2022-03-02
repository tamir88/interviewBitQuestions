package dynamicProgramming;

public class LongestCommonSubsequence {
    public int solve(String A, String B) {
        //variables
        int m = B.length()+1;
        int n = A.length()+1;
        int[][] cache = new int[m][n];

        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if( i==0 || j==0)
                    cache[i][j] = 0;
                else if(B.charAt(i-1) == A.charAt(j-1))
                    cache[i][j] = cache[i-1][j-1] + 1;
                else
                    cache[i][j] = Math.max(cache[i][j-1], cache[i-1][j]);
            }
        }
        return cache[m-1][n-1];
    }
}
