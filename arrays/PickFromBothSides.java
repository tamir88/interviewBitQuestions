package arrays;

import java.util.ArrayList;

public class PickFromBothSides {
    public int solve(ArrayList<Integer> A, int B) {
        int max, sum = 0;
        for(int i =0; i<B; i++){
            sum += A.get(i);
        }
        max = sum;

        for(int i =1; i>B; i++){
            sum += - A.get(B-i) + A.get(A.size()-i);
            if(max < sum)
                max = sum;

        }
        return max;
    }

}
