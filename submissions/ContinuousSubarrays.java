// Question: https://leetcode.com/problems/continuous-subarrays/description/

class ContinuousSubarrays {
    public long continuousSubarrays(int[] nums) {
        TreeMap<Integer, Integer> window = new TreeMap<>();
        boolean isTest = false;
        int left = 0;
        long result = 0;

        if (isTest) {
            System.out.println("nums: " + Arrays.toString(nums) + "\n-----------------------------------------------------------");
        }
        for (int right = 0; right < nums.length; right++) {
            window.merge(nums[right], 1, Integer::sum);

            while (window.lastKey() - window.firstKey() > 2) {
                window.computeIfPresent(nums[left++], (key, value) -> value == 1 ? null : value - 1);
            }

            int length = right - left + 1;
            if (isTest) {
                System.out.println(" * indices: [" + left + ", " + right + "] | length: " + length + " | subarray: " + Arrays.toString(Arrays.copyOfRange(nums, left, right + 1)));
            }

            result += length;
        }
        if (isTest) {
            System.out.println("-----------------------------------------------------------\nresult: " + result);
        }

        return result;
    }
}
