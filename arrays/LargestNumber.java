package arrays;/*Given a list of non negative integers, arrange them such that they form the largest number.
        For example:
        Given [3, 30, 34, 5, 9], the largest formed number is 9534330.*/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LargestNumber {
    // INPUT:List<Integer> OUTPUT:String (largest possible value from from the array as an Integer)
    public String largestNumber(final List<Integer> A) {

        String res;
        ArrayList<String> arr = this.copyMyArray(A);
        quickSort(arr,0,arr.size()-1);
        res = this.arrayToString(arr);
        return res;

    }

    private void quickSort(ArrayList<String> arr, int low, int high)
    {
        if (low < high)
        {

            // pi is partitioning index, arr[p]
            // is now at right place
            int pi = partition(arr, low, high);

            // Separately sort elements before
            // partition and after partition
            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }

    private int partition(ArrayList<String> arr, int low, int high)
    {

        // pivot
        String pivot = arr.get(high);

        // Index of smaller element and
        // indicates the right position
        // of pivot found so far
        int i = (low - 1);

        for(int j = low; j <= high - 1; j++)
        {

            // If current element is smaller
            // than the pivot
            if (this.myCompere(arr.get(j), pivot))
            {
                // Increment index of
                // smaller element
                i++;
                swap(arr, i, j);
            }
        }
        swap(arr, i + 1, high);
        return (i + 1);
    }

    // A utility function to swap two elements
    static void swap(ArrayList<String> arr, int i, int j)
    {
        String temp = arr.get(i);
        arr.set(i,arr.get(j));
        arr.set(j, temp);
    }




    // private method takes 2 Integer as Strings and return true if xy grater or equal from yx
    private boolean myCompere(String x, String y) {
        Double xy = Double.parseDouble(x + y);
        Double yx = Double.parseDouble(y + x);
        if (xy < yx)
            return false;
        else
            return true;
    }

    // private method input Integer array output String array as copy
    private ArrayList<String> copyMyArray(List<Integer> A) {
        ArrayList<String> res = new ArrayList<>();
        for (Integer temp : A) {
            res.add(String.valueOf(temp));
        }
        return res;
    }
    // private method INPUT:arrayString OUTPUT:merge String from the array
    private String arrayToString(ArrayList<String> A){
        String res = "";

        while(A.get(0).equals("0") && A.size() >1 )
            A.remove(0);

        for( String temp : A){
            res += temp;
        }
        return res;
    }



    public static void main(String[] args) {
        ArrayList<Integer> A = new ArrayList<>(Arrays.asList(45,7,87,9));
        LargestNumber R = new LargestNumber();
        System.out.println(R.largestNumber(A));
    }
}

