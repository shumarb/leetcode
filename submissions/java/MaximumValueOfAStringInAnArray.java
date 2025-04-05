// Question: https://leetcode.com/problems/maximum-value-of-a-string-in-an-array/description/

class MaximumValueOfAStringInAnArray {
    public int maximumValue(String[] strs) {
        int maximumValue = Integer.MIN_VALUE;
        for (String str: strs) {
            maximumValue = Math.max(maximumValue, getValue(str));
        }
        return maximumValue;
    }

    private int getValue(String str) {
        int len = str.length();
        int value = 0;

        for (int i = 0; i < len; i++) {
            char c = str.charAt(i);
            if (Character.isLetter(c)) {
                return len;
            }
            value *= 10;
            value += Character.getNumericValue(c);
        }

        return value;
    }
}