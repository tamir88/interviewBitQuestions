package arrays;/*Given an unsorted array, find the maximum difference between the successive elements in its sorted form.
Try to solve it in linear time/space.*/


import java.util.List;
import java.util.TreeSet;

public class MaximumConsecutiveGap {
    public int maximumGap(final List<Integer> A) {
        if(A.size() < 2)
            return 0;
        TreeSet<Integer> set = new TreeSet<>(A);
        int flag =0;
        int prev = 0;
        int max = Integer.MIN_VALUE;
        for( int temp : set)
            if( flag == 0){
                prev = temp;
                flag = 1;
            }
        else{
                max = Math.max(max, temp - prev);
                prev = temp;
            }
        return max == Integer.MIN_VALUE ? 0: max;


    }


}
