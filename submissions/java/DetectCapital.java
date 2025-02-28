// Question: https://leetcode.com/problems/detect-capital/description/

class DetectCapital {
    public boolean detectCapitalUse(String word) {
        /** 1.  Count number of uppercase letters in word,
         and use it to check if >= 1 of the conditions is fulfilled.
         */
        int countUpperCaseLetters = 0;
        int length = word.length();

        for (int i = 0; i < length; i++) {
            char letter = word.charAt(i);
            if (letter >= 65 && letter <= 90) {
                countUpperCaseLetters++;
            }
        }

        /**
         2. Case 1: All letters in word are upper case.
         3. Case 2: No letters in word are upper case.
         */
        if (countUpperCaseLetters == length || countUpperCaseLetters == 0) {
            return true;
        }

        // 4. Case 4: Only 1 uppercase letter, which is the first letter.
        char firstLetter = word.charAt(0);
        return countUpperCaseLetters == 1 && (firstLetter >= 65 && firstLetter <= 90);
    }
}