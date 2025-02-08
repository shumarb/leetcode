// Question: https://leetcode.com/problems/remove-all-adjacent-duplicates-in-string/description/

class RemoveAllAdjacentDuplicatesInString {
    public String removeDuplicates(String s) {
        boolean isTest = false;
        StringBuilder result = new StringBuilder();
        Stack<Character> stack = new Stack<>();

        for (char letter: s.toCharArray()) {
            if (isTest) {
                System.out.println("check: " + letter + ", stack so far: " + stack);
            }
            if (stack.isEmpty()) {
                stack.push(letter);
            } else {
                if (stack.peek() == letter) {
                    stack.pop();
                } else {
                    stack.push(letter);
                }
            }
        }
        if (isTest) {
            System.out.println("final stack: " + stack);
        }

        while (!stack.isEmpty()) {
            result.append(stack.pop());
        }
        result.reverse();
        if (isTest) {
            System.out.println("result: " + result.toString());
        }

        return result.toString();
    }
}