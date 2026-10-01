// Question: https://leetcode.com/problems/valid-parentheses/description/

class ValidParentheses {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        char[] tokens = s.toCharArray();

        if (tokens.length % 2 == 1) {
            return false;
        }

        for (char c: tokens) {
            if (c == '(' || c == '[' || c == '{') {
                stack.push(c);

            } else {
                if (stack.isEmpty()) {
                    return false;
                }

                char top = stack.peek();

                if (
                        (top == '(' && c == ')')
                                || (top == '[' && c == ']')
                                || (top == '{' && c == '}')
                ) {
                    stack.pop();

                } else {
                    return false;
                }
            }
        }

        return stack.isEmpty();
    }
}
