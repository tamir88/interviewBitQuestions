package arrays;
/*Given a matrix, A of size M x N of 0s and 1s. If an element is 0, set its entire row and column to 0.
Note: This will be evaluated on the extra memory used. Try to minimize the space and time complexity.*/

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Objects;

public class SetMatrixZeros {

    public class RowAndColum{
        int row;
        int colum;

        RowAndColum(int row, int colum){
            this.row = row;
            this.colum = colum;
        }

        @Override
        public int hashCode() {
            return Objects.hash(row, colum);
        }

        @Override
        public boolean equals(Object obj){
            if(this == obj)
                return true;
            RowAndColum temp = (RowAndColum)obj;
            if(this.row == temp.row || this.colum == temp.colum)
                return true;
            else
                return false;
        }
    }
    public void setZeroes(ArrayList<ArrayList<Integer>> a) {
        HashSet<RowAndColum> set = new HashSet<>();
        findZero(a, set);
        modifyArray(a, set);
    }

    private void findZero(ArrayList<ArrayList<Integer>> a, HashSet<RowAndColum> set){
        for(int i=0; i<a.size(); i++){
            for (int j=0; j<a.get(0).size(); j++){
                if(a.get(i).get(j) == 0){
                    set.add(new RowAndColum(i, j));
                }
            }
        }
    }

    private void modifyArray(ArrayList<ArrayList<Integer>> a, HashSet<RowAndColum> set){
        for(RowAndColum temp : set){
            for(int i=0; i<a.get(0).size(); i++)
                a.get(temp.row).set(i, 0);
            for(int j=0; j<a.size(); j++)
                a.get(j).set(temp.colum, 0);
        }
    }

}
