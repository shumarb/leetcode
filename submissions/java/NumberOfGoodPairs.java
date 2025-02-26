// Question: https://leetcode.com/problems/number-of-good-pairs/description/

class NumberOfGoodPairs {
    public int numIdenticalPairs(int[] nums) {
        int maximum = findMaximum(nums);
        int n = nums.length;
        int[] numberFrequency = new int[maximum + 1];
        boolean isTest = false;

        for (int element: nums) {
            numberFrequency[element]++;
        }
        if (isTest) {
            System.out.println("nums: " + Arrays.toString(nums) + ", numberFrequency: " + Arrays.toString(numberFrequency));
        }

        int count = 0;
        for (int i = 1; i <= maximum; i++) {
            int frequency = numberFrequency[i];
            if (frequency > 1) {
                count += frequency * (frequency - 1) / 2;
            }
        }

        return count;
    }

    private int findMaximum(int[] nums) {
        int maximum = nums[0];
        for (int element: nums) {
            maximum = Math.max(maximum, element);
        }
        return maximum;
    }
}