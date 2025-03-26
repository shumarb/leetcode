// Question: https://leetcode.com/problems/special-array-i/description/

class SpecialArrayOne {
    public boolean isArraySpecial(int[] nums) {
        for (int i = 0; i < nums.length - 1; i++) {
            /**
             1.  A pair of numbers are both even or or odd
                 when their sum is an even number.
             */
            if ((nums[i] + nums[i + 1]) % 2 == 0) {
                return false;
            }
        }
        return true;
    }
}