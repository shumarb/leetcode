// Question: https://leetcode.com/problems/absolute-difference-between-maximum-and-minimum-k-elements/description/

class AbsoluteDifferenceBetweenMaximumAndMinimumKElements {
    public int absDifference(int[] nums, int k) {
        boolean isTest = false;
        int count = k;
        int j = 0;
        int kLargest = 0;
        int kSmallest = 0;
        int n = nums.length;

        nums = sort(nums);
        while (j < n && count-- > 0) {
            kSmallest += nums[j++];
        }
        count = k;
        j = nums.length - 1;
        while (j >= 0 && count-- > 0) {
            kLargest += nums[j--];
        }
        if (isTest) {
            System.out.println("sorted nums: " + Arrays.toString(nums) + "\nkLargest: " + kLargest);
            System.out.println("kSmallest: " + kSmallest + "\nresult: " + Math.abs(kLargest - kSmallest));
        }

        return Math.abs(kLargest - kSmallest);
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