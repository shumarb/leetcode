// Question: https://leetcode.com/problems/minimum-string-length-after-balanced-removals/description/

class MinimumStringLengthAfterBalancedRemovals {
    public int minLengthAfterRemovals(String s) {
        Stack<Character> stack = new Stack<>();
        boolean isTest = false;
        char[] letters = s.toCharArray();

        if (letters.length == 1) {
            return 1;
        }

        for (char c: letters) {
            if (isTest) {
                System.out.println("------------------------------\nincoming: " + c);
                System.out.println(" * before | stack: " + stack);
            }

            if (stack.isEmpty()) {
                stack.push(c);

            } else {
                char top = stack.peek();

                if ((top == 'a' && c == 'b') || (top == 'b' && c == 'a')) {
                    stack.pop();
                } else {
                    stack.push(c);
                }
            }

            if (isTest) {
                System.out.println(" * after  | stack: " + stack);
            }
        }

        return stack.size();
    }
}
