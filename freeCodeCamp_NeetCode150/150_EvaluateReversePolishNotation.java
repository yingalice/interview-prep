// 150. Evaluate Reverse Polish Notation
// https://leetcode.com/problems/evaluate-reverse-polish-notation/description/
// https://www.youtube.com/watch?v=T0u5nwSA0w0&t=19247s

// You are given an array of strings tokens that represents an arithmetic expression in a Reverse Polish Notation.
// Evaluate the expression. Return an integer that represents the value of the expression.
// Note that:
// The valid operators are '+', '-', '*', and '/'.
// Each operand may be an integer or another expression.
// The division between two integers always truncates toward zero.
// There will not be any division by zero.
// The input represents a valid arithmetic expression in a reverse polish notation.
// The answer and all the intermediate calculations can be represented in a 32-bit integer.
 
// Example 1:
// Input: tokens = ["2","1","+","3","*"]
// Output: 9
// Explanation: ((2 + 1) * 3) = 9

import java.util.Stack;

class Solution150 {
  public static int evalRPN(String[] tokens) {
    Stack<Integer> stack = new Stack<>();
    for (String token : tokens) {
      if (isOperator(token)) {  // token is an operator
        // Pop the last 2 numbers off the stack
        int b = stack.pop();  // Second operand
        int a = stack.pop();  // First operand
        stack.push(applyOperator(a, b, token)); // apply the operator on the 2 numbers, and add the result to the stack
      } else {  // token is a number
        stack.push(Integer.parseInt(token));  // add number to stack
      }
    }
    return stack.pop();
  }

  private static int applyOperator(int a, int b, String operator) {
    switch(operator){
      case "+": return a + b;
      case "-": return a - b;
      case "*": return a * b;
      case "/": return a / b;
      default: throw new IllegalArgumentException("Invalid operator");
    }
  }

  private static boolean isOperator(String token) {
    return token.equals("+") || token.equals("-") || token.equals("*") || token.equals("/");
  }

  public static void main(String[] args) {
    System.out.println(evalRPN(new String[] {"2","1","+","3","*"}));  // 9
    System.out.println(evalRPN(new String[] {"4","13","5","/","+"}));  // 6
    System.out.println(evalRPN(new String [] {"10","6","9","3","+","-11","*","/","*","17","+","5","+"}));  // 22
  }
}
