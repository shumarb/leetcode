// Question: https://leetcode.com/problems/sum-of-elements-with-frequency-divisible-by-k/description/

class SumOfElementsWithFrequencyDivisibleByK {
    public int sumDivisibleByK(int[] nums, int k) {
        int[] frequency = new int[101];
        int sum = 0;

        for (int number: nums) {
            frequency[number]++;
        }
        for (int i = 1; i <= 100; i++) {
            int count = frequency[i];
            if (count == 0 || count % k != 0) {
                continue;
            }

            sum += (i * count);
        }

        return sum;
    }
}