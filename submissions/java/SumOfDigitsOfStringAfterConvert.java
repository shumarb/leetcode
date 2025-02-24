// Question: https://leetcode.com/problems/sum-of-digits-of-string-after-convert/description/

class SumOfDigitsOfStringAfterConvert class Solution {
    private boolean isTest = false;

    public int getLucky(String s, int k) {
        String converted = convert(s);
        if (isTest) {
            System.out.println("s: " + s + " --> converted: " + converted + "\nk: " + k);
        }
        for (int i = 0; i < k; i++) {
            if (isTest) {
                System.out.println("----------------------------------------------------------");
                System.out.println("before, result: " + converted + ", iteration: " + (i + 1));
            }
            converted = transform(converted);
            if (isTest) {
                System.out.println("after, result: " + converted);
            }
        }

        return Integer.parseInt(converted);
    }

    private String transform(String converted) {
        int sum = 0;
        for (int i = 0; i < converted.length(); i++) {
            char digit = converted.charAt(i);
            if (isTest) {
                System.out.println(" * current: " + digit + " --> value: " + Character.getNumericValue(digit));
            }
            sum += Character.getNumericValue(digit);
        }
        return String.valueOf(sum);
    }

    private String convert(String s) {
        StringBuilder converted = new StringBuilder();
        for (char letter: s.toCharArray()) {
            int value = letter - 'a' + 1;
            converted.append(value);
        }
        return converted.toString();
    }
}