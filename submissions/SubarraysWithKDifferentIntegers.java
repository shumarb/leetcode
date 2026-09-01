// Question: https://leetcode.com/problems/subarrays-with-k-different-integers/description/

class SubarraysWithKDifferentIntegers {
    private int[] nums;

    public int subarraysWithKDistinct(int[] nums, int k) {
        this.nums = nums;
        return countAtMost(k) - countAtMost(k - 1);
    }

    private int countAtMost(int limit) {
        boolean isTest = false;
        int[] count = new int[20001];
        int countDistinctIntegers = 0;
        int left = 0;
        int result = 0;

        if (isTest) {
            System.out.println("------------------------------------------------------------------------------\nnums: " + Arrays.toString(nums) + "\ncheck subarrays with <= " + limit + " distinct integers\n");
        }
        for (int right = 0; right < nums.length; right++) {
            if (++count[nums[right]] == 1) {
                countDistinctIntegers++;
            }

            while (countDistinctIntegers > limit) {
                if (--count[nums[left++]] == 0) {
                    countDistinctIntegers--;
                }
            }

            int countSubarrays = right - left + 1;
            if (isTest) {
                System.out.println(" * indices: [" + left + ", " + right + "] | countSubarrays: " + countSubarrays + " | subarray: " + Arrays.toString(Arrays.copyOfRange(nums, left, right + 1)));
            }
            result += countSubarrays;
        }
        if (isTest) {
            System.out.println("\ntotal subarrays: " + result);
        }

        return result;
    }
}
