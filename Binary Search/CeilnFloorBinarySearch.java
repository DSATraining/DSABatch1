import java.util.*;

public class Solution {
    public static int[] searchRange(int[] nums, int target) {
        // Find the first occurrence (floor index) of the target.
        int left = 0, right = nums.length - 1;
        int firstPosition = -1;
        while (left <= right) {
            int mid = left + (right - left) / 2; // Calculate the middle index.

            if (nums[mid] == target) {
                firstPosition = mid; // Update the result to the current index.
                right = mid - 1; // Narrow search range to the left.
            } else if (nums[mid] < target) {
                left = mid + 1; // Target is on the right side.
            } else {
                right = mid - 1; // Target is on the left side.
            }
        }

        // Find the last occurrence (ceil index) of the target.
        left = 0;
        right = nums.length - 1;
        int lastPosition = -1;
        while (left <= right) {
            int mid = left + (right - left) / 2; // Calculate the middle index.

            if (nums[mid] == target) {
                lastPosition = mid; // Update the result to the current index.
                left = mid + 1; // Narrow search range to the right.
            } else if (nums[mid] < target) {
                left = mid + 1; // Target is on the right side.
            } else {
                right = mid - 1; // Target is on the left side.
            }
        }

        // Return the result as an array containing the first and last positions.
        return new int[]{firstPosition, lastPosition};
    }

    public static void main(String[] args) {
        int[] nums = {5, 7, 7, 8, 8, 10};
        int target = 8;
        System.out.println(Arrays.toString(searchRange(nums, target))); // Output: [3, 4]
    }
}
