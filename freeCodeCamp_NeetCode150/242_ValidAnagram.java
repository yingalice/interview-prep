// 242. Valid Anagram
// https://leetcode.com/problems/valid-anagram/description/
// https://www.youtube.com/watch?v=T0u5nwSA0w0&t=564s

// Given two strings s and t, return true if t is an anagram of s, and false otherwise.

// Example 1:
// Input: s = "anagram", t = "nagaram"
// Output: true

class Solution242 {
  public static boolean isAnagram(String s, String t) {
    // If lengths are different, they can't be anagrams
    if (s.length() != t.length()) {
      return false;
    }

    // Create an array to count character frequencies
    int[] charCounts = new int[26]; // assuming only lowercase English letters

    // // Increment count for each character in 's' and decrement for each in 't'
    for (int i = 0; i < s.length(); i++) {
      charCounts[s.charAt(i) - 'a']++;
      charCounts[t.charAt(i) - 'a']--;
    }

    for (int count : charCounts) {
      if (count != 0) {
        return false;
      }
    }

    return true;  // All counts are zero, so 't' is an anagram of 's'
  }

  public static void main(String[] args) {
    System.out.println(isAnagram("anagram", "nagaram"));  // true
    System.out.println(isAnagram("rat", "car"));  // false
  }
}