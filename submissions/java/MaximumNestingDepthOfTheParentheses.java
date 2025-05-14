// Question: https://leetcode.com/problems/maximum-nesting-depth-of-the-parentheses/description/

class MaximumNestingDepthOfTheParentheses {
    public int maxDepth(String s) {
        int maxDepth = 0;
        int currentDepth = 0;

        for (char c: s.toCharArray()) {
            if (c == '(') {
                currentDepth++;
                maxDepth = Math.max(maxDepth, currentDepth);
            } else if (c == ')') {
                currentDepth--;
            }
        }

        return maxDepth;
    }
}