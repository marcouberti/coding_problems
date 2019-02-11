package mix;

/*
Design a data structure that supports all following operations in average O(1) time.

insert(val): Inserts an item val to the set if not already present.
remove(val): Removes an item val from the set if present.
getRandom: Returns a random element from current set of elements. Each element must have the same probability of being returned.
 */

import java.util.*;

public class RandomizedSet {

    private ArrayList<Integer> numbers;
    private Map<Integer, Integer> locations;

    /** Initialize your data structure here. */
    public RandomizedSet() {
        numbers = new ArrayList<>();
        locations = new HashMap<>();
    }

    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        if(locations.containsKey(val)) return false;
        else {
            numbers.add(val);
            locations.put(val, numbers.size()-1);
            return true;
        }
    }

    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        if(!locations.containsKey(val)) return false;
        else {
            int location = locations.get(val);
            if(location != numbers.size() -1) {
                int last = numbers.get(numbers.size() - 1);
                numbers.set(location, last); // swap with the last
                locations.put(last, location); // update last location, the others loc remain unchanged
            }
            numbers.remove(numbers.size() -1);
            locations.remove(val);
            return true;
        }
    }

    /** Get a random element from the set. */
    public int getRandom() {
        return numbers.get(new Random().nextInt(numbers.size()));
    }
}
