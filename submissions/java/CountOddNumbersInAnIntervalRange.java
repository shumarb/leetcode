// Question: https://leetcode.com/problems/count-odd-numbers-in-an-interval-range/description/

class CountOddNumbersInAnIntervalRange {
    public int countOdds(int low, int high) {
        int totalNumbers = high - low + 1;
        return (low % 2 != 0 && high % 2 != 0) ? totalNumbers / 2 + 1 : totalNumbers / 2;
    }
}