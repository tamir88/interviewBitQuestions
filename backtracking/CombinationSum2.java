package backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class CombinationSum2 {
    ArrayList<ArrayList<Integer>> res = new ArrayList<>();

    public ArrayList<ArrayList<Integer>> combinationSum(ArrayList<Integer> a, int b) {
        Collections.sort(a);
        backtrack(0,0,b,new ArrayList<>(),a);
        return res;
    }

    public void backtrack(int inx, int sum, int b,ArrayList<Integer> sub , ArrayList<Integer> a){
        //base cases
        if(sum == b){
            addIfValid(sub);
            return;
        }
        if(inx == a.size())
            return;

        //recursion section
        sub.add(a.get(inx));
        sum += a.get(inx);

        backtrack(inx+1,sum,b,sub,a);

        sum -= sub.remove(sub.size()-1);

        backtrack(inx+1,sum,b,sub,a);
    }

    private void addIfValid(ArrayList<Integer> sub){
        //case 1
        if(res.isEmpty()){
            res.add(new ArrayList<>(sub));
        }
        else{
            outerloop:
            for(ArrayList<Integer> temp : res){
                if(temp.size() == sub.size() && temp.get(0) == sub.get(0)){
                    for(int i=0;i<sub.size();i++){
                        if(temp.get(i) != sub.get(i))
                            continue outerloop;
                    }
                    return;
                }
            }
            res.add(new ArrayList<>(sub));
        }
    }

    public static void main(String[] args) {
        CombinationSum2 a = new CombinationSum2();
        System.out.println(a.combinationSum(new ArrayList<>(Arrays.asList(10,1,2,7,6,1,5)),8));
    }


}
