// 704. Binary Search
// https://leetcode.com/problems/binary-search/description/
// https://www.youtube.com/watch?v=T0u5nwSA0w0&t=23853s

// Given an array of integers nums which is sorted in ascending order, and an integer target, write a function to search target in nums. If target exists, then return its index. Otherwise, return -1.
// You must write an algorithm with O(log n) runtime complexity.

// Example 1:
// Input: nums = [-1,0,3,5,9,12], target = 9
// Output: 4
// Explanation: 9 exists in nums and its index is 4

class Solution704 {
  public int search(int[] nums, int target) {
    int left = 0;
    int right = nums.length - 1;
    
    while (left <= right) {
      int half = (left + right) / 2;
      if (nums[half] < target) {  // Answer in upper half
        left = half + 1;
      } else if (nums[half] > target){  // Answer in lower half
        right = half - 1;
      } else {
        return half;  // Found target
      }
    }

    return -1;  // Target not found
  }

  public static void main(String[] args) {
    Solution704 solution = new Solution704();
    System.out.println(solution.search(new int[]{-1,0,3,5,9,12}, 9));  // 4
    System.out.println(solution.search(new int[]{-1,0,3,5,9,12}, 2));  // -1
    System.out.println(solution.search(new int[]{2,5}, 2));  // 0
    System.out.println(solution.search(new int[]{5}, -5));  // -1
  }
}