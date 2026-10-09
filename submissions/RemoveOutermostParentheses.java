// Question: https://leetcode.com/problems/remove-outermost-parentheses/description/

class RemoveOutermostParentheses {
    public String removeOuterParentheses(String s) {
        StringBuilder result = new StringBuilder();
        int depth = 0;

        for (char c: s.toCharArray()) {
            if (c == '(' && depth++ > 0) {
                result.append('(');

            } else if (c == ')' && --depth > 0) {
                result.append(')');
            }
        }

        return result.toString();
    }
}
