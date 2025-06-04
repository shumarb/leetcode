// Question: https://leetcode.com/problems/buddy-strings/description/

class BuddyStrings {
    public boolean buddyStrings(String s, String goal) {
        if (s.length() != goal.length()) {
            return false;
        }

        if (s.equals(goal)) {
            int[] frequency = new int[26];
            for (char c: s.toCharArray()) {
                frequency[c - 'a']++;
                /**
                 1.  If s and goal are equal, a swap is possible
                     only if it all characters are the same.
                 */
                if (frequency[c - 'a'] > 1) {
                    return true;
                }
            }
            return false;
        }

        int[] mismatchedIndices = new int[2];
        int j = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != goal.charAt(i)) {
                if (j > 1) {
                    return false;
                }
                mismatchedIndices[j++] = i;
            }
        }

        // 2. Return true characters at alternate indices are the same.
        int firstIndex = mismatchedIndices[0];
        int secondIndex = mismatchedIndices[1];

        return s.charAt(firstIndex) == goal.charAt(secondIndex) && s.charAt(secondIndex) == goal.charAt(firstIndex);
    }
}