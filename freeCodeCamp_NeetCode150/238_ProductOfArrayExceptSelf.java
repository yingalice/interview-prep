// 238. Product of Array Except Self

// https://leetcode.com/problems/product-of-array-except-self/description/
// https://www.youtube.com/watch?v=T0u5nwSA0w0&t=3134s

// Given an integer array nums, return an array answer such that answer[i] is equal to the product of all the elements of nums except nums[i].
// The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.
// You must write an algorithm that runs in O(n) time and without using the division operation.

// Example 1:
// Input: nums = [1,2,3,4]
// Output: [24,12,8,6]

import java.util.Arrays;

class Solution238 {
  public static int[] productExceptSelf(int[] nums) {
    // Approach: Get all products before and after each number, multiply them to get final result

    int[] result = new int[nums.length];  // Use one array only to save space
    int pre = 1;
    int post = 1;

    // Start from the front
    // PRE: Get all products before this nums[i]
    for (int i = 0; i < nums.length; i++) {
      result[i] = pre;
      pre *= nums[i];
    }

    // Start from the back
    // POST: Get all products after this nums[i]
    // Multiply it by the PRE number
    for (int i = nums.length - 1; i >= 0; i--) {
      result[i] *= post;
      post *= nums[i];
    }

    return result;
  }

  public static void main(String[] args) {
    System.out.println(Arrays.toString(productExceptSelf(new int[] {1,2,3,4})));  // [24,12,8,6]
    System.out.println(Arrays.toString(productExceptSelf(new int[] {-1,1,0,-3,3})));  // [0,0,9,0,0]
  }
}