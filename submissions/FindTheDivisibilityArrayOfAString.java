// Question: https://leetcode.com/problems/find-the-divisibility-array-of-a-string/description/

class FindTheDivisibilityArrayOfAString {
    public int[] divisibilityArray(String word, int m) {
        boolean isTest = false;
        int len = word.length();
        int[] result = new int[len];
        long number = 0;

        if (isTest) {
            System.out.println("word: " + word + "\nm: " + m);
        }
        for (int i = 0; i < len; i++) {
            long digit = word.charAt(i) - '0';
            number = (number * 10) + digit;

            if (isTest) {
                System.out.println("-------------------------------------------");
                System.out.println("number: " + number + "\ndigit: " + digit);
                System.out.println("result: " + Arrays.toString(result));
            }

            number %= m;
            if (number == 0) {
                result[i] = 1;
            }
        }
        if (isTest) {
            System.out.println("-------------------------------------------");
            System.out.println("result: " + Arrays.toString(result));
        }

        return result;
    }
}