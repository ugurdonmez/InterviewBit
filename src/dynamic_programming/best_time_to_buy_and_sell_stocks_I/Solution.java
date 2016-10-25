package dynamic_programming.best_time_to_buy_and_sell_stocks_I;

import java.util.List;

/**
 * Created by ugurdonmez on 06/09/16.
 */
public class Solution {

    public static int maxProfit(final List<Integer> list) {

        if (list.size() < 2) {
            return 0;
        }

        int maxPro = 0;

        int minUpToNow = list.get(0);

        for (int i = 1; i < list.size(); i++) {
            if (list.get(i) > minUpToNow) {
                maxPro = Integer.max(maxPro, list.get(i) - minUpToNow);
            } else {
                minUpToNow = list.get(i);
            }
        }

        return maxPro;
    }

}
