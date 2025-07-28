// Question: https://leetcode.com/problems/maximum-strong-pair-xor-i/description/

class MaximumStrongPairXorOne {
    public int maximumStrongPairXor(int[] nums) {
        int len = nums.length;
        int maximumStrongPairXor = 0;

        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j < len; j++) {
                int current = nums[i];
                int next = nums[j];
                if (Math.abs(current - next) <= Math.min(current, next)) {
                    maximumStrongPairXor = Math.max(maximumStrongPairXor, current ^ next);
                }
            }
        }

        return maximumStrongPairXor;
    }
}