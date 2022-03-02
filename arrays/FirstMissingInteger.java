package arrays;
/*Given an unsorted integer array, find the first missing positive integer.
Example:
Given [1,2,0] return 3,
[3,4,-1,1] return 2,
[-8, -7, -6] returns 1
Your algorithm should run in O(n) time and use constant space.*/

import java.util.ArrayList;

public class FirstMissingInteger {
    public int firstMissingPositive(ArrayList<Integer> A) {
        for(int i=0; i<A.size(); i++){
            if(A.get(i)>0 && A.get(i)<A.size()+1){
                if(A.get(i) != A.get(A.get(i)-1) ){
                    sweap(i, A.get(i)-1, A);
                    i--;
                }
            }
        }
        for(int j=0; j<A.size(); j++)
            if(A.get(j) != j+1)
                return j+1;
        return A.size()+1;
    }
    private void sweap(int a, int b, ArrayList<Integer> c){
        int temp = c.get(a);
        c.set(a,c.get(b));
        c.set(b, temp);
    }
}
