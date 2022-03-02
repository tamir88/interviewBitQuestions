package Greedy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;

public class MeetingRooms {
    public int solve(ArrayList<ArrayList<Integer>> A) {
        Collections.sort(A, new Comparator<ArrayList<Integer>>() {
            @Override
            public int compare(ArrayList<Integer> t1, ArrayList<Integer> t2) {
                return t1.get(0) - t2.get(0);
            }
        });

        PriorityQueue<ArrayList<Integer>> pq = new PriorityQueue<>(new Comparator<ArrayList<Integer>>() {
            @Override
            public int compare(ArrayList<Integer> t1, ArrayList<Integer> t2) {
                return t1.get(1) - t2.get(1);
            }
        });
        pq.add(A.get(0));
        for (int i=1; i<A.size(); i++) {
            ArrayList<Integer> curr = A.get(i);
            ArrayList<Integer> prev = pq.poll();
            if(curr.get(0) < prev.get(1)){
                pq.add(curr);
            }
            else {
                prev.set(1, curr.get(1));
            }
            pq.add(prev);
        }
        return pq.size();
    }
}
