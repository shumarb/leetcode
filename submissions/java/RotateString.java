// Question: https://leetcode.com/problems/rotate-string/description/

class RotateString {
    public boolean rotateString(String s, String goal) {
        int goalLen = goal.length();
        int sLen = s.length();

        /**
         1.  Edge case: Goal and s are different length,
             so it is impossible to construct goal from s.
         */
        if (sLen != goalLen) {
            return false;
        }

        StringBuilder sDoubled = new StringBuilder();
        boolean isTest = false;

        for (int i = 0; i < 2; i++) {
            for (char letter: s.toCharArray()) {
                sDoubled.append(letter);
            }
        }
        if (isTest) {
            System.out.println("s: " + s + "\ngoal: " + goal + "\nsDoubled: " + sDoubled);
            System.out.println("-----------------------------------------------------");
        }

        int len = sDoubled.length();
        String sDoubledString = sDoubled.toString();
        for (int i = 0; i <= len - goalLen; i++) {
            if (sDoubledString.substring(i, i + goalLen).equals(goal)) {
                return true;
            }
        }

        return false;
    }
}