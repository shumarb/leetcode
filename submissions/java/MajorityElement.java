// Question: https://leetcode.com/problems/majority-element/description/

class MajorityElement {
    public int majorityElement(int[] nums) {
        /**
         Implemented Boyer-Moore Majority Voting Algorithm
         */
        int candidate = -1;
        int count = 0;

        for (int x: nums) {
            if (count == 0) {
                candidate = x;
            }
            count += ((x == candidate) ? 1 : -1);
        }

        return candidate;
    }
}