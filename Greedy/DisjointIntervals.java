package Greedy;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class DisjointIntervals {
    public int solve(ArrayList<ArrayList<Integer>> A) {
        int max_intervals = 1;
        int total_end_time;
        Collections.sort(A, new Comparator<ArrayList<Integer>>() {
            @Override
            public int compare(ArrayList<Integer> o1, ArrayList<Integer> o2) {
                return o1.get(1) - o2.get(1);
            }
        });
        total_end_time = A.get(0).get(1);
        for(int i=1;i<A.size();i++){
            int start_time_curr = A.get(i).get(0);
            if(start_time_curr > total_end_time){
                max_intervals++;
                total_end_time = A.get(i).get(1);
            }
        }
        return max_intervals;
    }
}
