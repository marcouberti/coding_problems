package mix;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;
import java.util.*;


public class RandomizedCollection {

    // pairs val / index in map list
    private ArrayList<Pair> numbers;
    // map val / indices in numbers
    private Map<Integer, LinkedList<Integer>> locations;

    /** Initialize your data structure here. */
    public RandomizedCollection() {
        numbers = new ArrayList<>();
        locations = new HashMap<>();
    }

    /** Inserts a value to the collection. Returns true if the collection did not already contain the specified element. */
    public boolean insert(int val) {
        if(locations.containsKey(val)) {
            numbers.add(new Pair(val, locations.get(val).size()));
            locations.get(val).add(numbers.size()-1);
            return false;
        }
        else {
            numbers.add(new Pair(val, 0));
            LinkedList<Integer> linkedList = new LinkedList<>();
            linkedList.add(numbers.size()-1);
            locations.put(val, linkedList);
            return true;
        }
    }

    /** Removes a value from the collection. Returns true if the collection contained the specified element. */
    public boolean remove(int val) {
        if(!locations.containsKey(val) || locations.get(val).isEmpty()) return false;
        else {
            LinkedList<Integer> linkedList = locations.get(val);
            int loc = linkedList.getLast();
            if(loc != numbers.size() - 1) {
                int last = numbers.get(numbers.size() - 1).val;
                int lastIndex = numbers.get(numbers.size() - 1).index;
                numbers.set(loc, new Pair(last, lastIndex)); // swap with the last
                locations.get(last).set(lastIndex, loc);
            }
            numbers.remove(numbers.size() -1);
            linkedList.removeLast();
            return true;
        }
    }

    /** Get a random element from the collection. */
    public int getRandom() {
        return numbers.get(new Random().nextInt(numbers.size())).val;
    }

    // simple Pair class
    private class Pair {
        private int val, index;
        Pair(int val, int index) {
            this.val = val;
            this.index = index;
        }
    }
}
