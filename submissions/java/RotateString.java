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
        for (int i = 0; i <= len - k; i++) {
            StringBuilder current = new StringBuilder();
            for (int j = i; j < len && j <= i + k - 1; j++) {
                current.append(doubledS.charAt(j));
            }
            if (isTest) {
                System.out.println(" * current: " + current + " | goal: " + goal);
            }
            if (current.toString().equals(goal)) {
                return true;
            }
        }

        return false;
    }
}