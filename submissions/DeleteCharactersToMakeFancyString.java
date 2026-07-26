// Question: https://leetcode.com/problems/delete-characters-to-make-fancy-string/description/

class DeleteCharactersToMakeFancyString {
    public String makeFancyString(String s) {
        char[] letters = s.toCharArray();
        int index = 2;
        int n = letters.length;

        if (n < 3) {
            return s;
        }

        for (int i = 2; i < n; i++) {
            char current = letters[i];
            if (current != letters[index - 1] || current != letters[index - 2]) {
                letters[index++] = current;
            }
        }

        return new String(letters, 0, index);
    }
}
