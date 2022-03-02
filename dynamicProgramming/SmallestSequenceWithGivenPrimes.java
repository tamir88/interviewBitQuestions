package dynamicProgramming;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class SmallestSequenceWithGivenPrimes {
    public ArrayList solve(int A, int B, int C, int D) {

        ArrayList<Integer> res = new ArrayList<>();

        PriorityQueue<Integer> q = new PriorityQueue<>();
        q.add(A);
        q.add(B);
        q.add(C);

        while(!q.isEmpty() && D>0){
            int temp=q.poll();
            while(!q.isEmpty() && q.peek()==temp){
                q.poll();
            }
            res.add(temp);
            D--;

            q.add(temp*A);
            q.add(temp*B);
            q.add(temp*C);

        }
        return res;
    }

    public static void main(String[] args) {
        SmallestSequenceWithGivenPrimes a = new SmallestSequenceWithGivenPrimes();
        System.out.println(a.solve(2,3,5,5));
    }
}


