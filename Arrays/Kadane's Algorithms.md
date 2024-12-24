<body>
    <h1>Kadane's Algorithm</h1>
    <p>Kadane's algorithm provides an efficient way to calculate the largest sum of a subarray with a linear time complexity <code>O(n)</code>.</p>

  <h2>Key Intuition</h2>
  <p>
      Since we are looking for the largest sum, it is a good idea to avoid negative numbers because they will decrease the sum. 
      However, there are scenarios where including a negative number is beneficial. 
  </p>
  <div class="highlight">
      <p>For example:</p>
      <ul>
          <li>In the array <code>[6, -2, 7]</code>, the maximum sum is <b>11</b>. Including <code>-2</code> is necessary to connect <code>6</code> and <code>7</code>.</li>
          <li>In the array <code>[1, -3, 7]</code>, the maximum sum is <b>7</b>. Including <code>-3</code> would decrease the sum unnecessarily.</li>
      </ul>
  </div>

  <h2>Pattern Recognition</h2>
  <p>
      If we encounter a negative subarray sum, we discard it and start a new subarray. This is because including it will only reduce the total sum further.
  </p>

  <h2>Algorithm Steps</h2>
  <ol>
      <li>
          <b>Track the Current Sum:</b> Initialize <code>curSum</code> to <code>0</code>. Add the current element to it while iterating through the array.
      </li>
      <li>
          <b>Reset on Negative:</b> If <code>curSum</code> becomes negative, reset it to <code>0</code>.
      </li>
      <li>
          <b>Initialize Maximum Sum:</b> Set <code>maxSum</code> to the first element of the array (or any single element if preferred).
      </li>
      <li>
          <b>Update Maximum Sum:</b> At each step, update <code>maxSum</code> to be the maximum of <code>curSum</code> and the current <code>maxSum</code>.
      </li>
  </ol>

  <h2>Edge Case</h2>
  <p>If all elements in the array are negative, the maximum sum will be the largest negative number. Kadane's algorithm handles this by initializing <code>maxSum</code> to the first element.</p>

  <h2>Code Implementation</h2>
    <pre><code>
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
  </code></pre>
  <p>For example, running <code>kadane([6, -2, 7])</code> will return <code>11</code>.</p>
</body>
