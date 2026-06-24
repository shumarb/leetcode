// Question: https://leetcode.com/problems/maximum-erasure-value/description/

class MaximumErasureValue {
    public int maximumUniqueSubarray(int[] nums) {
        boolean isTest = false;
        int[] count = new int[10001];
        int left = 0;
        int result = 0;
        int sum = 0;

        for (int right = 0; right < nums.length; right++) {
            int incoming = nums[right];
            count[incoming]++;
            sum += incoming;

            while (count[incoming] > 1) {
                int remove = nums[left++];
                count[remove]--;
                sum -= remove;
            }
            if (isTest) {
                System.out.println(" * index range: [" + left + ", " + right
                        + "] | sum: " + sum + " | subarray: " + Arrays.toString(Arrays.copyOfRange(nums, left, right + 1)));
            }

            result = Math.max(result, sum);
        }

        return result;
    }
}
