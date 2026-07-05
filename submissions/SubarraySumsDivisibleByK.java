// Question: https://leetcode.com/problems/subarray-sums-divisible-by-k/description/

class SubarraySumsDivisibleByK {
    public int subarraysDivByK(int[] nums, int k) {
        boolean isTest = false;
        int[] countRemainders = new int[k];
        int n = nums.length;
        int result = 0;
        long kLong = k;
        long sum = 0;

        if (isTest) {
            System.out.println("k: " + k + "\nnums: " + Arrays.toString(nums));
            System.out.println("-------------------------------------");
        }
        countRemainders[0]++;
        for (int i = 0; i < n; i++) {
            sum += nums[i];
            int remainder = (int) (sum % kLong);

            if (remainder < 0) {
                remainder += k;
            }
            result += countRemainders[remainder]++;
            if (isTest) {
                System.out.println("index " + i + " | element: " + nums[i]);
                System.out.println(" * remainder: " + remainder + "\n * sum: " + sum + "\n * countRemainders: " + Arrays.toString(countRemainders));
                System.out.println("-------------------------------------");
            }
        }
        if (isTest) {
            System.out.println("final countRemainders: " + Arrays.toString(countRemainders) + "\nresult: " + result);
        }

        return result;
    }
}
