package HeapsAndMaps;
import java.util.*;

public class DistinctNumbersInWindow {
    public ArrayList<Integer> dNums(ArrayList<Integer> A, int B) {

        // variables
        ArrayList<Integer> res = new ArrayList<>();
        HashMap<Integer, Integer> m = new HashMap<>();
        int key;
        int addElement = B;
        int removeElement = 0;


        //base case
        if(B == 1){
            for (int i = 0; i < A.size(); i++) {
                res.add(1);
            }
            return res;
        }
        if(B > A.size()){
            return res;
        }
        for (int i = 0; i < B; i++) {
            key = A.get(i);
            if(m.containsKey(key)){
                m.put(key,m.get(key)+1);
            }
            else
                m.put(key,1);
        }

        // first window
        res.add(m.size());
        while ( addElement < A.size()){

            // removing element from map
            key = A.get(removeElement);
            if(m.get(key) == 1)
                m.remove(key);
            else
                m.put(key,m.get(key)-1);

            // adding element to map
            key = A.get(addElement);
            if(m.containsKey(key)){
                m.put(key, m.get(key)+1);
            }
            else
                m.put(key,1);

            // insert distinct element inside the window
            res.add(m.size());

            //set pointers
            addElement++;
            removeElement++;
        }
        return res;
    }

}
