// 11. Container With Most Water
// https://leetcode.com/problems/container-with-most-water/
// https://www.youtube.com/watch?v=T0u5nwSA0w0&t=9685s

// You are given an integer array height of length n. There are n vertical lines drawn such that the two endpoints of the ith line are (i, 0) and (i, height[i]).
// Find two lines that together with the x-axis form a container, such that the container contains the most water.
// Return the maximum amount of water a container can store.
// Notice that you may not slant the container.

// Example 1:
// Input: height = [1,8,6,2,5,4,8,3,7]
// Output: 49
// Explanation: The above vertical lines are represented by array [1,8,6,2,5,4,8,3,7]. In this case, the max area of water (blue section) the container can contain is 49.

class Solution11 {
  public static int maxArea(int[] height) {
    int left = 0;
    int right = height.length - 1;
    int width = right - left;
    int max = 0;

    while (left < right) {
      // Get index of shortest height amongst left/right.  This is the tallest the container can be.
      // Keep the taller line to maximize area.  For the shorter line, increment if left pointer, decrement if right pointer
      int smaller_index = (height[left] < height[right]) ? left++ : right--;

      // Find area, which is the height of the shorter line times width
      // Decrement width at each turn, since we're always moving the pointers toward the middle
      max = Math.max(max, height[smaller_index] * width--);
    }
    return max;
  }

  public static void main(String[] args) {
    System.out.println(maxArea(new int[]{1,8,6,2,5,4,8,3,7}));  // 49
    System.out.println(maxArea(new int[]{1,1}));  // 1
  }
}