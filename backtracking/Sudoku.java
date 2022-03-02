package backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

public class Sudoku {
    ArrayList<HashSet<Character>> row;
    ArrayList<HashSet<Character>> col;
    ArrayList<HashSet<Character>> cubes;
    boolean goal;



    public void solveSudoku(ArrayList<ArrayList<Character>> a) {
        row = new ArrayList<>();
        col = new ArrayList<>();
        cubes = new ArrayList<>();
        for(int i=0; i<9; i++) {
            row.add(new HashSet<Character>());
            col.add(new HashSet<Character>());
            cubes.add(new HashSet<Character>());
        }
        goal = false;
        firstUpdate(a);
        solveSudoku(0, 0, a);
    }


    public void solveSudoku(int r, int j, ArrayList<ArrayList<Character>> a){

        if( r == 9){
            goal =  true;
            return;
        }

            if(a.get(r).get(j) == '.'){
                for(int number=1; number<10; number++){
                    char num = (char)(number + '0');
                    if(isValid(r, j, num)){
                        update(false, r, j, num, a);
                        if(j == 8)
                            solveSudoku(r+1,0, a);
                        else
                            solveSudoku(r,j+1, a);

                        if(goal)
                            return;
                        else
                            update(true,r,j,num,a);
                    }
                }
            }
            else if (j == 8)
                solveSudoku(r+1,0, a);
            else
                solveSudoku(r,j+1, a);
    }

    private void update(boolean del, int r, int j, char num, ArrayList<ArrayList<Character>> a){
        if(del){
            col.get(j).remove(num);
            row.get(r).remove(num);
            cubes.get(cubeIndex(r,j)).remove(num);
            a.get(r).set(j,'.');
        }
        else{
            col.get(j).add(num);
            row.get(r).add(num);
            cubes.get(cubeIndex(r,j)).add(num);
            a.get(r).set(j,num);
        }
    }

    private Boolean isValid(int r, int j, char num){
        if( col.get(j).contains(num) || row.get(r).contains(num) || cubes.get(cubeIndex(r,j)).contains(num))
            return false;
        else
            return true;
    }



    private void firstUpdate(ArrayList<ArrayList<Character>> a){
        for(int i=0; i<a.size(); i++)
            for(int j=0; j<a.get(i).size(); j++){
                char temp = a.get(i).get(j);
                if(temp != '.'){
                    col.get(j).add(temp);
                    row.get(i).add(temp);
                    cubes.get(cubeIndex(i, j)).add(temp);
                }
            }
    }

    private int cubeIndex(int i, int j){
        if(i<3 && j<3)
            return 0;
        if(i<3 && j>2 && j<6)
            return 1;
        if(i<3 && j>5)
            return 2;
        if(i>2 && i<6 && j<3)
            return 3;
        if(i>2 && i<6 && j>2 && j<6)
            return 4;
        if(i>2 && i<6 && j>5)
            return 5;
        if(i>5 && j<3)
            return 6;
        if(i>5 && j>2 && j<6)
            return 7;
        else
            return 8;
    }

    public static void main(String[] args) {

        Sudoku a = new Sudoku();
        ArrayList<ArrayList<Character>> b = new ArrayList<>();
        b.add(new ArrayList<>(Arrays.asList('5','3','.','.','7','.','.','.','.')));
        b.add(new ArrayList<>(Arrays.asList('6','.','.','1','9','5','.','.','.')));
        b.add(new ArrayList<>(Arrays.asList('.','9','8','.','.','.','.','6','.')));
        b.add(new ArrayList<>(Arrays.asList('8','.','.','.','6','.','.','.','3')));
        b.add(new ArrayList<>(Arrays.asList('4','.','.','8','.','3','.','.','1')));
        b.add(new ArrayList<>(Arrays.asList('7','.','.','.','2','.','.','.','6')));
        b.add(new ArrayList<>(Arrays.asList('.','6','.','.','.','.','2','8','.')));
        b.add(new ArrayList<>(Arrays.asList('.','.','.','4','1','9','.','.','5')));
        b.add(new ArrayList<>(Arrays.asList('.','.','.','.','8','.','.','7','9')));
        a.solveSudoku(b);
        System.out.println(b);

    }


}
