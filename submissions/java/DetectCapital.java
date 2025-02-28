// Question: https://leetcode.com/problems/detect-capital/description/

class DetectCapital {
    public boolean detectCapitalUse(String word) {
        return isAllUpperCase(word) || isAllLowerCase(word) || isOnlyFirstUppercase(word);
    }

    private boolean isAllLowerCase(String word) {
        for (char c: word.toCharArray()) {
            if (Character.isUpperCase(c)) {
                return false;
            }
        }
        return true;
    }

    private boolean isOnlyFirstUppercase(String word) {
        if (Character.isLowerCase(word.charAt(0))) {
            return false;
        }
        for (int i = 1; i < word.length(); i++) {
            if (Character.isUpperCase(word.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    private boolean isAllUpperCase(String word) {
        for (char letter: word.toCharArray()) {
            if (Character.isLowerCase(letter)) {
                return false;
            }
        }
        return true;
    }
}