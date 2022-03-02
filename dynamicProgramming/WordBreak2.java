package dynamicProgramming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

public class WordBreak2 {
    ArrayList<String> res = new ArrayList<>();
    public ArrayList<String> wordBreak(String A, ArrayList<String> B) {
        HashSet<String> dic = new HashSet<>();
        for (String s : B) {
            dic.add(s);
        }
        func(0,1,new ArrayList<>(),A,dic,new HashSet<>());
        return res;
    }

    public void func(int str, int end, ArrayList<String> word, String A, HashSet<String> dic,HashSet<String> s){
        //base case
        if(str == A.length()){
            res.add(createString(word));
            return;
        }
        if(end == A.length()+1)
            return;

        //recursion
        String subString = A.substring(str,end);
        if(dic.contains(subString)){
            word.add(subString);
            func(end,end+1,word,A,dic,s);
            word.remove(word.size()-1);
        }
        func(str,end+1,word,A,dic,s);
    }

    private String createString(ArrayList<String> w){
        StringBuilder s = new StringBuilder();
        for (String s1 : w) {
            s.append(" ").append(s1);
        }
        return s.substring(1);
    }

    public static void main(String[] args) {
        WordBreak2 a = new WordBreak2();
        System.out.println(a.wordBreak("catsanddog",new ArrayList<>(Arrays.asList("cat", "cats", "and", "sand", "dog"))));
    }

}
