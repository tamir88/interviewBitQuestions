package TreeDataStructure.VerticalOrderTraversalOfBinaryTree;




import TreeDataStructure.TreeNode;

import java.util.*;

class Solution {
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        Map<Integer, Map<Integer, List<Integer>>> map = new TreeMap<>();
        verticalTrav(root, 0, 0, map);
        return sortAndConvert(map);
    }

    private void verticalTrav(TreeNode root, int hd, int level, Map<Integer, Map<Integer,List<Integer>>> map){

        //base case
        if(root == null)
            return;

        //recursion section

        if(map.containsKey(hd)){
            Map levMap = map.get(hd);

            if(!levMap.containsKey(level)){
                List<Integer> newList = new ArrayList<>(); //create new List
                newList.add(root.val); // insert value into List
                levMap.put(level, newList); // insert the entry (level, List<>)


            }
            else{
                List<Integer> list = (List<Integer>) levMap.get(level);
                list.add(root.val);
            }
        }
        else{
            List<Integer> newList = new ArrayList<>(); //create new List
            newList.add(root.val); // insert value into List
            Map<Integer, List<Integer>> levMap = new TreeMap<>(); // create a Map
            levMap.put(level, newList); //insert entry into the Map
            map.put(hd, levMap); // insert new entry into primary Map
        }

        verticalTrav(root.left,hd-1, level+1, map);

        verticalTrav(root.right,hd+1, level+1, map);
    }

    private List<List<Integer>> sortAndConvert(Map<Integer, Map<Integer,List<Integer>>> map){
        List<List<Integer>> ans = new ArrayList<>();

        for(Map.Entry<Integer,Map<Integer,List<Integer>>> entry : map.entrySet()){
            for(Map.Entry<Integer,List<Integer>> entry2 : entry.getValue().entrySet()){
                if(entry2.getValue().size() > 1){
                    Collections.sort(entry2.getValue());
                }
            }
        }
        for(Map.Entry<Integer,Map<Integer,List<Integer>>> entry : map.entrySet()){
            List<Integer> col = new ArrayList<>();
            for(Map.Entry<Integer,List<Integer>> entry2 : entry.getValue().entrySet()){

                for(int temp : entry2.getValue()){
                    col.add(temp);
                }

            }
            ans.add(col);
        }

        return ans;
    }

    public static void main(String[] args) {
        Solution a = new Solution();
        TreeNode b = new TreeNode(3,new TreeNode(9), new TreeNode(20,new TreeNode(15), new TreeNode(7)));
        System.out.println(a.verticalTraversal(b));
    }
}