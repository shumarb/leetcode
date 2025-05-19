// Question: https://leetcode.com/problems/sum-of-even-numbers-after-queries/description/

class SumOfEvenNumbersAfterQueries {
    public int[] sumEvenAfterQueries(int[] nums, int[][] queries) {
        int[] result = new int[nums.length];
        int j = 0;
        boolean isTest = false;
        if (isTest) {
            System.out.println("before, nums: " + Arrays.toString(nums));
            System.out.println("----------------------------------------------");
        }

        for (int i = 0; i < queries.length; i++) {
            int[] query = queries[i];
            nums[query[1]] += query[0];
            if (isTest) {
                System.out.println(" * after iteration #" + (i + 1) + ": " + Arrays.toString(nums));
            }
            result[j++] = getSumEvenNumbers(nums);
        }
        if (isTest) {
            System.out.println("----------------------------------------------");
            System.out.println("after, nums: " + Arrays.toString(nums));
            System.out.println("result: " + Arrays.toString(result));
        }

        return result;
    }

    private int getSumEvenNumbers(int[] nums) {
        int sumEvenNumbers = 0;
        for (int number: nums) {
            if (number % 2 == 0) {
                sumEvenNumbers += number;
            }
        }
        return sumEvenNumbers;
    }
}