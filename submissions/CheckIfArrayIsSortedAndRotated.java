// Question: https://leetcode.com/problems/check-if-array-is-sorted-and-rotated/description/

class CheckIfArrayIsSortedAndRotated {
    public boolean check(int[] nums) {
        int count = 0;
        int len = nums.length;

        /**
         1.  Compare 2 elements at indices i and (i + 1) % len
             and count the number of times element decreases
             from index i to index (i + 1) % len.
             Sorted and rotated arrays have a count of <= 1.
         */
        for (int i = 0; i < len; i++) {
            int next = (i + 1) % len;
            if (nums[next] < nums[i]) {
                count++;
            }
        }

        return count <= 1;
    }
}