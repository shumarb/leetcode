// Question: https://leetcode.com/problems/find-indices-with-index-and-value-difference-i/description/

class FindIndicesWithIndexAndValueDifferenceOne {
    public int[] findIndices(int[] nums, int indexDifference, int valueDifference) {
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                if (Math.abs(i - j) >= indexDifference && Math.abs(nums[i] - nums[j]) >= valueDifference) {
                    return new int[] {i, j};
                }
            }
        }
        return new int[] {-1, -1};
    }
}