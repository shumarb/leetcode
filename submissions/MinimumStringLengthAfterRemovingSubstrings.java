// Question: https://leetcode.com/problems/minimum-string-length-after-removing-substrings/description/

class MinimumStringLengthAfterRemovingSubstrings {
    public int minLength(String s) {
        Deque<Character> stack = new ArrayDeque<>();
        boolean isTest = false;
        char[] letters = s.toCharArray();

        for (int i = 0; i < letters.length; i++) {
            char letter = letters[i];
            if (isTest) {
                System.out.println("incoming: " + letter + "\n * before, stack: " + stack);
            }

            if (!stack.isEmpty() && ((stack.peek() == 'A' && letter == 'B') || (stack.peek() == 'C' && letter == 'D'))) {
                stack.pop();

            } else {
                stack.push(letter);
            }

            if (isTest) {
                System.out.println(" * after, stack: " + stack);
                System.out.println("---------------------------------------------------------");
            }
        }
        if (isTest) {
            System.out.println("stack: " + stack);
        }

        return stack.size();
    }
}
