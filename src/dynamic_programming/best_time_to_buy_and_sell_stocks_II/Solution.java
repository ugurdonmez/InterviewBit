package dynamic_programming.best_time_to_buy_and_sell_stocks_II;

/**
 * Created by ugurdonmez on 06/09/16.
 */

import java.util.List;

/**
 *

 Say you have an array for which the ith element is the price of a given stock on day i.

 Design an algorithm to find the maximum profit.
 You may complete as many transactions as you like (ie, buy one and sell one share of the stock multiple times).
 However, you may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).

 Example :

 Input : [1 2 3]
 Return : 2


 */

public class Solution {

    public int maxProfit(final List<Integer> list) {

        if (list.size() < 2) {
            return 0;
        }

        int maxPro = 0;

        for (int i = 0; i < list.size()-1; i++) {

            if (list.get(i) < list.get(i+1)) {
                int buyPrice = list.get(i);
                int j = i+1;

                while (j < list.size() - 1 && list.get(j) < list.get(j+1)) {
                    j++;
                }

                if (j < list.size() && j > i) {
                    maxPro += list.get(j) - buyPrice;
                }
                i = j;
            }
        }

        return maxPro;
    }

}
