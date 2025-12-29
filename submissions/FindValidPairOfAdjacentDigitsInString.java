// Question: https://leetcode.com/problems/find-valid-pair-of-adjacent-digits-in-string/description/

class FindValidPairOfAdjacentDigitsInString {
    public String findValidPair(String s) {
        StringBuilder validPair = new StringBuilder();
        boolean isTest = false;
        int[] digitFrequency = new int[10];

        for (int i = 0; i < s.length(); i++) {
            digitFrequency[s.charAt(i) - '0']++;
        }
        if (isTest) {
            System.out.println("s: " + s);
            System.out.println("digitFrequency: " + Arrays.toString(digitFrequency));
            System.out.println("--------------------------------------------------");
        }

        for (int i = 0; i < s.length() - 1; i++) {
            int firstDigit = s.charAt(i) - '0';
            int secondDigit = s.charAt(i + 1) - '0';
            if (firstDigit != secondDigit) {
                if (isTest) {
                    System.out.println("first digit: " + firstDigit + ", secondDigit: " + secondDigit);
                }
                if (digitFrequency[firstDigit] == firstDigit && digitFrequency[secondDigit] == secondDigit) {
                    validPair.append(firstDigit);
                    validPair.append(secondDigit);
                    break;
                }
            }
        }

        return validPair.toString();
    }
}