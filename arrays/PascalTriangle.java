package arrays;

import java.util.ArrayList;
import java.util.Arrays;

public class PascalTriangle {
    public ArrayList<ArrayList<Integer>> solve(int A) {
        ArrayList<ArrayList<Integer>> main = new ArrayList<>();

        switch (A){
            case 0:
                return main;
            case 1:
                main.add(new ArrayList<Integer>(Arrays.asList(1)));
                return main;
            case 2:
                main.add(new ArrayList<>(Arrays.asList(1)));
                main.add(new ArrayList<>(Arrays.asList(1,1)));
                return main;
        }
        main.add(new ArrayList<>(Arrays.asList(1)));
        main.add(new ArrayList<>(Arrays.asList(1,1)));
        int temp2;
        for(int i=1; i<A-1; i++){
            ArrayList<Integer> temp = new ArrayList<>(main.get(i));
            for(int j=temp.size()-1; j>0; j--){
                temp2 = temp.get(j)+ temp.get(j-1);
                temp.set(j, temp2);
            }
            temp.add(1);
            main.add(temp);
        }

        return main;
    }

    public static void main(String[] args) {
        PascalTriangle r = new PascalTriangle();
        for(ArrayList<Integer> temp : r.solve(3))
            System.out.println(Arrays.toString(temp.toArray()));
    }
}
