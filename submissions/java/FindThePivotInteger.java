// Question: https://leetcode.com/problems/find-the-pivot-integer/description/

class FindThePivotInteger {
    public int pivotInteger(int n) {
        boolean isTest = false;
        int[] arr = new int[n];
        int[] prefix = new int[n];
        int[] suffix = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = i + 1;
        }
        if (isTest) {
            System.out.println("arr: " + Arrays.toString(arr));
        }

        prefix[0] = arr[0];
        suffix[n - 1] = arr[n - 1];
        for (int i = 1; i < n; i++) {
            prefix[i] = prefix[i - 1] + arr[i];
        }
        for (int i = n - 2; i >= 0; i--) {
            suffix[i] = suffix[i + 1] + arr[i];
        }
        if (isTest) {
            System.out.println("prefix: " + Arrays.toString(prefix));
            System.out.println("suffix: " + Arrays.toString(suffix));
        }

        for (int i = 0; i < n; i++) {
            if (prefix[i] == suffix[i]) {
                return arr[i];
            }
        }

        return -1;
    }
}