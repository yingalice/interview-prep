// 1. Two Sum
// https://leetcode.com/problems/two-sum/description/
// https://www.youtube.com/watch?v=T0u5nwSA0w0&t=1110s

// Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
// You may assume that each input would have exactly one solution, and you may not use the same element twice.
// You can return the answer in any order.

// Example 1:
// Input: nums = [2,7,11,15], target = 9
// Output: [0,1]
// Explanation: Because nums[0] + nums[1] == 9, we return [0, 1].

import java.util.Arrays;
import java.util.HashMap;

class Solution1 {
  public static int[] twoSum(int[] nums, int target) {
    // Create a HashMap to store numbers and their indices
    HashMap<Integer, Integer> map = new HashMap<>();
    
    // Iterate through the array
    for (int i = 0; i < nums.length; i++) {
      // Calculate the complement of the current number
      int complement = target - nums[i];

      // Check if complement is already in the map
      if (map.containsKey(complement)) {
        // If found, return the indices of the complement and the current number
        return new int[] {map.get(complement), i};
      }

      // Otherwise, add the current number and its index to the map
      map.put(nums[i], i);
    }

    // Return an empty array if no solution is found (this case won't occur as per problem constraints)
    return new int[] {}; 
  }

  public static void main(String[] args) {
    System.out.println(Arrays.toString(twoSum(new int[]{2,7,11,15}, 9)));  // [0, 1]
    System.out.println(Arrays.toString(twoSum(new int[]{3, 2, 4}, 6)));  // [1, 2]
    System.out.println(Arrays.toString(twoSum(new int[]{3, 3}, 6)));  // [0, 1]
  }
}