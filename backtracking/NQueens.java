package backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

public class NQueens {
    // global variable
    ArrayList<ArrayList<Integer>> ans = new ArrayList<>();


    public ArrayList<ArrayList<String>> solveNQueens(int a) {
        HashSet<Integer> col = new HashSet<>();
        HashSet<Integer> posDiag = new HashSet<>();
        HashSet<Integer> negDiag = new HashSet<>();
        ArrayList<Integer> validRow = new ArrayList<>();
        solveNQueens(a, 0, col, posDiag, negDiag, validRow);
        return convert(a);
    }

    //recursive func backtracking method
    private void solveNQueens(int n, int row, HashSet col, HashSet posDiag, HashSet negDiag, ArrayList<Integer> validRow){

        if(validRow.size() == n){
            ans.add(new ArrayList<>(validRow));
            return;
        }
        for(int j=0; j<n; j++){
            if(isValid(j, row, col, posDiag, negDiag, validRow)){
                update(false, j, row, col, posDiag, negDiag, validRow);
                solveNQueens(n, row+1, col, posDiag, negDiag, validRow);
                update(true, j, row, col, posDiag, negDiag, validRow);
            }
        }
    }

    private Boolean isValid(int j, int row, HashSet<Integer> col, HashSet<Integer> posDiag, HashSet<Integer> negDiag, ArrayList<Integer> validRow){
        int posD = row + j;
        int negD = row - j;

        if((col.contains(j) || posDiag.contains(posD) || negDiag.contains(negD)))
            return false;
        else{
            return true;
        }
    }

    private void update(boolean delete, int j, int row, HashSet<Integer> col, HashSet<Integer> posDiag, HashSet<Integer> negDiag, ArrayList<Integer> validRow){
        int posD = row + j;
        int negD = row - j;

        if(delete){
            col.remove(j);
            posDiag.remove(posD);
            negDiag.remove(negD);
            validRow.remove(row);

        }
        else{
            col.add(j);
            posDiag.add(posD);
            negDiag.add(negD);
            validRow.add(row, j);
        }
    }

    private ArrayList<ArrayList<String>> convert(int n){
        ArrayList<ArrayList<String>> s = new ArrayList<>();
        ArrayList<String> a = new ArrayList<>();
        char[] ro = new char[n];
        Arrays.fill(ro,'.');

        for(int i=0; i<ans.size(); i++){
            for(int j=0; j<ans.get(i).size(); j++){
                ro[ans.get(i).get(j)] = 'Q';
                a.add(new String(ro));
                ro[ans.get(i).get(j)] = '.';
            }
            s.add(new ArrayList<>(a));
            a.clear();
        }
        return s;
    }

    public static void main(String[] args) {
        NQueens s = new NQueens();
        System.out.println(s.solveNQueens(4));
    }
}
