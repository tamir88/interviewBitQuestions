package dynamicProgramming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class MaxSumWithoutAdjacentElements {
    public int adjacent(ArrayList<ArrayList<Integer>> A){
        HashMap<String, Integer> q = new HashMap<>();
        return adjacent(0,0, A, q);
    }

    public int adjacent(int row, int col, ArrayList<ArrayList<Integer>> A, HashMap<String, Integer> q) {
        //build key
        String key = row + "," + col;

        //base cases
        if(q.containsKey(key))          return q.get(key);
        if(col > A.get(0).size() - 1)   return 0;

        //recursion
        int addItem = A.get(row).get(col);

        if(row == 1) {
            q.put(key, Math.max(addItem + adjacent(0, col + 2, A, q), adjacent(0, col + 1, A, q)));
            return q.get(key);
        }
        else {
            q.put(key, Math.max(addItem + adjacent(0, col + 2, A, q), adjacent(1, col, A, q)));
            return q.get(key);
        }
    }






    public static void main(String[] args) {
        MaxSumWithoutAdjacentElements a = new MaxSumWithoutAdjacentElements();
        ArrayList<ArrayList<Integer>> A = new ArrayList<>(2);
        A.add(new ArrayList<>(Arrays.asList(1, 2, 3, 4)));
        A.add(new ArrayList<>(Arrays.asList(2, 3, 4, 5)));
        System.out.println(a.adjacent(A));
    }

}
