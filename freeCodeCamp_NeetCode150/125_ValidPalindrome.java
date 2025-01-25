// 125. Valid Palindrome
// https://leetcode.com/problems/valid-palindrome/
// https://www.youtube.com/watch?v=T0u5nwSA0w0&t=7167s

// A phrase is a palindrome if, after converting all uppercase letters into lowercase letters and removing all non-alphanumeric characters, it reads the same forward and backward. Alphanumeric characters include letters and numbers.
// Given a string s, return true if it is a palindrome, or false otherwise. 

// Example 1:
// Input: s = "A man, a plan, a canal: Panama"
// Output: true
// Explanation: "amanaplanacanalpanama" is a palindrome.

class Solution125 {
  public static boolean isPalindrome(String s) {
    int left = 0;
    int right = s.length() - 1;

    // Compare left and right characters, moving towards the middle in each round
    while (left < right) {
      // If a character is not alphanumeric, skip it
      while (left < right && !Character.isLetterOrDigit(s.charAt(left))) {
        left++;
      }
      while (left < right && !Character.isLetterOrDigit(s.charAt(right))) {
        right--;
      }

      // Convert characters to lowercase before comparing
      if (Character.toLowerCase(s.charAt(left)) != Character.toLowerCase(s.charAt(right))) {
        return false;
      }
      left++;
      right--;
    }

    return true;
  }

  public static void main(String[] args) {
    System.out.println(isPalindrome("A man, a plan, a canal: Panama"));  // true
    System.out.println(isPalindrome("race a car"));  // false
    System.out.println(isPalindrome(" "));  // true
    System.out.println(isPalindrome(".,"));  // true
  }
}