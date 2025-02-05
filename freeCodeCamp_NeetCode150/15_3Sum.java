// 15. 3Sum
// https://leetcode.com/problems/3sum/description/
// https://www.youtube.com/watch?v=T0u5nwSA0w0&t=8476s

// Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]] such that i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0.
// Notice that the solution set must not contain duplicate triplets.

// Example 1:
// Input: nums = [-1,0,1,2,-1,-4]
// Output: [[-1,-1,2],[-1,0,1]]
// Explanation: 
// nums[0] + nums[1] + nums[2] = (-1) + 0 + 1 = 0.
// nums[1] + nums[2] + nums[4] = 0 + 1 + (-1) = 0.
// nums[0] + nums[3] + nums[4] = (-1) + 2 + (-1) = 0.
// The distinct triplets are [-1,0,1] and [-1,-1,2].
// Notice that the order of the output and the order of the triplets does not matter.

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution15 {
  public static List<List<Integer>> threeSum(int[] nums) {
    List<List<Integer>> result = new ArrayList<>();
    
    // Sort the numbers in order, so we can search using left and right pointers for j and k
    Arrays.sort(nums);  

    // The largest potential i is the 3rd from last number (the other numbers are j and k)
    for (int i = 0; i <= nums.length - 3; i++) {
      // Don't check the same i twice (skip it to avoid duplicate triplets)
      if ((i == 0) || (nums[i] != nums[i - 1])) {
        int j = i + 1;
        int k = nums.length - 1;
        
        while (j < k) {
          int sum = nums[j] + nums[k];
          int target = -nums[i];  // In order to add up to 0, values at j + k must equal -i
          if (sum < target) {
            j++;  // Sum too little, increase it by incrementing j
          } else if (sum > target) {
            k--;  // Sum too large, reduce it by decrementing k
          } else {
            result.add(Arrays.asList(nums[i], nums[j++], nums[k]));  // Found an answer
          }
          // Don't check the same j twice (skip it to avoid duplicate triplets)
          while((j != i + 1) && (j < k) && (nums[j] == nums[j - 1])) {
            j++;
          }
        }        
      }
    }
    return result;
  }

  public static void main(String[] args) {
    System.out.println(threeSum(new int[]{-1,0,1,2,-1,-4}));  // [[-1,-1,2],[-1,0,1]]
    System.out.println(threeSum(new int[]{0,1,1}));  // []
    System.out.println(threeSum(new int[]{0,0,0}));  // [[0,0,0]]
    System.out.println(threeSum(new int[]{0,0,0,0}));  // [[0,0,0]]
  }
}