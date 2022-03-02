package arrays;
/*You are given a read only array of n integers from 1 to n.
Each integer appears exactly once except A which appears twice and B which is missing.
Return A and B.
 Note: Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?
Note that in your output A should precede B.*/

import java.util.ArrayList;
import java.util.List;

public class RepeatAndMissingNumberArray {
    public ArrayList<Integer> repeatedNumber(final List<Integer> A) {
        ArrayList<Integer> lis = new ArrayList<>(A);
        ArrayList<Integer> ans = new ArrayList<>();
        int a = findA(lis);
        int diff = findDiff(lis);
        int b = a + diff;
        ans.add(a);
        ans.add(b);
        return ans;
    }

    private int findDiff(ArrayList<Integer> A){
        int a = 0;
        int b = 0;
        for(int i=1; i<A.size()+1; i++){
            a += i;
        }
        for(int temp : A)
            b += temp;
        return a-b;
    }

    private int findA(ArrayList<Integer> A){
        for(int i=0; i<A.size(); i++){
            if(A.get(i) != i+1){
                if(A.get(i) == A.get(A.get(i)-1))
                    return A.get(i);
                else {
                    swap(i, A.get(i) - 1, A);
                    i--;
                }
            }
        }
        return -1;
    }
    // swapping betewing elements
    private void swap(int i, int j, ArrayList<Integer> A){
        int temp;
        temp = A.get(i);
        A.set(i, A.get(j));
        A.set(j, temp);
    }
}
