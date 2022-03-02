package HeapsAndMaps;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class KLargestElements {
    public ArrayList<Integer> solve(ArrayList<Integer> A, int B) {

        //base case
        if(B == A.size())   return A;

        // variables
        ArrayList<Integer> res = new ArrayList<>();
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        // insert B element into priorityQueue
        for(int i=0; i<B;i++)
            pq.add(A.get(i));

        // insert only if elment is bigger than the root
        for(int i=B;i<A.size();i++){
            int cur = A.get(i);
            if(cur > pq.peek()){
                pq.poll();
                pq.add(cur);
            }
        }

        while(!pq.isEmpty()){
            res.add(pq.poll());
        }
        return res;
    }

}
