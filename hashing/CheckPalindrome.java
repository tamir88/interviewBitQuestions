package hashing;

import java.util.HashMap;

public class CheckPalindrome {
    public int solve(String A) {
        //base case 
        if(A.length() == 1)   return 1;
        
        //algor body
        HashMap<Character,Integer> map = new HashMap<>();
        int numOfOddAppearance = 0;
        for(char ch : A.toCharArray()){
            if(map.containsKey(ch)){
                map.put(ch, map.get(ch)+1);
            }
            else
                map.put(ch,1);
        }
        for(int cur : map.values()){
            if(cur % 2 != 0)
            numOfOddAppearance++;
        }
        return numOfOddAppearance > 1 ? 0 : 1;
    }
}
