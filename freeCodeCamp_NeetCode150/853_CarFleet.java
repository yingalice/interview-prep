
// 853. Car Fleet
// https://leetcode.com/problems/car-fleet/description/
// https://www.youtube.com/watch?v=T0u5nwSA0w0&t=21611s

// There are n cars at given miles away from the starting mile 0, traveling to reach the mile target.
// You are given two integer array position and speed, both of length n, where position[i] is the starting mile of the ith car and speed[i] is the speed of the ith car in miles per hour.
// A car cannot pass another car, but it can catch up and then travel next to it at the speed of the slower car.
// A car fleet is a car or cars driving next to each other. The speed of the car fleet is the minimum speed of any car in the fleet.
// If a car catches up to a car fleet at the mile target, it will still be considered as part of the car fleet.
// Return the number of car fleets that will arrive at the destination.

// Example 1:
// Input: target = 12, position = [10,8,0,5,3], speed = [2,4,1,1,3]
// Output: 3

// Explanation:
// The cars starting at 10 (speed 2) and 8 (speed 4) become a fleet, meeting each other at 12. The fleet forms at target.
// The car starting at 0 (speed 1) does not catch up to any other car, so it is a fleet by itself.
// The cars starting at 5 (speed 1) and 3 (speed 3) become a fleet, meeting each other at 6. The fleet moves at speed 1 until it reaches target.

import java.util.Arrays;

class Solution853 {
  public int carFleet(int target, int[] position, int[] speed) {
    int n = position.length;
    float[][] cars = new float[n][2];
    
    for (int i = 0; i < n; i++) {
      cars[i][0] = position[i];  // position
      cars[i][1] = (float)(target - position[i]) / speed[i];  // time it takes to reach destination if they were to continue at initial speed
    }
    Arrays.sort(cars, (a, b) -> Float.compare(b[0], a[0]));  // Sort by position, descending order
    // System.out.println(Arrays.deepToString(cars));
    
    int count = 0;
    float prevTime = 0;
    for (int i = 0; i < n; i++) {
      if (cars[i][1] > prevTime) {  // Key: Cars can't overtake each other, so if a car has a lower time, they'll be stuck behind another car
        count++;                    // Add a fleet whenever you encounter a higher time, and use that as the new base time
        prevTime = cars[i][1];
      }
    }

    return count;
  }

  public static void main(String[] args) {
    Solution853 solution = new Solution853();
    System.out.println(solution.carFleet(12, new int[] {10,8,0,5,3}, new int[] {2,4,1,1,3}));  // 3
    System.out.println(solution.carFleet(10, new int[] {3}, new int[] {3}));  // 1
    System.out.println(solution.carFleet(100, new int[] {0,2,4}, new int[] {4,2,1}));  // 1
    System.out.println(solution.carFleet(10, new int[] {6, 8}, new int[] {3, 2}));  // 2

  }
}