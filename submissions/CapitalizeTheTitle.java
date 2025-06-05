// Question: https://leetcode.com/problems/capitalize-the-title/description/

class CapitalizeTheTitle {
    public String capitalizeTitle(String title) {
        StringBuilder result = new StringBuilder();
        String[] words = title.split(" ");
        int len = words.length;
        for (int i = 0; i < len; i++) {
            words[i] = update(words[i]);
        }
        for (int i = 0; i < len - 1; i++) {
            result.append(words[i] + " ");
        }
        result.append(words[len - 1]);
        return result.toString();
    }

    private String update(String word) {
        StringBuilder updatedWord = new StringBuilder();
        if (word.length() == 1 || word.length() == 2) {
            for (char letter: word.toCharArray()) {
                updatedWord.append(Character.toLowerCase(letter));
            }
        } else {
            updatedWord.append(Character.toUpperCase(word.charAt(0)));
            for (int i = 1; i < word.length(); i++) {
                updatedWord.append(Character.toLowerCase(word.charAt(i)));
            }
        }
        return updatedWord.toString();
    }
}