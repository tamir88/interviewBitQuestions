package TreeDataStructure;

import java.util.*;

public class BurnATree {
    public int solve(TreeNode A, int B) {
        //variables
        HashMap<Integer, TreeNode> parentMap = new HashMap<>();
        HashSet<Integer> vis = new HashSet<>();
        Queue<TreeNode> q = new LinkedList<>();
        int iterationQueue = 1;
        int minTime = 0;
        boolean burnValid = true;

        mapHashMap(A,parentMap);
        TreeNode leaf = getNodeB(A,B);
        q.add(leaf);
        vis.add(leaf.val);

        while (!q.isEmpty()){
            TreeNode curNode = q.poll();
            iterationQueue--;

            if(curNode.left != null){
                if(!vis.contains(curNode.left.val)){
                    vis.add(curNode.left.val);
                    q.add(curNode.left);
                    burnValid = true;
                }

            }
            if(curNode.right != null){
                if(!vis.contains(curNode.right.val)){
                    vis.add(curNode.right.val);
                    q.add(curNode.right);
                    burnValid = true;
                }
            }
            if(parentMap.containsKey(curNode.val)){
                TreeNode parent = parentMap.get(curNode.val);
                if(!vis.contains(parent.val)){
                    vis.add(parent.val);
                    q.add(parent);
                    burnValid = true;
                }
            }

            if(iterationQueue == 0){
                if(burnValid)
                    minTime++;
                burnValid = false;
                iterationQueue = q.size();
            }
        }
        return minTime;
    }

    private TreeNode getNodeB(TreeNode A, int B){
        //base case
        if(A == null)   return new TreeNode(Integer.MIN_VALUE,null,null);
        if(A.val == B)  return A;

        // recursion section
        TreeNode left = getNodeB(A.left,B);
        TreeNode right = getNodeB(A.right,B);
        return left.val > right.val ? left : right;
    }


    //mapping the hashMap key=node.value  value=TreeNode
    private void mapHashMap(TreeNode A, HashMap<Integer,TreeNode> map){
        //variables
        Queue<TreeNode> q = new LinkedList<>();
        TreeNode root;
        int valueLeft;
        int valueRight;

        // algorithm logic
        q.add(A);
        while (!q.isEmpty()){
            root = q.poll();
            if(root.left != null){
                valueLeft = root.left.val;
                map.put(valueLeft, root);
                q.add(root.left);
            }
            if(root.right != null){
                valueRight = root.right.val;
                map.put(valueRight, root);
                q.add(root.right);
            }
        }
    }

    public static void main(String[] args) {
        BurnATree a = new BurnATree();
        TreeNode A = new TreeNode(7,new TreeNode(4,null,null), new TreeNode(1,null,null));
        System.out.println(a.solve(A,1));

    }
}
