package mix;

import java.util.HashMap;
import java.util.Map;

public class CoinChange {

    public static void main(String[] args) {
        System.out.println(new CoinChange().coinChange(new int[]{2}, 11));
    }

    Map<Integer, Integer> map = new HashMap<>();

    public int coinChange(int[] coins, int amount) {
        return coinChangeDP(coins, amount);
    }

    private int coinChangeDP(int[] coins, int amount) {
        if(amount == 0) return 0;
        else if(amount < 0) return -1;
        else {

            if(map.containsKey(amount)) return map.get(amount);

            int min = Integer.MAX_VALUE;
            for (int value : coins) {
                int minCoins = coinChangeDP(coins, amount - value);
                if(minCoins != -1 && minCoins < min) min = minCoins;
                map.put(amount - value, minCoins);
            }

            min = min!=Integer.MAX_VALUE?min+1:Integer.MAX_VALUE;

            map.put(amount, min!=Integer.MAX_VALUE?min:-1);
            return min!=Integer.MAX_VALUE?min:-1;
        }
    }

}
