package mix;

public class MaxProductOfThreeNumbers {

    public int maximumProduct(int[] nums) {
        // the max product of three numbers (with sign) is
        // max(min1 * min2 * max1, max1 * max2 * max3)
        // because if min1 and min2 are negative, the product is positive...
        int max1 = Integer.MIN_VALUE, max2  = Integer.MIN_VALUE, max3  = Integer.MIN_VALUE;
        int min1  = Integer.MAX_VALUE, min2 = Integer.MAX_VALUE;

        for(int i=0; i<nums.length; i++) {
            int n = nums[i];
            if(n > max1) {
                max3 = max2;
                max2 = max1;
                max1 = n;
            }else if(n > max2) {
                max3 = max2;
                max2 = n;
            }else if(n > max3) {
                max3 = n;
            }

            if(n < min1) {
                min2 = min1;
                min1 = n;
            }else if(n < min2) {
                min2 = n;
            }
        }

        return Math.max(min1*min2*max1, max1*max2*max3);
    }

}
