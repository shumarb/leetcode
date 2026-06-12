// Question: https://leetcode.com/problems/string-to-integer-atoi/description/

class StringToIntegerAtoi {
    public int myAtoi(String s) {
        s = s.trim();

        boolean isTest = false;
        char[] tokens = s.toCharArray();
        int index = 0;
        int sign = 1;
        long value = 0l;

        if (isTest) {
            System.out.println("tokens: " + Arrays.toString(tokens));
        }
        if (tokens.length == 0
                || Character.isLetter(tokens[0])
                || tokens[0] == '.') {
            return 0;
        } else if (tokens[0] == '-' || tokens[0] == '+') {
            index++;
            if (tokens[0] == '-') {
                sign = -1;
            }
        }

        for (int i = index; i < tokens.length; i++) {
            char c = tokens[i];
            if (c < '0' || c > '9') {
                break;
            }

            value = value * 10l + (c - '0');

            if (sign * value > Integer.MAX_VALUE) {
                return Integer.MAX_VALUE;
            } else if (sign * value < Integer.MIN_VALUE) {
                return Integer.MIN_VALUE;
            }
        }
        if (isTest) {
            System.out.println("sign: " + sign + "\nvalue: " + value);
        }

        return sign * (int) value;
    }
}
