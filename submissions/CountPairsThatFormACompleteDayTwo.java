// Question: https://leetcode.com/problems/count-pairs-that-form-a-complete-day-ii/description/

class CountPairsThatFormACompleteDayTwo {
    public long countCompleteDayPairs(int[] hours) {
        long result = 0;
        int[] frequency = new int[24];

        for (int hour: hours) {
            int remainder = hour % 24;
            int complement = (24 - remainder) % 24;
            result += frequency[complement];
            frequency[remainder]++;
        }

        return result;
    }
}
