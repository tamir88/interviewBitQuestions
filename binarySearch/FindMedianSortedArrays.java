package binarySearch;

import java.util.List;

public class FindMedianSortedArrays {
    public double findMedianSortedArrays(final List<Integer> a, final List<Integer> b) {

        //setting a to be the smallest recursively
        if(a.size() > b.size())
            return findMedianSortedArrays(b, a);

        int sizeA = a.size();
        int sizeB = b.size();

        int low = 0;
        int high = sizeA;

        while(low <= high) {
            int partitionA = (low + high) / 2;
            int partitionB = (sizeA + sizeB + 1) / 2 - partitionA;

            int maxLeftA = partitionA == 0 ? Integer.MIN_VALUE : a.get(partitionA - 1);
            int minRightA = partitionA == sizeA ? Integer.MAX_VALUE : a.get(partitionA);

            int maxLeftB = partitionB == 0 ? Integer.MIN_VALUE : b.get(partitionB - 1);
            int minRightB = partitionB == sizeB ? Integer.MAX_VALUE : b.get(partitionB);

            if (maxLeftA <= minRightB && maxLeftB <= minRightA) {
                if ((sizeA + sizeB) % 2 == 0)
                    return ((double) Math.max(maxLeftA, maxLeftB) + Math.min(minRightA, minRightB)) / 2;
                else
                    return (double) Math.max(maxLeftA, maxLeftB);
            } else if (maxLeftA > minRightB)
                        high = partitionA - 1;
                else
                        low = partitionA + 1;
        }
        throw new IllegalArgumentException();
    }
}
