// 217. Contains Duplicate
// https://leetcode.com/problems/contains-duplicate/
// https://www.youtube.com/watch?v=T0u5nwSA0w0&t=129s

// Given an integer array nums, return true if any value appears at least twice in the array, and return false if every element is distinct.

// Example 1:
// Input: nums = [1,2,3,1]
// Output: true
// Explanation: The element 1 occurs at the indices 0 and 3.

import java.util.HashSet;

class Solution217 {
    public static boolean containsDuplicate(int[] nums) {
        // Create HashSet to store elements from array
        HashSet<Integer> seenNumbers = new HashSet<>();
        
        for (int num : nums) {
            // Check if element is already in the HashSet
            if (seenNumbers.contains(num)) {
                return true;  // Duplicate found
            }
            // Add element to the HashSet
            seenNumbers.add(num);
        }
        return false;  // No duplicate found
    }
    
    public static void main (String[] args) {
        System.out.println(containsDuplicate(new int []{1,2,3,1}));  // true
        System.out.println(containsDuplicate(new int []{1,2,3,4}));  // false
        System.out.println(containsDuplicate(new int []{1,1,1,3,3,4,3,2,4,2}));  // true
    }
}