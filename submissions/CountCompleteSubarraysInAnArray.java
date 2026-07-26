// Question: https://leetcode.com/problems/count-complete-subarrays-in-an-array/description/

class CountCompleteSubarraysInAnArray {
    private boolean isTest;
    private int[] nums;

    public int countCompleteSubarrays(int[] nums) {
        int[] count = new int[2001];
        int k = 0;
        isTest = false;
        this.nums = nums;

        for (int e: nums) {
            if (++count[e] == 1) {
                k++;
            }
        }
        if (isTest) {
            System.out.println("nums: " + Arrays.toString(nums) + "\nk: " + k);
        }

        return countAtLeast(k) - countAtLeast(k - 1);
    }

    private int countAtLeast(int k) {
        int[] count = new int[2001];
        int countDistinct = 0;
        int left = 0;
        int result = 0;

        if (isTest) {
            System.out.println("------------------------------------------------------------------\nlimit of distinct elements: " + k);
        }
        for (int right = 0; right < nums.length; right++) {
            int incoming = nums[right];

            if (++count[incoming] == 1) {
                countDistinct++;
            }

            while (countDistinct > k) {
                if (--count[nums[left++]] == 0) {
                    countDistinct--;
                }
            }

            int totalCompleteSubarrays = right - left + 1;
            if (isTest) {
                System.out.println(" * complete subarray: " + Arrays.toString(Arrays.copyOfRange(nums, left, right + 1)) + " -> total complete subarrays: " + totalCompleteSubarrays);
            }

            result += totalCompleteSubarrays;
        }
        if (isTest) {
            System.out.println("\ntotal complete subarrays: " + result);
        }

        return result;
    }
}
