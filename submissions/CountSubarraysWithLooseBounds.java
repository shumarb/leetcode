// Question: https://leetcode.com/problems/count-subarrays-with-loose-bounds/description/

class CountSubarraysWithLooseBounds {
    public long countSubarrays(int[] nums, int minK, int maxK) {
        boolean isTest = false;
        int countInvalidElements = 0;
        int left = 0;
        long result = 0;

        if (isTest) {
            System.out.println("minK: " + minK + "\nmaxK: " + maxK + "\nnums: " + Arrays.toString(nums) + "\n---------------------------------------------------------");
        }
        for (int right = 0; right < nums.length; right++) {
            int incoming = nums[right];

            if (incoming < minK || incoming > maxK) {
                countInvalidElements++;
            }

            while (countInvalidElements > 0) {
                int remove = nums[left++];

                if (remove < minK || remove > maxK) {
                    countInvalidElements--;
                }
            }

            int length = right - left + 1;
            if (isTest) {
                System.out.println(" * indices: [" + left + ", " + right + "] | length: " + length + " | subarray: " + Arrays.toString(Arrays.copyOfRange(nums, left, right + 1)));
            }

            result += length;
        }
        if (isTest) {
            System.out.println("---------------------------------------------------------\nresult: " + result);
        }

        return result;
    }
}
