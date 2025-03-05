// Question: https://leetcode.com/problems/count-odd-numbers-in-an-interval-range/description/

class CountOddNumbersInAnIntervalRange {
    public int countOdds(int low, int high) {
        int range = high - low + 1;
        if (range % 2 == 0) {
            return range / 2;
        }
        int countOddNumbers = 0;
        if (low % 2 == 0) {
            low++;
        }
        for (int i = low; i <= high; i += 2) {
            countOddNumbers++;
        }
        return countOddNumbers;
    }
}