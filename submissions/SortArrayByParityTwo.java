// Question: https://leetcode.com/problems/sort-array-by-parity-ii/description/

class SortArrayByParityTwo {
    public int[] sortArrayByParityII(int[] nums) {
        int maximum = nums[0];
        for (int number: nums) {
            maximum = Math.max(number, maximum);
        }
        int[] numberFrequency = new int[maximum + 1];
        for (int number: nums) {
            numberFrequency[number]++;
        }

        int j = 0;
        int k = 1;
        for (int i = 0; i < numberFrequency.length; i++) {
            if (i % 2 == 0) {
                while (numberFrequency[i]-- > 0) {
                    nums[j] = i;
                    j += 2;
                }
            } else {
                while (numberFrequency[i]-- > 0) {
                    nums[k] = i;
                    k += 2;
                }
            }
        }

        return nums;
    }
}