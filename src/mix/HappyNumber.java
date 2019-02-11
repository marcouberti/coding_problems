package mix;

import java.util.*;

public class HappyNumber {

    public static void main(String[] args) {
        System.out.println(new HappyNumber().isHappy(7));
    }

    public boolean isHappy(int n) {
        Map<Integer, Boolean> map = new HashMap<>();
        while(!map.containsKey(n)) {
            map.put(n, true);
            List<Integer> digits = getDigits(n);
            int squareSum = getSquareSum(digits);
            n = squareSum;
            if(squareSum == 1) return true;
        }
        return false;
    }

    private List<Integer> getDigits(int n) {
        List<Integer> list = new ArrayList<>();

        while(n > 0) {
            list.add(n % 10);
            n /= 10;
        }

        return list;
    }

    private int getSquareSum(List<Integer> list) {
        int sum = 0;
        if(list != null && list.size() > 0) {
            for (Integer n : list) {
                sum += n*n;
            }
        }
        return sum;
    }
}
