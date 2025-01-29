// Question: https://leetcode.com/problems/smallest-even-multiple/description/

class SmallestEvenMultiple {
    public int smallestEvenMultiple(int n) {
        if (n % 2 == 0) {
            return n;
        }
        return n * 2;
    }
}