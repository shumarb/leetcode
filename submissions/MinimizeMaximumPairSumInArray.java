// Question: https://leetcode.com/problems/minimize-maximum-pair-sum-in-array/description/

class MinimizeMaximumPairSumInArray {
    public int minPairSum(int[] nums) {
        boolean isTest = false;
        int left = 0;
        int result = Integer.MIN_VALUE;
        int right = nums.length - 1;

        nums = sort(nums);
        if (isTest) {
            System.out.println("sorted nums: " + Arrays.toString(nums));
        }
        while (left < right) {
            int sum = nums[left] + nums[right];
            if (isTest) {
                System.out.println("--------------------------\nleft: " + left + " -> e: " + nums[left]);
                System.out.println("right: " + right + " -> e: " + nums[right]);
                System.out.println("sum: " + sum + " | result: " + result);
            }
            result = Math.max(sum, result);
            left++;
            right--;
        }
        if (isTest) {
            System.out.println("--------------------------\nresult: " + result);
        }

        return result;
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