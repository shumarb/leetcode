// Question: https://leetcode.com/problems/palindrome-number/description/

class PalindromeNumber {
    public boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }
        int xCopy = x;
        int reverseX = 0;
        while (xCopy != 0) {
            reverseX *= 10;
            reverseX += xCopy % 10;
            xCopy /= 10;
        }
        return x == reverseX;
    }
}