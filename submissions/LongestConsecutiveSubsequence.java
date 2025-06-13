// Question: https://leetcode.com/problems/longest-consecutive-sequence/description/

class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int len = nums.length;
        int longestConsecutive = 0;

        // 1. Edge case: number of elements <= 1.
        if (len <= 1) {
            return len;
        }

        /**
         2.  Populate set with elements,
             and iterate set by checking for a number that is the start of a sequence.
             While its increment is in the set, increase length of current sequence,
             else compare length of longest consecutive elements with length of current sequence.
             and update former accordingly.

             Iterate set to avoid redundant iterations.
             Example: [1 2 3 4 5] --> sequence: 1 2 3 4 5
             Iterating over set ensures only 1 2 3 4 5 check, but iteration over array
             results in 1 2 3 4 5, 2 3 4 5, ... being checked, which are unnecessary.
         */
        for (int number: nums) {
            set.add(number);
        }
        for (int number: set) {
            if (!set.contains(number - 1)) {
                int currentConsecutive = 1;
                while (set.contains(number + 1)) {
                    currentConsecutive++;
                    number++;
                }
                longestConsecutive = Math.max(currentConsecutive, longestConsecutive);
            }
        }

        return longestConsecutive;
    }
}