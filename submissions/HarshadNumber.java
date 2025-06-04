// Question: https://leetcode.com/problems/harshad-number/description/

class HarshadNumber {
    public int sumOfTheDigitsOfHarshadNumber(int x) {
        int sumOfDigits = 0;
        int xCopy = x;

        while (xCopy != 0) {
            sumOfDigits += xCopy % 10;
            xCopy /= 10;
        }

        return ((x % sumOfDigits) == 0) ? sumOfDigits : -1;
    }
}