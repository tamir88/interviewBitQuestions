package arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SpiralOrderMatrix {

    public static ArrayList<Integer> spiralOrder(final List<ArrayList<Integer>> A) {
        ArrayList<Integer> ans = new ArrayList<Integer>();
        // intial dir
        int dir = 0;
        // bonderies
        int T = 0;
        int B = A.size()-1;
        int R = A.get(0).size()-1;
        int L = 0;
        // start moving
        while (B >= T && L <= R){
            if(dir == 0){
                for( int i = L; i <= R; i++){
                    ans.add(A.get(T).get(i));
                }
                T++; // update top
                dir = 1; // update direction
                continue; // check condition again
            }
            if(dir == 1){
                for( int i = T; i<=B; i++){
                    ans.add(A.get(i).get(R));
                }
                R--;
                dir = 2;
                continue;
            }
            if( dir == 2 ){
                for( int i = R; i>=L; i--){
                    ans.add(A.get(B).get(i));
                }
                B--;
                dir = 3;
                continue;
            }
            if(dir == 3){
                for(int i = B; i >= T; i--){
                    ans.add(A.get(i).get(L));
                }
                L++;
                dir = 0;
                continue;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        List<ArrayList<Integer>> A = new ArrayList<>();
       A.add(new ArrayList<>(Arrays.asList(1,2)));
       A.add(new ArrayList<>(Arrays.asList(3,4)));
       A.add(new ArrayList<>(Arrays.asList(5,6)));

       ArrayList<Integer> B = spiralOrder(A);
        System.out.println(B);
    }


}
