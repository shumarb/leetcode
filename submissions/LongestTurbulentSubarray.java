// Question: https://leetcode.com/problems/longest-turbulent-subarray/description/

class LongestTurbulentSubarray {
    public int maxTurbulenceSize(int[] arr) {
        boolean isTest = false;
        int n = arr.length;
        int result = 0;
        int[] first = new int[n];
        int[] second = new int[n];

        Arrays.fill(first, 1);
        Arrays.fill(second, 1);

        for (int k = 0; k < n - 1; k++) {
            if ((k % 2 == 1 && arr[k] > arr[k + 1]) || (k % 2 == 0 && arr[k] < arr[k + 1])) {
                first[k + 1] = 1 + first[k];

            } else {
                first[k + 1] = 1;
            }
        }

        for (int k = 0; k < n - 1; k++) {
            if ((k % 2 == 1 && arr[k] < arr[k + 1]) || (k % 2 == 0 && arr[k] > arr[k + 1])) {
                second[k + 1] = 1 + second[k];

            } else {
                second[k + 1] = 1;
            }
        }

        for (int i = 0; i < n; i++) {
            result = Math.max(result, Math.max(first[i], second[i]));
        }
        if (isTest) {
            System.out.println("arr:    " + Arrays.toString(arr) + "\nfirst:  " + Arrays.toString(first) + "\nsecond: " + Arrays.toString(second) + "\nresult: " + result);
        }

        return result;
    }
}
