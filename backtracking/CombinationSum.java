package backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class CombinationSum {
    ArrayList<ArrayList<Integer>> res = new ArrayList<>();

    public ArrayList<ArrayList<Integer>> combinationSum(ArrayList<Integer> A, int B) {
        Collections.sort(A);
        backtrack(0,0,B,new ArrayList<>(),A);
        return res;
    }

    private boolean equals(ArrayList<Integer> sub){
        int size = res.size();
        outerloop:
        for(int i= size-1;i>=0;i--){
            ArrayList<Integer> temp = res.get(i);
            if(temp.size() == sub.size() && sub.get(0) == temp.get(0)) {
                for (int j = 0; j < sub.size(); j++) {
                    if (temp.get(j) != sub.get(j))
                        continue outerloop;
                }
                return true;
            }
        }
        return false;
    }

    public void backtrack(int inx, int sum, int B, ArrayList<Integer> sub, ArrayList<Integer> A){
        //base case
        if(sum > B)
            return ;
        if(sum == B) {
            if(res.isEmpty()) {
                res.add(new ArrayList<>(sub));
                return;
            }
            else if(equals(sub))
                return;
            else{
                res.add(new ArrayList<>(sub));
                return;
            }
        }
        if(inx == A.size())
            return ;

        //recursion section
        sub.add(A.get(inx));
        sum += A.get(inx);
        backtrack(inx,sum,B,sub,A);

        sum -= (sub.remove(sub.size()-1));
        backtrack(inx+1,sum,B,sub,A);
    }

    public static void main(String[] args) {
        CombinationSum a = new CombinationSum();
        System.out.println(a.combinationSum(new ArrayList<>(Arrays.asList(8, 10, 6, 11, 1, 16, 8 )),28));
    }
}
