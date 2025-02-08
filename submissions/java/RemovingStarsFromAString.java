// Question: https://leetcode.com/problems/removing-stars-from-a-string/description/

class RemovingStarsFromAString {
    public String removeStars(String s) {
        boolean isTest = false;
        StringBuilder result = new StringBuilder();
        Stack<Character> stack = new Stack<>();

        for (char currentChar: s.toCharArray()) {
            if (isTest) {
                System.out.println("currentChar: " + currentChar + ", stack so far: " + stack);
            }
            if (stack.isEmpty()) {
                stack.push(currentChar);
            } else {
                if (currentChar == '*') {
                    stack.pop();
                } else {
                    stack.push(currentChar);
                }
            }
        }
        if (isTest) {
            System.out.println("final stack: " + stack);
        }

        while (!stack.isEmpty()) {
            if (stack.peek() != '*') {
                result.append(stack.peek());
            }
            stack.pop();
        }
        result.reverse();
        if (isTest) {
            System.out.println("result: " + result);
        }

        return result.toString();
    }
}