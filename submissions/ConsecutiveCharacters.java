// Question: https://leetcode.com/problems/consecutive-characters/description/

class ConsecutiveCharacters {
    public int maxPower(String s) {
        int maxLength = 0;

        /**
         1.  Set first letter in s as part of current consecutive letters length,
             and set previous to this letter.
         */
        int currentLength = 1;
        char[] sLetters = s.toCharArray();
        char previous = sLetters[0];
        for (int i = 1; i < s.length(); i++) {
            /**
             2.  If current letter != previous letter, so the 
                 increase current consecutive letters length by 1.
             */
            char current = sLetters[i];
            if (current == previous) {
                currentLength++;
            } else {
                /**
                 3.  If current letter == previous letter, 
                     so the current consecutive letters length stops here.
                     compare this length with the maximum consecutive letters length
                     and update it accordingly,
                     and reset current consecutive letters length to 1 for next letter to be checked.
                 */
                maxLength = Math.max(maxLength, currentLength);
                currentLength = 1;
            }
            /**
             4.  At the end of every iteration, set previous letter to be current letter
                 for comparison with next letter.
             */
            previous = current;
        }

        // 5. Final comparison with maxLength and final current consecutive letters length.
        return Math.max(maxLength, currentLength);
    }
}