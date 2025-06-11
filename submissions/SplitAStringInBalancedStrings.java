// Question: https://leetcode.com/problems/split-a-string-in-balanced-strings/description/

class SplitAStringInBalancedStrings {
    public int balancedStringSplit(String s) {
        boolean isTest = false;
        int balance = 0;
        int count = 0;

        for (char letter: s.toCharArray()) {
            if (letter == 'L') {
                balance++;
            } else {
                balance--;
            }
            if (balance == 0) {
                count++;
            }
        }
        if (isTest) {
            System.out.println("s: " + s + "\ncount: " + count);
        }

        return count;
    }
}