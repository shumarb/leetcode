// Question: https://leetcode.com/problems/maximum-nesting-depth-of-the-parentheses/description/

class MaximumNestingDepthOfTheParentheses {
    public int maxDepth(String s) {
        int current = 0;
        int result = 0;

        for (char c: s.toCharArray()) {
            if (c == '(') {
                current++;

            } else if (c == ')') {
                result = Math.max(current--, result);
            }
        }

        return result;
    }
}
