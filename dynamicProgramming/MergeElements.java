package dynamicProgramming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class MergeElements {
    public int solve(ArrayList<Integer> A) {
        return func(0,0,A.size()-1,A,new HashMap<>());
    }

    public int func(int start, int inx, int end, ArrayList<Integer> A, HashMap<String,Integer> q) {
        //build key
        String key = start + "," + end;

        //base cases
        if(q.containsKey(key))  return q.get(key);
        if(start == end)        return 0;
        if(inx == end)          return Integer.MAX_VALUE;

        //recursion
        int sum = 0;
        for(int i=start; i<=end; i++)
            sum += A.get(i);

        int left = sum + func(start,start,inx,A,q) + func(inx+1,inx+1,end,A,q);
        int right = func(start,inx+1,end,A,q);

        q.put(key, Math.min(left, right));
        return q.get(key);
    }

    public static void main(String[] args) {
        MergeElements a = new MergeElements();
        System.out.println(a.solve(new ArrayList<>(Arrays.asList(1,3,7))));
    }
}
