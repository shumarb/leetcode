// Question: https://leetcode.com/problems/count-pairs-that-form-a-complete-day-i/description/

class CountPairsThatFormACompleteDayOne {
    public int countCompleteDayPairs(int[] hours) {
        int countCompleteDayPairs = 0;
        int len = hours.length;
        for (int i = 0; i < len - 1; i++) {
            for (int j = i + 1; j < len; j++) {
                long sum = hours[i] + hours[j];
                if (sum % 24 == 0) {
                    countCompleteDayPairs++;
                }
            }
        }
        return countCompleteDayPairs;
    }
}