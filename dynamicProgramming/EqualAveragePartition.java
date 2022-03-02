package dynamicProgramming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;

public class EqualAveragePartition {
    public ArrayList<ArrayList<Integer>> avgset(ArrayList<Integer> A) {
        ArrayList<Integer> inx;
        Collections.sort(A);

        inx = func(0,0,0,sum(A),A.size(),new ArrayList<>(),A, new HashMap<>());
        return result(inx, A);
    }

    public ArrayList<Integer> func(int i, int sumA, int numA, int sumB, int numB, ArrayList<Integer> inx, ArrayList<Integer> A, HashMap<String,ArrayList<Integer>> q){
        //build String
        String key = i + "," + sumA + "," + inx.size();

        //base cases
        if(q.containsKey(key))              return q.get(key);
        if(inx.size() > (A.size() / 2))     return new ArrayList<>();
        if(isEqual(sumA,numA,sumB,numB))    return new ArrayList<>(inx);
        if(i == A.size())                   return new ArrayList<>();

        //variables
        int newSumA = sumA + A.get(i);
        int newSumB = sumB - A.get(i);

        //recursion
        inx.add(i);
        ArrayList<Integer> left = func(i+1,newSumA,numA+1,newSumB,numB-1,inx,A,q);

        inx.remove(inx.size()-1);
        ArrayList<Integer> right = func(i+1,sumA,numA,sumB,numB,inx,A,q);

        q.put(key,min(left, right));
        return q.get(key);
    }

    private int sum(ArrayList<Integer> A){
        int sum = 0;
        for(int temp : A)
            sum += temp;
        return sum;
    }

    // generate the minimum arrayList
    private ArrayList<Integer> min(ArrayList<Integer> left, ArrayList<Integer> right){
        if(left.isEmpty())      return right;
        if(right.isEmpty())     return left;
        if(left.size() < right.size())
            return left;
        else if(left.size() == right.size()){
            for(int i=0; i<left.size(); i++){
                if(left.get(i) < right.get(i))
                    return left;
                if(right.get(i) < left.get(i))
                    return right;
            }
            return left;
        }
        else
            return right;
    }

    //generate true if avg is equal
    private boolean isEqual(int sumA, int numA, int sumB, int numB){
        if(numA == 0)
            return false;
        else {
            double avgA = (sumA / (double)numA);
            double avgB = (sumB / (double)numB);
            if(avgA == avgB)
                return true;
            else
                return false;
        }
    }

    private ArrayList<ArrayList<Integer>> result(ArrayList<Integer> inx, ArrayList<Integer> B){
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        ArrayList<Integer> A = new ArrayList<>();
        if(inx.isEmpty())   return res;
        for(int index : inx)
            A.add(B.get(index));
        int count = 0;
        for(int index : inx) {
            B.remove(index-count);
            count++;
        }
        res.add(A);
        res.add(B);
        return res;
    }

    public static void main(String[] args) {
        EqualAveragePartition a = new EqualAveragePartition();
        System.out.println(a.avgset(new ArrayList<>(Arrays.asList( 19, 5, 38, 22, 44, 12, 17, 35))));

    }
}
