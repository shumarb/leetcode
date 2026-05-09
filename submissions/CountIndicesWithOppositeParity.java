// Question: https://leetcode.com/problems/count-indices-with-opposite-parity/description/

class CountIndicesWithOppositeParity {
    public int[] countOppositeParity(int[] nums) {
        boolean isTest = false;
        int n = nums.length;
        int[] suffixEven = new int[n];
        int[] suffixOdd = new int[n];
        int[] result = new int[n];

        // 1. For each index, count the number of even and odd numbers after it.
        suffixEven[n - 1] = nums[n - 1] % 2 == 0 ? 1 : 0;
        suffixOdd[n - 1] = nums[n - 1] % 2 == 1 ? 1 : 0;
        for (int i = n - 2; i >= 0; i--) {
            suffixEven[i] = nums[i] % 2 == 0 ? 1 + suffixEven[i + 1] : suffixEven[i + 1];
        }
        for (int i = n - 2; i >= 0; i--) {
            suffixOdd[i] = nums[i] % 2 == 1 ? 1 + suffixOdd[i + 1] : suffixOdd[i + 1];
        }
        if (isTest) {
            System.out.println("suffixEven: " + Arrays.toString(suffixEven) + "\nsuffixOdd:  " + Arrays.toString(suffixOdd));
        }

        for (int i = n - 1; i >= 0; i--) {
            result[i] = nums[i] % 2 == 0 ? suffixOdd[i] : suffixEven[i];
        }
        if (isTest) {
            System.out.println("------------------------------\nresult: " + Arrays.toString(result));
        }

        return result;
    }
}
