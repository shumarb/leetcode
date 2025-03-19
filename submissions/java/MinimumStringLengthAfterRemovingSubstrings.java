// Question: https://leetcode.com/problems/minimum-string-length-after-removing-substrings/description/

class MinimumStringLengthAfterRemovingSubstrings {
    public int minLength(String s) {
        Stack<Character> stack = new Stack<>();
        boolean isTest = false;

        for (int i = 0; i < s.length(); i++) {
            char letter = s.charAt(i);
            if (isTest) {
                System.out.println(" * incoming: " + letter + "\nbefore, stack: " + stack);
            }

            if (!stack.isEmpty() && ((stack.peek() == 'A' && letter == 'B') || (stack.peek() == 'C' && letter == 'D'))) {
                stack.pop();
            } else {
                stack.push(letter);
            }

            if (isTest) {
                System.out.println("after, stack: " + stack);
                System.out.println("---------------------------------------------------------");
            }
        }
        if (isTest) {
            System.out.println("stack: " + stack);
        }

        return stack.size();
    }
}