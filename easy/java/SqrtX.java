// Question: https://leetcode.com/problems/sqrtx/description/

class SqrtX {
    public int mySqrt(int x) {
        long i = 0;
        while (i * i <= (long) x) {
            i++;
        }
        return (int) i - 1;
    }
}