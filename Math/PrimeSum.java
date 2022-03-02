package Math;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;

public class PrimeSum {
    public ArrayList<Integer> primesum(int A) {
        ArrayList<Integer> ans = new ArrayList<>();
        ArrayList<Integer> allPrimes = primeNum(A);
        HashSet<Integer> isHere = new HashSet<>(allPrimes);

        for(int temp : allPrimes){
            if(isHere.contains(A-temp)){
                ans.add(temp);
                ans.add(A-temp);
                break;
            }
        }
        return ans;
    }

    private ArrayList<Integer> primeNum(int N){
        ArrayList<Boolean> isPrime = new ArrayList<>(Arrays.asList(new Boolean[N]));
        ArrayList<Integer> prime = new ArrayList<>();
        ArrayList<Integer> SPF = new ArrayList<>(Arrays.asList(new Integer[N]));

        Collections.fill(SPF,0);
        Collections.fill(isPrime,true);

        for(int i=2; i<N; i++){
            if(isPrime.get(i)){
                prime.add(i);
                SPF.set(i,i);
            }
            for(int j=0; j<prime.size() && i*prime.get(j)<N && prime.get(j)<=SPF.get(i); j++){
                isPrime.set(i*prime.get(j), false);
                SPF.set(i*prime.get(j), prime.get(j));
            }
        }
        return prime;
    }

    public static void main(String[] args) {
        PrimeSum r = new PrimeSum();
        System.out.println(r.primesum(16777214));
    }



}

