// Question: https://leetcode.com/problems/max-number-of-k-sum-pairs/description/

class MaxNumberOfKSumPairs {
    public int maxOperations(int[] nums, int k) {
        boolean isTest = false;
        int left = 0;
        int result = 0;
        int right = nums.length - 1;

        Arrays.sort(nums);
        while (left < right) {
            long sum = (long) (nums[left] + nums[right]);
            if (sum == k) {
                if (isTest) {
                    System.out.println(" * found: " + nums[left] + ", " + nums[right]);
                }
                result++;
                left++;
                right--;
            } else if (sum < k) {
                left++;
            } else {
                right--;
            }
        }
        if (isTest) {
            System.out.println("---------------------\nresult: " + result);
        }

        return result;
    }
}