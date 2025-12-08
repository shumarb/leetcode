// Question: https://leetcode.com/problems/delete-characters-to-make-fancy-string/description/

class DeleteCharactersToMakeFancyString {
    public String makeFancyString(String s) {
        // 1. Edge case: s has < 3 characters, so answer is itself.
        if (s.length() < 3) {
            return s;
        }

        StringBuilder result = new StringBuilder();
        boolean isTest = false;
        char last = s.charAt(0);
        int count = 1;

        result.append(last);
        for (int i = 1; i < s.length(); i++) {
            char c = s.charAt(i);
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