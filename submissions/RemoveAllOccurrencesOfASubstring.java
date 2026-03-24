// Question: https://leetcode.com/problems/remove-all-occurrences-of-a-substring/description/

class RemoveAllOccurrencesOfASubstring {
    public String removeOccurrences(String s, String part) {
        // 1. Edge case: impossible to form part from s.
        if (s.length() < part.length() || !s.contains(part)) {
            return s;
        }

        Stack<Character> stack = new Stack<>();
        StringBuilder result = new StringBuilder();
        boolean isTest = false;

        for (char c: s.toCharArray()) {
            if (isTest) {
                System.out.println("c: " + c + "\n * before, stack: " + stack);
            }

            stack.push(c);
            while (stack.size() >= part.length() && isMatch(stack, part)) {
                for (int i = 0; i < part.length(); i++) {
                    stack.pop();
                }
            }

            if (isTest) {
                System.out.println(" * after, stack: " + stack);
                System.out.println("----------------------------------------");
            }
        }
        while (!stack.isEmpty()) {
            result.append(stack.pop());
        }
        result = result.reverse();
        if (isTest) {
            System.out.println("result: " + result);
        }

        return result.toString();
    }

    private boolean isMatch(Stack<Character> stack, String part) {
        Stack<Character> duplicateStack = new Stack<>();
        StringBuilder str = new StringBuilder();

        duplicateStack.addAll(stack);
        for (int i = 0; i < part.length(); i++) {
            str.append(duplicateStack.pop());
        }
        str = str.reverse();

        return str.toString().equals(part);
    }
}
