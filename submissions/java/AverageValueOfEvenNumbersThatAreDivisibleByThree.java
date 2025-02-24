// Question: https://leetcode.com/problems/average-value-of-even-numbers-that-are-divisible-by-three/description/

class AverageValueOfEvenNumbersThatAreDivisibleByThree {
    public int averageValue(int[] nums) {
        int count = 0;
        int sum = 0;

        for (int number: nums) {
            if ((number % 6) == 0) {
                sum += number;
                count++;
            }
        }

        return (count == 0) ? 0 : (sum / count);
    }
}