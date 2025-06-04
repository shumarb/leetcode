// Question: https://leetcode.com/problems/check-if-all-1s-are-at-least-length-k-places-away/description/

class CheckIfAll1sAreAtLeastKPlacesAway {
    public boolean kLengthApart(int[] nums, int k) {
        int last = -1;
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            if (nums[i] == 1) {
                if (last != -1 && i - last - 1 < k) {
                    return false;
                }
                last = i;
            }
        }
        return true;
    }
}