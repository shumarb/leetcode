class Solution {
    public int removeDuplicates(int[] nums) {
        int l = 0;
        int r = 0;
        while (r < nums.length) {
            // 1. Values at indices l and r are the same
            if (nums[l] == nums[r]) {
                r++;
            } else {
                // 2. Values at indices l & r are different
                nums[++l] = nums[r];
            }
        }
        return l + 1;
    }
}

