Kadane's Algorithm
==================

Kadane's algorithm provides an efficient way to calculate the largest sum of a subarray with a linear time complexity `O(n)`.

Key Intuition
-------------

Since we are looking for the largest sum, it is a good idea to avoid negative numbers because they will decrease the sum. However, there are scenarios where including a negative number is beneficial.

For example:

*   In the array `[6, -2, 7]`, the maximum sum is **11**. Including `-2` is necessary to connect `6` and `7`.
*   In the array `[1, -3, 7]`, the maximum sum is **7**. Including `-3` would decrease the sum unnecessarily.

Pattern Recognition
-------------------

If we encounter a negative subarray sum, we discard it and start a new subarray. This is because including it will only reduce the total sum further.

Algorithm Steps
---------------

1.  **Track the Current Sum:** Initialize `curSum` to `0`. Add the current element to it while iterating through the array.
2.  **Reset on Negative:** If `curSum` becomes negative, reset it to `0`.
3.  **Initialize Maximum Sum:** Set `maxSum` to the first element of the array (or any single element if preferred).
4.  **Update Maximum Sum:** At each step, update `maxSum` to be the maximum of `curSum` and the current `maxSum`.

Edge Case
---------

If all elements in the array are negative, the maximum sum will be the largest negative number. Kadane's algorithm handles this by initializing `maxSum` to the first element.

Code Implementation
-------------------

    
    public class KadanesAlgorithm {
        public static int maxSubArray(int[] nums) {
            int maxSum = nums[0]; // Initialize maxSum to the first element
            int curSum = 0;       // Initialize curSum to 0
            for (int num : nums) {
                if (curSum < 0) {
                    curSum = 0;  // Reset curSum if it's negative
                }
                curSum += num;    // Add the current number to curSum
                maxSum = Math.max(maxSum, curSum); // Update maxSum if curSum is larger
            }
            return maxSum;
      }
      

For example, running `kadane([6, -2, 7])` will return `11`.
