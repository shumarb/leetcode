// Question: https://leetcode.com/problems/find-pivot-index/description/

class FindPivotIndex {
    public int pivotIndex(int[] nums) {
        int n = nums.length;
        int[] pSum = new int[n];
        int[] sSum = new int[n];
        boolean t = false;

        pSum[0] = 0;
        for (int i = 1; i < pSum.length; i++) {
            pSum[i] = nums[i - 1] + pSum[i - 1];
        }
        sSum[n - 1] = 0;
        for (int i = n - 2; i >= 0; i--) {
            sSum[i] = nums[i + 1] + sSum[i + 1];
        }

        if (t) {
            System.out.println("nums: " + Arrays.toString(nums));
            System.out.println("pSum: " + Arrays.toString(pSum));
            System.out.println("sSum: " + Arrays.toString(sSum));
        }

        for (int i = 0; i < n; i++) {
            if (pSum[i] == sSum[i]) {
                return i;
            }
        }
        return -1;
    }
}