// 3. Longest Substring Without Repeating Characters
// https://leetcode.com/problems/longest-substring-without-repeating-characters/
// https://www.youtube.com/watch?v=T0u5nwSA0w0&t=12758s

// Given a string s, find the length of the longest substring without repeating characters.

// Example 1:
// Input: s = "abcabcbb"
// Output: 3
// Explanation: The answer is "abc", with the length of 3.

import java.util.HashSet;

class Solution3 {
  public static int lengthOfLongestSubstring(String s) {
    int left = 0;
    int right = 0;
    int answer = 0;
    HashSet<Character> hashSet = new HashSet<>();

    // Uses a sliding window and 2 pointers
    while (right < s.length()) {
      char c = s.charAt(right);
      // If right character is not a dupe, add it to hashset, and increase right pointer
      // Otherwise, remove each left character from the hashset until you get past the duplicate (substring gets smaller)
      if (!hashSet.add(c)) {
        while (s.charAt(left) != c) {
          hashSet.remove(s.charAt(left));
          left++;
        }
        left++;
      }
      right++;
      answer = Math.max(answer, hashSet.size());
    }
   return answer;
  }

  public static void main(String[] args) {
    System.out.println(lengthOfLongestSubstring("abcabcbb"));  // 3
    System.out.println(lengthOfLongestSubstring("bbbbb"));  // 1
    System.out.println(lengthOfLongestSubstring("pwwkew"));  // 3
    System.out.println(lengthOfLongestSubstring("au"));  // 2
  }
}