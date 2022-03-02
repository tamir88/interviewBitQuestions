package arrays;/*
Given a non-negative number represented as an array of digits,

add 1 to the number ( increment the number represented by the digits ).

The digits are stored such that the most significant digit is at the head of the list.
 */


import java.util.ArrayList;
import java.util.Arrays;

public class AddOneToNumber {
    public static ArrayList<Integer> plusOne(ArrayList<Integer> A) {
        //variables
        int i = 0;

        //positioning index 0 to start with a digit instead of 0
        while (A.get(i) == 0) {
            if(A.size() == 1){
                break;
            }
            A.remove(i);
        }

        //logical work
        for (int j = A.size() - 1; j >= 0; j--) {
            if (j == 0) {
                if (A.get(j) == 9) {
                    A.set(0, 0);
                    A.add(0, 1);
                    break;
                } else {
                    A.set(j, A.get(j) + 1);
                    break;
                }
            }
            if (A.get(j) != 9) {
                A.set(j, A.get(j) + 1);
                break;
            } else {
                A.set(j, 0);
                continue;
            }

        }
        return A;
    }


    public static void main(String[] args) {

        ArrayList<Integer> A = new ArrayList<>(Arrays.asList(0,0,9,9,9));
        System.out.println(plusOne(A));
    }


}

