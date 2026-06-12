// Question: https://leetcode.com/problems/string-to-integer-atoi/description/

class StringToIntegerAtoi {
    public int myAtoi(String s) {
        s = s.trim();
        if (s.isEmpty()) {
            return 0;
        }

        boolean isNegative = false;
        boolean isTest = false;
        char[] tokens = s.toCharArray();
        int index = 0;
        long result = 0;

        if (tokens[0] == '-' || tokens[0] == '+') {
            if (tokens[0] == '-') {
                isNegative = true;
            }
            index++;

        } else if (!Character.isDigit(tokens[0])) {
            return 0;
        }

        for (int i = index; i < tokens.length; i++) {
            char c = tokens[i];

            if (!Character.isDigit(c)) {
                break;
            }

            result = result * 10l + (c - '0');
            if (isNegative && -result < Integer.MIN_VALUE) {
                return Integer.MIN_VALUE;
            }

            if (!isNegative && result > Integer.MAX_VALUE) {
                return Integer.MAX_VALUE;
            }
        }
        if (isTest) {
            System.out.println("tokens: " + Arrays.toString(tokens) + "\nresult: " + result);
        }

        return isNegative ? (int) -result : (int) result;
    }
}
