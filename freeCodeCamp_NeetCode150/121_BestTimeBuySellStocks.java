// 121. Best Time to Buy and Sell Stock
// https://leetcode.com/problems/best-time-to-buy-and-sell-stock/description/
// https://www.youtube.com/watch?v=T0u5nwSA0w0&t=12195s

// You are given an array prices where prices[i] is the price of a given stock on the ith day.
// You want to maximize your profit by choosing a single day to buy one stock and choosing a different day in the future to sell that stock.
// Return the maximum profit you can achieve from this transaction. If you cannot achieve any profit, return 0.

// Example 1:
// Input: prices = [7,1,5,3,6,4]
// Output: 5
// Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6-1 = 5.
// Note that buying on day 2 and selling on day 1 is not allowed because you must buy before you sell.

class Solution121 {
  public static int maxProfit(int[] prices) {
    int buy = prices[0];
    int profit = 0;

    
    for (int i = 0; i < prices.length; i++) {
      // Buy is set to the lowest price we've encountered so far
      if (prices[i] < buy) {
        buy = prices[i];
      }

      // Sell is set to whatever price we're currently on
      // Check sell - buy to find the max profit
      profit = Math.max(profit, prices[i] - buy);
    }
    
    return profit;
  }

  public static void main(String[] args) {
    System.out.println(maxProfit(new int[] {7,1,5,3,6,4}));  // 5
    System.out.println(maxProfit(new int[] {7,6,4,3,1}));  // 0
  }
}