// Question: https://leetcode.com/problems/count-elements-with-maximum-frequency/description/

class CountElementsWithMaximumFrequency {
    public int maxFrequencyElements(int[] nums) {
        int countMaxFrequencyElements = 0;
        int maxFrequency = 0;
        int maximum = 0;

        for (int number: nums) {
            maximum = Math.max(maximum, number);
        }

        int[] numberFrequency = new int[maximum + 1];
        for (int number: nums) {
            numberFrequency[number]++;
            maxFrequency = Math.max(maxFrequency, numberFrequency[number]);
        }

        for (int frequency: numberFrequency) {
            if (frequency == maxFrequency) {
                countMaxFrequencyElements += frequency;
            }
        }

        return countMaxFrequencyElements;
    }
}