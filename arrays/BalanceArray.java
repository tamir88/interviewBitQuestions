package arrays;

public class BalanceArray {
    public int solve(int[] A) {
        int n = A.length;

        //base case
        if(n == 1)
            return 1;

        int[] E_left = new int[n];
        int[] O_left = new int[n];
        int[] E_right = new int[n];
        int[] O_right = new int[n];
        int ans = 0;

        //initializing arrays left and right
        if((n-1) % 2 == 0 )
            E_left[n-1] = A[n-1];
        else
            O_left[n-1] = A[n-1];

        for (int i = n-2; i>=0 ; i--) {
            if(i % 2 == 0) {
                E_left[i] = E_left[i + 1] + A[i];
                O_left[i] = O_left[i + 1];
            }
            else{
                E_left[i] = E_left[i + 1];
                O_left[i] = O_left[i + 1] + A[i];
            }
        }

        E_right[0] = A[0];
        for (int i = 1; i <n;i++) {
            if(i % 2 == 0) {
                E_right[i] = E_right[i - 1] + A[i];
                O_right[i] = O_right[i - 1];
            }
            else{
                E_right[i] = E_right[i - 1];
                O_right[i] = O_right[i - 1] + A[i];
            }
        }

        //first check before looping
        int even = O_left[1];
        int odd = E_left[1];
        if(even == odd)
            ans++;

        //middle checks
        for (int i = 1; i <n-1 ; i++) {
            even = O_left[i+1] +E_right[i-1];
            odd = E_left[i+1] + O_right[i-1];
            if(even == odd)
                ans++;
        }

        //last check
        even = E_right[n-2];
        odd = O_right[n-2];
        if(even == odd)
            ans++;

        return ans;
    }

    public static void main(String[] args) {
        BalanceArray a = new BalanceArray();
        System.out.println(a.solve(new int[]{ 2, 8, 2, 2, 6, 3}));
    }
}
