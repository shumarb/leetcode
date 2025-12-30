// Question: https://leetcode.com/problems/mirror-distance-of-an-integer/description/

class MirrorDistanceOfAnInteger {
    public int mirrorDistance(int n) {
        boolean isTest = false;
        int nCopy = n;
        int reverse = 0;

        while (nCopy > 0) {
            reverse *= 10;
            reverse += nCopy % 10;
            nCopy /= 10;
        }
        if (isTest) {
            System.out.println("n: " + n + "\nreverse: " + reverse + "\nresult: " + Math.abs(n - reverse));
        }

        return Math.abs(n - reverse);
    }
}