// Question: https://leetcode.com/problems/special-array-i/description/

class SpecialArrayOne {
    public boolean isArraySpecial(int[] nums) {
        for (int i = 0; i < nums.length - 1; i++) {
            /**
             1.  If the sum of a pair of numbers is even,
                 both numbers are either even or odd.
             */
            if ((nums[i] + nums[i + 1]) % 2 == 0) {
                return false;
            }
        }
        return true;
    }
}