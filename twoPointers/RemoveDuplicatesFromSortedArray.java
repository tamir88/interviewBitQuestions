package twoPointers;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class RemoveDuplicatesFromSortedArray {

    public int removeDuplicates(ArrayList<Integer> a) {
        //
        if(a.isEmpty())
            throw new IllegalArgumentException("array is empty");

        //variables
        Queue<Integer> q = new LinkedList<>();
        int val = a.get(0);

        for(int i=1; i<a.size(); i++){
            if(a.get(i) == val){
                q.add(i);
            }
            else{
                val = a.get(i);
                if(!q.isEmpty()){
                    q.add(i);
                    a.set(q.remove(), val);
                }
            }
        }
        return (a.size() - q.size());
    }


}
