
// 22. Generate Parentheses
// https://leetcode.com/problems/generate-parentheses/description/
// https://www.youtube.com/watch?v=T0u5nwSA0w0&t=19833s

// Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.

// Example 1:
// Input: n = 3
// Output: ["((()))","(()())","(())()","()(())","()()()"]

import java.util.ArrayList;
import java.util.List;

class Solution22 {
  public List<String> generateParenthesis(int n) {
    List<String> list = new ArrayList<>();
    backtrack(list, new StringBuilder(), 0, 0, n);
    return list;
  }

  public void backtrack(List<String> list, StringBuilder ans, int open, int close, int n) {
    // End case: have 2n characters (all pairs)
    if (ans.length() == (n * 2)) {
      list.add(ans.toString());  // Add answer to list
      return;
    }

    if (open < n) {  // Fewer than the maximum open parentheses
      ans.append("(");  // Append open parentheses to answer
      backtrack(list, ans, open + 1, close, n);
      // StringBuilder is mutable. This means that any changes you make to the StringBuilder 
      // within one recursive call will be reflected in subsequent recursive calls, unless you backtrack
      ans.deleteCharAt(ans.length() - 1);
    }

    if (close < open) {  // Can only close if there's a matching open parentheses first
      ans.append(")");  // Append close parentheses to answer
      backtrack(list, ans, open, close + 1, n);
      ans.deleteCharAt(ans.length() - 1);
    }
  }

  public static void main(String[] args) {
    Solution22 solution = new Solution22();
    System.out.println(solution.generateParenthesis(3));  // ["((()))","(()())","(())()","()(())","()()()"]
    System.out.println(solution.generateParenthesis(1));  // ["()"]
  }
}