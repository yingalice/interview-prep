// 567. Permutation in String
// https://leetcode.com/problems/permutation-in-string/
// https://www.youtube.com/watch?v=T0u5nwSA0w0&t=14660s

// Given two strings s1 and s2, return true if s2 contains a 
// permutation of s1, or false otherwise.

// In other words, return true if one of s1's permutations is the substring of s2.

// Example 1:
// Input: s1 = "ab", s2 = "eidbaooo"
// Output: true
// Explanation: s2 contains one permutation of s1 ("ba").

import java.util.Arrays;

class Solution567 {
    public static boolean checkInclusion(String s1, String s2) {
      // s1 must be smaller than s2 because it's a substring
      if (s1.length() > s2.length()) {
        return false;
      }

      int[] s1Map = new int[26];
      int[] s2Map = new int[26];
      
      // Set initial hashmaps for the s1 and first window of s2
      for (int i = 0; i < s1.length(); i++) {
        s1Map[s1.charAt(i) - 'a']++;
        s2Map[s2.charAt(i) - 'a']++;
      }

      // Slide the window through s2 and compare maps
      for (int i = 0; i < s2.length() - s1.length(); i++) {
        if (Arrays.equals(s1Map, s2Map)) {
          return true;
        }

        s2Map[s2.charAt(i + s1.length()) - 'a']++;  // Add new character to window
        s2Map[s2.charAt(i) - 'a']--;  // Remove old character from window
      }
      
      // Check the last window
      if (Arrays.equals(s1Map, s2Map)) {
        return true;
      }

      return false;
    }

    public static void main(String[] args) {
      System.out.println(checkInclusion("ab", "eidbaooo"));  // true
      System.out.println(checkInclusion("ab", "eidboaoo"));  // false
      System.out.println(checkInclusion("adc", "dcda"));     // true
    }
}