package Math;

import java.util.ArrayList;

public class NextSimilarNumber {
    public String solve(String A) {
        int index_sec;
        int index = findIndex(A);
        if(index == -1)
            return "-1";
        index_sec = findSecIndex(A.charAt(index), A);
        ArrayList<Character> arr = convert(A);
        swap(index,index_sec, arr);
        arranger(index+1, arr);
        return convertToString(arr);
    }
    private String convertToString(ArrayList<Character> A){
        String str = new String();
        for(Character c : A)
            str+=c;
        return str;
    }

    private void arranger(int j, ArrayList<Character> A){
       int i = A.size()-1;
       while(j<i){
           swap(j,i,A);
           j++;
           i--;
       }
    }

    private int findIndex(String A){
        if(A.length() == 1)
            return -1;
        for(int i=A.length()-2; i>=0; i--){
            if(A.charAt(i) < A.charAt(i+1))
                return i;
        }
        return -1;
    }

    private int findSecIndex(char c, String A){
        for(int i=A.length()-1; i>0; i--){
            if(A.charAt(i) > c)
                return i;
        }
        return -1;
    }

    private void swap(int i, int j, ArrayList<Character> A){
        Character temp = A.get(i);
        A.set(i, A.get(j));
        A.set(j, temp);
    }

    private ArrayList<Character> convert(String A){
        ArrayList<Character> arr = new ArrayList<>();
        for(int i=0; i<A.length(); i++)
            arr.add(A.charAt(i));
        return arr;
    }

    public static void main(String[] args) {
        NextSimilarNumber r = new NextSimilarNumber();
        System.out.println(r.solve("1152"));;
    }

}
