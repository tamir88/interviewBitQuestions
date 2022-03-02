package arrays;/*Implement the next permutation, which rearranges numbers into the numerically next greater permutation of numbers for a given array A of size N.
If such arrangement is not possible, it must be rearranged as the lowest possible order i.e., sorted in an ascending order.*/


import java.util.ArrayList;
import java.util.Arrays;

public class NextPermutation {

    public ArrayList<Integer> nextPermutation(ArrayList<Integer> A) {
        int index = findFirstIndex(A);
        if(index == -1){
            sortRightArray(A, 0);
            return A;
        }
        sweapFirstIndex(A, index);
        sortRightArray(A, index+1);
        return A;
    }

    // this method find the first index to be sweap return -1 if no such index
    private int findFirstIndex(ArrayList<Integer> A) {
        for (int i = A.size() - 1; i > 0; i--) {
            if (A.get(i) > A.get(i - 1))
                return i - 1;
        }
        return -1; // there is no such index
    }

    //sweap only the first pair
    private void sweapFirstIndex(ArrayList<Integer> A, int index) {
        int temp;
        for (int i = A.size() - 1; i > index; i--) {
            if (A.get(i) > A.get(index)) {
                temp = A.get(index);
                A.set(index, A.get(i));
                A.set(i, temp);
                break;
            }
        }
    }

    //method takes array and index and sort the right part from index of the array
    private void sortRightArray(ArrayList<Integer> A, int index) {
        int temp;
        int i = index;
        int j = A.size() - 1;
        while (i < j) {
            temp = A.get(i);
            A.set(i, A.get(j));
            A.set(j, temp);
            i++;
            j--;
        }
    }

    public static void main(String[] args) {
        NextPermutation B = new NextPermutation();
        ArrayList<Integer> A = new ArrayList<>(Arrays.asList(2,1,4,3));
        System.out.println(Arrays.toString(B.nextPermutation(A).toArray()));
    }
}



