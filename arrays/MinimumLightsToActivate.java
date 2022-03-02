package arrays;/*
    Problem Description

There is a corridor in a Jail which is N units long. Given an array A of size N. The ith index of this array is 0 if the light at ith position is faulty otherwise it is 1.

All the lights are of specific power B which if is placed at position X, it can light the corridor from [ X-B+1, X+B-1].

Initially all lights are off.

Return the minimum number of lights to be turned ON to light the whole corridor or -1 if the whole corridor cannot be lighted.
 */

public class MinimumLightsToActivate {
    //using overload and recursion
    public static int solve(int[] A, int B){
        int result = solve(A,B,0,B-1,0);
        if( result == -1) {
            return -1;
        }
        else return result;
    }
    // overload method using more variables as arguments
    private static int solve(int[] A, int B, int p_left, int p_piv, int counter) {

        //variables to initialize before every call
        int p_right = A.length-B; // gives indication for the end condition
        int result = 0; // store the final result

        if(B > A.length){ //handling edge case
            for(int i = A.length-1; i>=0; i--){ // moving over the array to find only one 1
                if(A[i]==1){
                    return 1;
                }
            }
            return -1;
        }

        if(p_left > p_right){// stop condition indicates job done
            return counter;
        }
        if(p_piv >A.length-1){//keeps boundaries's array
            p_piv = A.length-1;
        }
        for(int i = p_piv; i >= p_left; i--){// searching for 1's in the array

            if(A[i]==1){
                result = solve(A, B, i+1, i+(2*B)-1,counter+1);//send to itself to find the next section
                if(result == -1){
                    continue;
                }
                else {
                    return result;
                }

            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] A = new int[] {  1, 1, 1 };
        System.out.println(solve(A, 6));
    }

}
