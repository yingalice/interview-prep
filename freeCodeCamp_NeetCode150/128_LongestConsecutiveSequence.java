// 128. Longest Consecutive Sequence

// https://leetcode.com/problems/longest-consecutive-sequence/
// https://www.youtube.com/watch?v=T0u5nwSA0w0&t=5774s

// Given an unsorted array of integers nums, return the length of the longest consecutive elements sequence.
// You must write an algorithm that runs in O(n) time.

// Example 1:
// Input: nums = [100,4,200,1,3,2]
// Output: 4
// Explanation: The longest consecutive elements sequence is [1, 2, 3, 4]. Therefore its length is 4.

import java.util.Set;
import java.util.HashSet;

class Solution128 {
  public static int longestConsecutive(int[] nums) {
    // Add all unique numbers to HashSet (removes duplicates)
    Set<Integer> set = new HashSet<>();
    for (int num : nums) {
      set.add(num);
    }

    int longestSequence = 0;
    for (int num : set) {
      // Only check if it's a potential starting number (don't start in the middle --> won't get the longest sequence)
      if (!set.contains(num - 1)) {
        int start = num;
        int currentSequence = 1;
        // Check how long this consecutive sequence is
        while (set.contains(start + 1)) {
          currentSequence++;
          start++;
        }
        // Update longest sequence
        longestSequence = Math.max(longestSequence, currentSequence);
      } 
    }

    return longestSequence;
  }

  public static void main(String[] args) {
    System.out.println(longestConsecutive(new int[] {100,4,200,1,3,2}));  // 4
    System.out.println(longestConsecutive(new int[] {0,3,7,2,5,8,4,6,0,1}));  // 9
  }
}