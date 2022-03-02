package TreeDataStructure;

import java.util.ArrayList;
import java.util.Stack;

public class InorderTraversalOfCartesianTree {
    public TreeNode buildTree(ArrayList<Integer> A) {
        if (A.size()==0){
            return null;
        }

        TreeNode top = new TreeNode(A.get(0));
        for (int i = 1;i<A.size();i++){
            TreeNode current = new TreeNode(A.get(i));
            if (current.val>top.val){
                current.left = top;
                top = current;
            }else{
                TreeNode right = top;
                while (right.right!=null && right.right.val>current.val){
                    right = right.right;
                }
                current.left = right.right;
                right.right = current;
            }
        }
        return top;
    }



}
