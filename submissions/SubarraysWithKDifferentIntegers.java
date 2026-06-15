// Question: https://leetcode.com/problems/subarrays-with-k-different-integers/description/

class SubarraysWithKDifferentIntegers {
    public int subarraysWithKDistinct(int[] nums, int k) {
        return countAtMost(nums, k) - countAtMost(nums, k - 1);
    }

    private int countAtMost(int[] nums, int limit) {
        boolean isTest = false;
        if (limit == 0) {
            return 0;
        }

        int[] frequency;
        int countDifferentIntegers = 0;
        int largest = 0;
        int left = 0;
        int result = 0;

        for (int e: nums) {
            largest = Math.max(e, largest);
        }
        frequency = new int[largest + 1];

        if (isTest) {
            System.out.println("-----------------------------------------------\nsubarrays with at most " + limit + " different integers: ");
        }
        for (int right = 0; right < nums.length; right++) {
            int incoming = nums[right];

            if (++frequency[incoming] == 1) {
                countDifferentIntegers++;
            }

            while (countDifferentIntegers > limit) {
                int remove = nums[left++];
                if (--frequency[remove] == 0) {
                    countDifferentIntegers--;
                }
            }

            int totalSubarrays = right - left + 1;
            if (isTest) {
                System.out.println(" * " + Arrays.toString(Arrays.copyOfRange(nums, left, right + 1)) + ", totalSubarrays: " + totalSubarrays);
            }

            result += totalSubarrays;
        }
        if (isTest) {
            System.out.println("\nresult: " + result);
        }

        return result;
    }
}
