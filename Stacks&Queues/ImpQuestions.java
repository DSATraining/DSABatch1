//1. Next Greater Element II (Circular Array)
//LeetCode: https://leetcode.com/problems/next-greater-element-ii/


import java.util.*;

public class NextGreaterElementII {
    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];
        Arrays.fill(result, -1); // Default to -1 for no greater element
        Stack<Integer> stack = new Stack<>(); // Store indices

        // Loop twice to simulate circular behavior
        for (int i = 0; i < 2 * n; i++) {
            int idx = i % n;
            while (!stack.isEmpty() && nums[stack.peek()] < nums[idx]) {
                result[stack.pop()] = nums[idx];
            }
            // Only push index in first pass
            if (i < n) {
                stack.push(idx);
            }
        }

        return result;
    }
}


//2. Daily Temperatures (Next Greater Element Variant)
//LeetCode: https://leetcode.com/problems/daily-temperatures/

import java.util.*;

public class DailyTemperatures {
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] result = new int[n];
        Stack<Integer> stack = new Stack<>(); // Store indices

        for (int i = 0; i < n; i++) {
            // Pop until we find a day with a higher temperature
            while (!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]) {
                int prevIndex = stack.pop();
                result[prevIndex] = i - prevIndex;
            }
            stack.push(i);
        }

        return result;
    }
}


// 3. Next Smaller Element (Non-Circular Array)

import java.util.*;

public class NextSmallerElement {
    public int[] nextSmallerElements(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];
        Stack<Integer> stack = new Stack<>();

        // Traverse from right to left
        for (int i = n - 1; i >= 0; i--) {
            // Remove elements that are greater or equal
            while (!stack.isEmpty() && stack.peek() >= nums[i]) {
                stack.pop();
            }
            result[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(nums[i]);
        }

        return result;
    }
}



// 4. Previous Smaller Element

import java.util.*;

public class PreviousSmallerElement {
    public int[] previousSmallerElements(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];
        Stack<Integer> stack = new Stack<>();

        // Traverse from left to right
        for (int i = 0; i < n; i++) {
            // Remove elements that are greater or equal
            while (!stack.isEmpty() && stack.peek() >= nums[i]) {
                stack.pop();
            }
            result[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(nums[i]);
        }

        return result;
    }
}
