package bitWise;

public class SingleNumber {

    public int singleNumber(final int[] A) {
        int result = 0;
        for (int temp : A)
            result ^= temp;
        return result;
    }

    public static void main(String[] args) {
        SingleNumber a = new SingleNumber();
        int[] s = new int[]{1,2,1,2,4};
        System.out.println(a.singleNumber(s));
    }


}
