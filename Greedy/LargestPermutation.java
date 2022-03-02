package Greedy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;

public class LargestPermutation {
    public ArrayList<Integer> solve(ArrayList<Integer> A, int B) {
        if(B==0)
            return A;
        //variables
        int j = 0;
         HashMap<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<A.size();i++){
            map.put(A.get(i), i);
        }
        for(int i=0;i<A.size() && j<B;i++){
            int to_be_swap = A.size() - i;
            int inx = map.get(to_be_swap);
            if(inx == i)
                continue;
            else {
                map.replace(A.get(i), inx);
                Collections.swap(A, i, inx);
                j++;
            }
        }
        return A;
    }

    public static void main(String[] args) {
        LargestPermutation a = new LargestPermutation();
        System.out.println(a.solve(new ArrayList<>(Arrays.asList(3, 2, 4, 1, 5)), 3));
    }



}
