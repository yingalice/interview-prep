// 49. Group Anagrams
// https://leetcode.com/problems/group-anagrams/description/
// https://leetcode.com/problems/group-anagrams/solutions/3687735/beats-100-c-java-python-beginner-friendly/
// https://www.youtube.com/watch?v=T0u5nwSA0w0&t=1701

// Given an array of strings strs, group the anagrams together. You can return the answer in any order.

// Example 1:
// Input: strs = ["eat","tea","tan","ate","nat","bat"]
// Output: [["bat"],["nat","tan"],["ate","eat","tea"]]
// Explanation:
// There is no string in strs that can be rearranged to form "bat".
// The strings "nat" and "tan" are anagrams as they can be rearranged to form each other.
// The strings "ate", "eat", and "tea" are anagrams as they can be rearranged to form each other.

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution49 {
    public static List<List<String>> groupAnagrams(String[] strs) {
      Map<String, List<String>> map = new HashMap<>();

      for (String word : strs) {
        char[] chars = word.toCharArray();
        Arrays.sort(chars);

        String sortedWord = new String(chars);
        if (!map.containsKey(sortedWord)) {
          map.put(sortedWord, new ArrayList<>());
        }
        map.get(sortedWord).add(word);
      }

      return new ArrayList<>(map.values());
    }

    public static void main(String[] args) {
      System.out.println(groupAnagrams(new String[] {"eat","tea","tan","ate","nat","bat"}));  // [[eat, tea, ate], [bat], [tan, nat]]
      System.out.println(groupAnagrams(new String[] {}));  // []
      System.out.println(groupAnagrams(new String[] {"a"}));  // [[a]]
    }
}
