// Question: https://leetcode.com/problems/maximum-sum-with-exactly-k-elements/description/

class MaximumSumWithExactlyKElements {
    public int maximizeSum(int[] nums, int k) {
        int maximumSum = 0;
        int maximum = 0;

        /**
            1.  Find the maximum element (m) in nums.
         */
        for (int number: nums) {
            maximum = Math.max(maximum, number);
        }

        /**
             2.  Since m is >= all elements,
                 (m + 1) > all elements for each of remaining iterations.
         */
        for (int i = 0; i < k; i++) {
            maximumSum += maximum;
            maximum++;
        }

        return maximumSum;
    }
}