// Question: https://leetcode.com/problems/binary-subarrays-with-sum/description/

class BinarySubarraysWithSum {
    private int[] nums;

    public int numSubarraysWithSum(int[] nums, int goal) {
        this.nums = nums;
        return countAtMost(goal) - countAtMost(goal - 1);
    }

    private int countAtMost(int limit) {
        if (limit < 0) {
            return 0;
        }

        boolean isTest = false;
        int left = 0;
        int result = 0;
        int sum = 0;

        if (isTest) {
            System.out.println("--------------------------------------------------------------\nnums: " + Arrays.toString(nums) + "\ncount subarrays with sum <= " + limit + "\n");
        }
        for (int right = 0; right < nums.length; right++) {
            sum += nums[right];

            while (sum > limit) {
                sum -= nums[left++];
            }

            int countSubarrays = right - left + 1;
            if (isTest) {
                System.out.println(" * indices: [" + left + ", " + right + "] | countSubarrays: " + countSubarrays + " | subarray: " + Arrays.toString(Arrays.copyOfRange(nums, left, right + 1)));
            }

            result += countSubarrays;
        }
        if (isTest) {
            System.out.println("\nresult: " + result);
        }

        return result;
    }
}
