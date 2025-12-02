// Question: https://leetcode.com/problems/maximum-length-of-repeated-subarray/description/

class MaximumLengthOfRepeatedSubarray {
    public int findLength(int[] nums1, int[] nums2) {
        boolean isTest = false;
        int n1 = nums1.length;
        int n2 = nums2.length;
        int result = 0;
        int[][] dp = new int[n1 + 1][n2 + 1];

        for (int i = n1 - 1; i >= 0; i--) {
            for (int j = n2 - 1; j >= 0; j--) {
                if (nums1[i] == nums2[j]) {
                    if (isTest) {
                        System.out.println(" * valid | i: " + i + ", j: " + j);
                    }
                    dp[i][j] = 1 + dp[i + 1][j + 1];
                    result = Math.max(dp[i][j], result);
                }
            }
        }
        if (isTest) {
            System.out.println("--------------------------------------\ndp:");
            for (int[] row: dp) {
                System.out.println(Arrays.toString(row));
            }
        }

        return result;
    }
}