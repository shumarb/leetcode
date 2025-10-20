// Question: https://leetcode.com/problems/equal-score-substrings/description/

class EqualScoreSubstrings {
    public boolean scoreBalance(String s) {
        boolean isTest = false;
        int leftSum = 0;
        int rightSum = 0;

        for (char c: s.toCharArray()) {
            rightSum += (c - 'a' + 1);
        }
        if (isTest) {
            System.out.println("leftSum: " + leftSum + "\nrightSum: " + rightSum);
        }

        for (int i = 0; i < s.length(); i++) {
            int letterValue = s.charAt(i) - 'a' + 1;
            leftSum += letterValue;
            rightSum -= letterValue;
            if (isTest) {
                System.out.println("-----------------------\ni: " + i);
                System.out.println("leftSum: " + leftSum + "\nrightSum: " + rightSum);
            }
            if (leftSum == rightSum) {
                return true;
            }
        }

        return false;
    }
}