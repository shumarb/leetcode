// Question: https://leetcode.com/problems/count-commas-in-range/description/

class CountCommasInRange {
    public int countCommas(int n) {
        return n < 1000 ? 0 : n - 1000 + 1;
    }
}
