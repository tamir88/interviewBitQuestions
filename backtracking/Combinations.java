package backtracking;

import java.util.ArrayList;

public class Combinations {
    ArrayList<ArrayList<Integer>> res = new ArrayList<>();

    public ArrayList<ArrayList<Integer>> combine(int A, int B) {
        ArrayList<Integer> arr = new ArrayList<>(A);
        for(int i=0;i<A;i++){
            arr.add(i+1);
        }
        backtrack(0,0,B,new ArrayList<>(),arr);
        return res;
    }

    public void backtrack(int inx, int count, int B,ArrayList<Integer> sub, ArrayList<Integer> A){
        //base case
        if(count == B){
            res.add(new ArrayList<>(sub));
            return;
        }
        if(inx == A.size())
            return;

        //recursion section
        sub.add(A.get(inx));
        count++;

        backtrack(inx+1,count,B,sub,A);

        sub.remove(sub.size()-1);
        count--;

        backtrack(inx+1,count,B,sub,A);
    }

    public static void main(String[] args) {
        Combinations a = new Combinations();
        System.out.println(a.combine(4,2));

    }
}
