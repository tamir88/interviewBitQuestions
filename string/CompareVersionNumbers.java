package string;

public class CompareVersionNumbers {

    public int compareVersion(String A, String B) {
        if (A == null || B == null || A.charAt(0) == '.' || B.charAt(0) == '.' )
            throw new IllegalArgumentException("A or B are null or dot at first argument in A or B ");
        int l = 0;
        int r = 0;
        int n = A.length();
        int m = B.length();
        Boolean f = false;
        int left = 0;

        // ignore zeros at the first string
        l = ignoreZeros(A, 0);
        r = ignoreZeros(B, 0);

        while (l < n && r < m){
            if (A.charAt(l) == B.charAt(r)){
                if(A.charAt(l) == '.'){
                    if(left == 1)
                        return 1;
                    if(left == 2)
                        return -1;

                    l = ignoreZeros(A, ++l);
                    r = ignoreZeros(B, ++r);
                    continue;
                }
                l++;
                r++;
            }
            else{
                if(A.charAt(l) == '.')
                    return -1;
                if(B.charAt(r) == '.')
                    return 1;
                while (!f) {
                    if (A.charAt(l) > B.charAt(r)){
                        left = 1;
                    }
                    else
                        left = 2;
                    f = true;
                }
                l++;
                r++;
            }
        }
        while (l < n){
            if(A.charAt(l) == '.') {
                switch (left){
                    case 1:
                        return 1;
                    case 2:
                        return -1;
                }
                l = ignoreZeros(A, ++l);
                continue;
            }
            return 1;
        }
        while (r < m){
            if(B.charAt(r) == '.'){
                switch (left){
                    case 1:
                        return 1;
                    case 2:
                        return -1;
                }
                r = ignoreZeros(B, ++r);
                continue;
            }
            return -1;
        }
        if(left == 1)
            return 1;
        if(left == 2)
            return -1;
        return 0;
    }
    private int ignoreZeros(String a, int low){
        while (low < a.length() && a.charAt(low) == '0'){
            low++;
        }
        return low;
    }

    public static void main(String[] args) {
        CompareVersionNumbers a = new CompareVersionNumbers();
        System.out.println(a.compareVersion("9", "6.61154768574.1982"));
    }
}
