// Question: https://leetcode.com/problems/check-adjacent-digit-differences/description/

class CheckAdjacentDigitDifferences {
    public boolean isAdjacentDiffAtMostTwo(String s) {
        boolean isTest = false;

        for (int i = 0; i < s.length() - 1; i++) {
            int first = s.charAt(i) - '0';
            int second = s.charAt(i + 1) - '0';
            int absDifference = Math.abs(first - second);

            if (isTest) {
                System.out.println("first: " + first + ", second: " + second + " -> absDifference: " + absDifference);
            }
            if (absDifference > 2) {
                return false;
            }
        }

        return true;
    }
}
