package backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;


public class Subset {
    ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();

    public ArrayList<ArrayList<Integer>> subsets(ArrayList<Integer> A) {
        res.add(new ArrayList<>());
        if(A.isEmpty())
            return res;
        Collections.sort(A);
        backtrack(0,new ArrayList<>(),A);
        return res;
    }

    public void backtrack(int inx, ArrayList<Integer> sub, ArrayList<Integer> A){
        //base case
        if(inx == A.size())     return;

        //recursion section

        sub.add(A.get(inx));
        res.add(new ArrayList<>(sub));

        backtrack(inx+1,sub,A);

        sub.remove(sub.size()-1);

        backtrack(inx+1,sub,A);
    }

    public static void main(String[] args) {
        Subset a = new Subset();
        System.out.println(a.subsets(new ArrayList<>(Arrays.asList(3,1,2))));
    }

}
