package twoPointers;

import java.util.LinkedList;
import java.util.Queue;

public class MaximumOnesAfterModification {

    public int solve(int[] A, int B) {

        //trivial case for efficiency
        if(A.length <= B)
            return A.length;

        //variables
        Queue<Integer> q = new LinkedList<>();
        int count = 0;
        int chank = 0;
        int max = 0;

        for(int i=0; i<A.length; i++){
            if(A[i] == 0){
                if(B == 0){
                    max = Math.max(max, count);
                    count = (count - q.remove()) +1;
                    q.add(++chank);
                    chank = 0;
                }
                else{
                    count++;
                    q.add(++chank);
                    chank = 0;
                    B--;
                }
            }
            else{
                count++;
                chank++;
            }
        }
        return Math.max(max, count);
    }

    public static void main(String[] args) {
        MaximumOnesAfterModification a = new MaximumOnesAfterModification();
        int[] s = new int[]{0, 0, 0, 0, 0, 1, 1, 1, 1, 1};
        System.out.println(a.solve(s, 2));
    }



}
