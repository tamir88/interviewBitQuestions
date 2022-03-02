package TreeDataStructure;

import lombok.NoArgsConstructor;

import java.util.ArrayList;


public class XorBetweenTwoArrays {


    class Node{
       private Node[] links = new Node[2];

       public Node(){};

        private boolean isContains(int bit){
            return (links[bit] != null);
        }

        private Node getNode(int bit){
            return links[bit];
        }

        private void put(int bit, Node node){
            links[bit] = node;
        }
    };


    class Trie{
        private Node root = new Node();

        public Trie(){};

        private void insert(int num){
            Node node = root;
            for (int i = 31; i>= 0 ;i--) {
                int bit = (num >> i) & 1;
                if(!node.isContains(bit)){
                    node.put(bit, new Node());
                }
                node = node.getNode(bit);
            }
        }

        private int getMax(int num){
            Node node = root;
            int maxNum = 0;
            for (int i = 31; i >= 0 ; i--) {
                int bit = (num >> i) & 1;
                if(node.isContains(1 - bit)){
                    maxNum = maxNum | (1 << i);
                    node = node.getNode(1-bit);
                }
                else
                    node = node.getNode(bit);
            }
            return maxNum;
        }
    }

    public int solve(ArrayList<Integer> A, ArrayList<Integer> B) {
        Trie trie = new Trie();
        int max = 0;

        for(int num : B){
            trie.insert(num);
        }
        for (int num : A){
            max = Math.max(max, trie.getMax(num));
        }
        return max;
    }
}
