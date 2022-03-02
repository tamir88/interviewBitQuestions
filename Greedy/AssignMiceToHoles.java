package Greedy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class AssignMiceToHoles {
    public int mice(ArrayList<Integer> A, ArrayList<Integer> B) {
        Collections.sort(A);
        Collections.sort(B);
        int max_steps = 0;
        for(int i=0;i<A.size();i++){
            max_steps = Math.max(max_steps, Math.abs(A.get(i) - B.get(i)));
        }
        return max_steps;
    }

    public static void main(String[] args) {
        AssignMiceToHoles a = new AssignMiceToHoles();
        System.out.println(a.mice(new ArrayList<>(Arrays.asList(-4, 2, 3)), new ArrayList<>(Arrays.asList(0, -2, 4))));
    }

}
