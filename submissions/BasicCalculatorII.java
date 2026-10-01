// Question: https://leetcode.com/problems/basic-calculator-ii/description/

class BasicCalculatorII {
    public int calculate(String s) {
        Stack<Integer> stack = new Stack<>();
        boolean isTest = false;
        char[] tokens;
        char sign = '+';
        int number = 0;
        int result = 0;

        s = s.trim();
        tokens = s.toCharArray();

        for (int i = 0; i < tokens.length; i++) {
            char c = tokens[i];

            if (c == ' ') {
                continue;
            }

            if (isTest) {
                System.out.println("c: " + c + " @ index " + i);
                System.out.println(" * before, stack: " + stack + ", number: " + number + ", sign: " + sign);
            }
            if (Character.isDigit(c)) {
                number = number * 10 + (c - '0');
            }

            if (i == s.length() - 1 || !Character.isDigit(c)) {
                if (sign == '+') {
                    stack.push(number);

                } else if (sign == '-') {
                    stack.push(-number);

                } else if (sign == '*') {
                    stack.push(stack.pop() * number);

                } else {
                    stack.push(stack.pop() / number);
                }

                sign = c;
                number = 0;
            }
            if (isTest) {
                System.out.println(" * after, stack: " + stack + ", number: " + number + ", sign: " + sign);
                System.out.println("---------------------------------------------------------------------");
            }
        }
        if (isTest) {
            System.out.println("final stack: " + stack);
        }

        while (!stack.isEmpty()) {
            result += stack.pop();
        }
        if (isTest) {
            System.out.println("result: " + result);
        }

        return result;
    }
}
