// Question: https://leetcode.com/problems/second-largest-digit-in-a-string/description/

class SecondLargestDigitInAString {
    public int secondHighest(String s) {
        boolean[] digitFrequency = new boolean[10];
        boolean isTest = false;

        for (char c: s.toCharArray()) {
            if (Character.isDigit(c)) {
                digitFrequency[Character.getNumericValue(c)] = true;
            }
        }
        if (isTest) {
            System.out.println("s: " + s + "\ndigitFrequency: " + Arrays.toString(digitFrequency));
        }

        int count = 0;
        for (int i = digitFrequency.length - 1; i >= 0; i--) {
            if (digitFrequency[i]) {
                count++;
                if (count == 2) {
                    return i;
                }
            }
        }

        return -1;
    }
}