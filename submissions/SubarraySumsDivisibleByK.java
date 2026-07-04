// Question: https://leetcode.com/problems/subarray-sums-divisible-by-k/description/

class SubarraySumsDivisibleByK {
    public int subarraysDivByK(int[] nums, int k) {
        Map<Integer, Integer> countRemainders = new HashMap<>();
        boolean isTest = false;
        int n = nums.length;
        int result = 0;
        long kLong = k;
        long sum = 0;

        if (isTest) {
            System.out.println("k: " + k + "\nnums: " + Arrays.toString(nums));
            System.out.println("-------------------------------------");
        }
        countRemainders.put(0, 1);
        for (int i = 0; i < n; i++) {
            sum += nums[i];
            int remainder = (int) (sum % kLong);

            if (remainder < 0) {
                remainder += k;
            }
            if (countRemainders.containsKey(remainder)) {
                result += countRemainders.get(remainder);
            }

            countRemainders.put(remainder, 1 + countRemainders.getOrDefault(remainder, 0));
            if (isTest) {
                System.out.println("index " + i + " | element: " + nums[i]);
                System.out.println(" * remainder: " + remainder + "\n * sum: " + sum + "\n * countRemainders: " + countRemainders);
                System.out.println("-------------------------------------");
            }
        }
        if (isTest) {
            System.out.println("final countRemainders: " + countRemainders + "\nresult: " + result);
        }

        return result;
    }
}
