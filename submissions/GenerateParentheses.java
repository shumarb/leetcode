// Question: https://leetcode.com/problems/generate-parentheses/description/

class GenerateParentheses {
    private List<String> result;
    private boolean isTest;
    private char[] arr;

    public List<String> generateParenthesis(int n) {
        arr = new char[2 * n];
        isTest = false;
        result = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            arr[i] = '(';
        }
        for (int i = n; i < arr.length; i++) {
            arr[i] = ')';
        }
        if (isTest) {
            System.out.println("arr: " + Arrays.toString(arr) + "\n----------------------------");
        }

        helper(new StringBuilder(), new boolean[arr.length]);
        if (isTest) {
            System.out.println("----------------------------\nresult: " + result);
        }

        return result;
    }

    private void helper(StringBuilder current, boolean[] isUsed) {
        if (isTest) {
            System.out.println(" * current: " + current);
        }
        if (current.length() == arr.length) {
            if (isValid(current.toString())) {
                result.add(current.toString());
            }
            return;
        }

        for (int i = 0; i < arr.length; i++) {
            // 1. Skip used character or current character and previous are the same but previous is not used.
            if (isUsed[i] || i > 0 && arr[i] == arr[i - 1] && !isUsed[i - 1]) {
                continue;
            }

            isUsed[i] = true;
            current.append(arr[i]);
            helper(current, isUsed);

            // 2. Backtrack
            current.setLength(current.length() - 1);
            isUsed[i] = false;
        }
    }

    private boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();

        for (char c: s.toCharArray()) {
            if (c == '(') {
                stack.push(c);
            } else {
                if (stack.isEmpty() || !stack.isEmpty() && stack.peek() != '(') {
                    return false;
                }
                stack.pop();
            }
        }

        return stack.isEmpty();
    }
}