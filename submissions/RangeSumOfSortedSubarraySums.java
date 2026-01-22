// Question: https://leetcode.com/problems/range-sum-of-sorted-subarray-sums/description/

class RangeSumOfSortedSubarraySums {
    public int rangeSum(int[] nums, int n, int left, int right) {
        boolean isTest = false;
        int[] updated = new int[n * (n + 1) / 2];
        long[] prefix = new long[n * (n + 1) / 2];
        int k = 0;

        for (int i = 0; i < n; i++) {
            int sum = 0;
            for (int j = i; j < n; j++) {
                sum += nums[j];
                updated[k++] = sum;
            }
        }

        updated = sort(updated);
        prefix[0] = (long) updated[0];
        for (int i = 1; i < prefix.length; i++) {
            prefix[i] = ((long) prefix[i - 1] + (long) updated[i]) % 1000000007;
        }
        if (isTest) {
            System.out.println("updated: " + Arrays.toString(updated) + "\nprefix: " + Arrays.toString(prefix));
        }

        return (int) getRangeSum(prefix, left - 1, right - 1);
    }

    private int[] sort(int[] arr) {
        int[] count;
        int j = 0;
        int largest = 0;

        for (int e: arr) {
            largest = Math.max(e, largest);
        }
        count = new int[largest + 1];

        for (int e: arr) {
            count[e]++;
        }
        for (int i = 1; i <= largest; i++) {
            while (count[i]-- > 0) {
                arr[j++] = i;
            }
        }

        return arr;
    }

    private int getRangeSum(long[] prefix, int left, int right) {
        return left == 0 ? (int) prefix[right] : (int) (prefix[right] - prefix[left - 1]);
    }
}