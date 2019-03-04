package mix;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a set of distinct integers, nums, return all possible subsets (the power set).
 * Note: The solution set must not contain duplicate subsets.
 */
public class PowerSetJava {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        list.add(new ArrayList<>());//empty set

        subset(list, nums, 0);
        return list;
    }

    private void subset(List<List<Integer>> list, int[] nums, int index) {
        if(index >= nums.length) return;

        int value = nums[index];

        final int size = list.size();
        for(int i=0; i<size; i++) {
            List<Integer> newSet = new ArrayList<>();
            newSet.addAll(list.get(i));
            newSet.add(value);
            list.add(newSet);
        }

        subset(list, nums, index+1);
    }
}
