package arrays;/*Problem Description
You are given a 1D integer array B containing A integers.
Count the number of ways to split all the elements of the array into 3 contiguous parts so that the sum of elements in each part is the same.
Such that : sum(B[1],..B[i]) = sum(B[i+1],...B[j]) = sum(B[j+1],...B[n])*/


import java.util.ArrayList;
import java.util.Arrays;

public class Partitions {
    //main method for the problem
    public int solve(int A, ArrayList<Integer> B) {
        int oneTherd = sumOfArray(B);
        if( A<3 || oneTherd == -1) // possibility check
            return 0;
        ArrayList<Integer> suffix = makeSuffix(oneTherd, B);
        int ans = numOfPartitions(suffix, B, oneTherd);
        return ans;

    }
    // this method takes array calculate the sum of all integer checks if the total sum dividing in 3 if so return
    // one therd of th sum if not return -1
    private int sumOfArray(ArrayList<Integer> B){
        int sum = 0;
        for(int temp: B)
            sum += temp;
        if(sum % 3 != 0)
            return -1;
        else
            return sum/3;
    }
    // this method takes the array and return suffix array which indexing 1 where the sum is one therd as needed
    private ArrayList<Integer> makeSuffix(int oneTherd, ArrayList<Integer> B){
        int sum = 0;
        ArrayList<Integer> A = new ArrayList<>();
        for( int i = B.size()-1; i > -1; i-- ){
            sum += B.get(i);
            if( sum == oneTherd)
                A.add(0, 1);
            else
                A.add(0, 0);
        }
        return A;
    }
    // this method checks if there is first partition with the sum we want if so it check if 3th partition is exsist
    private int numOfPartitions(ArrayList<Integer> A, ArrayList<Integer> B, int oneTherd){
        int sum = 0;
        int totalNum = 0;
        for(int i = 0; i<B.size()-2; i++){
            sum += B.get(i);
            if(sum == oneTherd)
                for(int j=i+2; j<A.size(); j++){
                    if(A.get(j) == 1)
                        totalNum++;
                }
        }
        return totalNum;
    }

    public static void main(String[] args) {
        Partitions A = new Partitions();
        ArrayList<Integer> B = new ArrayList<>(Arrays.asList(1,2,3,0,3));
        System.out.println(A.solve(5,B));
    }


}
