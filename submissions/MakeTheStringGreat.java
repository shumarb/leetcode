// Question: https://leetcode.com/problems/make-the-string-great/description/

class MakeTheStringGreat {
    public String makeGood(String s) {
        StringBuilder result = new StringBuilder();
        boolean isTest = false;
        Stack<Character> stack = new Stack<>();

        for (char letter: s.toCharArray()) {
            if (isTest) {
                System.out.println("check: " + letter + " | stack so far: " + stack);
            }
            if (!stack.isEmpty() && isSameLetterInDifferentCases(stack.peek(), letter)) {
                stack.pop();
            } else {
                stack.push(letter);
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
            System.out.println("result: " + result);
        }

        return result.toString();
    }

    private boolean isSameLetterInDifferentCases(char firstLetter, char secondLetter) {
        /**
         A a ==> true
         r R ==> true
         i i ==> false
         Q Q ==> false
         */
        if (firstLetter == secondLetter) {
            return false;
        }

        if (Character.isUpperCase(firstLetter)) {
            return secondLetter == Character.toLowerCase(firstLetter);
        }

        return secondLetter == Character.toUpperCase(firstLetter);
    }
}