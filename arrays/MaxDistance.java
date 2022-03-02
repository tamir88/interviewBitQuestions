package arrays;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MaxDistance {
    public class Pairs implements Comparable<Pairs>{
        int x;
        int index;

        public Pairs(int x, int index){
            this.x = x;
            this.index = index;
        }


        @Override
        public int compareTo(Pairs p) {
            if(this.x == p.x)
                return 0;
            else if(this.x > p.x)
                return 1;
            else
                return -1;
        }
    }

    public int maximumGap(final List<Integer> A) {
        ArrayList<Pairs> arr = new ArrayList<>();

        for(int i=0; i<A.size(); i++ )
            arr.add(new Pairs(A.get(i), i));

        Collections.sort(arr);
        int ans = 0;
        int min = Integer.MAX_VALUE;
        for(int i=0; i<arr.size(); i++){
            min = Math.min(arr.get(i).index, min);
            ans = Math.max(ans, arr.get(i).index - min);
        }
        return ans;
    }

}
