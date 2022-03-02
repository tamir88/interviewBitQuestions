package arrays;

import java.util.ArrayList;
import java.util.Collections;

public class HotelBookingsPossible {

    public class Pair implements Comparable<Pair>{
        int x;
        boolean depart;

        public Pair(int x, boolean depart){
            this.x = x;
            this.depart = depart;
        }

        @Override
        public int compareTo(Pair pair) {
            if(this.x == pair.x){
                if(this.depart && !pair.depart)
                    return -1;
                else
                    return 0;
            }
            else if(this.x > pair.x)
                return 1;
            else
                return -1;
        }
    }

    public boolean hotel(ArrayList<Integer> arrive, ArrayList<Integer> depart, int K){
            ArrayList<Pair> arr = new ArrayList<>();
            for(int temp : arrive)
                arr.add(new Pair(temp,false));
            for(int temp : depart)
                arr.add(new Pair(temp, true));
        Collections.sort(arr);
        for(Pair temp : arr){
            if(!temp.depart)
                K--;
            else {
                K++;
                continue;
            }
            if(K < 0)
                return false;
        }
        return true;
    }
}
