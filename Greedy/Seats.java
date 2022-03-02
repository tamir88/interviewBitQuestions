package Greedy;

import java.util.ArrayList;

public class Seats {

        public int seats(String A) {
            if (A.length() < 2) {
                return 0;
            }
            int sum = 0;
            ArrayList<Integer> arr = new ArrayList<>();
            for (int i = 0; i < A.length(); i++) {
                if (A.charAt(i) =='x')
                arr.add(i);
            }
            if (arr.size() == 0)
                return 0;
            int mid = arr.size() / 2;
            int cp = arr.get(mid);
            for (int i = 0; i < arr.size(); i++) {
                int start = arr.get(i);
                int end = cp - mid + i;
                sum = (sum + Math.abs(start - end) % 10000003) % 10000003;
            }
            return sum % 10000003;
        }

    public static void main(String[] args) {
        Seats a = new Seats();
        System.out.println(a.seats("....x..xx...x.."));
    }
}
