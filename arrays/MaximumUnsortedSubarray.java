package arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MaximumUnsortedSubarray {
    public ArrayList<Integer> subUnsort(ArrayList<Integer> A) {
        if(ifSorted(A))
            return new ArrayList<>(Arrays.asList(-1));
        else
            return firstAndLastIndex(A);


    }


    private ArrayList<Integer> firstAndLastIndex(ArrayList<Integer> A){
        ArrayList<Integer> ans = new ArrayList<>();
        int index1 = 0;
        int index2 = 0;
        for(int i=0; i<A.size(); i++){
            if(A.get(i)>A.get(i+1)) {
                index1 = i;
                break;
            }
        }
        for(int i=A.size()-1; i>=1; i--){
            if(A.get(i)<A.get(i-1)) {
                index2 = i;
                break;
            }
        }
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for(int i=index1; i<=index2; i++){
            min = Math.min(A.get(i), min);
            max = Math.max(A.get(i), max);
        }
        for(int i=0; i<A.size(); i++)
            if(A.get(i)>min) {
                ans.add(i);
                break;
            }
        for(int i=A.size()-1; i>=0; i--)
            if(A.get(i)<max){
                ans.add(i);
                break;
            }
        return ans;
    }

    private boolean ifSorted(ArrayList<Integer> A){
        for(int i=0; i<A.size()-1; i++){
            if(A.get(i)>A.get(i+1))
                return false;
        }
        return true;
    }

}
