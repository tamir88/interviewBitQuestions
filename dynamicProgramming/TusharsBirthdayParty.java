package dynamicProgramming;

import java.util.*;

public class TusharsBirthdayParty {

    public int solve(final List<Integer> A, final List<Integer> B, final List<Integer> C) {
        HashMap<Integer, Integer> q = new HashMap<>();
        ArrayList<Integer> res = new ArrayList<>();
        for(int i=0; i<A.size(); i++){
            res.add(solve(A.get(i),B,C,q));
        }
        return computeSum(res);
    }

    public int solve(int capacity, final List<Integer> B, final List<Integer> C, HashMap<Integer, Integer> q){

        //base cases
        if(q.containsKey(capacity))     return q.get(capacity);
        if(capacity == 0)   return 0;

        // variables
        ArrayList<Integer> nodes = new ArrayList<>();

        //recursion section
        for(int i=0; i<B.size(); i++){
            int newCap = capacity - B.get(i);
            int cost = C.get(i);
            if(newCap >= 0)
                nodes.add(cost + solve(newCap,B,C,q));
        }
        q.put(capacity, min(nodes));
        return q.get(capacity);
    }

    private int min(ArrayList<Integer> arr){
        int res = arr.get(0);
        for (int temp : arr)
            res = Math.min(res, temp);
        return res;
    }

    private int computeSum(ArrayList<Integer> arr){
        int sum = 0;
        for(int temp : arr)
            sum += temp;
        return sum;
    }

    public static void main(String[] args) {
        List<Integer> A = new ArrayList<>(Arrays.asList(4,6));
        List<Integer> B = new ArrayList<>(Arrays.asList(1,3));
        List<Integer> C = new ArrayList<>(Arrays.asList(5,3));

        TusharsBirthdayParty a = new TusharsBirthdayParty();
        System.out.println(a.solve(A,B,C));
    }

}
