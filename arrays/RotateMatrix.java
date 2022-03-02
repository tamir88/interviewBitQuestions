package arrays;/*You are given an n x n 2D matrix representing an image.
Rotate the image by 90 degrees (clockwise).
You need to do this in place.
 Note that if you end up using an additional array, you will only receive partial score.*/

import java.util.ArrayList;

public class RotateMatrix {
    public void rotate(ArrayList<ArrayList<Integer>> a) {
        int N = a.size();
        transpose(N, a);
        sweapHorizontal(N, a);
    }

    private void transpose(int N, ArrayList<ArrayList<Integer>> a){
        int temp;
        for(int i=0; i<N; i++){
            for(int j=i; j<N; j++){
                temp = a.get(i).get(j);
                a.get(i).set(j,a.get(j).get(i));
                a.get(j).set(i, temp);
            }
        }
    }

    private void sweapHorizontal(int N, ArrayList<ArrayList<Integer>> a){
        int temp;
        for(int i=0; i<N; i++)
            for(int j=0; j<(N/2); j++){
                temp = a.get(i).get(j);
                a.get(i).set(j, a.get(i).get(N-1-j));
                a.get(i).set(N-1-j, temp);
            }
    }


}
