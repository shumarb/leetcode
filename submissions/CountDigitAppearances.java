// Question:

class CountDigitAppearances {
    public int countDigitOccurrences(int[] nums, int digit) {
        int[] count = new int[10];

        for (int e: nums) {
            while (e > 0) {
                count[e % 10]++;
                e /= 10;
            }
        }

        return count[digit];
    }
}
