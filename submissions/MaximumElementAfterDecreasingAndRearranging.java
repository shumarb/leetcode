// Question: https://leetcode.com/problems/maximum-element-after-decreasing-and-rearranging/description/

class MaximumElementAfterDecreasingAndRearranging {
    public int maximumElementAfterDecrementingAndRearranging(int[] arr) {
        boolean isTest = false;
        int n = arr.length;

        if (n == 1) {
            return 1;
        }

        Arrays.sort(arr);
        if (isTest) {
            System.out.println("sorted arr: " + Arrays.toString(arr));
        }

        arr[0] = 1;
        for (int i = 1; i < n; i++) {
            arr[i] = Math.min(arr[i], 1 + arr[i - 1]);
        }
        if (isTest) {
            System.out.println("after update, arr: " + Arrays.toString(arr));
        }

        return arr[n - 1];
    }
}
