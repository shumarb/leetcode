// Question: https://leetcode.com/problems/string-without-aaa-or-bbb/description/

class StringWithoutAAAOrBBB {
    public String strWithout3a3b(int a, int b) {
        StringBuilder result = new StringBuilder();

        while (a > 0 || b > 0) {
            int len = result.length();

            /**
             1.  If result has at least 2 characters
                 last 2 characters are the same, add a different character
                 and update the character's remaining frequency.
             */
            if (len >= 2 && result.charAt(len - 1) == 'a' && result.charAt(len - 2) == 'a') {
                result.append('b');
                b--;

            } else if (len >= 2 && result.charAt(len - 1) == 'b' && result.charAt(len - 2) == 'b') {
                result.append('a');
                a--;

            } else {
                /**
                 2.  Last 2 characters differ from one another,
                     so add the character with the greater reamining frequency.
                 */
                if (a >= b) {
                    result.append('a');
                    a--;
                } else {
                    result.append('b');
                    b--;
                }
            }
        }

        return result.toString();
    }
}