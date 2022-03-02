package arrays;

import java.util.ArrayList;
import java.util.Arrays;

public class KthRowofPascalsTriangle {
    public ArrayList<Integer> getRow(int A) {
        ArrayList<Integer> ans = new ArrayList<>();
        if(A == 0){
            ans.add(1);
            return ans;
        }
        ans.add(1);
        ans.add(1);
        int temp;

        for( int i=1; i<=A-1; i++){
            for(int j=ans.size()-1; j>0; j--){
                temp = ans.get(j)+ ans.get(j-1);
                ans.set(j, temp);
            }
            ans.add(1);
        }
        return ans;
    }

    public static void main(String[] args) {
        KthRowofPascalsTriangle r = new KthRowofPascalsTriangle();
        System.out.println(Arrays.toString(r.getRow(3).toArray()));
    }

}
