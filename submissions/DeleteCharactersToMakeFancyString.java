// Question: https://leetcode.com/problems/delete-characters-to-make-fancy-string/description/

class DeleteCharactersToMakeFancyString {
    public String makeFancyString(String s) {
        StringBuilder result = new StringBuilder();
        char[] letters = s.toCharArray();
        char last = letters[0];
        int count = 1;
        int n = letters.length;

        // 1. Edge case: s has < 3 characters, so answer is itself.
        if (n < 3) {
            return s;
        }

        result.append(last);
        for (int i = 1; i < n; i++) {
            char c = letters[i];
            if (c != last) {
                result.append(c);
                count = 1;

            } else {
                if (count + 1 != 3) {
                    result.append(c);
                    count++;
                }
            }

            last = c;
        }

        return result.toString();
    }
}
