// Question: https://leetcode.com/problems/count-the-digits-that-divide-a-number/description/

class CountTheDigitsThatDivideANumber {
    public int countDigits(int num) {
        int count = 0;
        int numCopy = num;
        boolean isTest = false;

        if (isTest) {
            System.out.println("num: " + num);
        }

        while (numCopy != 0) {
            int digit = numCopy % 10;
            if (isTest) {
                System.out.println("numCopy: " + numCopy + ", digit: " + digit + ", count: " + count);
            }
            if (digit != 0 && num % digit == 0) {
                if (isTest) {
                    System.out.println(num + " divisible by " + digit);
                }
                count++;
            }
            numCopy /= 10;
        }

        return count;
    }
}