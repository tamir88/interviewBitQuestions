package Math;

public class TotalMovesForBishop {
    public int solve(int A, int B) {
       int left_down = Math.min(8-A, B-1);
       int right_down = Math.min(7-A, 7-B);

       int left_top = Math.min(A-1, B-1);
       int right_top = Math.min(A-1, 8-B);

       return left_down + left_top + right_down + right_top;
    }

    public static void main(String[] args) {
        TotalMovesForBishop a = new TotalMovesForBishop();
        System.out.println(a.solve(4,4));
    }


}
