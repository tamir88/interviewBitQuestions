package dynamicProgramming;

import java.util.*;

public class FlipArray {
    public int solve(final List<Integer> A) {
        HashMap<String, ArrayList<Integer>> q = new HashMap<>();
        ArrayList<Integer> arr = buildArray(A);
        Collections.sort(arr);
        int sum = doSum(A);
        ArrayList<Integer> res = solve(sum,0,A.size()-1,arr,q);
        return res.get(1);
    }

    public ArrayList<Integer> solve(int sum, int num,int j, ArrayList<Integer> arr, HashMap<String, ArrayList<Integer>> q  ){
        //build key
        String key = j + "," + sum;

       //base cases
        if(q.containsKey(key))  return q.get(key);
        if(sum == 0 ||j == -1)
            return new ArrayList<>(Arrays.asList(sum,num));

        //recursion
        int newSum = sum - arr.get(j);

        if(newSum >= 0){
            //return min(solve(newSum,num+1,j-1,arr,q), solve(sum,num,j-1,arr,q));
            q.put(key, min(solve(newSum,num+1,j-1,arr,q), solve(sum,num,j-1,arr,q)));
            return q.get(key);
        }
        else
            return solve(sum,num,j-1,arr,q);
    }

    private ArrayList<Integer>buildArray(List<Integer> a){
        ArrayList<Integer> res = new ArrayList<>();
        for(int temp : a)
            res.add(temp *2);
        return res;
    }

    // generate min from 2 arrays
    private ArrayList<Integer> min(ArrayList<Integer> a, ArrayList<Integer> b){
        if(a.get(0) < b.get(0))
            return a;
        if(a.get(0) == b.get(0))
            if(a.get(1) < b.get(1))
                return a;
            else
                return b;
        return b;
    }

    private int doSum(List<Integer> a){
        int sum = 0;
        for(int temp : a)
            sum += temp;
        return sum;
    }


    public static void main(String[] args) {
        FlipArray a = new FlipArray();
        ArrayList<Integer> ar = new ArrayList<>(Arrays.asList(11, 10, 8, 6, 8, 11, 1, 10, 2, 3, 8, 3, 8, 12, 11, 1,7));
        System.out.println(a.solve(ar));
    }
}
