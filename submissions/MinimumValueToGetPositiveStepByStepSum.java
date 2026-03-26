// Question: https://leetcode.com/problems/minimum-value-to-get-positive-step-by-step-sum/description/

class MinimumValueToGetPositiveStepByStepSum {
    public int minStartValue(int[] nums) {
        boolean isTest = false;
        int n = nums.length;
        int result = 1;
        int[] prefix = new int[n];

        prefix[0] = nums[0];
        for (int i = 1; i < n; i++) {
            prefix[i] = nums[i] + prefix[i - 1];
        }

        while (!isValid(prefix)) {
            if (isTest) {
                System.out.println(" * invalid: " + Arrays.toString(prefix) + " | result: " + result);
            }

            for (int i = 0; i < n; i++) {
                prefix[i]++;
            }
            if (isValid(prefix)) {
                break;
            }
            result++;
        }
        if (isTest) {
            System.out.println("prefix: " + Arrays.toString(prefix) + "\nresult: " + result);
        }

        return result;
    }

    private boolean isValid(int[] arr) {
        for (int e: arr) {
            if (e < 1) {
                return false;
            }
        }

        return true;
    }
}
