// Question: https://leetcode.com/problems/minimum-add-to-make-parentheses-valid/description/

class MinimumAddToMakeParenthesesValid {
    public int minAddToMakeValid(String s) {
        Stack<Character> stack = new Stack<>();
        boolean isTest = false;

        for (char part: s.toCharArray()) {
            if (!stack.isEmpty() && part == ')' && stack.peek() == '(') {
                stack.pop();
            } else {
                stack.push(part);
            }
        }
        if (isTest) {
            System.out.println("s: " + s + "\nstack: " + stack + "\nanswer: " + stack.size());
        }

        return stack.size();
    }
}