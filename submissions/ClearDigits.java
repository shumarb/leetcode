// Question: https://leetcode.com/problems/clear-digits/description/

class ClearDigits {
    public String clearDigits(String s) {
        Stack<Character> stack = new Stack<>();
        boolean isTest = false;
        StringBuilder result = new StringBuilder();

        for (char c: s.toCharArray()) {
            if (Character.isLetter(c)) {
                stack.push(c);
            } else {
                stack.pop();
            }
        }
        if (isTest) {
            System.out.println("s: " + s + "\nstack: " + stack);
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
}