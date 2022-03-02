package arrays;/*Given an array of integers, sort the array into a wave like array and return it,
In other words, arrange the elements into a sequence such that a1 >= a2 <= a3 >= a4 <= a5.....*/


import java.util.ArrayList;
import java.util.Collections;

public class WaveArray {
    public ArrayList<Integer> wave(ArrayList<Integer> A) {
        Collections.sort(A);
        for(int i=0; i<A.size()-1; i+=2){
            swap(i,i+1,A);
        }
        return A;
    }

    private void swap(int i, int j, ArrayList<Integer> A){
        int temp = A.get(i);
        A.set(i,A.get(j));
        A.set(j, temp);
    }
}
