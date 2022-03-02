package dynamicProgramming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public int solve(int[] A) {
        int[][] dp=new int[202][202];
        for(int i=0;i<202;i++)              //INITIALIZE DP WITH -1
            for(int j=0;j<202;j++)
                dp[i][j]=-1;
        return funn(A,0,A.length-1,dp);
    }
    public int funn(int[] A,int i,int j,int[][] dp){
        if(i>j)return 0;                    //BASE CASES
        if(i==j)return 0;
        if(dp[i][j]!=-1)return dp[i][j];    //CHECK IF ALREADY SOLVED
        int min=Integer.MAX_VALUE,sum=0,temp=min;
        for(int k=i;k<=j;k++)sum=sum+A[k];  //CALCULATE SUM
        for(int k=i;k<j;k++){
            int a=funn(A,i,k,dp);
            int b=funn(A,k+1,j,dp);
            temp=Math.min(temp,(a+b+sum));  //CALCULATE TEMP ANSWER
            if(temp<min)min=temp;           //UPDATE MIN IF FOUND BETTER ANSWER
        }
        return dp[i][j]=min;
    }

    public static void main(String[] args) {
        Solution a = new Solution();
        System.out.println(a.solve(new int[]{1,2,3,4}));
    }
}