// Question: https://leetcode.com/problems/count-elements-with-maximum-frequency/description/

class CountElementsWithMaximumFrequency {
    public int maxFrequencyElements(int[] nums) {
        int maximum = nums[0];
        for (int number: nums) {
            maximum = Math.max(maximum, number);
        }
        int[] numberFrequency = new int[maximum + 1];
        int countMaxFrequencyElements = 0;
        int maxFrequency = Integer.MIN_VALUE;
        boolean isTest = false;

        for (int number: nums) {
            numberFrequency[number]++;
            maxFrequency = Math.max(maxFrequency, numberFrequency[number]);
        }
        if (isTest) {
            System.out.println("nums: " + Arrays.toString(nums) + "\nnumberFrequency: " + Arrays.toString(numberFrequency));
            System.out.println("maxFrequency: " + maxFrequency);
        }

        for (int element: numberFrequency) {
            if (element == maxFrequency) {
                countMaxFrequencyElements++;
            }
        }

        return maxFrequency * countMaxFrequencyElements;
    }
}