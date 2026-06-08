// Question: https://leetcode.com/problems/move-zeroes/description/

class MoveZeroes {
    public void moveZeroes(int[] nums) {
        int i = 0;

        for (int e: nums) {
            if (e != 0) {
                nums[i++] = e;
            }
        }
        while (i < nums.length) {
            nums[i++] = 0;
        }
    }
}
