package Greedy;

import java.util.ArrayList;
import java.util.Arrays;


public class HighestProduct {
    public int maxp3(ArrayList<Integer> A) {
        ArrayList<Integer> copyA = new ArrayList<>(A);
        int resA = 1;
        int resB = 1;
        int resA1;
        int resA2;

        // CASE 1
        if(A.size() < 4){
            for (int temp : A)
                resA *= temp;
            return resA;
        }
        for(int i=0;i<2;i++){
            resA *= copyA.remove(maxMinIndex(false,copyA));
        }
        resA1 = resA;
        resA2 = resA;
        resA1 *= copyA.remove(maxMinIndex(false,copyA));
        resA2 *= copyA.remove(maxMinIndex(true,copyA));
        resA = (resA1 > resA2) ? resA1 : resA2;

        for(int i=0;i<3;i++){
            resB *= A.remove(maxMinIndex(true,A));
        }

        return (resA > resB) ? resA : resB;
    }

    private int maxMinIndex(boolean max, ArrayList<Integer> A){
        int inx = 0;
        if(max) {
            for (int i = 1; i < A.size(); i++) {
                if (A.get(inx) < A.get(i))
                    inx = i;
            }
        }
        else
        {
            for (int i = 1; i < A.size(); i++) {
                if (A.get(inx) > A.get(i))
                    inx = i;
            }
        }
        return inx;
    }

    public static void main(String[] args) {
        HighestProduct a = new HighestProduct();
        System.out.println(a.maxp3(new ArrayList<>(Arrays.asList(-10000000, 1, 2, 3, 4 ))));
    }
}
