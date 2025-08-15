// Question: https://leetcode.com/problems/longest-alternating-subarray/description/

class LongestAlternatingSubarray {
    public int alternatingSubarray(int[] nums) {
        int longestLength = -1;
        int n = nums.length;

        for (int i = 0; i < n - 1; ) {
            int current = nums[i];
            int next = nums[i + 1];

            if (next - current != 1) {
                i++;
                continue;
            }

            /**
             1.  [current, next] is an alternating subarray.
                 Hence, it's current length is 2.
                 Find the longest alternating subarray whose
                 first two numbers are current and next,
                 starting from the third number
                 (first number is at index i --> third number is at index (i + 2)).
             */
            int currentLength = 2;
            int j = i + 2;
            for (; j < n; j++) {
                if (nums[j] != nums[j - 2]) {
                    break;
                } else {
                    currentLength++;
                }
            }

            longestLength = Math.max(currentLength, longestLength);

            /**
                 2.  Optimization:
                     Since the pattern broke at index j,
                     we can start the next index from j - 1 (last valid index),
                     as earlier indices won't lead to a longer valid subarray.
             */
            i = j - 1;
        }

        return longestLength;
    }
}