package arrays;/*You are given a binary string(i.e. with characters 0 and 1) S consisting of characters S1, S2, …, SN. In a single operation,
you can choose two indices L and R such that 1 ≤ L ≤ R ≤ N and flip the characters SL, SL+1, …, SR. By flipping,
we mean change character 0 to 1 and vice-versa.
Your aim is to perform ATMOST one operation such that in final string number of 1s is maximised. If you don’t want to perform the operation
, return an empty array. Else, return an array consisting of two elements denoting L and R. If there are multiple solutions,
return the lexicographically smallest pair of L and R.*/

import java.util.ArrayList;
import java.util.Arrays;

public class Flip {

    public ArrayList<Integer> flip(String A) {
        ArrayList<Integer> arr = new ArrayList<>();
        ArrayList<Integer> array = zeroIndex(A);
        if(array == null)
            return arr;
        else
            if(array.get(0) == array.get(1))
                return array;
        return findBestIndex(array, A);
    }

    //this method takes String and return array of size 2 with the indexes of first '0' and last '0'
    private ArrayList<Integer> zeroIndex(String A){
        ArrayList<Integer> arr = new ArrayList<>(2);
        int index = A.indexOf('0');
        if(index == -1)
            return null;
        else
            arr.add(0, index);
        int end_index = A.lastIndexOf('0');
        arr.add(1, end_index);
        return arr;
    }

    private ArrayList<Integer> findBestIndex(ArrayList<Integer> arr, String A){
        ArrayList<Integer> copy = new ArrayList<>();
        ArrayList<Integer> global_ans = new ArrayList<>(Arrays.asList(arr.get(0)+1,arr.get(0)+1));
        ArrayList<Integer> current_ans = new ArrayList<>(Arrays.asList(arr.get(0)+1,arr.get(0)+1));
        int global_max = 1;
        int current_max = 1;

        for(int i = 0; i < A.length(); i++){
            if(A.charAt(i) == '0')
                copy.add(i, 1);
            else
                copy.add(i, -1);
        }

        for(int i = arr.get(0)+1; i<arr.get(1)+1; i++){
            if(copy.get(i) > copy.get(i) + current_max){
                current_max = copy.get(i);
                current_ans.set(0, i+1);
                current_ans.set(1, i+1);

            }
            else{
                current_max += copy.get(i);
                current_ans.set(1, current_ans.get(1) + 1);

            }
            if( current_max > global_max){
                global_max = current_max;
                global_ans.set(0, current_ans.get(0));
                global_ans.set(1, current_ans.get(1));
            }
        }
        return global_ans;
    }

    public static void main(String[] args) {
        String S = "0111000100010";
        Flip A = new Flip();
        System.out.println( Arrays.toString(A.flip(S).toArray()));
    }


}
