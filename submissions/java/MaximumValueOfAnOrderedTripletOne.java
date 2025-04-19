// Question: https://leetcode.com/problems/maximum-value-of-an-ordered-triplet-i/description/

class MaximumValueOfAnOrderedTripletOne {
    public long maximumTripletValue(int[] nums) {
        int len = nums.length;
        long maximumTripletValue = 0;

        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j < len; j++) {
                for (int k = j + 1; k < len; k++) {
                    long currentTripletValue = ((long) nums[i] - (long) nums[j]) * (long) nums[k];
                    if (currentTripletValue > 0) {
                        maximumTripletValue = Math.max(maximumTripletValue, currentTripletValue);
                    }
                }
            }
        }

        return maximumTripletValue;
    }
}