package fun.hoyouly;

/**
 * 买卖股票的最佳时机 II
 */
public class Leetcode_122 {
    public static void main(String[] args) {
        Solution test = new Solution();
    }

    static class Solution {
        //贪心算法
        public int maxProfit(int[] prices) {
            int profit = 0;
            for (int i = 0; i < prices.length - 1; i++) {
                if (prices[i] < prices[i + 1]) {
                    profit += prices[i + 1] - prices[i];
                }
            }
            return profit;
        }
    }
}
