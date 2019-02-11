package mix;

import java.util.HashMap;

public class HouseRobber {

    HashMap<Integer, Integer> map = new HashMap<>();

    public int rob(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        return helper(nums, 0);
    }

    private int helper(int[] nums, int n) {
        if(map.containsKey(n) && map.get(n) > 0) return map.get(n);
        int max = 0;
        if(n == nums.length - 1) max = nums[n];
        if(n == nums.length - 2) max = Math.max(nums[n], nums[n+1]);
        else max = Math.max(nums[n]+helper(nums,n+2), helper(nums,n+1));
        map.put(n, max);
        return max;
    }
}
