Two Pointers Approach
=====================

The two pointers approach is an efficient technique often used to solve problems involving arrays or strings. It works by having two pointers traverse the data structure in different ways to achieve the desired result in optimal time complexity.

Key Intuition
-------------

The two pointers approach is particularly useful for problems where:

*   You need to find a pair of elements that satisfy a condition.
*   You need to minimize or maximize a function over a sorted array or string.
*   You need to perform operations on a subarray or substring.

Example 1: Best Time to Buy and Sell Stock
------------------------------------------

This problem involves finding the maximum profit you can achieve by buying and selling a stock on different days. The two pointers approach can efficiently solve this in linear time.

### Algorithm

1.  Use one pointer, `minPrice`, to track the minimum price seen so far.
2.  Use another variable, `maxProfit`, to track the maximum profit achieved so far.
3.  Iterate through the array, updating `minPrice` and calculating the potential profit at each step.

### Code Implementation

    
    public class BestTimeToBuySellStock {
        public static int maxProfit(int[] prices) {
            int minPrice = Integer.MAX_VALUE; // Track the minimum price seen so far
            int maxProfit = 0; // Track the maximum profit
    
            for (int price : prices) {
                if (price < minPrice) {
                    minPrice = price; // Update minPrice if a lower price is found
                } else {
                    maxProfit = Math.max(maxProfit, price - minPrice); // Calculate potential profit
                }
            }
    
            return maxProfit;
        }
    
        public static void main(String[] args) {
            int[] prices = {7, 1, 5, 3, 6, 4};
            System.out.println("Maximum Profit: " + maxProfit(prices)); // Output: 5
        }
    }
        

Example 2: Two Sum (Input Array Is Sorted)
------------------------------------------

In this problem, you are given a sorted array and a target sum. You need to find two numbers such that their sum equals the target. The two pointers approach allows us to solve this in linear time.

### Algorithm

1.  Use two pointers, `left` and `right`, initially pointing to the start and end of the array.
2.  Calculate the sum of the elements at the pointers.
3.  If the sum matches the target, return the indices.
4.  If the sum is less than the target, increment the `left` pointer to increase the sum.
5.  If the sum is greater than the target, decrement the `right` pointer to decrease the sum.

### Code Implementation

    
    public class TwoSumSortedArray {
        public static int[] twoSum(int[] numbers, int target) {
            int left = 0; // Start pointer
            int right = numbers.length - 1; // End pointer
    
            while (left < right) {
                int sum = numbers[left] + numbers[right]; // Calculate the sum
    
                if (sum == target) {
                    return new int[]{left + 1, right + 1}; // Return 1-based indices
                } else if (sum < target) {
                    left++; // Increase the sum
                } else {
                    right--; // Decrease the sum
                }
            }
    
            return new int[]{-1, -1}; // If no solution is found
        }
    
        public static void main(String[] args) {
            int[] numbers = {2, 7, 11, 15};
            int target = 9;
            System.out.println(Arrays.toString(twoSum(numbers, target))); // Output: [1, 2]
        }
    }
        

Advantages of Two Pointers
--------------------------

*   Optimal for sorted arrays or strings.
*   Reduces time complexity to `O(n)` in many cases.
*   Easy to implement and intuitive for specific problems.

Practice Problems
-----------------

*   [Best Time to Buy and Sell Stock](https://leetcode.com/problems/best-time-to-buy-and-sell-stock/)
*   [Two Sum II - Input Array Is Sorted](https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/)
