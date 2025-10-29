// Question: https://leetcode.com/problems/resulting-string-after-adjacent-removals/description/

class ResultingStringAfterAdjacentRemovals {
    public String resultingString(String s) {
        // 1. Edge case: s has 1 character.
        if (s.length() == 1) {
            return s;
        }

        Stack<Character> stack = new Stack<>();
        StringBuilder result = new StringBuilder();
        boolean isTest = false;

        for (int i = 0; i < s.length(); i++) {
            char incoming = s.charAt(i);

            if (stack.isEmpty()) {
                stack.push(incoming);
            } else {
                char top = stack.peek();
                int absoluteDifference = Math.abs(top - incoming);
                if (absoluteDifference == 1 || absoluteDifference == 25) {
                    stack.pop();
                } else {
                    stack.push(incoming);
                }
            }
        }
        if (isTest) {
            System.out.println("stack: " + stack);
        }

        while (!stack.isEmpty()) {
            result.append(stack.pop());
        }
        result = result.reverse();
        if (isTest) {
            System.out.println("result: " + result.toString());
        }

        return result.toString();
    }
}