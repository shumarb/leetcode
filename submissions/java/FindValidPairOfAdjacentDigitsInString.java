// Question: https://leetcode.com/problems/find-valid-pair-of-adjacent-digits-in-string/description/

class FindValidPairOfAdjacentDigitsInString {
    public String findValidPair(String s) {
        StringBuilder validPair = new StringBuilder();
        int[] digitFrequency = new int[10];
        boolean isTest = false;

        for (int i = 0; i < s.length(); i++) {
            digitFrequency[Character.getNumericValue(s.charAt(i))]++;
        }
        if (isTest) {
            System.out.println("s: " + s);
            System.out.println("digitFrequency: " + Arrays.toString(digitFrequency));
        }

        for (int i = 0; i < s.length() - 1; i++) {
            int firstDigit = Character.getNumericValue(s.charAt(i));
            int secondDigit = Character.getNumericValue(s.charAt(i + 1));
            if (firstDigit != secondDigit) {
                if (isTest) {
                    System.out.println("first digit: " + firstDigit + ", secondDigit: " + secondDigit);
                }
                if (digitFrequency[firstDigit] == firstDigit && digitFrequency[secondDigit] == secondDigit) {
                    validPair.append(s.charAt(i));
                    validPair.append(s.charAt(i + 1));
                    break;
                }
            }
        }

        return validPair.toString();
    }
}