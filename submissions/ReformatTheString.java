// Question: https://leetcode.com/problems/reformat-the-string/description/

class ReformatTheString {
    public String reformat(String s) {
        Stack<Character> digitsStack = new Stack<>();
        Stack<Character> lettersStack = new Stack<>();
        StringBuilder result = new StringBuilder();
        boolean isTest = false;

        for (char token: s.toCharArray()) {
            if (Character.isDigit(token)) {
                digitsStack.push(token);
            } else {
                lettersStack.push(token);
            }
        }
        if (isTest) {
            System.out.println("s: " + s + "\ndigitsStack: " + digitsStack + "\nlettersStack: " + lettersStack);
        }

        if (Math.abs(digitsStack.size() - lettersStack.size()) == 1 || Math.abs(digitsStack.size() - lettersStack.size()) == 0) {
            if (digitsStack.size() > lettersStack.size()) {
                while (!digitsStack.isEmpty() && !lettersStack.isEmpty()) {
                    result.append(digitsStack.pop());
                    result.append(lettersStack.pop());
                }
                result.append(digitsStack.pop());
            } else {
                while (!digitsStack.isEmpty() && !lettersStack.isEmpty()) {
                    result.append(lettersStack.pop());
                    result.append(digitsStack.pop());
                }
                if (!digitsStack.isEmpty()) {
                    result.append(digitsStack.pop());
                }
                if (!lettersStack.isEmpty()) {
                    result.append(lettersStack.pop());
                }
            }
        }
        if (isTest) {
            System.out.println("result: " + result.toString());
        }

        return result.toString();
    }
}