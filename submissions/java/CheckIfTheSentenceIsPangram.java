// Question: https://leetcode.com/problems/check-if-the-sentence-is-pangram/description/

class CheckIfTheSentenceIsPangram {
    public boolean checkIfPangram(String sentence) {
        // 1. Sentence is not pangram if it has less than 26 letters.
        if (sentence.length() < 26) {
            return false;
        }

        for (int i = 'a'; i <= 'z'; i++) {
            // 2. Sentence is not pangram if any letter from a to z is not found.
            if (sentence.indexOf(i) == -1) {
                return false;
            }
        }

        return true;
    }
}