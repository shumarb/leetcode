// Question: https://leetcode.com/problems/minimum-average-difference/description/

class MinimumAverageDifference {
    public int minimumAverageDifference(int[] nums) {
        boolean isTest = false;
        int index = Integer.MAX_VALUE;
        int n = nums.length;
        long minimumAverageDifference = Long.MAX_VALUE;
        long total = nums[0];
        long[] prefix = new long[n];

        prefix[0] = nums[0];
        for (int i = 1; i < n; i++) {
            total += (long) nums[i];
            prefix[i] = (long) (prefix[i - 1]) + (long) nums[i];
        }
        if (isTest) {
            System.out.println("nums: " + Arrays.toString(nums) + "\nprefix: " + Arrays.toString(prefix));
            System.out.println("--------------------------------------------");
        }

        for (int i = 0; i < n - 1; i++) {
            long prefixAverage = prefix[i] / (i + 1);
            long suffixAverage = (total - prefix[i]) / (n - i - 1);
            long averageDifference = Math.abs(prefixAverage - suffixAverage);

            if (isTest) {
                System.out.println("i: " + i + "\n * prefixAverage: " + prefixAverage + " -> suffixAverage: " + suffixAverage);
                System.out.println(" ** averageDifference: " + averageDifference + " | minimumAverageDifference: " + minimumAverageDifference);
                System.out.println("--------------------------------------------");
            }

            if (averageDifference < minimumAverageDifference) {
                index = i;
                minimumAverageDifference = averageDifference;
            }
        }

        return Math.abs(prefix[n - 1] / n) < minimumAverageDifference ? n - 1 : index;
    }
}