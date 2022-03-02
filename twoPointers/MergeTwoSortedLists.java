package twoPointers;

import java.util.ArrayList;
import java.util.Arrays;

public class MergeTwoSortedLists {

    public void merge(ArrayList<Integer> a, ArrayList<Integer> b) {
        int p1 = 0;
        int p2 = 0;

        while (p1 < a.size() && p2 < b.size()){
            if(a.get(p1) <= b.get(p2))
                p1++;
            else{
                a.add(p1, b.get(p2));
                p1++;
                p2++;
            }
        }

        while(p2 < b.size()){
            a.add(a.size(), b.get(p2));
            p2++;
        }
    }
}
