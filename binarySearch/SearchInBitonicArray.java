package binarySearch;

import java.util.Arrays;

public class SearchInBitonicArray {
    public int solve(int[] A, int B) {
        int pivot = findpivot(A, 0, A.length-1);
        int res = binarySearch(A, 0, pivot, B, true);
        return res == -1 ? binarySearch(A, pivot, A.length-1, B, false) : res;
    }

    // recursive func which finds the spacial element in the array
    private int findpivot(int[] a, int low, int high){

        //base condition
        if(low <= high){

            int mid = low + (high - low)/2;
            int left = mid - 1;
            int right = mid + 1;

            if(a[mid] > a[left] && a[mid] > a[right])
                return mid; //return the pivot

            if (a[mid] > a[left] && a[mid] < a[right])
                return findpivot(a, mid + 1, high);

            if (a[mid] < a[left] && a[mid] > a[right])
                return findpivot(a, low, mid -1);
            }
        // no such pivot
        return -1;
    }

    private int binarySearch(int[] a, int low, int high, int key, boolean left){
        if(left){
            while (low <= high){

                int mid = low + (high - low)/2;
                if (a[mid] == key)
                    return mid;
                if (a[mid] < key)
                    low = mid + 1;
                else
                    high = mid - 1;
            }
            return -1;
        }
        else{
            while (low <= high){
                int mid = low + (high - low)/2;
                if (a[mid] == key)
                    return mid;
                if (a[mid] < key)
                    high = mid - 1;
                else
                    low = mid + 1;
            }
            return -1;
        }
    }

    public static void main(String[] args) {
        int[] a = new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 20, 19, 18, 17, 16, 15, 14, 13, 12, 11};
        SearchInBitonicArray b = new SearchInBitonicArray();
        System.out.println( b.solve(a, 12));
    }
}
