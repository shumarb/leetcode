// Question: https://leetcode.com/problems/base-7/description/

class Base7 {
    public String convertToBase7(int num) {
        if (num == 0) {
            return String.valueOf(0);
        }

        boolean isNegative = false;
        if (num < 0) {
            isNegative = true;
            num *= -1;
        }

        StringBuilder base7Representation = new StringBuilder();
        while (num != 0) {
            base7Representation.insert(0, num % 7);
            num /= 7;
        }

        if (isNegative) {
            base7Representation.insert(0, '-');
        }

        return base7Representation.toString();
    }
}