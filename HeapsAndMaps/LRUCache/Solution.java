package HeapsAndMaps.LRUCache;


import java.util.Comparator;
import java.util.HashMap;
import java.util.PriorityQueue;

public class Solution {
    int capacity;
    int timeStamp = 0;
    HashMap<Integer,Element> map = new HashMap<>();
    PriorityQueue<Element> pq = new PriorityQueue(new Comparator<Element>() {
        @Override
        public int compare(Element a1, Element a2) {
            return a1.priority - a2.priority;
        }
    });

    //constructor
    public Solution(int capacity) {
        this.capacity = capacity;
    }

    // get method
    public int get(int key) {

        // if present in the map update the element timeStamp in priorityQueue
        if(map.containsKey(key)){
            Element objToRemove = map.get(key);
            pq.remove(objToRemove);
            Element objToAdd = new Element(objToRemove.key,objToRemove.value,timeStamp);
            pq.add(objToAdd);
            map.put(key, objToAdd);
            timeStamp++;
            return objToAdd.value;
        }
        else{
            return -1;
        }
    }

    // set method
    public void set(int key, int value) {
        Element objToAdd = new Element(key, value,timeStamp);
        if(map.containsKey(key)){
            Element objToRemove = map.get(key);
            pq.remove(objToRemove);
            pq.add(objToAdd);
            map.put(key,objToAdd);
        }
        else {
            if (pq.size() == capacity) {
                Element objToRemove = pq.poll();
                map.remove(objToRemove.key);
            }
            map.put(objToAdd.key, objToAdd);
            pq.add(objToAdd);
        }
        timeStamp++;
    }

    class Element {
        public int key;
        public int value;
        public int priority;

        public Element(int key, int value, int priority) {
            this.key = key;
            this.value = value;
            this.priority = priority;
        }
    }
}
