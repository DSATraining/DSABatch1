Prefix Sum Technique
====================

The **Prefix Sum** technique is a powerful tool in array-based problems that involve calculating the sum of elements over a range or efficiently precomputing sums to answer queries quickly. It is widely used in competitive programming and interview scenarios due to its simplicity and effectiveness.

What is Prefix Sum?
-------------------

A prefix sum is an array where each element at index `i` contains the sum of all elements from the start of the array up to index `i`. This allows you to compute the sum of any subarray in constant time after preprocessing the prefix sum array.

### Algorithm

The algorithm works as follows:

*   Precompute the prefix sum array.
*   For any range `[i, j]`, the sum is calculated as: `sum[i..j] = prefixSum[j] - prefixSum[i-1]`.
*   If the range starts at the beginning of the array (`i = 0`), then the sum is simply `prefixSum[j]`.

Example: Range Sum Query
------------------------

### Problem Statement

Given an array of integers, preprocess it using prefix sum and efficiently find the sum of elements in any given range `[i, j]`.

### Code Implementation

    
    public class PrefixSum {
        public static void main(String[] args) {
            int[] nums = {2, 4, 6, 8, 10};
            int[] prefixSum = new int[nums.length];
    
            // Step 1: Compute the prefix sum array
            prefixSum[0] = nums[0];
            for (int i = 1; i < nums.length; i++) {
                prefixSum[i] = prefixSum[i - 1] + nums[i];
            }
    
            // Step 2: Define the range [i, j] for which we want the sum
            int i = 1, j = 3;
    
            // Step 3: Calculate the sum of the range [i, j]
            int rangeSum = prefixSum[j] - (i > 0 ? prefixSum[i - 1] : 0);
    
            // Output the result
            System.out.println("Sum of elements in range [" + i + ", " + j + "]: " + rangeSum);
            // Output: 18 (Subarray [4, 6, 8])
        }
    }
        

### Explanation

The prefix sum array stores the cumulative sums. For the example above, the prefix sum array would look like:

    
    nums       = [2, 4, 6, 8, 10]
    prefixSum  = [2, 6, 12, 20, 30]
        

To find the sum of elements from index `1` to `3`, subtract `prefixSum[0]` (the sum before index `1`) from `prefixSum[3]`:  
`prefixSum[3] - prefixSum[0] = 20 - 2 = 18`.

* * *

Example: Count Subarrays Divisible by K
---------------------------------------

### Problem Statement

Given an array of integers, find the number of subarrays whose sum is divisible by a given integer `K`. Use the prefix sum technique to optimize the solution.

### Algorithm

*   Use a map to track the count of prefix sums modulo `K`.
*   If two prefix sums have the same remainder when divided by `K`, the subarray sum between these indices is divisible by `K`.
*   Initialize the map with `{0: 1}` to account for cases where a prefix sum itself is divisible by `K`.

### Code Implementation

    
    import java.util.HashMap;
    
    public class SubarraysDivisibleByK {
        public static int countSubarraysDivisibleByK(int[] nums, int k) {
            HashMap<Integer, Integer> remainderMap = new HashMap<>();
            remainderMap.put(0, 1); // To handle cases where prefix sum is divisible by K
            int count = 0, prefixSum = 0;
    
            for (int num : nums) {
                prefixSum += num;
                int remainder = prefixSum % k;
    
                // Adjust for negative remainders
                if (remainder < 0) {
                    remainder += k;
                }
    
                // Check if this remainder has been seen before
                count += remainderMap.getOrDefault(remainder, 0);
    
                // Update the map
                remainderMap.put(remainder, remainderMap.getOrDefault(remainder, 0) + 1);
            }
    
            return count;
        }
    
        public static void main(String[] args) {
            int[] nums = {4, 5, 0, -2, -3, 1};
            int k = 5;
            System.out.println("Number of subarrays divisible by " + k + ": " + countSubarraysDivisibleByK(nums, k));
            // Output: 7
        }
    }
        

### Explanation

The key observation is that if two prefix sums have the same remainder when divided by `K`, the subarray between them is divisible by `K`. By using a hash map, we track how many times each remainder has occurred and use this to count valid subarrays.

* * *

Why Use Prefix Sum?
-------------------

*   It simplifies range sum calculations to constant time after an `O(n)` preprocessing step.
*   It is versatile and can be combined with other techniques like hash maps to solve complex problems.
