// Question: https://leetcode.com/problems/digit-frequency-score/description/

class DigitFrequencyScore {
    public int digitFrequencyScore(int n) {
        int[] count = new int[10];
        int result = 0;

        while (n > 0) {
            count[n % 10]++;
            n /= 10;
        }
        for (int i = 0; i < count.length; i++) {
            result += (i * count[i]);
        }

        return result;
    }
}
