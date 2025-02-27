// Question: https://leetcode.com/problems/check-if-a-string-is-an-acronym-of-words/description/

class CheckIfAStringIsAnAcronymOfWords {
    public boolean isAcronym(List<String> words, String s) {
        // 1. Not acronym if number of words and length of s are different.
        if (words.size() != s.length()) {
            return false;
        }

        /**
         2.  Compare ith letter of string
         to the first letter of ith word.
         */
        for (int i = 0; i < words.size(); i++) {
            if (words.get(i).charAt(0) != s.charAt(i)) {
                return false;
            }
        }

        return true;
    }
}