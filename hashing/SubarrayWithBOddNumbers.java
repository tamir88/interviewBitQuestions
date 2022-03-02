package hashing;

import java.util.ArrayList;
import java.util.HashMap;

public class SubarrayWithBOddNumbers {
    public int solve(ArrayList<Integer> A, int B) {
        convertTheArray(A);// converting the array

        HashMap<Integer, Integer> m = new HashMap<>();
        m.put(0,1);
        int diff;
        int sum = 0;
        int res = 0;
        for (int cur : A) {
            sum += cur;
            diff = sum -B;

            if(m.containsKey(diff)) {
                res += m.get(diff);
            }
            if(m.containsKey(sum)) {
                m.put(sum,m.get(sum)+1);
            }
            else
                m.put(sum,1);
        }
        return res;
    }

    private void convertTheArray(ArrayList<Integer> A){
        for ( int i=0;i<A.size();i++ ){
            if(A.get(i) % 2 == 0)
                A.set(i,0);
            else
                A.set(i,1);
        }
    }
}
