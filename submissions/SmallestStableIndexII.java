// Question: https://leetcode.com/problems/smallest-stable-index-ii/description/

class SmallestStableIndexII {
    public int firstStableIndex(int[] nums, int k) {
        boolean isTest = false;
        int leftLargest = 0;
        int n = nums.length;
        int[] suffix = new int[n];

        suffix[n - 1] = nums[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            suffix[i] = Math.min(nums[i], suffix[i + 1]);
        }
        if (isTest) {
            System.out.println("k: " + k + "\nnums:   " + Arrays.toString(nums) + "\nsuffix: " + Arrays.toString(suffix));
            System.out.println("--------------------------------------------------------------------");
        }

        for (int i = 0; i < n; i++) {
            leftLargest = Math.max(leftLargest, nums[i]);
            int instabilityScore = leftLargest - suffix[i];

            if (isTest) {
                System.out.println(" * i: " + i + " | leftLargest: " + leftLargest + " | rightSmallest: " + suffix[i] + " | instabilityScore: " + instabilityScore);
            }
            if (instabilityScore <= k) {
                if (isTest) {
                    System.out.println(" ** result @ index " + i);
                }

                return i;
            }
        }

        return -1;
    }
}
