package string;

public class PalindromeString {

    public int isPalindrome(String A) {
        int low = 0;
        int high = A.length() - 1;
        String s = A.toLowerCase();

        while (low < high){
            if (!Character.isLetterOrDigit(s.charAt(low))){
                low++;
                continue;
            }
            if (!Character.isLetterOrDigit(s.charAt(high))){
                high--;
                continue;
            }
            if (s.charAt(low) == s.charAt(high)){
                low++;
                high--;
            }
            else
                return 0;

        }
        return 1;
    }


    public static void main(String[] args) {
        PalindromeString r = new PalindromeString();
        String s = "A man, a plan, a canal: Panama";
        System.out.println(r.isPalindrome(s));
    }
}
