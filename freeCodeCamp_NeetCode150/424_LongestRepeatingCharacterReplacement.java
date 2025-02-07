// 424. Longest Repeating Character Replacement
// https://leetcode.com/problems/longest-repeating-character-replacement/description/
// https://www.youtube.com/watch?v=T0u5nwSA0w0&t=13416s

// You are given a string s and an integer k. You can choose any character of the string and change it to any other uppercase English character. You can perform this operation at most k times.
// Return the length of the longest substring containing the same letter you can get after performing the above operations.

// Example 1:
// Input: s = "ABAB", k = 2
// Output: 4
// Explanation: Replace the two 'A's with two 'B's or vice versa.

class Solution424 {
  public static int characterReplacement(String s, int k) {
    int[] occurrence = new int[26];
    int left = 0;
    int answer = 0;
    int maxOccurrence = 0;

    for (int right = 0; right < s.length(); right++) {
      maxOccurrence = Math.max(maxOccurrence, ++occurrence[s.charAt(right) - 'A']);

      // Find the least number of characters that need to be replaced in this substring (length - maximum occurring character in substring)
      // This number needs to be <= k in order for the substring to all have the same character
      // If it's not, make substring shorter by doing left++
      if (right - left + 1 - maxOccurrence > k) {  
        occurrence[s.charAt(left) - 'A']--;
        left++;
      }
      answer = Math.max(answer, right - left + 1);
    }
    return answer;
  }

  public static void main(String[] args) {
    System.out.println(characterReplacement("ABAB", 2));  // 4
    System.out.println(characterReplacement("AABABBA", 1));  // 4
  }
}