package hashing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class AnIncrementProblem {
    public ArrayList solve(ArrayList<Integer> A) {
        ArrayList<Integer> ans = new ArrayList<>();
        HashMap<Integer, Integer> ind = new HashMap<>();
        HashSet set = new HashSet<>();

        for(int  i = 0; i < A.size(); ++i) {
            if(!set.contains(A.get(i))) {
                ans.add(A.get(i));
                set.add(A.get(i));
                ind.put(A.get(i), i);
            } else {
                int val = ans.get(ind.get(A.get(i))) + 1;
                ans.set(ind.get(A.get(i)), val);
                ans.add(A.get(i));
                if(!set.contains(val) || ind.get(val) > ind.get(A.get(i))) {
                    set.add(val);
                    ind.put(val, ind.get(A.get(i)));
                }
                ind.put(A.get(i), i);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        AnIncrementProblem a =new AnIncrementProblem();
        System.out.println(a.solve(new ArrayList<>(Arrays.asList(1,2,3,2,1,3))));
    }
}
