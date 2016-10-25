package dynamic_programming.best_time_to_buy_and_sell_stocks_III;

import java.util.List;

/**
 * Created by ugurdonmez on 06/09/16.
 */
public class Solution {

    public static void main(String [] args) {

    }

    public int maxProfit(final List<Integer> prices) {
        if (prices == null || prices.size() < 2) {
            return 0;
        }

        //highest profit in 0 ... i
        int[] left = new int[prices.size()];
        int[] right = new int[prices.size()];

        // DP from left to right
        left[0] = 0;
        int min = prices.get(0);
        for (int i = 1; i < prices.size(); i++) {
            min = Math.min(min, prices.get(i));
            left[i] = Math.max(left[i - 1], prices.get(i) - min);
        }

        // DP from right to left
        right[prices.size() - 1] = 0;
        int max = prices.get(prices.size() - 1);
        for (int i = prices.size() - 2; i >= 0; i--) {
            max = Math.max(max, prices.get(i));
            right[i] = Math.max(right[i + 1], max - prices.get(i));
        }

        int profit = 0;
        for (int i = 0; i < prices.size(); i++) {
            profit = Math.max(profit, left[i] + right[i]);
        }

        return profit;
    }

}
