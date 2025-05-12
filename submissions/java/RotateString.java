// Question: https://leetcode.com/problems/rotate-string/description/

class RotateString {
    public boolean rotateString(String s, String goal) {
        int k = goal.length();
        int sLen = s.length();

        /**
         1.  Edge case: Goal and s are different length,
             so it is impossible to construct goal from s.
         */
        if (k != sLen) {
            return false;
        }

        StringBuilder doubledS = new StringBuilder();
        boolean isTest = false;

        for (char letter: s.toCharArray()) {
            doubledS.append(letter);
        }
        for (char letter: s.toCharArray()) {
            doubledS.append(letter);
        }
        if (isTest) {
            System.out.println("s: " + s + "\ngoal: " + goal + "\ndoubledS: " + doubledS);
            System.out.println("-----------------------------------------------------");
        }

        int len = doubledS.length();
        String doubledSStr = doubledS.toString();
        for (int i = 0; i <= len - k; i++) {
            if (doubledSStr.substring(i, i + k).equals(goal)) {
                return true;
            }
        }

        return false;
    }
}