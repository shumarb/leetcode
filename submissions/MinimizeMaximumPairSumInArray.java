// Question: https://leetcode.com/problems/minimize-maximum-pair-sum-in-array/description/

class MinimizeMaximumPairSumInArray {
    public int minPairSum(int[] nums) {
        boolean isTest = false;
        int left = 0;
        int minPairSum = 0;
        int right = nums.length - 1;

        nums = sort(nums);
        if (isTest) {
            System.out.println("sorted nums: " + Arrays.toString(nums));
        }

        while (left < right) {
            minPairSum = Math.max(minPairSum, nums[left++] + nums[right--]);
        }

        return minPairSum;
    }

    private int[] sort(int[] nums) {
        int[] count;
        int j = 0;
        int largest = 0;

        for (int e: nums) {
            largest = Math.max(e, largest);
        }
        count = new int[largest + 1];
        for (int e: nums) {
            count[e]++;
        }

        for (int i = 1; i <= largest; i++) {
            while (count[i]-- > 0) {
                nums[j++] = i;
            }
        }

        return nums;
    }
}