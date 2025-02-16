// Question: https://leetcode.com/problems/backspace-string-compare/description/

class BackspaceStringCompare {
    public boolean backspaceCompare(String s, String t) {
        Stack<Character> sStack = new Stack<>();
        Stack<Character> tStack = new Stack<>();
        boolean isTest = false;
        populate(sStack, s);
        populate(tStack, t);

        if (isTest) {
            System.out.println("s: " + s + " | sStack: " + sStack);
            System.out.println("t: " + t + " | tStack: " + tStack);
        }

        if (sStack.size() != tStack.size()) {
            return false;
        }
        while (!sStack.isEmpty() || !tStack.isEmpty()) {
            if (sStack.pop() != tStack.pop()) {
                return false;
            }
        }

        return true;
    }

    private void populate(Stack<Character> stack, String str) {
        for (char c: str.toCharArray()) {
            if (stack.isEmpty()) {
                if (c != '#') {
                    stack.push(c);
                }
            } else {
                if (c == '#') {
                    stack.pop();
                } else {
                    stack.push(c);
                }
            }
        }
    }
}