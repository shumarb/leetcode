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
        if (isValid(arr)) {
            return arr[n - 1];
        }

        arr[0] = 1;
        for (int i = 1; i < n; i++) {
            if (Math.abs(arr[i] - arr[i - 1]) > 1) {
                arr[i] = 1 + arr[i - 1];
            }
        }
        if (isTest) {
            System.out.println("after update, arr: " + Arrays.toString(arr));
        }

        return arr[n - 1];
    }

    private boolean isValid(int[] arr) {
        if (arr[0] != 1) {
            return false;
        }

        for (int i = 1; i < arr.length; i++) {
            if (Math.abs(arr[i] - arr[i - 1]) > 1) {
                return false;
            }
        }

        return true;
    }
}
