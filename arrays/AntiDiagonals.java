package arrays;

import java.util.ArrayList;
import java.util.Arrays;

public class AntiDiagonals {
    public ArrayList<ArrayList<Integer>> diagonal(ArrayList<ArrayList<Integer>> A) {

        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        int size = A.get(0).size();
        int left_ind;
        int right_ind;

        for(int i=0; i<size; i++){
            left_ind = 0;
            right_ind = i;
            ArrayList<Integer> in = new ArrayList<>();
            for(int j=0; j<i+1; j++){
                in.add(A.get(left_ind).get(right_ind));
                left_ind++;
                right_ind--;
            }
            ans.add(in);
        }
        for(int i=1; i<size; i++){
            left_ind = i;
            right_ind = size-1;
            ArrayList<Integer> in = new ArrayList<>();
            for(int j=0; j<size-i; j++){
                in.add(A.get(left_ind).get(right_ind));
                left_ind++;
                right_ind--;
            }
            ans.add(in);
        }
        return ans;
    }

    public static void main(String[] args) {
        AntiDiagonals r = new AntiDiagonals();
        ArrayList<ArrayList<Integer>> n =new ArrayList<>();
        n.add(new ArrayList<>(Arrays.asList(1,2)));
        n.add(new ArrayList<>(Arrays.asList(3,4)));
        for(ArrayList<Integer> temp : r.diagonal(n))
            System.out.println(Arrays.toString(temp.toArray()));
    }
}
