// Question: https://leetcode.com/problems/append-characters-to-string-to-make-subsequence/description/

class AppendCharactersToStringToMakeSubsequence {
    public int appendCharacters(String s, String t) {
        boolean isTest = false;
        int index = 0;
        int tLen = t.length();

        for (char c: s.toCharArray()) {
            if (index == tLen) {
                break;
            }

            if (c == t.charAt(index)) {
                index++;
            }
        }
        if (isTest) {
            System.out.println("index: " + index);
        }

        return tLen - index;
    }
}
