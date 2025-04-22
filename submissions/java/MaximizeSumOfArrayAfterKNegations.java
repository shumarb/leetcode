// Question: https://leetcode.com/problems/maximize-sum-of-array-after-k-negations/description/

class MaximizeSumOfArrayAfterKNegations {
    public int largestSumAfterKNegations(int[] nums, int k) {
        boolean isTest = false;
        int largestSumAfterKNegations = 0;

        nums = sort(nums);
        if (isTest) {
            System.out.println("sorted nums: " + Arrays.toString(nums) + "\nk: " + k);
            System.out.println("----------------------------------------------------------------------------------------");
        }

        // 1. Negatate as many negative numbers as possible.
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < 0 && k > 0) {
                nums[i] *= -1;
                k--;
            }
        }
        nums = sort(nums);
        if (isTest) {
            System.out.println("after applying negation on negative numbers, nums: " + Arrays.toString(nums) + ", remaining k: " + k);
            System.out.println("----------------------------------------------------------------------------------------");
        }

        if (k > 0) {
            boolean hasZero = false;
            /**
             2.  If there exists a zero, don't change remaining numbers
                 as remaining negations are applied
                 onto this element with value of zero.
             */
            for (int number: nums) {
                if (number == 0) {
                    hasZero = true;
                    break;
                }
            }

            /**
             3.  If there are no zeros and and k is odd,
                 then negate the first element only.
             */
            if (!hasZero && k % 2 == 1) {
                nums[0] *= -1;
            }
        }

        for (int number: nums) {
            largestSumAfterKNegations += number;
        }

        return largestSumAfterKNegations;
    }

    private int[] sort(int[] nums) {
        int[] numberFrequency = new int[201];
        for (int number: nums) {
            numberFrequency[number + 100]++;
        }

        int j = 0;
        for (int i = 0; i < numberFrequency.length; i++) {
            while (numberFrequency[i]-- > 0) {
                nums[j++] = i - 100;
            }
        }

        return nums;
    }
}