package arrays;/* Find the contiguous subarray within an array, A of length N which has the largest sum.*/


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MaxSumContiguousSubarray {
    public int maxSubArray(final List<Integer> A) {
        int max = -1000;
        int sum = 0;
        //start with the first positive integer
        for( int j = 0; j<A.size(); j++){

            if( sum + A.get(j) > 0){
                sum += A.get(j);
                if( sum > max )
                    max = sum;

            }
            else{
                sum = 0;
                if( A.get(j)>max )
                    max = A.get(j);
            }

        }
        return max;
    }

    public static void main(String[] args) {
        List<Integer> A = new ArrayList<Integer>(Arrays.asList(1,2,-5,10,5));


    }






}
