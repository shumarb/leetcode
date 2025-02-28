// Question: https://leetcode.com/problems/detect-capital/description/

class DetectCapital {
    public boolean detectCapitalUse(String word) {
        /** 1.  Count number of uppercase letters in word,
                and use it to check if >= 1 of the conditions is fulfilled.
         */
        int countUpperCaseLetters = 0;
        for (int i = 0; i < word.length(); i++) {
            if (Character.isUpperCase(word.charAt(i))) {
                countUpperCaseLetters++;
            }
        }

        /**
             2. Case 1: All letters in word are upper case.
             3. Case 2: No letters in word are upper case.
         */
        if (countUpperCaseLetters == word.length() || countUpperCaseLetters == 0) {
            return true;
        }

        // 4. Case 4: Only 1 uppercase letter, which is the first letter.
        return countUpperCaseLetters == 1 && Character.isUpperCase(word.charAt(0));
    }
}