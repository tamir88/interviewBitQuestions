package hashing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class LargestContinuousSequenceZeroSum {

    public ArrayList<Integer> lszero(ArrayList<Integer> A) {
        //variables
        HashMap<Integer, Integer> cache = new HashMap<>();

        int[] ind = new int[]{0,-1};
        int s = 0;
        int maxLen = 0;
        int length = 0;
        int startInd = 0;

        for(int i=0; i<A.size(); i++){
            s += A.get(i);
            if( s == 0){
                length = i+1;
                if(length > maxLen) {
                    ind[0] = 0;
                    ind[1] = i;
                    maxLen = length;
                }
            }
            else{
                if(cache.containsKey(s)){
                    startInd = cache.get(s)+1;
                    length = (i - startInd) +1;
                    if(length > maxLen){
                        ind[0] = startInd;
                        ind[1] = i;
                        maxLen = length;
                    }
                }
                else {
                    cache.put(s, i);
                }
            }
        }
        return build(ind, A);
    }

    private ArrayList<Integer> build(int[] a, ArrayList<Integer> b){
        ArrayList<Integer> ans = new ArrayList<>();
        if(a[1] == -1)
            return ans;
        for(int i= a[0]; i<=a[1]; i++)
            ans.add(b.get(i));
        return ans;
    }

    public static void main(String[] args) {
        LargestContinuousSequenceZeroSum b = new LargestContinuousSequenceZeroSum();
        ArrayList<Integer> a = new ArrayList<>(Arrays.asList(1 ,2 ,-2 ,4 ,-4));
        System.out.println(b.lszero(a));
    }



}
