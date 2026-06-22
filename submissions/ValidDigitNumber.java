// Question: https://leetcode.com/problems/valid-digit-number/description/

class ValidDigitNumber {
    public boolean validDigit(int n, int x) {
        boolean isTest = false;
        int[] count = new int[10];
        int nCopy = n;

        while (nCopy >= 10) {
            count[nCopy % 10]++;
            nCopy /= 10;
        }
        count[nCopy]++;
        if (isTest) {
            System.out.println("n: " + n + "\nnCopy: " + nCopy + "\ncount: " + Arrays.toString(count));
        }

        return count[x] > 0 && nCopy != x;
    }
}
