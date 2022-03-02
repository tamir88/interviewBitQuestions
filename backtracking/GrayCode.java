package backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class GrayCode {
    public ArrayList<Integer> grayCode(int a) {
        ArrayList<Integer> res = new ArrayList<>();
        double n = (int)Math.pow(2,a);
        for(int i=0; i<n; i++){
            int xor = i >> 1;
            int ans = i ^ xor;
            res.add(ans);
        }
        return res;
    }

    public static void main(String[] args) {
        GrayCode a = new GrayCode();
        System.out.println(a.grayCode(10).size());
    }
}
