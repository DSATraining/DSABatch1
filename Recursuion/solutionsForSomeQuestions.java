Q.13 (leetcode 3211) commented code with solution :-->
https://leetcode.com/problems/generate-binary-strings-without-adjacent-zeros/submissions/1344561955/

Q14. (leetcode 494) commented code with solutions :---->
https://leetcode.com/problems/target-sum/submissions/1344564937/

Q15. Generate all subsequence of a string using recursion.
public class SubsequenceGenerator {
    public static void main(String[] args) {
        // Input string
        String inputString = "64391";
        
        // Call the helper method to generate all subsequences
        generateSubsequences(inputString, "", 0);
    }

    // Recursive method to generate all subsequences
    private static void generateSubsequences(String input, String currentSubsequence, int index) {
        // Base case: If the index is beyond the end of the input string
        if (index >= input.length()) {
            // Print the current subsequence
            System.out.println(currentSubsequence);
            return;
        }
        
        // Recursive case 1: Include the current character in the subsequence
        generateSubsequences(input, currentSubsequence + input.charAt(index), index + 1);
        
        // Recursive case 2: Exclude the current character from the subsequence
        generateSubsequences(input, currentSubsequence, index + 1);
    }
}
