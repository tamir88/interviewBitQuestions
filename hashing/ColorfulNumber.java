package hashing;

import java.util.HashSet;
import java.util.Set;

public class ColorfulNumber {
    public int colorful(int A) {
        Set st=new HashSet<>();
        String s=String.valueOf(A);
        for(int i=0;i<s.length();i++){
            long x=1;
            for(int j=i;j<s.length();j++){
                int n=s.charAt(j)-'0';
                x*=n;
                if(st.contains(x)){
                    return 0;
                }
                st.add(x);
            }
        }
        return 1;
    }

    public static void main(String[] args) {
        ColorfulNumber b = new ColorfulNumber();
        int a = 3245;
        b.colorful(a);

    }
}
