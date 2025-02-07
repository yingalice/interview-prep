// 20. Valid Parentheses
// https://leetcode.com/problems/valid-parentheses/description/
// https://www.youtube.com/watch?v=T0u5nwSA0w0&t=18014s

// Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
// An input string is valid if:

// Open brackets must be closed by the same type of brackets.
// Open brackets must be closed in the correct order.
// Every close bracket has a corresponding open bracket of the same type.
 
// Example 1:
// Input: s = "()"
// Output: true

import java.util.HashMap;
import java.util.Stack;

class Solution20 {
  public static boolean isValid(String s) {
    HashMap<Character, Character> parenthesesPairs = new HashMap<>();
    parenthesesPairs.put(')','(');
    parenthesesPairs.put('}','{');
    parenthesesPairs.put(']','[');

    Stack<Character> stack = new Stack<>();
    for (char c : s.toCharArray()) {
      // c is open parentheses
      if (!parenthesesPairs.containsKey(c)) {
        stack.push(c);  // Add open parentheses to stack
      } else {  // c is close parentheses
        if (stack.isEmpty()) {
          return false;  // No corresponding open parentheses
        }
        char topElement = stack.pop();
        if (parenthesesPairs.get(c) != topElement) {
          return false;  // Closing parentheses doesn't match open parentheses
        }
      }
    }

    return stack.isEmpty();  // If nothing left on stack, all parentheses have been closed out
  }

  public static void main(String[] args) {
    System.out.println(isValid("()"));  // true
    System.out.println(isValid("()[]{}"));  // true
    System.out.println(isValid("(]"));  // false
    System.out.println(isValid("([])"));  // true
  }
}