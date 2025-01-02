class Solution {
    public int removeDuplicates(int[] nums) {
        int l = 0;
        int r = 0;
        while (r < nums.length) {
            if (nums[l] == nums[r]) {
                r++;
            } else {
                nums[++l] = nums[r];
            }
        }
        return l + 1;
    }
}

