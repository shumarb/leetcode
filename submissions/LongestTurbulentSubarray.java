// Question: https://leetcode.com/problems/longest-turbulent-subarray/description/

class LongestTurbulentSubarray {
    public int maxTurbulenceSize(int[] arr) {
        int down = 1;
        int result = 1;
        int up = 1;

        for (int k = 0; k < arr.length - 1; k++) {
            if (arr[k] > arr[k + 1]) {
                up = down + 1;
                down = 1;

            } else if (arr[k] < arr[k + 1]) {
                down = up + 1;
                up = 1;

            } else {
                up = 1;
                down = 1;
            }

            result = Math.max(result, Math.max(down, up));
        }

        return result;
    }
}
