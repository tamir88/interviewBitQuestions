package bitWise;

public class NumberofOneBits {

    public int numSetBits(long a) {

        int result = 0;
        while (a > 0){
            a = a & (a-1);
            result++;
        }
        return result;
    }
}
