// 36. Valid Sudoku
// https://leetcode.com/problems/valid-sudoku/description/
// https://leetcode.com/problems/valid-sudoku/solutions/15472/short-simple-java-using-strings/
// https://www.youtube.com/watch?v=T0u5nwSA0w0&t=4116s

// Determine if a 9 x 9 Sudoku board is valid. Only the filled cells need to be validated according to the following rules:

// Each row must contain the digits 1-9 without repetition.
// Each column must contain the digits 1-9 without repetition.
// Each of the nine 3 x 3 sub-boxes of the grid must contain the digits 1-9 without repetition.
// Note:

// A Sudoku board (partially filled) could be valid but is not necessarily solvable.
// Only the filled cells need to be validated according to the mentioned rules.

// Example 1:
// Input: board = 
// [["5","3",".",".","7",".",".",".","."]
// ,["6",".",".","1","9","5",".",".","."]
// ,[".","9","8",".",".",".",".","6","."]
// ,["8",".",".",".","6",".",".",".","3"]
// ,["4",".",".","8",".","3",".",".","1"]
// ,["7",".",".",".","2",".",".",".","6"]
// ,[".","6",".",".",".",".","2","8","."]
// ,[".",".",".","4","1","9",".",".","5"]
// ,[".",".",".",".","8",".",".","7","9"]]
// Output: true

import java.util.HashSet;
import java.util.Set;

class Solution36 {
  public static boolean isValidSudoku(char[][] board) {
    Set<String> seen = new HashSet<>();
    for (int i = 0; i < 9; i++) {
      for (int j = 0; j < 9; j++) {
        char value = board[i][j];

        // Add all row/col/block data in a single HashSet
        // If there's a problem adding, that means there's a duplicate, so return false
        if (value != '.')
          if (!seen.add(value + " in row " + i) ||
              !seen.add(value + " in col " + j) ||
              !seen.add(value + " in block " + i/3 + "/" + j/3))
              return false;
      }
    }
    return true;
  }

  public static void main(String[] args) {
    System.out.println(isValidSudoku(new char[][] {{'5','3','.','.','7','.','.','.','.'},{'6','.','.','1','9','5','.','.','.'},{'.','9','8','.','.','.','.','6','.'},{'8','.','.','.','6','.','.','.','3'},{'4','.','.','8','.','3','.','.','1'},{'7','.','.','.','2','.','.','.','6'},{'.','6','.','.','.','.','2','8','.'},{'.','.','.','4','1','9','.','.','5'},{'.','.','.','.','8','.','.','7','9'}}));  // true
    System.out.println(isValidSudoku(new char[][] {{'8','3','.','.','7','.','.','.','.'},{'6','.','.','1','9','5','.','.','.'},{'.','9','8','.','.','.','.','6','.'},{'8','.','.','.','6','.','.','.','3'},{'4','.','.','8','.','3','.','.','1'},{'7','.','.','.','2','.','.','.','6'},{'.','6','.','.','.','.','2','8','.'},{'.','.','.','4','1','9','.','.','5'},{'.','.','.','.','8','.','.','7','9'}}));  // false
  }
}