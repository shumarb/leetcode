// Question: https://leetcode.com/problems/alternating-digit-sum/description/

class AlternatingDigitSum {
    public int alternateDigitSum(int n) {
        Stack<Integer> digits = new Stack<> ();
        int sum = 0;
        int count = 0;
        boolean t = false;

        while (n > 0) {
            digits.push(n % 10);
            n /= 10;
        }
        if (t) {
            System.out.println("digits: " + digits);
        }

        while (!digits.isEmpty()) {
            int digit = digits.pop();
            count += 1;
            if (t) {
                System.out.println("digit: " + digit + " | count: " + count);
            }
            if (count % 2 == 0) {
                digit *= -1;
            }
            sum += digit;
        }

        return sum;
    }
}