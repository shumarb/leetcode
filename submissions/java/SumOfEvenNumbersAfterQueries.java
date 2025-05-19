// Question: https://leetcode.com/problems/sum-of-even-numbers-after-queries/description/

class SumOfEvenNumbersAfterQueries {
    public int[] sumEvenAfterQueries(int[] nums, int[][] queries) {
        boolean isTest = false;
        int len = nums.length;
        int sumOfEvenNumbers = 0;
        int[] result = new int[len];

        for (int number: nums) {
            if (number % 2 == 0) {
                sumOfEvenNumbers += number;
            }
        }
        if (isTest) {
            System.out.println("before, nums: " + Arrays.toString(nums) + "\nsumOfEvenNumbers: " + sumOfEvenNumbers);
            System.out.println("-----------------------------------------------");
        }

        int j = 0;
        for (int[] query: queries) {
            int value = query[0];
            int index = query[1];
            int previousValue = nums[index];
            int newValue = previousValue + value;
            if (isTest) {
                System.out.println("j: " + j + "\nquery: " + Arrays.toString(query) + " | index: " + index);
                System.out.println("previousValue: " + previousValue + " | newValue: " + newValue);
                System.out.println(" * before, nums: " + Arrays.toString(nums) + ", sumOfEvenNumbers: " + sumOfEvenNumbers);
            }

            // 1. Update element of nums at index.
            nums[index] = newValue;

            // 2. Update sumOfEvenNumbers accordingly.
            // 2.1 Odd -> Even: Increase sumOfEvenNumbers by newValue.
            if (previousValue % 2 != 0 && newValue % 2 == 0) {
                sumOfEvenNumbers += newValue;
            }

            // 2.2. Even --> Odd: Decrease sumOfEvenNumbers by previousValue.
            else if (previousValue % 2 == 0 && newValue % 2 != 0) {
                sumOfEvenNumbers -= previousValue;
            }

            // 2.3 Even --> Even: Increase sumOfEvenNumbers by (newValue - previousValue).
            else if (previousValue % 2 == 0 && newValue % 2 == 0) {
                sumOfEvenNumbers += (newValue - previousValue);
            }

            result[j++] = sumOfEvenNumbers;
            if (isTest) {
                System.out.println(" * after, nums: " + Arrays.toString(nums) + ", sumOfEvenNumbers: " + sumOfEvenNumbers);
                System.out.println(" * so far, result: " + Arrays.toString(result));
                System.out.println("-----------------------------------------------");
            }
        }

        if (isTest) {
            System.out.println("after, nums: " + Arrays.toString(nums));
            System.out.println("result: " + Arrays.toString(result));
        }

        return result;
    }
}