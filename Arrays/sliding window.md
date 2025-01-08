Sliding Window Approach
=======================

The sliding window technique is a powerful approach for solving problems involving arrays or strings, where you need to process a contiguous segment of elements. This method is particularly effective when the problem involves finding the maximum, minimum, or certain properties of subarrays or substrings.

Example: Maximum Sum Subarray of Fixed Size K
---------------------------------------------

### Problem Statement

Given an array of integers and an integer `K`, find the maximum sum of a subarray of size `K`.

### Algorithm

The idea is to use a sliding window of fixed size:

*   Initialize the sum of the first window of size `K`.
*   Slide the window by removing the first element and adding the next element in the array.
*   Keep track of the maximum sum encountered.

### Code Implementation

    
    public class FixedSizeSlidingWindow {
        public static int maxSumSubarray(int[] nums, int k) {
            int maxSum = 0;
            int currentSum = 0;
    
            // Calculate the sum of the first window
            for (int i = 0; i < k; i++) {
                currentSum += nums[i];
            }
            maxSum = currentSum;
    
            // Slide the window
            for (int i = k; i < nums.length; i++) {
                currentSum += nums[i] - nums[i - k];
                maxSum = Math.max(maxSum, currentSum);
            }
    
            return maxSum;
        }
    
        public static void main(String[] args) {
            int[] nums = {2, 1, 5, 1, 3, 2};
            int k = 3;
            System.out.println("Maximum Sum of Subarray of Size K: " + maxSumSubarray(nums, k));
            // Output: 9 (Subarray [5, 1, 3])
        }
    }
        

### Explanation

This approach computes the sum of the first window of size `K` and then iteratively adjusts the window by adding the next element and removing the first element of the previous window. This keeps the complexity at `O(n)`.

* * *

Example: Maximum Length of Subarray with Consecutive Same Numbers
-----------------------------------------------------------------

### Problem Statement

Given an array of integers, find the length of the longest subarray where all elements are the same. The size of the subarray can vary.

### Algorithm

The idea is to maintain a window that contains consecutive elements with the same value:

*   Initialize a `start` pointer at the beginning of the array.
*   Iterate through the array with an `end` pointer to expand the window.
*   If the current element is not the same as the previous one, update the `start` pointer to the current index.
*   Update the maximum length of the subarray as `end - start + 1`.

### Code Implementation

    
    public class VariableSizeSlidingWindow {
        public static int maxLengthConsecutiveSame(int[] nums) {
            int maxLength = 0;
            int start = 0;
    
            for (int end = 0; end < nums.length; end++) {
                // If the current element is not the same as the previous one
                if (end > 0 && nums[end] != nums[end - 1]) {
                    start = end; // Reset the window
                }
                // Update the maximum length
                maxLength = Math.max(maxLength, end - start + 1);
            }
    
            return maxLength;
        }
    
        public static void main(String[] args) {
            int[] nums = {1, 1, 2, 2, 2, 3, 3};
            System.out.println("Maximum Length of Subarray with Consecutive Same Numbers: " + maxLengthConsecutiveSame(nums));
            // Output: 3 (Subarray [2, 2, 2])
        }
    }
        

### Explanation

The subarray with consecutive same numbers can be efficiently tracked using two pointers. The `start` pointer resets whenever the current number differs from the previous number.

This approach runs in `O(n)` time and uses constant space.
