package Math;

import java.util.ArrayList;

public class RearrangeArray {
    public void arrange(ArrayList<Integer> a) {
        int n = a.size();
        int ins = 0;
        for (int i = 0; i < n; i++) {
            int inx = a.get(i);
            int val = a.get(inx);
            ins = inx + (val%n) * n;
            a.set(i,ins);
        }
        for (int i = 0; i < n; i++) {
            ins = a.get(i) / n;
            a.set(i,ins);
        }
    }

}
