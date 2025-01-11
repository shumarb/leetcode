// Question: https://leetcode.com/problems/left-and-right-sum-differences/description/

class LeftAndRightSumDifferences {
    public int[] leftRightDifference(int[] nums) {
        int n = nums.length;
        int[] diff = new int[n];
        int[] pSum = new int[n];
        int[] sSum = new int[n];
        boolean t = false;

        pSum[0] = sSum[n - 1] = 0;
        for (int i = 1; i < n; i++) {
            pSum[i] = nums[i - 1] + pSum[i - 1];
        }
        for (int i = n - 2; i >= 0; i--){
            sSum[i] = nums[i + 1] + sSum[i + 1];
        }
        if (t) {
            System.out.println("pSum:   " + Arrays.toString(pSum));
            System.out.println("nums:   " + Arrays.toString(nums));
            System.out.println("sSum:   " + Arrays.toString(sSum));
        }

        for (int i = 0; i < n; i++) {
            diff[i] = Math.abs(pSum[i] - sSum[i]);
        }
        if (t) {
            System.out.println("diff:   " + Arrays.toString(diff));
        }

        return diff;
    }
}