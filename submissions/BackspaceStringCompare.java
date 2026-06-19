// Question: https://leetcode.com/problems/backspace-string-compare/description/

class BackspaceStringCompare {
    public boolean backspaceCompare(String s, String t) {
        return getString(s).equals(getString(t));
    }

    private String getString(String s) {
        StringBuilder result = new StringBuilder();

        for (char c: s.toCharArray()) {
            if (c == '#') {
                if (!result.isEmpty()) {
                    result.setLength(result.length() - 1);
                }
            } else {
                result.append(c);
            }
        }

        return result.toString();
    }
}
