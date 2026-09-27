// Question: https://leetcode.com/problems/rearrange-array-by-removing-distinct-values/description/

class RearrangeArrayByRemovingDistinctValues {
    public int[] rearrangeArray(int[] nums) {
        boolean isTest = false;
        int[] count = new int[101];
        int index = 0;
        int n = nums.length;

        if (n == 1) {
            return nums;
        }

        if (isTest) {
            System.out.println("before, nums: " + Arrays.toString(nums));
        }
        for (int e: nums) {
            count[e]++;
        }

        while (index != n) {
            for (int i = 0; i < count.length; i++) {
                if (count[i] > 0) {
                    nums[index++] = i;
                    count[i]--;
                }
            }
        }
        if (isTest) {
            System.out.println("after, nums:  " + Arrays.toString(nums));
        }

        return nums;
    }
}
