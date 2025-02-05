// 167. Two Sum II - Input Array Is Sorted
// https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/description/
// https://www.youtube.com/watch?v=T0u5nwSA0w0&t=7698s

// Given a 1-indexed array of integers numbers that is already sorted in non-decreasing order, find two numbers such that they add up to a specific target number. Let these two numbers be numbers[index1] and numbers[index2] where 1 <= index1 < index2 <= numbers.length.
// Return the indices of the two numbers, index1 and index2, added by one as an integer array [index1, index2] of length 2.
// The tests are generated such that there is exactly one solution. You may not use the same element twice.
// Your solution must use only constant extra space.

// Example 1:
// Input: numbers = [2,7,11,15], target = 9
// Output: [1,2]
// Explanation: The sum of 2 and 7 is 9. Therefore, index1 = 1, index2 = 2. We return [1, 2].

import java.util.Arrays;

class Solution167 {
  public static int[] twoSum(int[] numbers, int target) {
    int left = 0;
    int right = numbers.length - 1;

    // Use left and right pointers to iterate over the sorted array once
    // If their sums are greater than the target, decrease sum by decrementing right pointer
    // If their sums are lower than the target, increase sum by incrementing left pointer
    while (left < right) {
      int sum = numbers[left] + numbers[right];
      if (sum > target) {
        right--;
      } else if (sum < target) {
        left++;
      } else {
        return new int[] {left + 1, right + 1};
      }
    }
    return new int[] {};
  }

  public static void main(String[] args) {
    System.out.println(Arrays.toString(twoSum(new int[]{2,7,11,15}, 9)));  // [1,2]
    System.out.println(Arrays.toString(twoSum(new int[]{2, 3, 4}, 6)));  // [1,3]
    System.out.println(Arrays.toString(twoSum(new int[]{-1, 0}, -1)));  // [1, 2]
  }
}