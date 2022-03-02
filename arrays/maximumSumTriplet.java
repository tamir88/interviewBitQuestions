package arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.TreeSet;

public class maximumSumTriplet {

        public static int solve(ArrayList<Integer> A) {
            //variables
            int n = A.size();
            int ans = 0;
            ArrayList<Integer> arrS = new ArrayList<Integer>(n);
            int maxS = A.get(n - 1);
            arrS.add(0,A.get(n - 1));
            TreeSet<Integer> tree = new TreeSet<Integer>();
            tree.add(A.get(0));


            // building suffix array
            for (int i = n - 2; i > -1; i--) {
                if (A.get(i) > maxS) {
                    maxS = A.get(i);
                    arrS.add(0, maxS);
                }
                else {
                    arrS.add(0, maxS);
                }

            }

            for (int i = 1; i < n - 1; i++) {
                Integer maxL = tree.floor(A.get(i)-1);
                if (maxL == null || A.get(i) >= arrS.get(i + 1)) {
                    tree.add(A.get(i));
                    continue;
                }
                else {
                    if (ans < maxL + A.get(i) + arrS.get(i + 1)) {
                        ans = maxL + A.get(i) + arrS.get(i + 1);
                    }
                    tree.add(A.get(i));
                }
            }
            return ans;
        }


        public static void main(String[] args) {
            ArrayList<Integer> A = new ArrayList<Integer>(Arrays.asList(14310, 7617, 18936, 17452, 20601, 5250, 16520, 31557, 22799, 30304, 6225, 11009, 5845, 32610));
            System.out.println( solve(A) );
        }
    }



