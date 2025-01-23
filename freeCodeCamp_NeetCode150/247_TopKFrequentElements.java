// 347. Top K Frequent Elements
// https://leetcode.com/problems/top-k-frequent-elements/description/
// https://www.youtube.com/watch?v=T0u5nwSA0w0&t=2465s

// Given an integer array nums and an integer k, return the k most frequent elements. You may return the answer in any order.

// Example 1:
// Input: nums = [1,1,1,2,2,3], k = 2
// Output: [1,2]

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

class Solution247 {
  public static int[] topKFrequent(int[] nums, int k) {

    // 1. Build hash map: character and how often it appears
    Map<Integer, Integer> map = new HashMap<>();
    for (int num : nums) {
      map.put(num, map.getOrDefault(num, 0) + 1);
    }

    // init heap 'the less frequent element first'
    Queue<Integer> heap = new PriorityQueue<>((a, b) -> map.get(a) - map.get(b));

    // 2. Keep k top frequent elements in the heap
    for (int key : map.keySet()) {
      heap.add(key);
      if (heap.size() > k) {
        heap.poll();
      }
    }

    // 3. Build an output array
    int[] answer = new int[k];
    for (int i = 0; i < k; i++) {
      answer[i] = heap.poll();
    }

    return answer;
  }

  public static void main(String[] args) {
    System.out.println(Arrays.toString(topKFrequent(new int[] {1,1,1,2,2,3}, 2)));  // [2, 1]
    System.out.println(Arrays.toString(topKFrequent(new int[] {1}, 1)));  // [1]
  }
}