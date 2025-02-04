// Question: https://leetcode.com/problems/keyboard-row/description/

class KeyboardRow {
    public String[] findWords(String[] words) {
        List<String> resultList = new ArrayList<>();
        for (String word: words) {
            if (isFormedByOnlyOneRow(word)) {
                resultList.add(word);
            }
        }

        String[] result = new String[resultList.size()];
        int i = 0;
        for (String word: resultList) {
            result[i++] = word;
        }
        return result;
    }

    private boolean isFormedByOnlyOneRow(String word) {
        boolean isAllFirstRowLetters = check("qwertyuiop", word);
        if (isAllFirstRowLetters) {
            return true;
        }
        boolean isAllSecondRowLetters = check("asdfghjkl", word);
        if (isAllSecondRowLetters) {
            return true;
        }
        return check("zxcvbnm", word);
    }

    private boolean check(String rowLetters, String word) {
        boolean[] letterFrequency = new boolean[26];
        for (char letter: rowLetters.toCharArray()) {
            letterFrequency[letter - 'a'] = true;
        }

        for (char letter: word.toCharArray()) {
            if (!letterFrequency[Character.toLowerCase(letter) - 'a']) {
                return false;
            }
        }

        return true;
    }
}