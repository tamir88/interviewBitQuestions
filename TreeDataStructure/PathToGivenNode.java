package TreeDataStructure;
import java.util.ArrayList;

public class PathToGivenNode {
    boolean hit = false;

    public ArrayList<Integer> solve(TreeNode A, int B) {
        //variables
        ArrayList<Integer> res = new ArrayList<>();

        //body algorithm
        func(A,B,res);
        return res;
    }

    //recursion method in order to find the path from root to Node B
    private void func(TreeNode A, int B, ArrayList<Integer> res){
        //base case
        if(A == null)   return;
        if(A.val == B){
            hit = true;
            res.add(A.val);
            return;
        }
        //variables

        //recursion section (backtracking version)
        res.add(A.val);
        func(A.left,B, res);
        if(!hit){
            func(A.right,B, res);
            if(!hit) {
                int lastElement = res.size()-1;
                res.remove(lastElement);
            }
        }
    }

    public static void main(String[] args) {
        PathToGivenNode a = new PathToGivenNode();
        System.out.println(a.solve(new TreeNode(1,new TreeNode(4,new TreeNode(2,null,null)
                , new TreeNode(3,null,null)),new TreeNode(5,new TreeNode(6,null,null),
                new TreeNode(7,null,null))),3));
    }


}
