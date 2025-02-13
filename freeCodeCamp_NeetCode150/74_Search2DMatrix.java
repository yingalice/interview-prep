// 74. Search a 2D Matrix
// https://leetcode.com/problems/search-a-2d-matrix/description/
// https://www.youtube.com/watch?v=T0u5nwSA0w0&t=24400s

// You are given an m x n integer matrix matrix with the following two properties:
// - Each row is sorted in non-decreasing order.
// - The first integer of each row is greater than the last integer of the previous row.
// Given an integer target, return true if target is in matrix or false otherwise.

// You must write a solution in O(log(m * n)) time complexity.

// Input: matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 3
// Output: true

class Solution74 {
  public boolean searchMatrix(int[][] matrix, int target) {
    int m = matrix.length;
    int n = matrix[0].length;

    // Number each box to treat it as a 1d instead of 2d array, since it's already sorted in increasing order
    int left = 0;
    int right = (m * n) - 1;

    while (left <= right) {
      int mid = (left + right) / 2;
      int currentValue = matrix[mid / n][mid % n];  // Find the value at the midpoint, by converting to its position in the 2d array
      if (currentValue < target) {  // Target in upper half
        left = mid + 1;
      } else if (currentValue > target) {  // Target in lower half
        right = mid - 1;
      } else {
        return true;  // Found target
      }
    }

    return false;  // Did not find target
  }

  public static void main(String[] args) {
    Solution74 solution = new Solution74();
    System.out.println(solution.searchMatrix(new int[][]{{1,3,5,7},{10,11,16,20},{23,30,34,60}}, 3));  // true
    System.out.println(solution.searchMatrix(new int[][]{{1,3,5,7},{10,11,16,20},{23,30,34,60}}, 13));  // false
  }
}