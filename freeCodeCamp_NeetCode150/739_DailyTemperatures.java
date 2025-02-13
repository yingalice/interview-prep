
// 739. Daily Temperatures
// https://leetcode.com/problems/daily-temperatures/description/
// https://www.youtube.com/watch?v=T0u5nwSA0w0&t=20767s

// Given an array of integers temperatures represents the daily temperatures, 
// return an array answer such that answer[i] is the number of days you have to 
// wait after the ith day to get a warmer temperature. If there is no future day 
// for which this is possible, keep answer[i] == 0 instead.

// Example 1:
// Input: temperatures = [73,74,75,71,69,72,76,73]
// Output: [1,1,4,2,1,1,0,0]

import java.util.Arrays;
import java.util.Stack;

class Solution739 {
  public int[] dailyTemperatures(int[] temperatures) {
    int n = temperatures.length;
    int[] result = new int[n];
    Stack<Integer> stack = new Stack<>();  // Store index (not temperatures) on the stack

    for (int curIdx = 0; curIdx < n; curIdx++) {
      // Compare current temperature against previous index's temperature
      // If current is greater:
      //   You have an answer for the index at the top of the stack
      //   Remember: Temperatures on the stack can only be added in descending order, 
      //             so when you pop, the temperatures will be rising
      //   Use a while loop to populate results until current temperature is no longer higher than the one at the top of the stack
      // Else:
      //   Add index to stack
      while (!stack.empty() && temperatures[curIdx] > temperatures[stack.peek()]) {
        int idx = stack.pop();
        result[idx] = curIdx - idx;  // Difference in index is the number of days to wait before warmer temperature
      }
      stack.push(curIdx);  // Add current index to stack.  Don't have an answer for this yet
    }
    return result;
  }

  public static void main(String[] args) {
    Solution739 solution = new Solution739();
    System.out.println(Arrays.toString(solution.dailyTemperatures(new int[] {73,74,75,71,69,72,76,73})));  // [1,1,4,2,1,1,0,0]
    System.out.println(Arrays.toString(solution.dailyTemperatures(new int[] {30,40,50,60})));  // [1,1,1,0]
    System.out.println(Arrays.toString(solution.dailyTemperatures(new int[] {30,60,90})));  // [1,1,0]
  }
}