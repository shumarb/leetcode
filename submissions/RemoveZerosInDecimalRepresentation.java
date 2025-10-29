// Question: https://leetcode.com/problems/remove-zeros-in-decimal-representation/description/

class RemoveZerosInDecimalRepresentation {
    public long removeZeros(long n) {
        Stack<Long> stack = new Stack<>();
        boolean isTest = false;
        long result = 0;

        while (n > 0) {
            long digit = n % 10;
            if (digit > 0) {
                stack.push(digit);
            }
            n /= 10;
        }
        if (isTest) {
            System.out.println("stack: " + stack);
        }

        while (!stack.isEmpty()) {
            long digit = stack.pop();
            result *= 10;
            result += digit;
        }
        if (isTest) {
            System.out.println("result: " + result);
        }

        return result;
    }
}